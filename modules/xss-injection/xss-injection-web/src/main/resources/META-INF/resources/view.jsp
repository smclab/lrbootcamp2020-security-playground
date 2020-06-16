<%@ include file="./init.jsp" %>

<%
String firstName = GetterUtil.getString(renderRequest.getAttribute("firstName"));
String lastName = GetterUtil.getString(renderRequest.getAttribute("lastName"));
%>
<liferay-portlet:actionURL
	varImpl="submitActionURL" name="/submit/action" />

<aui:form name="fm" action="<%= submitActionURL.toString() %>">
	<c:if test="<%= Validator.isNotNull(firstName) || Validator.isNotNull(lastName) %>">
		<p>Hello, <%= firstName %> <%= lastName %></p>
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

	<aui:button-row>
		<% 
		for (int inj = 0 ; inj < 3; inj++) {
		%>
			<aui:a href="#" cssClass="btn btn-danger btn-default" label="<%= "xss-injection-demo-" + (1+inj) %>" 
				onclick="<%= "xssInjectionSuggestions(" + inj + ")" %>" />
		<%
		}
		%>
	</aui:button-row>
</aui:form>

<aui:script>
	var firstName = '<%= firstName %>';
	var lastName = '<%= lastName %>';
	var lastNameField = $("#<portlet:namespace/>lastName");
	console.log("firstName: " + firstName);
	console.log("lastName: " + lastName);

	
	function xssInjectionSuggestions(injIndex) {
		event.preventDefault();
		injIndex = (injIndex === undefined ? 0 : injIndex % 3);
		var suggestion = "";
		if (injIndex == 0) {
			suggestion = "'+eval(unescape(\"alert%28document.cookie%29\"))+'";
		} else if (injIndex == 1) {
			suggestion = "'+eval(unescape(\"var%20x%3D10%3B%20var%20y%3D10%3B%20alert%28%27x*y%3D%27%20+%20x*y%29\"))+'";
		} else if (injIndex == 2) {
			suggestion = "< script > ... < / script >";
		}
		lastNameField.val(suggestion);
	}
</aui:script>