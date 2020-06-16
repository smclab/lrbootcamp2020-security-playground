package it.scinti.lfr.secpg.xssinjection.web.action;



import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;

import org.osgi.service.component.annotations.Component;

import it.scinti.lfr.secpg.xssinjection.web.constants.XssInjectionWebPortletKeys;

@Component(
	immediate = true,
	property = { 
		"javax.portlet.name=" + XssInjectionWebPortletKeys.XSSINJECTION_PORTLET_NAME,
		"mvc.command.name=/submit/action"
	}, service = MVCActionCommand.class)
public class FormSubmitMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

//		hideDefaultSuccessMessage(actionRequest)
//		hideDefaultErrorMessage(actionRequest);
		
		try {
			String firstName = ParamUtil.getString(actionRequest, "firstName");
			String lastName = ParamUtil.getString(actionRequest, "lastName");

			actionRequest.setAttribute("firstName", firstName);
			actionRequest.setAttribute("lastName", lastName);
		} catch (Exception e) {
			_log.error(e, e);
			throw e;
		}
	}

	private void validate(PortletRequest portletRequest) throws PortalException {
	}

	private static Log _log = LogFactoryUtil.getLog(FormSubmitMVCActionCommand.class);
}
