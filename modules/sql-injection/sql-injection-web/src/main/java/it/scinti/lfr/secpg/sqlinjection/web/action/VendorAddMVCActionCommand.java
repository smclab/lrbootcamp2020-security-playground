
package it.scinti.lfr.secpg.sqlinjection.web.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;

import org.osgi.service.component.annotations.Component;

import it.scinti.lfr.secpg.sqlinjection.service.VendorLocalServiceUtil;
import it.scinti.lfr.secpg.sqlinjection.web.constants.SqlInjectionWebPortletKeys;

@Component(
	immediate = true,
	property = { 
		"javax.portlet.name=" + SqlInjectionWebPortletKeys.SQLINJECTION_PORTLET_NAME,
		"mvc.command.name=/add/action"
	},
	service = MVCActionCommand.class
)
public class VendorAddMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		hideDefaultSuccessMessage(actionRequest);

		try {
			long companyId = PortalUtil.getCompanyId(actionRequest);

			String name = ParamUtil.getString(actionRequest, "name");
			String description = ParamUtil.getString(actionRequest, "description");
			String hwId = ParamUtil.getString(actionRequest, "hwid");
			String website = ParamUtil.getString(actionRequest, "website");
			String metadata = ParamUtil.getString(actionRequest, "metadata");
			
			VendorLocalServiceUtil.addVendor(companyId, name, description, hwId, metadata, website);
			_log.info("added vendor with name:" + name + " and hwId: " + hwId);
		} catch (Exception e) {
			_log.error(e, e);
			throw e;
		}
	}

	private void validate(PortletRequest portletRequest) throws PortalException {
	}

	private static Log _log = LogFactoryUtil.getLog(VendorAddMVCActionCommand.class);
}
