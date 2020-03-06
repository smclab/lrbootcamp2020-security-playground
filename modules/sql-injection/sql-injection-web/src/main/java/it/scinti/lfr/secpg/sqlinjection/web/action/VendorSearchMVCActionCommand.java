
package it.scinti.lfr.secpg.sqlinjection.web.action;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;

import org.osgi.service.component.annotations.Component;

import it.scinti.lfr.secpg.sqlinjection.model.Vendor;
import it.scinti.lfr.secpg.sqlinjection.service.VendorLocalServiceUtil;
import it.scinti.lfr.secpg.sqlinjection.web.constants.SqlInjectionWebPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + SqlInjectionWebPortletKeys.SQLINJECTION_PORTLET_NAME,
		"mvc.command.name=/search/action" }, service = MVCActionCommand.class)
public class VendorSearchMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		hideDefaultSuccessMessage(actionRequest);

		try {
			long companyId = PortalUtil.getCompanyId(actionRequest);

			String keyword = ParamUtil.getString(actionRequest, "keyword");

			validate(actionRequest);

			int delta = (ParamUtil.getInteger(actionRequest, SearchContainer.DEFAULT_DELTA_PARAM,
					SearchContainer.DEFAULT_DELTA)) % (SearchContainer.MAX_DELTA + 1); // to avoid pagination attacks

			int currentPage = ParamUtil.getInteger(actionRequest, SearchContainer.DEFAULT_CUR_PARAM,
					SearchContainer.DEFAULT_CUR);

			int end = currentPage * delta;
			int start = end - delta;

			long vendorsCount = VendorLocalServiceUtil.searchVendorsCount(companyId, keyword);

			List<Vendor> vendors = VendorLocalServiceUtil.searchVendors(companyId, keyword, start, end, null);

			actionRequest.setAttribute("keyword", keyword);
			actionRequest.setAttribute("vendors", vendors);
			actionRequest.setAttribute("vendorsCount", vendorsCount);

		} catch (Exception e) {
			_log.error(e, e);
			throw e;
		}
	}

	private void validate(PortletRequest portletRequest) throws PortalException {
	}

	private static Log _log = LogFactoryUtil.getLog(VendorSearchMVCActionCommand.class);
}
