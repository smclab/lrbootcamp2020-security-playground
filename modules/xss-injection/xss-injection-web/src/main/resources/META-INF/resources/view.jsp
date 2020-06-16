<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="./init.jsp" %>

<%
String firstName = GetterUtil.getString(renderRequest.getAttribute("firstName"), "");
String lastName = GetterUtil.getString(renderRequest.getAttribute("lastName"), "");

%>
<liferay-portlet:actionURL
	varImpl="submitActionURL" name="/submit/action" />

<aui:form name="fm" action="<%= submitActionURL.toString() %>">
	<c:if test="<%= Validator.isNotNull(firstName) %>">
		<p>Hello <%= firstName %></p>
	</c:if>
	<aui:row>
		<aui:col>
			<aui:input type="text" name="firstName" label="first-name" value="<%= firstName %>"/>
		</aui:col>	
	</aui:row>
	<aui:row>
		<aui:col>
			<aui:input type="text" name="lastName" label="last-name" value="<%= lastName %>"/>
		</aui:col>	
	</aui:row>
	<aui:button-row>
		<aui:button type="submit" name="submit" value="submit"/>
	</aui:button-row>
</aui:form>

<aui:script>
	var firstName = '<%= firstName %>';
	var lastName = '<%= lastName %>';
	if (firstName.length && firstName.length > 0) {
		console.log(firstName);
	}
	if (lastName.length && lastName.length > 0) {
		console.log(lastName);
	}
</aui:script>