
package it.scinti.lfr.secpg.xssinjection.web.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import it.scinti.lfr.secpg.xssinjection.web.constants.XssInjectionWebPortletKeys;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + XssInjectionWebPortletKeys.XSSINJECTION_PORTLET_NAME,
		"mvc.command.name=/" },
	service = MVCRenderCommand.class
)
public class ViewMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		String firstName = ParamUtil.getString(renderRequest, "firstName");
		String lastName = ParamUtil.getString(renderRequest, "lastName");
		String hiddenField = ParamUtil.getString(renderRequest, "hiddenField");

		renderRequest.setAttribute("firstName", firstName);
		renderRequest.setAttribute("lastName", lastName);
		renderRequest.setAttribute("hiddenField", hiddenField);

		return "/view.jsp";
	}

	private static Log _log = LogFactoryUtil.getLog(ViewMVCRenderCommand.class);

}
