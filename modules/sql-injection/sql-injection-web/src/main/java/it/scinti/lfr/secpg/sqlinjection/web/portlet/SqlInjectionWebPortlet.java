package it.scinti.lfr.secpg.sqlinjection.web.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import it.scinti.lfr.secpg.sqlinjection.web.constants.SqlInjectionWebPortletKeys;

/**
 * @author simone
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.security",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.info.keywords=sqli,sql,injection,portlet",
		"javax.portlet.display-name=SQL Injection Demo",
		"javax.portlet.description=A demonstration portlet for SQL Injection attacks",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + SqlInjectionWebPortletKeys.SQLINJECTION_PORTLET_NAME,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class SqlInjectionWebPortlet extends MVCPortlet {
}