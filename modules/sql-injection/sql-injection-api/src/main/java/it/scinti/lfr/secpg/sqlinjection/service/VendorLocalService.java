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

import com.liferay.exportimport.kernel.lar.PortletDataContext;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.scinti.lfr.secpg.sqlinjection.model.Vendor;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for Vendor. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see VendorLocalServiceUtil
 * @see it.scinti.lfr.secpg.sqlinjection.service.base.VendorLocalServiceBaseImpl
 * @see it.scinti.lfr.secpg.sqlinjection.service.impl.VendorLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface VendorLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VendorLocalServiceUtil} to access the vendor local service. Add custom service methods to {@link it.scinti.lfr.secpg.sqlinjection.service.impl.VendorLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public Vendor addVendor(long companyId, String name, String description,
		String hwId, String metadata, String website) throws PortalException;

	/**
	* Adds the vendor to the database. Also notifies the appropriate model listeners.
	*
	* @param vendor the vendor
	* @return the vendor that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Vendor addVendor(Vendor vendor);

	/**
	* Creates a new vendor with the primary key. Does not add the vendor to the database.
	*
	* @param vendorId the primary key for the new vendor
	* @return the new vendor
	*/
	@Transactional(enabled = false)
	public Vendor createVendor(long vendorId);

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	* Deletes the vendor with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vendorId the primary key of the vendor
	* @return the vendor that was removed
	* @throws PortalException if a vendor with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public Vendor deleteVendor(long vendorId) throws PortalException;

	/**
	* Deletes the vendor from the database. Also notifies the appropriate model listeners.
	*
	* @param vendor the vendor
	* @return the vendor that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public Vendor deleteVendor(Vendor vendor);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Vendor fetchVendor(long vendorId);

	/**
	* Returns the vendor matching the UUID and group.
	*
	* @param uuid the vendor's UUID
	* @param groupId the primary key of the group
	* @return the matching vendor, or <code>null</code> if a matching vendor could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Vendor fetchVendorByUuidAndGroupId(String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public String getOSGiServiceIdentifier();

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	* Returns the vendor with the primary key.
	*
	* @param vendorId the primary key of the vendor
	* @return the vendor
	* @throws PortalException if a vendor with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Vendor getVendor(long vendorId) throws PortalException;

	/**
	* Returns the vendor matching the UUID and group.
	*
	* @param uuid the vendor's UUID
	* @param groupId the primary key of the group
	* @return the matching vendor
	* @throws PortalException if a matching vendor could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Vendor getVendorByUuidAndGroupId(String uuid, long groupId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Vendor> getVendors(int start, int end);

	/**
	* Returns all the vendors matching the UUID and company.
	*
	* @param uuid the UUID of the vendors
	* @param companyId the primary key of the company
	* @return the matching vendors, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Vendor> getVendorsByUuidAndCompanyId(String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Vendor> getVendorsByUuidAndCompanyId(String uuid,
		long companyId, int start, int end,
		OrderByComparator<Vendor> orderByComparator);

	/**
	* Returns the number of vendors.
	*
	* @return the number of vendors
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getVendorsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Vendor> searchVendors(long companyId, String keyword,
		int start, int end, OrderByComparator<Vendor> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int searchVendorsCount(long companyId, String keyword);

	/**
	* Updates the vendor in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vendor the vendor
	* @return the vendor that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Vendor updateVendor(Vendor vendor);
}