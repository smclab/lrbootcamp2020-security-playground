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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link VendorLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see VendorLocalService
 * @generated
 */
public class VendorLocalServiceWrapper
	implements ServiceWrapper<VendorLocalService>, VendorLocalService {

	public VendorLocalServiceWrapper(VendorLocalService vendorLocalService) {
		_vendorLocalService = vendorLocalService;
	}

	/**
	 * Adds the vendor to the database. Also notifies the appropriate model listeners.
	 *
	 * @param vendor the vendor
	 * @return the vendor that was added
	 */
	@Override
	public it.scinti.lfr.secpg.sqlinjection.model.Vendor addVendor(
		it.scinti.lfr.secpg.sqlinjection.model.Vendor vendor) {

		return _vendorLocalService.addVendor(vendor);
	}

	/**
	 * Creates a new vendor with the primary key. Does not add the vendor to the database.
	 *
	 * @param vendorId the primary key for the new vendor
	 * @return the new vendor
	 */
	@Override
	public it.scinti.lfr.secpg.sqlinjection.model.Vendor createVendor(
		long vendorId) {

		return _vendorLocalService.createVendor(vendorId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _vendorLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the vendor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param vendorId the primary key of the vendor
	 * @return the vendor that was removed
	 * @throws PortalException if a vendor with the primary key could not be found
	 */
	@Override
	public it.scinti.lfr.secpg.sqlinjection.model.Vendor deleteVendor(
			long vendorId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _vendorLocalService.deleteVendor(vendorId);
	}

	/**
	 * Deletes the vendor from the database. Also notifies the appropriate model listeners.
	 *
	 * @param vendor the vendor
	 * @return the vendor that was removed
	 */
	@Override
	public it.scinti.lfr.secpg.sqlinjection.model.Vendor deleteVendor(
		it.scinti.lfr.secpg.sqlinjection.model.Vendor vendor) {

		return _vendorLocalService.deleteVendor(vendor);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _vendorLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _vendorLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.scinti.lfr.secpg.sqlinjection.model.impl.VendorModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _vendorLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.scinti.lfr.secpg.sqlinjection.model.impl.VendorModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _vendorLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _vendorLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _vendorLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public it.scinti.lfr.secpg.sqlinjection.model.Vendor fetchVendor(
		long vendorId) {

		return _vendorLocalService.fetchVendor(vendorId);
	}

	/**
	 * Returns the vendor matching the UUID and group.
	 *
	 * @param uuid the vendor's UUID
	 * @param groupId the primary key of the group
	 * @return the matching vendor, or <code>null</code> if a matching vendor could not be found
	 */
	@Override
	public it.scinti.lfr.secpg.sqlinjection.model.Vendor
		fetchVendorByUuidAndGroupId(String uuid, long groupId) {

		return _vendorLocalService.fetchVendorByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _vendorLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _vendorLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _vendorLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _vendorLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _vendorLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the vendor with the primary key.
	 *
	 * @param vendorId the primary key of the vendor
	 * @return the vendor
	 * @throws PortalException if a vendor with the primary key could not be found
	 */
	@Override
	public it.scinti.lfr.secpg.sqlinjection.model.Vendor getVendor(
			long vendorId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _vendorLocalService.getVendor(vendorId);
	}

	/**
	 * Returns the vendor matching the UUID and group.
	 *
	 * @param uuid the vendor's UUID
	 * @param groupId the primary key of the group
	 * @return the matching vendor
	 * @throws PortalException if a matching vendor could not be found
	 */
	@Override
	public it.scinti.lfr.secpg.sqlinjection.model.Vendor
			getVendorByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _vendorLocalService.getVendorByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the vendors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>it.scinti.lfr.secpg.sqlinjection.model.impl.VendorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of vendors
	 * @param end the upper bound of the range of vendors (not inclusive)
	 * @return the range of vendors
	 */
	@Override
	public java.util.List<it.scinti.lfr.secpg.sqlinjection.model.Vendor>
		getVendors(int start, int end) {

		return _vendorLocalService.getVendors(start, end);
	}

	/**
	 * Returns all the vendors matching the UUID and company.
	 *
	 * @param uuid the UUID of the vendors
	 * @param companyId the primary key of the company
	 * @return the matching vendors, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<it.scinti.lfr.secpg.sqlinjection.model.Vendor>
		getVendorsByUuidAndCompanyId(String uuid, long companyId) {

		return _vendorLocalService.getVendorsByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<it.scinti.lfr.secpg.sqlinjection.model.Vendor>
		getVendorsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<it.scinti.lfr.secpg.sqlinjection.model.Vendor>
					orderByComparator) {

		return _vendorLocalService.getVendorsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of vendors.
	 *
	 * @return the number of vendors
	 */
	@Override
	public int getVendorsCount() {
		return _vendorLocalService.getVendorsCount();
	}

	/**
	 * Updates the vendor in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param vendor the vendor
	 * @return the vendor that was updated
	 */
	@Override
	public it.scinti.lfr.secpg.sqlinjection.model.Vendor updateVendor(
		it.scinti.lfr.secpg.sqlinjection.model.Vendor vendor) {

		return _vendorLocalService.updateVendor(vendor);
	}

	@Override
	public VendorLocalService getWrappedService() {
		return _vendorLocalService;
	}

	@Override
	public void setWrappedService(VendorLocalService vendorLocalService) {
		_vendorLocalService = vendorLocalService;
	}

	private VendorLocalService _vendorLocalService;

}