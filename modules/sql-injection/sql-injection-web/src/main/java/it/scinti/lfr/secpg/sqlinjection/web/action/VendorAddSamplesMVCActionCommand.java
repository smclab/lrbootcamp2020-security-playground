
package it.scinti.lfr.secpg.sqlinjection.web.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import it.scinti.lfr.secpg.sqlinjection.service.VendorLocalServiceUtil;
import it.scinti.lfr.secpg.sqlinjection.web.constants.SqlInjectionWebPortletKeys;

@Component(
	immediate = true,
	property = { 
		"javax.portlet.name=" + SqlInjectionWebPortletKeys.SQLINJECTION_PORTLET_NAME,
		"mvc.command.name=/addsamples/action"
	},
	service = MVCActionCommand.class
)
public class VendorAddSamplesMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		try {
			int count = 0;
			long companyId = PortalUtil.getCompanyId(actionRequest);
			for (String[] row: SAMPLE_DATA) {
				String name = row[0].trim();
				String hwId = row[1].trim().toUpperCase();
				String description = row[2].trim();
				String metadata = row[3].trim();
				String website = row[4].trim();

				if (VendorLocalServiceUtil.fetchVendorByHwId(hwId) == null) {
					VendorLocalServiceUtil.addVendor(companyId, name, description, hwId, metadata, website);
					_log.info("added vendor with name:" + name + " and hwId: " + hwId);
					count ++;
				}
				else {
					_log.warn("skipping to add vendor with name:" + name + " and hwId: " + hwId + " because already exists!");
				}
				
			}
			_log.info("sample data added successfully. Total vendors added: " + count);
		} catch (Exception e) {
			_log.error(e, e);
			throw e;
		}
	}

	private String[][] SAMPLE_DATA = new String[][] { 
		{"3DLabs", "3D3D", "3D Labs", "", "https://www.3dlabs.com"},
		{"Intel", "8086", "Intel Corporation", "", "https://www.intel.com"},
		{"A-Trend", "117A", "A-Trend Technology", "", ""},
		{"ABB", "125A", "ABB Power Systems", "", ""}

	};

	private static Log _log = LogFactoryUtil.getLog(VendorAddSamplesMVCActionCommand.class);
}
