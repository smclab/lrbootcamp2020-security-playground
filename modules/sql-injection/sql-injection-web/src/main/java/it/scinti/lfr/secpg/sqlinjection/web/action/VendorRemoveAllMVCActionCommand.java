
package it.scinti.lfr.secpg.sqlinjection.web.action;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import it.scinti.lfr.secpg.sqlinjection.model.Vendor;
import it.scinti.lfr.secpg.sqlinjection.service.VendorLocalServiceUtil;
import it.scinti.lfr.secpg.sqlinjection.web.constants.SqlInjectionWebPortletKeys;

@Component(
	immediate = true, property = { 
		"javax.portlet.name=" + SqlInjectionWebPortletKeys.SQLINJECTION_PORTLET_NAME,
		"mvc.command.name=/removeall/action" 
	},
	service = MVCActionCommand.class
)
public class VendorRemoveAllMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		try {
			int count = VendorLocalServiceUtil.getVendorsCount();

			_log.info("before remove-all : " + count + " total vendors found ");

			List<Vendor> vendors = VendorLocalServiceUtil.getVendors(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			for (Vendor vendor : vendors) {
				VendorLocalServiceUtil.deleteVendor(vendor);
				_log.info("removed vendor with name:" + vendor.getName() + " and hwId: " + vendor.getHwId());
			}
			count = VendorLocalServiceUtil.getVendorsCount();

			_log.info("after remove-all : " + count + " vendors left");
		} catch (Exception e) {
			_log.error(e, e);
			throw e;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(VendorRemoveAllMVCActionCommand.class);
}
