<%@ include file="./init.jsp" %>

<%
String sqliConfirmMessage = LanguageUtil.get(request,"confirm-sql-command-for-injection");
String sqliSuccessMessage = LanguageUtil.get(request,"please-see-the-console-log-for-injection");
String sqliDefaultSQL = "(CASE WHEN  (SELECT substring(CONVERT(userId, CHAR),1,1) FROM user_ WHERE emailAddress = 'test@liferay.com') = '2' THEN name ELSE vendorId END)";

List<Vendor> vendors = (List<Vendor>) renderRequest.getAttribute("vendors");
Long vendorsCount = GetterUtil.getLong(renderRequest.getAttribute("vendorsCount"));

if (vendors == null) { 
	vendors = new ArrayList<Vendor>(0);
	vendorsCount = 0L;
}

String keyword = GetterUtil.get(renderRequest.getAttribute("keyword"), "");

String orderByCol = ParamUtil.getString(renderRequest, SearchContainer.DEFAULT_ORDER_BY_COL_PARAM, "name");
String orderByType = ParamUtil.getString(renderRequest, SearchContainer.DEFAULT_ORDER_BY_TYPE_PARAM, "asc");

%>

<liferay-portlet:actionURL varImpl="searchFormActionURL" name="/search/action" />
<liferay-portlet:actionURL varImpl="searchFormIteratorURL" name="/search/action" >
	<liferay-portlet:param name="keyword" value="<%= keyword %>" />
</liferay-portlet:actionURL>

<liferay-portlet:actionURL varImpl="addSamplesActionURL" name="/addsamples/action" />
<aui:form
	action="<%= addSamplesActionURL.toString() %>"
	method="post"
	name="fmaddsamples">
</aui:form>

<liferay-portlet:actionURL varImpl="removeAllActionURL" name="/removeall/action" />
<aui:form
	action="<%= removeAllActionURL.toString() %>"
	method="post"
	name="fmremall">
</aui:form>

<aui:form
	action="<%= searchFormActionURL.toString() %>"
	method="post"
	name="fm">

	<aui:field-wrapper cssClass="container-fluid-1280 lfr-search-container-wrapper">
		<aui:row>
			<aui:col md="4">
				<aui:input name="keyword" label="" value="<%= keyword %>" placeholder="insert search keyword here..." />
			</aui:col>
			<aui:col md="8">
				<aui:button type="submit" name="search" value="search" />
				<aui:a href="#" cssClass="btn btn-primary btn-default" label="add-samples" onClick="doSubmit('fmaddsamples')"/>
				<aui:a href="#" cssClass="btn btn-danger btn-default" label="remove-all" onClick="doSubmit('fmremall')"/>
				<aui:a href="#" id="sqlinjbutton" cssClass="btn btn-danger btn-default" label="sql-injection-start-button" onClick="doSqlInjection()"/>
			</aui:col>
		</aui:row>
	</aui:field-wrapper>
	<liferay-ui:search-container
		cssClass="container-fluid-1280" 
		delta="20"
		iteratorURL="<%= searchFormIteratorURL %>" >
		
		<liferay-ui:search-container-results 
			results="<%= vendors %>" /> 
		<%
			searchContainer.setResults(vendors);
			searchContainer.setTotal(vendorsCount.intValue());
			renderRequest.setAttribute("redirect", searchFormIteratorURL.toString());
		%>
			<liferay-ui:search-container-row
				className="it.scinti.lfr.secpg.sqlinjection.model.Vendor"
				keyProperty="vendorId"
				modelVar="curVendor">
	
<%-- 				<liferay-portlet:renderURL varImpl="vendorDetailsURL"> --%>
<%-- 					<liferay-portlet:param name="mvcRenderCommandName" value="/vendor/details" /> --%>
<%-- 					<liferay-portlet:param name="vendorId" value="<%= String.valueOf(curVendor.getVendorId()) %>" /> --%>
<%-- 				</liferay-portlet:renderURL> --%>

				<liferay-ui:search-container-column-text 
					cssClass="text-nowrap"
					name="vendor-id"
					property="vendorId"
					orderable="true"
					orderableProperty="vendorId"
				>
					<%= String.valueOf(curVendor.getVendorId()) %>
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text 
					cssClass="text-nowrap"
					name="vendor-name"
					property="name"
					orderable="true"
					orderableProperty="name"
				>
					<%= curVendor.getName() %>
				</liferay-ui:search-container-column-text>
				
				<liferay-ui:search-container-column-text 
					cssClass="text-nowrap"
					name="hw-id"
					property="hwId"
					orderable="true"
					orderableProperty="hwId"
				>
					<%= curVendor.getHwId() %>
				</liferay-ui:search-container-column-text>
	
				<liferay-ui:search-container-column-text 
					cssClass="text-nowrap"
					name="vendor-website"
					property="website"
					orderable="true"
					orderableProperty="website"
				>
					<%= curVendor.getWebsite() %>
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text 
					cssClass="text-nowrap"
					name="vendor-description"
					property="description"
					orderable="true"
					orderableProperty="description"
				>
					<%= curVendor.getDescription() %>
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text 
					cssClass="text-nowrap"
					name="vendor-metadata"
					orderable="true"
					orderableProperty="metadata"
				>
					<%= curVendor.getMetadata() %>
				</liferay-ui:search-container-column-text>
					
	
			</liferay-ui:search-container-row>
	
		<liferay-ui:search-iterator displayStyle="list" />
	
	</liferay-ui:search-container>
</aui:form>
<aui:script>
	function doSubmit(formName) {
		event.preventDefault();
		var fm = $("#<portlet:namespace/>" + formName);
		if (fm) {
			submitForm(fm);
		}
	}
	function getCurrentState() {
		var container = $("#<portlet:namespace/>vendorsSearchContainer");
		var arr = container.find(".searchcontainer-content .table-data .table-cell.text-nowrap.first");
		var curIds = [];
		arr.each(function(i) {
			curIds.push($($(arr[i])[0]).text().trim());
		});
		return curIds;
	}
	function doSqlInjection() {
		event.preventDefault();
		var namespace = "<portlet:namespace/>";
		var searchUrl = "<%= searchFormActionURL.toString() %>";
		var sqliConfirmMessage = "<%= sqliConfirmMessage %>";
		var sqliSuccessMessage = "<%= sqliSuccessMessage %>";
		var sqliDefaultSQL = "<%= sqliDefaultSQL %>";
		var sqli =  prompt(sqliConfirmMessage, sqliDefaultSQL);
		if (sqli == null || sqli == undefined || sqli.length == 0) {
			sqli = sqliDefaultSQL;
		}
		else {
			searchUrl += "&" + namespace + "<%= SearchContainer.DEFAULT_ORDER_BY_COL_PARAM %>" + "=" + sqli;
			searchUrl += "&" + namespace + "<%= SearchContainer.DEFAULT_ORDER_BY_TYPE_PARAM %>" + "=" + "asc";
		
			console.log("URL for SQL Injection demonstration is: ");
			console.log(searchUrl);
			alert(sqliSuccessMessage);
		}
	}
</aui:script>
