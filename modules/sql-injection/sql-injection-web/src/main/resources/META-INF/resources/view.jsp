<%@ include file="./init.jsp" %>

<%
List<Vendor> vendors = (List<Vendor>) renderRequest.getAttribute("vendors");
Long vendorsCount = (Long) renderRequest.getAttribute("vendorsCount");

if (vendors == null) { 
	vendors = new ArrayList<Vendor>(0);
	vendorsCount = 0L;
}

String keyword = GetterUtil.get(renderRequest.getAttribute("keyword"), "");
%>

<liferay-portlet:actionURL varImpl="searchFormActionURL" name="/search/action" />

<liferay-portlet:actionURL varImpl="searchFormIteratorURL" name="/search/action" >
	<liferay-portlet:param name="keyword" value="<%= keyword %>" />
</liferay-portlet:actionURL>
<%

%>
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
			searchContainer.setTotal(vendorsCount);
			renderRequest.setAttribute("redirect", searchFormIteratorURL.toString());
		%>
			<liferay-ui:search-container-row className="com.liferay.portal.kernel.model.User"
				keyProperty="vendorId" modelVar="curVendor">
	
<%-- 				<liferay-portlet:renderURL varImpl="vendorDetailsURL"> --%>
<%-- 					<liferay-portlet:param name="mvcRenderCommandName" value="/vendor/details" /> --%>
<%-- 					<liferay-portlet:param name="vendorId" value="<%= String.valueOf(curVendor.getVendorId()) %>" /> --%>
<%-- 				</liferay-portlet:renderURL> --%>

				<liferay-ui:search-container-column-text 
					cssClass="text-nowrap"
					name="hw-id">
					<%= curVendor.getHwId() %>
				</liferay-ui:search-container-column-text>
	
				<liferay-ui:search-container-column-text 
					cssClass="text-nowrap"
					name="vendor-name">
					<%= curVendor.getName() %>
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text 
					cssClass="text-nowrap"
					name="vendor-website">
					<%= curVendor.getWebsite() %>
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text 
					cssClass="text-nowrap"
					name="vendor-description">
					<%= curVendor.getDescription() %>
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text 
					cssClass="text-nowrap"
					name="vendor-metadata">
					<%= curVendor.getMetadata() %>
				</liferay-ui:search-container-column-text>
					
	
			</liferay-ui:search-container-row>
	
		<liferay-ui:search-iterator displayStyle="list" markupView="lexicon" />
	
	</liferay-ui:search-container>
</aui:form>