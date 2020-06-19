
package it.scinti.lfr.secpg.sqlinjection.web.action;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import it.scinti.lfr.secpg.sqlinjection.model.Vendor;
import it.scinti.lfr.secpg.sqlinjection.service.VendorLocalServiceUtil;
import it.scinti.lfr.secpg.sqlinjection.web.constants.SqlInjectionWebPortletKeys;
import it.scinti.lfr.secpg.sqlinjection.web.util.comparator.VendorOrderByComparator;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + SqlInjectionWebPortletKeys.SQLINJECTION_PORTLET_NAME,
		"mvc.command.name=/" },
	service = MVCRenderCommand.class
)
public class VendorSearchMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		try {
			long companyId = PortalUtil.getCompanyId(renderRequest);

			String keyword = ParamUtil.getString(renderRequest, "keyword");

			int delta = (ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM,
					SearchContainer.DEFAULT_DELTA)) % (SearchContainer.MAX_DELTA + 1);

			int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM,
					SearchContainer.DEFAULT_CUR);

			int end = currentPage * delta;
			int start = end - delta;

			long vendorsCount = VendorLocalServiceUtil.searchVendorsCount(companyId, keyword);

			String orderByCol = ParamUtil.getString(renderRequest, SearchContainer.DEFAULT_ORDER_BY_COL_PARAM, "name");
			String orderByType = ParamUtil.getString(renderRequest, SearchContainer.DEFAULT_ORDER_BY_TYPE_PARAM, "asc")
					.trim();

			OrderByComparator<Vendor> orderByComparator = VendorOrderByComparator.getVendorOrderByComparator(orderByCol,
					("asc".equalsIgnoreCase(orderByType)));

			List<Vendor> vendors = VendorLocalServiceUtil.searchVendors(companyId, keyword, start, end, orderByComparator);

			renderRequest.setAttribute("keyword", keyword);
			renderRequest.setAttribute("vendors", vendors);
			renderRequest.setAttribute("vendorsCount", vendorsCount);

		} catch (Exception e) {
			_log.error(e, e);
			throw e;
		}

		return "/view.jsp";
	}

	private static Log _log = LogFactoryUtil.getLog(VendorSearchMVCRenderCommand.class);

}
