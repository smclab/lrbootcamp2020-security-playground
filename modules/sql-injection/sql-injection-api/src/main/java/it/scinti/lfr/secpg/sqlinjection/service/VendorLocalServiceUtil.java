/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.scinti.lfr.secpg.sqlinjection.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Vendor. This utility wraps
 * {@link it.scinti.lfr.secpg.sqlinjection.service.impl.VendorLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see VendorLocalService
 * @see it.scinti.lfr.secpg.sqlinjection.service.base.VendorLocalServiceBaseImpl
 * @see it.scinti.lfr.secpg.sqlinjection.service.impl.VendorLocalServiceImpl
 * @generated
 */
@ProviderType
public class VendorLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.scinti.lfr.secpg.sqlinjection.service.impl.VendorLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static it.scinti.lfr.secpg.sqlinjection.model.Vendor addVendor(
		long companyId, String name, String description, String hwId,
		String metadata, String website)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addVendor(companyId, name, description, hwId, metadata,
			website);
	}

	/**
	* Adds the vendor to the database. Also notifies the appropriate model listeners.
	*
	* @param vendor the vendor
	* @return the vendor that was added
	*/
	public static it.scinti.lfr.secpg.sqlinjection.model.Vendor addVendor(
		it.scinti.lfr.secpg.sqlinjection.model.Vendor vendor) {
		return getService().addVendor(vendor);
	}

	/**
	* Creates a new vendor with the primary key. Does not add the vendor to the database.
	*
	* @param vendorId the primary key for the new vendor
	* @return the new vendor
	*/
	public static it.scinti.lfr.secpg.sqlinjection.model.Vendor createVendor(
		long vendorId) {
		return getService().createVendor(vendorId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the vendor with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vendorId the primary key of the vendor
	* @return the vendor that was removed
	* @throws PortalException if a vendor with the primary key could not be found
	*/
	public static it.scinti.lfr.secpg.sqlinjection.model.Vendor deleteVendor(
		long vendorId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteVendor(vendorId);
	}

	/**
	* Deletes the vendor from the database. Also notifies the appropriate model listeners.
	*
	* @param vendor the vendor
	* @return the vendor that was removed
	*/
	public static it.scinti.lfr.secpg.sqlinjection.model.Vendor deleteVendor(
		it.scinti.lfr.secpg.sqlinjection.model.Vendor vendor) {
		return getService().deleteVendor(vendor);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.scinti.lfr.secpg.sqlinjection.model.impl.VendorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.scinti.lfr.secpg.sqlinjection.model.impl.VendorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static it.scinti.lfr.secpg.sqlinjection.model.Vendor fetchVendor(
		long vendorId) {
		return getService().fetchVendor(vendorId);
	}

	public static it.scinti.lfr.secpg.sqlinjection.model.Vendor fetchVendorByHwId(
		String hwId) {
		return getService().fetchVendorByHwId(hwId);
	}

	public static it.scinti.lfr.secpg.sqlinjection.model.Vendor fetchVendorByName(
		String name) {
		return getService().fetchVendorByName(name);
	}

	/**
	* Returns the vendor matching the UUID and group.
	*
	* @param uuid the vendor's UUID
	* @param groupId the primary key of the group
	* @return the matching vendor, or <code>null</code> if a matching vendor could not be found
	*/
	public static it.scinti.lfr.secpg.sqlinjection.model.Vendor fetchVendorByUuidAndGroupId(
		String uuid, long groupId) {
		return getService().fetchVendorByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the vendor with the primary key.
	*
	* @param vendorId the primary key of the vendor
	* @return the vendor
	* @throws PortalException if a vendor with the primary key could not be found
	*/
	public static it.scinti.lfr.secpg.sqlinjection.model.Vendor getVendor(
		long vendorId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getVendor(vendorId);
	}

	/**
	* Returns the vendor matching the UUID and group.
	*
	* @param uuid the vendor's UUID
	* @param groupId the primary key of the group
	* @return the matching vendor
	* @throws PortalException if a matching vendor could not be found
	*/
	public static it.scinti.lfr.secpg.sqlinjection.model.Vendor getVendorByUuidAndGroupId(
		String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getVendorByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the vendors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.scinti.lfr.secpg.sqlinjection.model.impl.VendorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of vendors
	* @param end the upper bound of the range of vendors (not inclusive)
	* @return the range of vendors
	*/
	public static java.util.List<it.scinti.lfr.secpg.sqlinjection.model.Vendor> getVendors(
		int start, int end) {
		return getService().getVendors(start, end);
	}

	/**
	* Returns all the vendors matching the UUID and company.
	*
	* @param uuid the UUID of the vendors
	* @param companyId the primary key of the company
	* @return the matching vendors, or an empty list if no matches were found
	*/
	public static java.util.List<it.scinti.lfr.secpg.sqlinjection.model.Vendor> getVendorsByUuidAndCompanyId(
		String uuid, long companyId) {
		return getService().getVendorsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of vendors matching the UUID and company.
	*
	* @param uuid the UUID of the vendors
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of vendors
	* @param end the upper bound of the range of vendors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching vendors, or an empty list if no matches were found
	*/
	public static java.util.List<it.scinti.lfr.secpg.sqlinjection.model.Vendor> getVendorsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<it.scinti.lfr.secpg.sqlinjection.model.Vendor> orderByComparator) {
		return getService()
				   .getVendorsByUuidAndCompanyId(uuid, companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of vendors.
	*
	* @return the number of vendors
	*/
	public static int getVendorsCount() {
		return getService().getVendorsCount();
	}

	public static java.util.List<it.scinti.lfr.secpg.sqlinjection.model.Vendor> searchVendors(
		long companyId, String keyword, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<it.scinti.lfr.secpg.sqlinjection.model.Vendor> orderByComparator) {
		return getService()
				   .searchVendors(companyId, keyword, start, end,
			orderByComparator);
	}

	public static int searchVendorsCount(long companyId, String keyword) {
		return getService().searchVendorsCount(companyId, keyword);
	}

	/**
	* Updates the vendor in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vendor the vendor
	* @return the vendor that was updated
	*/
	public static it.scinti.lfr.secpg.sqlinjection.model.Vendor updateVendor(
		it.scinti.lfr.secpg.sqlinjection.model.Vendor vendor) {
		return getService().updateVendor(vendor);
	}

	public static VendorLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<VendorLocalService, VendorLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(VendorLocalService.class);

		ServiceTracker<VendorLocalService, VendorLocalService> serviceTracker = new ServiceTracker<VendorLocalService, VendorLocalService>(bundle.getBundleContext(),
				VendorLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}