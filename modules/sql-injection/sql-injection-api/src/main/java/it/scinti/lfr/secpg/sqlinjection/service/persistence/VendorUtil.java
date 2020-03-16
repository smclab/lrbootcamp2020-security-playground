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

package it.scinti.lfr.secpg.sqlinjection.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.scinti.lfr.secpg.sqlinjection.model.Vendor;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the vendor service. This utility wraps {@link it.scinti.lfr.secpg.sqlinjection.service.persistence.impl.VendorPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VendorPersistence
 * @see it.scinti.lfr.secpg.sqlinjection.service.persistence.impl.VendorPersistenceImpl
 * @generated
 */
@ProviderType
public class VendorUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Vendor vendor) {
		getPersistence().clearCache(vendor);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Vendor> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Vendor> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Vendor> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Vendor> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Vendor update(Vendor vendor) {
		return getPersistence().update(vendor);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Vendor update(Vendor vendor, ServiceContext serviceContext) {
		return getPersistence().update(vendor, serviceContext);
	}

	/**
	* Returns all the vendors where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching vendors
	*/
	public static List<Vendor> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the vendors where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VendorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of vendors
	* @param end the upper bound of the range of vendors (not inclusive)
	* @return the range of matching vendors
	*/
	public static List<Vendor> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the vendors where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VendorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of vendors
	* @param end the upper bound of the range of vendors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vendors
	*/
	public static List<Vendor> findByUuid(String uuid, int start, int end,
		OrderByComparator<Vendor> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the vendors where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VendorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of vendors
	* @param end the upper bound of the range of vendors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching vendors
	*/
	public static List<Vendor> findByUuid(String uuid, int start, int end,
		OrderByComparator<Vendor> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first vendor in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vendor
	* @throws NoSuchVendorException if a matching vendor could not be found
	*/
	public static Vendor findByUuid_First(String uuid,
		OrderByComparator<Vendor> orderByComparator)
		throws it.scinti.lfr.secpg.sqlinjection.exception.NoSuchVendorException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first vendor in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vendor, or <code>null</code> if a matching vendor could not be found
	*/
	public static Vendor fetchByUuid_First(String uuid,
		OrderByComparator<Vendor> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last vendor in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vendor
	* @throws NoSuchVendorException if a matching vendor could not be found
	*/
	public static Vendor findByUuid_Last(String uuid,
		OrderByComparator<Vendor> orderByComparator)
		throws it.scinti.lfr.secpg.sqlinjection.exception.NoSuchVendorException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last vendor in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vendor, or <code>null</code> if a matching vendor could not be found
	*/
	public static Vendor fetchByUuid_Last(String uuid,
		OrderByComparator<Vendor> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the vendors before and after the current vendor in the ordered set where uuid = &#63;.
	*
	* @param vendorId the primary key of the current vendor
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vendor
	* @throws NoSuchVendorException if a vendor with the primary key could not be found
	*/
	public static Vendor[] findByUuid_PrevAndNext(long vendorId, String uuid,
		OrderByComparator<Vendor> orderByComparator)
		throws it.scinti.lfr.secpg.sqlinjection.exception.NoSuchVendorException {
		return getPersistence()
				   .findByUuid_PrevAndNext(vendorId, uuid, orderByComparator);
	}

	/**
	* Removes all the vendors where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of vendors where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching vendors
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the vendor where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchVendorException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching vendor
	* @throws NoSuchVendorException if a matching vendor could not be found
	*/
	public static Vendor findByUUID_G(String uuid, long groupId)
		throws it.scinti.lfr.secpg.sqlinjection.exception.NoSuchVendorException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the vendor where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching vendor, or <code>null</code> if a matching vendor could not be found
	*/
	public static Vendor fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the vendor where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching vendor, or <code>null</code> if a matching vendor could not be found
	*/
	public static Vendor fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the vendor where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the vendor that was removed
	*/
	public static Vendor removeByUUID_G(String uuid, long groupId)
		throws it.scinti.lfr.secpg.sqlinjection.exception.NoSuchVendorException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of vendors where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching vendors
	*/
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the vendors where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching vendors
	*/
	public static List<Vendor> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the vendors where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VendorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of vendors
	* @param end the upper bound of the range of vendors (not inclusive)
	* @return the range of matching vendors
	*/
	public static List<Vendor> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the vendors where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VendorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of vendors
	* @param end the upper bound of the range of vendors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vendors
	*/
	public static List<Vendor> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<Vendor> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the vendors where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VendorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of vendors
	* @param end the upper bound of the range of vendors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching vendors
	*/
	public static List<Vendor> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<Vendor> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first vendor in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vendor
	* @throws NoSuchVendorException if a matching vendor could not be found
	*/
	public static Vendor findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Vendor> orderByComparator)
		throws it.scinti.lfr.secpg.sqlinjection.exception.NoSuchVendorException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first vendor in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vendor, or <code>null</code> if a matching vendor could not be found
	*/
	public static Vendor fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Vendor> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last vendor in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vendor
	* @throws NoSuchVendorException if a matching vendor could not be found
	*/
	public static Vendor findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Vendor> orderByComparator)
		throws it.scinti.lfr.secpg.sqlinjection.exception.NoSuchVendorException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last vendor in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vendor, or <code>null</code> if a matching vendor could not be found
	*/
	public static Vendor fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Vendor> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the vendors before and after the current vendor in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param vendorId the primary key of the current vendor
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vendor
	* @throws NoSuchVendorException if a vendor with the primary key could not be found
	*/
	public static Vendor[] findByUuid_C_PrevAndNext(long vendorId, String uuid,
		long companyId, OrderByComparator<Vendor> orderByComparator)
		throws it.scinti.lfr.secpg.sqlinjection.exception.NoSuchVendorException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(vendorId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the vendors where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of vendors where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching vendors
	*/
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the vendors where hwId = &#63;.
	*
	* @param hwId the hw ID
	* @return the matching vendors
	*/
	public static List<Vendor> findByhwId(String hwId) {
		return getPersistence().findByhwId(hwId);
	}

	/**
	* Returns a range of all the vendors where hwId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VendorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param hwId the hw ID
	* @param start the lower bound of the range of vendors
	* @param end the upper bound of the range of vendors (not inclusive)
	* @return the range of matching vendors
	*/
	public static List<Vendor> findByhwId(String hwId, int start, int end) {
		return getPersistence().findByhwId(hwId, start, end);
	}

	/**
	* Returns an ordered range of all the vendors where hwId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VendorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param hwId the hw ID
	* @param start the lower bound of the range of vendors
	* @param end the upper bound of the range of vendors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vendors
	*/
	public static List<Vendor> findByhwId(String hwId, int start, int end,
		OrderByComparator<Vendor> orderByComparator) {
		return getPersistence().findByhwId(hwId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the vendors where hwId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VendorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param hwId the hw ID
	* @param start the lower bound of the range of vendors
	* @param end the upper bound of the range of vendors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching vendors
	*/
	public static List<Vendor> findByhwId(String hwId, int start, int end,
		OrderByComparator<Vendor> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByhwId(hwId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first vendor in the ordered set where hwId = &#63;.
	*
	* @param hwId the hw ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vendor
	* @throws NoSuchVendorException if a matching vendor could not be found
	*/
	public static Vendor findByhwId_First(String hwId,
		OrderByComparator<Vendor> orderByComparator)
		throws it.scinti.lfr.secpg.sqlinjection.exception.NoSuchVendorException {
		return getPersistence().findByhwId_First(hwId, orderByComparator);
	}

	/**
	* Returns the first vendor in the ordered set where hwId = &#63;.
	*
	* @param hwId the hw ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vendor, or <code>null</code> if a matching vendor could not be found
	*/
	public static Vendor fetchByhwId_First(String hwId,
		OrderByComparator<Vendor> orderByComparator) {
		return getPersistence().fetchByhwId_First(hwId, orderByComparator);
	}

	/**
	* Returns the last vendor in the ordered set where hwId = &#63;.
	*
	* @param hwId the hw ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vendor
	* @throws NoSuchVendorException if a matching vendor could not be found
	*/
	public static Vendor findByhwId_Last(String hwId,
		OrderByComparator<Vendor> orderByComparator)
		throws it.scinti.lfr.secpg.sqlinjection.exception.NoSuchVendorException {
		return getPersistence().findByhwId_Last(hwId, orderByComparator);
	}

	/**
	* Returns the last vendor in the ordered set where hwId = &#63;.
	*
	* @param hwId the hw ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vendor, or <code>null</code> if a matching vendor could not be found
	*/
	public static Vendor fetchByhwId_Last(String hwId,
		OrderByComparator<Vendor> orderByComparator) {
		return getPersistence().fetchByhwId_Last(hwId, orderByComparator);
	}

	/**
	* Returns the vendors before and after the current vendor in the ordered set where hwId = &#63;.
	*
	* @param vendorId the primary key of the current vendor
	* @param hwId the hw ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vendor
	* @throws NoSuchVendorException if a vendor with the primary key could not be found
	*/
	public static Vendor[] findByhwId_PrevAndNext(long vendorId, String hwId,
		OrderByComparator<Vendor> orderByComparator)
		throws it.scinti.lfr.secpg.sqlinjection.exception.NoSuchVendorException {
		return getPersistence()
				   .findByhwId_PrevAndNext(vendorId, hwId, orderByComparator);
	}

	/**
	* Removes all the vendors where hwId = &#63; from the database.
	*
	* @param hwId the hw ID
	*/
	public static void removeByhwId(String hwId) {
		getPersistence().removeByhwId(hwId);
	}

	/**
	* Returns the number of vendors where hwId = &#63;.
	*
	* @param hwId the hw ID
	* @return the number of matching vendors
	*/
	public static int countByhwId(String hwId) {
		return getPersistence().countByhwId(hwId);
	}

	/**
	* Returns all the vendors where name = &#63;.
	*
	* @param name the name
	* @return the matching vendors
	*/
	public static List<Vendor> findByname(String name) {
		return getPersistence().findByname(name);
	}

	/**
	* Returns a range of all the vendors where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VendorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of vendors
	* @param end the upper bound of the range of vendors (not inclusive)
	* @return the range of matching vendors
	*/
	public static List<Vendor> findByname(String name, int start, int end) {
		return getPersistence().findByname(name, start, end);
	}

	/**
	* Returns an ordered range of all the vendors where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VendorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of vendors
	* @param end the upper bound of the range of vendors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vendors
	*/
	public static List<Vendor> findByname(String name, int start, int end,
		OrderByComparator<Vendor> orderByComparator) {
		return getPersistence().findByname(name, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the vendors where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VendorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of vendors
	* @param end the upper bound of the range of vendors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching vendors
	*/
	public static List<Vendor> findByname(String name, int start, int end,
		OrderByComparator<Vendor> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByname(name, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first vendor in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vendor
	* @throws NoSuchVendorException if a matching vendor could not be found
	*/
	public static Vendor findByname_First(String name,
		OrderByComparator<Vendor> orderByComparator)
		throws it.scinti.lfr.secpg.sqlinjection.exception.NoSuchVendorException {
		return getPersistence().findByname_First(name, orderByComparator);
	}

	/**
	* Returns the first vendor in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vendor, or <code>null</code> if a matching vendor could not be found
	*/
	public static Vendor fetchByname_First(String name,
		OrderByComparator<Vendor> orderByComparator) {
		return getPersistence().fetchByname_First(name, orderByComparator);
	}

	/**
	* Returns the last vendor in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vendor
	* @throws NoSuchVendorException if a matching vendor could not be found
	*/
	public static Vendor findByname_Last(String name,
		OrderByComparator<Vendor> orderByComparator)
		throws it.scinti.lfr.secpg.sqlinjection.exception.NoSuchVendorException {
		return getPersistence().findByname_Last(name, orderByComparator);
	}

	/**
	* Returns the last vendor in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vendor, or <code>null</code> if a matching vendor could not be found
	*/
	public static Vendor fetchByname_Last(String name,
		OrderByComparator<Vendor> orderByComparator) {
		return getPersistence().fetchByname_Last(name, orderByComparator);
	}

	/**
	* Returns the vendors before and after the current vendor in the ordered set where name = &#63;.
	*
	* @param vendorId the primary key of the current vendor
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vendor
	* @throws NoSuchVendorException if a vendor with the primary key could not be found
	*/
	public static Vendor[] findByname_PrevAndNext(long vendorId, String name,
		OrderByComparator<Vendor> orderByComparator)
		throws it.scinti.lfr.secpg.sqlinjection.exception.NoSuchVendorException {
		return getPersistence()
				   .findByname_PrevAndNext(vendorId, name, orderByComparator);
	}

	/**
	* Removes all the vendors where name = &#63; from the database.
	*
	* @param name the name
	*/
	public static void removeByname(String name) {
		getPersistence().removeByname(name);
	}

	/**
	* Returns the number of vendors where name = &#63;.
	*
	* @param name the name
	* @return the number of matching vendors
	*/
	public static int countByname(String name) {
		return getPersistence().countByname(name);
	}

	/**
	* Returns all the vendors where description = &#63;.
	*
	* @param description the description
	* @return the matching vendors
	*/
	public static List<Vendor> findBydescription(String description) {
		return getPersistence().findBydescription(description);
	}

	/**
	* Returns a range of all the vendors where description = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VendorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param description the description
	* @param start the lower bound of the range of vendors
	* @param end the upper bound of the range of vendors (not inclusive)
	* @return the range of matching vendors
	*/
	public static List<Vendor> findBydescription(String description, int start,
		int end) {
		return getPersistence().findBydescription(description, start, end);
	}

	/**
	* Returns an ordered range of all the vendors where description = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VendorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param description the description
	* @param start the lower bound of the range of vendors
	* @param end the upper bound of the range of vendors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vendors
	*/
	public static List<Vendor> findBydescription(String description, int start,
		int end, OrderByComparator<Vendor> orderByComparator) {
		return getPersistence()
				   .findBydescription(description, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the vendors where description = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VendorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param description the description
	* @param start the lower bound of the range of vendors
	* @param end the upper bound of the range of vendors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching vendors
	*/
	public static List<Vendor> findBydescription(String description, int start,
		int end, OrderByComparator<Vendor> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBydescription(description, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first vendor in the ordered set where description = &#63;.
	*
	* @param description the description
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vendor
	* @throws NoSuchVendorException if a matching vendor could not be found
	*/
	public static Vendor findBydescription_First(String description,
		OrderByComparator<Vendor> orderByComparator)
		throws it.scinti.lfr.secpg.sqlinjection.exception.NoSuchVendorException {
		return getPersistence()
				   .findBydescription_First(description, orderByComparator);
	}

	/**
	* Returns the first vendor in the ordered set where description = &#63;.
	*
	* @param description the description
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vendor, or <code>null</code> if a matching vendor could not be found
	*/
	public static Vendor fetchBydescription_First(String description,
		OrderByComparator<Vendor> orderByComparator) {
		return getPersistence()
				   .fetchBydescription_First(description, orderByComparator);
	}

	/**
	* Returns the last vendor in the ordered set where description = &#63;.
	*
	* @param description the description
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vendor
	* @throws NoSuchVendorException if a matching vendor could not be found
	*/
	public static Vendor findBydescription_Last(String description,
		OrderByComparator<Vendor> orderByComparator)
		throws it.scinti.lfr.secpg.sqlinjection.exception.NoSuchVendorException {
		return getPersistence()
				   .findBydescription_Last(description, orderByComparator);
	}

	/**
	* Returns the last vendor in the ordered set where description = &#63;.
	*
	* @param description the description
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vendor, or <code>null</code> if a matching vendor could not be found
	*/
	public static Vendor fetchBydescription_Last(String description,
		OrderByComparator<Vendor> orderByComparator) {
		return getPersistence()
				   .fetchBydescription_Last(description, orderByComparator);
	}

	/**
	* Returns the vendors before and after the current vendor in the ordered set where description = &#63;.
	*
	* @param vendorId the primary key of the current vendor
	* @param description the description
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vendor
	* @throws NoSuchVendorException if a vendor with the primary key could not be found
	*/
	public static Vendor[] findBydescription_PrevAndNext(long vendorId,
		String description, OrderByComparator<Vendor> orderByComparator)
		throws it.scinti.lfr.secpg.sqlinjection.exception.NoSuchVendorException {
		return getPersistence()
				   .findBydescription_PrevAndNext(vendorId, description,
			orderByComparator);
	}

	/**
	* Removes all the vendors where description = &#63; from the database.
	*
	* @param description the description
	*/
	public static void removeBydescription(String description) {
		getPersistence().removeBydescription(description);
	}

	/**
	* Returns the number of vendors where description = &#63;.
	*
	* @param description the description
	* @return the number of matching vendors
	*/
	public static int countBydescription(String description) {
		return getPersistence().countBydescription(description);
	}

	/**
	* Returns all the vendors where metadata = &#63;.
	*
	* @param metadata the metadata
	* @return the matching vendors
	*/
	public static List<Vendor> findBymetadata(String metadata) {
		return getPersistence().findBymetadata(metadata);
	}

	/**
	* Returns a range of all the vendors where metadata = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VendorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param metadata the metadata
	* @param start the lower bound of the range of vendors
	* @param end the upper bound of the range of vendors (not inclusive)
	* @return the range of matching vendors
	*/
	public static List<Vendor> findBymetadata(String metadata, int start,
		int end) {
		return getPersistence().findBymetadata(metadata, start, end);
	}

	/**
	* Returns an ordered range of all the vendors where metadata = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VendorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param metadata the metadata
	* @param start the lower bound of the range of vendors
	* @param end the upper bound of the range of vendors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vendors
	*/
	public static List<Vendor> findBymetadata(String metadata, int start,
		int end, OrderByComparator<Vendor> orderByComparator) {
		return getPersistence()
				   .findBymetadata(metadata, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the vendors where metadata = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VendorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param metadata the metadata
	* @param start the lower bound of the range of vendors
	* @param end the upper bound of the range of vendors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching vendors
	*/
	public static List<Vendor> findBymetadata(String metadata, int start,
		int end, OrderByComparator<Vendor> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBymetadata(metadata, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first vendor in the ordered set where metadata = &#63;.
	*
	* @param metadata the metadata
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vendor
	* @throws NoSuchVendorException if a matching vendor could not be found
	*/
	public static Vendor findBymetadata_First(String metadata,
		OrderByComparator<Vendor> orderByComparator)
		throws it.scinti.lfr.secpg.sqlinjection.exception.NoSuchVendorException {
		return getPersistence().findBymetadata_First(metadata, orderByComparator);
	}

	/**
	* Returns the first vendor in the ordered set where metadata = &#63;.
	*
	* @param metadata the metadata
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vendor, or <code>null</code> if a matching vendor could not be found
	*/
	public static Vendor fetchBymetadata_First(String metadata,
		OrderByComparator<Vendor> orderByComparator) {
		return getPersistence()
				   .fetchBymetadata_First(metadata, orderByComparator);
	}

	/**
	* Returns the last vendor in the ordered set where metadata = &#63;.
	*
	* @param metadata the metadata
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vendor
	* @throws NoSuchVendorException if a matching vendor could not be found
	*/
	public static Vendor findBymetadata_Last(String metadata,
		OrderByComparator<Vendor> orderByComparator)
		throws it.scinti.lfr.secpg.sqlinjection.exception.NoSuchVendorException {
		return getPersistence().findBymetadata_Last(metadata, orderByComparator);
	}

	/**
	* Returns the last vendor in the ordered set where metadata = &#63;.
	*
	* @param metadata the metadata
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vendor, or <code>null</code> if a matching vendor could not be found
	*/
	public static Vendor fetchBymetadata_Last(String metadata,
		OrderByComparator<Vendor> orderByComparator) {
		return getPersistence().fetchBymetadata_Last(metadata, orderByComparator);
	}

	/**
	* Returns the vendors before and after the current vendor in the ordered set where metadata = &#63;.
	*
	* @param vendorId the primary key of the current vendor
	* @param metadata the metadata
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vendor
	* @throws NoSuchVendorException if a vendor with the primary key could not be found
	*/
	public static Vendor[] findBymetadata_PrevAndNext(long vendorId,
		String metadata, OrderByComparator<Vendor> orderByComparator)
		throws it.scinti.lfr.secpg.sqlinjection.exception.NoSuchVendorException {
		return getPersistence()
				   .findBymetadata_PrevAndNext(vendorId, metadata,
			orderByComparator);
	}

	/**
	* Removes all the vendors where metadata = &#63; from the database.
	*
	* @param metadata the metadata
	*/
	public static void removeBymetadata(String metadata) {
		getPersistence().removeBymetadata(metadata);
	}

	/**
	* Returns the number of vendors where metadata = &#63;.
	*
	* @param metadata the metadata
	* @return the number of matching vendors
	*/
	public static int countBymetadata(String metadata) {
		return getPersistence().countBymetadata(metadata);
	}

	/**
	* Returns all the vendors where website = &#63;.
	*
	* @param website the website
	* @return the matching vendors
	*/
	public static List<Vendor> findBywebsite(String website) {
		return getPersistence().findBywebsite(website);
	}

	/**
	* Returns a range of all the vendors where website = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VendorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param website the website
	* @param start the lower bound of the range of vendors
	* @param end the upper bound of the range of vendors (not inclusive)
	* @return the range of matching vendors
	*/
	public static List<Vendor> findBywebsite(String website, int start, int end) {
		return getPersistence().findBywebsite(website, start, end);
	}

	/**
	* Returns an ordered range of all the vendors where website = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VendorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param website the website
	* @param start the lower bound of the range of vendors
	* @param end the upper bound of the range of vendors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vendors
	*/
	public static List<Vendor> findBywebsite(String website, int start,
		int end, OrderByComparator<Vendor> orderByComparator) {
		return getPersistence()
				   .findBywebsite(website, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the vendors where website = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VendorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param website the website
	* @param start the lower bound of the range of vendors
	* @param end the upper bound of the range of vendors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching vendors
	*/
	public static List<Vendor> findBywebsite(String website, int start,
		int end, OrderByComparator<Vendor> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBywebsite(website, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first vendor in the ordered set where website = &#63;.
	*
	* @param website the website
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vendor
	* @throws NoSuchVendorException if a matching vendor could not be found
	*/
	public static Vendor findBywebsite_First(String website,
		OrderByComparator<Vendor> orderByComparator)
		throws it.scinti.lfr.secpg.sqlinjection.exception.NoSuchVendorException {
		return getPersistence().findBywebsite_First(website, orderByComparator);
	}

	/**
	* Returns the first vendor in the ordered set where website = &#63;.
	*
	* @param website the website
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vendor, or <code>null</code> if a matching vendor could not be found
	*/
	public static Vendor fetchBywebsite_First(String website,
		OrderByComparator<Vendor> orderByComparator) {
		return getPersistence().fetchBywebsite_First(website, orderByComparator);
	}

	/**
	* Returns the last vendor in the ordered set where website = &#63;.
	*
	* @param website the website
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vendor
	* @throws NoSuchVendorException if a matching vendor could not be found
	*/
	public static Vendor findBywebsite_Last(String website,
		OrderByComparator<Vendor> orderByComparator)
		throws it.scinti.lfr.secpg.sqlinjection.exception.NoSuchVendorException {
		return getPersistence().findBywebsite_Last(website, orderByComparator);
	}

	/**
	* Returns the last vendor in the ordered set where website = &#63;.
	*
	* @param website the website
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vendor, or <code>null</code> if a matching vendor could not be found
	*/
	public static Vendor fetchBywebsite_Last(String website,
		OrderByComparator<Vendor> orderByComparator) {
		return getPersistence().fetchBywebsite_Last(website, orderByComparator);
	}

	/**
	* Returns the vendors before and after the current vendor in the ordered set where website = &#63;.
	*
	* @param vendorId the primary key of the current vendor
	* @param website the website
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vendor
	* @throws NoSuchVendorException if a vendor with the primary key could not be found
	*/
	public static Vendor[] findBywebsite_PrevAndNext(long vendorId,
		String website, OrderByComparator<Vendor> orderByComparator)
		throws it.scinti.lfr.secpg.sqlinjection.exception.NoSuchVendorException {
		return getPersistence()
				   .findBywebsite_PrevAndNext(vendorId, website,
			orderByComparator);
	}

	/**
	* Removes all the vendors where website = &#63; from the database.
	*
	* @param website the website
	*/
	public static void removeBywebsite(String website) {
		getPersistence().removeBywebsite(website);
	}

	/**
	* Returns the number of vendors where website = &#63;.
	*
	* @param website the website
	* @return the number of matching vendors
	*/
	public static int countBywebsite(String website) {
		return getPersistence().countBywebsite(website);
	}

	/**
	* Returns all the vendors where name = &#63; and description = &#63; and metadata = &#63;.
	*
	* @param name the name
	* @param description the description
	* @param metadata the metadata
	* @return the matching vendors
	*/
	public static List<Vendor> findByndm(String name, String description,
		String metadata) {
		return getPersistence().findByndm(name, description, metadata);
	}

	/**
	* Returns a range of all the vendors where name = &#63; and description = &#63; and metadata = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VendorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param description the description
	* @param metadata the metadata
	* @param start the lower bound of the range of vendors
	* @param end the upper bound of the range of vendors (not inclusive)
	* @return the range of matching vendors
	*/
	public static List<Vendor> findByndm(String name, String description,
		String metadata, int start, int end) {
		return getPersistence()
				   .findByndm(name, description, metadata, start, end);
	}

	/**
	* Returns an ordered range of all the vendors where name = &#63; and description = &#63; and metadata = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VendorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param description the description
	* @param metadata the metadata
	* @param start the lower bound of the range of vendors
	* @param end the upper bound of the range of vendors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vendors
	*/
	public static List<Vendor> findByndm(String name, String description,
		String metadata, int start, int end,
		OrderByComparator<Vendor> orderByComparator) {
		return getPersistence()
				   .findByndm(name, description, metadata, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the vendors where name = &#63; and description = &#63; and metadata = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VendorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param description the description
	* @param metadata the metadata
	* @param start the lower bound of the range of vendors
	* @param end the upper bound of the range of vendors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching vendors
	*/
	public static List<Vendor> findByndm(String name, String description,
		String metadata, int start, int end,
		OrderByComparator<Vendor> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByndm(name, description, metadata, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first vendor in the ordered set where name = &#63; and description = &#63; and metadata = &#63;.
	*
	* @param name the name
	* @param description the description
	* @param metadata the metadata
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vendor
	* @throws NoSuchVendorException if a matching vendor could not be found
	*/
	public static Vendor findByndm_First(String name, String description,
		String metadata, OrderByComparator<Vendor> orderByComparator)
		throws it.scinti.lfr.secpg.sqlinjection.exception.NoSuchVendorException {
		return getPersistence()
				   .findByndm_First(name, description, metadata,
			orderByComparator);
	}

	/**
	* Returns the first vendor in the ordered set where name = &#63; and description = &#63; and metadata = &#63;.
	*
	* @param name the name
	* @param description the description
	* @param metadata the metadata
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vendor, or <code>null</code> if a matching vendor could not be found
	*/
	public static Vendor fetchByndm_First(String name, String description,
		String metadata, OrderByComparator<Vendor> orderByComparator) {
		return getPersistence()
				   .fetchByndm_First(name, description, metadata,
			orderByComparator);
	}

	/**
	* Returns the last vendor in the ordered set where name = &#63; and description = &#63; and metadata = &#63;.
	*
	* @param name the name
	* @param description the description
	* @param metadata the metadata
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vendor
	* @throws NoSuchVendorException if a matching vendor could not be found
	*/
	public static Vendor findByndm_Last(String name, String description,
		String metadata, OrderByComparator<Vendor> orderByComparator)
		throws it.scinti.lfr.secpg.sqlinjection.exception.NoSuchVendorException {
		return getPersistence()
				   .findByndm_Last(name, description, metadata,
			orderByComparator);
	}

	/**
	* Returns the last vendor in the ordered set where name = &#63; and description = &#63; and metadata = &#63;.
	*
	* @param name the name
	* @param description the description
	* @param metadata the metadata
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vendor, or <code>null</code> if a matching vendor could not be found
	*/
	public static Vendor fetchByndm_Last(String name, String description,
		String metadata, OrderByComparator<Vendor> orderByComparator) {
		return getPersistence()
				   .fetchByndm_Last(name, description, metadata,
			orderByComparator);
	}

	/**
	* Returns the vendors before and after the current vendor in the ordered set where name = &#63; and description = &#63; and metadata = &#63;.
	*
	* @param vendorId the primary key of the current vendor
	* @param name the name
	* @param description the description
	* @param metadata the metadata
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vendor
	* @throws NoSuchVendorException if a vendor with the primary key could not be found
	*/
	public static Vendor[] findByndm_PrevAndNext(long vendorId, String name,
		String description, String metadata,
		OrderByComparator<Vendor> orderByComparator)
		throws it.scinti.lfr.secpg.sqlinjection.exception.NoSuchVendorException {
		return getPersistence()
				   .findByndm_PrevAndNext(vendorId, name, description,
			metadata, orderByComparator);
	}

	/**
	* Removes all the vendors where name = &#63; and description = &#63; and metadata = &#63; from the database.
	*
	* @param name the name
	* @param description the description
	* @param metadata the metadata
	*/
	public static void removeByndm(String name, String description,
		String metadata) {
		getPersistence().removeByndm(name, description, metadata);
	}

	/**
	* Returns the number of vendors where name = &#63; and description = &#63; and metadata = &#63;.
	*
	* @param name the name
	* @param description the description
	* @param metadata the metadata
	* @return the number of matching vendors
	*/
	public static int countByndm(String name, String description,
		String metadata) {
		return getPersistence().countByndm(name, description, metadata);
	}

	/**
	* Caches the vendor in the entity cache if it is enabled.
	*
	* @param vendor the vendor
	*/
	public static void cacheResult(Vendor vendor) {
		getPersistence().cacheResult(vendor);
	}

	/**
	* Caches the vendors in the entity cache if it is enabled.
	*
	* @param vendors the vendors
	*/
	public static void cacheResult(List<Vendor> vendors) {
		getPersistence().cacheResult(vendors);
	}

	/**
	* Creates a new vendor with the primary key. Does not add the vendor to the database.
	*
	* @param vendorId the primary key for the new vendor
	* @return the new vendor
	*/
	public static Vendor create(long vendorId) {
		return getPersistence().create(vendorId);
	}

	/**
	* Removes the vendor with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vendorId the primary key of the vendor
	* @return the vendor that was removed
	* @throws NoSuchVendorException if a vendor with the primary key could not be found
	*/
	public static Vendor remove(long vendorId)
		throws it.scinti.lfr.secpg.sqlinjection.exception.NoSuchVendorException {
		return getPersistence().remove(vendorId);
	}

	public static Vendor updateImpl(Vendor vendor) {
		return getPersistence().updateImpl(vendor);
	}

	/**
	* Returns the vendor with the primary key or throws a {@link NoSuchVendorException} if it could not be found.
	*
	* @param vendorId the primary key of the vendor
	* @return the vendor
	* @throws NoSuchVendorException if a vendor with the primary key could not be found
	*/
	public static Vendor findByPrimaryKey(long vendorId)
		throws it.scinti.lfr.secpg.sqlinjection.exception.NoSuchVendorException {
		return getPersistence().findByPrimaryKey(vendorId);
	}

	/**
	* Returns the vendor with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param vendorId the primary key of the vendor
	* @return the vendor, or <code>null</code> if a vendor with the primary key could not be found
	*/
	public static Vendor fetchByPrimaryKey(long vendorId) {
		return getPersistence().fetchByPrimaryKey(vendorId);
	}

	public static java.util.Map<java.io.Serializable, Vendor> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the vendors.
	*
	* @return the vendors
	*/
	public static List<Vendor> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the vendors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VendorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of vendors
	* @param end the upper bound of the range of vendors (not inclusive)
	* @return the range of vendors
	*/
	public static List<Vendor> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the vendors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VendorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of vendors
	* @param end the upper bound of the range of vendors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of vendors
	*/
	public static List<Vendor> findAll(int start, int end,
		OrderByComparator<Vendor> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the vendors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link VendorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of vendors
	* @param end the upper bound of the range of vendors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of vendors
	*/
	public static List<Vendor> findAll(int start, int end,
		OrderByComparator<Vendor> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the vendors from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of vendors.
	*
	* @return the number of vendors
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static VendorPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<VendorPersistence, VendorPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(VendorPersistence.class);

		ServiceTracker<VendorPersistence, VendorPersistence> serviceTracker = new ServiceTracker<VendorPersistence, VendorPersistence>(bundle.getBundleContext(),
				VendorPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}