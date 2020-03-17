<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="./init.jsp" %>

<%
List<Vendor> vendors = (List<Vendor>) renderRequest.getAttribute("vendors");
Long vendorsCount = GetterUtil.getLong(renderRequest.getAttribute("vendorsCount"));

if (vendors == null) { 
	vendors = new ArrayList<Vendor>(0);
	vendorsCount = 0L;
}

String keyword = GetterUtil.get(renderRequest.getAttribute("keyword"), "");

String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", "name");
String orderByType = ParamUtil.getString(renderRequest, "orderByType", "asc");

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

<%--
<aui:row>
	<aui:col md="2">
		<aui:input name="name" label="name" value="" placeholder="3DLabs" />
	</aui:col>
	<aui:col md="2">
		<aui:input name="hwid" label="hw-id" value="" placeholder="3D3D" />
	</aui:col>
	<aui:col md="3">
		<aui:input name="description" label="description" value="" placeholder="3DLabs" />
	</aui:col>
	<aui:col md="3">
		<aui:input name="website" label="website" value="" placeholder="www.3dlabs.com" />
	</aui:col>
	<aui:col md="2">
		<aui:input name="metdata" label="metadata" value="" placeholder="metadatas" />
	</aui:col>
</aui:row>
--%>

<aui:button-row>
	<aui:a href="#" cssClass="btn btn-primary" label="add-samples" onClick="doSubmit('fmaddsamples')"/>
	<aui:a href="#" cssClass="btn btn-danger" label="remove-all" onClick="doSubmit('fmremall')"/>
</aui:button-row>

<aui:form
	action="<%= searchFormActionURL.toString() %>"
	method="post"
	name="fm">

	<aui:field-wrapper cssClass="container-fluid-1280 lfr-search-container-wrapper">
		<aui:row>
			<aui:col md="4">
				<aui:input name="keyword" label="keyword" value="<%= keyword %>" />
			</aui:col>
		</aui:row>
		
		<aui:button-row>
			<aui:button type="submit" name="search" value="search" />
			<aui:button type="reset" name="reset" value="clear" />
		</aui:button-row>
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
		var fm = $("#<portlet:namespace/>" + formName);
		if (fm) {
			submitForm(fm);
		}
	}
</aui:script>
