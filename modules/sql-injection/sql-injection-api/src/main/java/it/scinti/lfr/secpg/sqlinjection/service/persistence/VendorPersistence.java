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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import it.scinti.lfr.secpg.sqlinjection.exception.NoSuchVendorException;
import it.scinti.lfr.secpg.sqlinjection.model.Vendor;

/**
 * The persistence interface for the vendor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see it.scinti.lfr.secpg.sqlinjection.service.persistence.impl.VendorPersistenceImpl
 * @see VendorUtil
 * @generated
 */
@ProviderType
public interface VendorPersistence extends BasePersistence<Vendor> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VendorUtil} to access the vendor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the vendors where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching vendors
	*/
	public java.util.List<Vendor> findByUuid(String uuid);

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
	public java.util.List<Vendor> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Vendor> findByUuid(String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator);

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
	public java.util.List<Vendor> findByUuid(String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first vendor in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vendor
	* @throws NoSuchVendorException if a matching vendor could not be found
	*/
	public Vendor findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException;

	/**
	* Returns the first vendor in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vendor, or <code>null</code> if a matching vendor could not be found
	*/
	public Vendor fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator);

	/**
	* Returns the last vendor in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vendor
	* @throws NoSuchVendorException if a matching vendor could not be found
	*/
	public Vendor findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException;

	/**
	* Returns the last vendor in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vendor, or <code>null</code> if a matching vendor could not be found
	*/
	public Vendor fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator);

	/**
	* Returns the vendors before and after the current vendor in the ordered set where uuid = &#63;.
	*
	* @param vendorId the primary key of the current vendor
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vendor
	* @throws NoSuchVendorException if a vendor with the primary key could not be found
	*/
	public Vendor[] findByUuid_PrevAndNext(long vendorId, String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException;

	/**
	* Removes all the vendors where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of vendors where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching vendors
	*/
	public int countByUuid(String uuid);

	/**
	* Returns the vendor where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchVendorException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching vendor
	* @throws NoSuchVendorException if a matching vendor could not be found
	*/
	public Vendor findByUUID_G(String uuid, long groupId)
		throws NoSuchVendorException;

	/**
	* Returns the vendor where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching vendor, or <code>null</code> if a matching vendor could not be found
	*/
	public Vendor fetchByUUID_G(String uuid, long groupId);

	/**
	* Returns the vendor where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching vendor, or <code>null</code> if a matching vendor could not be found
	*/
	public Vendor fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the vendor where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the vendor that was removed
	*/
	public Vendor removeByUUID_G(String uuid, long groupId)
		throws NoSuchVendorException;

	/**
	* Returns the number of vendors where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching vendors
	*/
	public int countByUUID_G(String uuid, long groupId);

	/**
	* Returns all the vendors where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching vendors
	*/
	public java.util.List<Vendor> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Vendor> findByUuid_C(String uuid, long companyId,
		int start, int end);

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
	public java.util.List<Vendor> findByUuid_C(String uuid, long companyId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator);

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
	public java.util.List<Vendor> findByUuid_C(String uuid, long companyId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first vendor in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vendor
	* @throws NoSuchVendorException if a matching vendor could not be found
	*/
	public Vendor findByUuid_C_First(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException;

	/**
	* Returns the first vendor in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vendor, or <code>null</code> if a matching vendor could not be found
	*/
	public Vendor fetchByUuid_C_First(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator);

	/**
	* Returns the last vendor in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vendor
	* @throws NoSuchVendorException if a matching vendor could not be found
	*/
	public Vendor findByUuid_C_Last(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException;

	/**
	* Returns the last vendor in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vendor, or <code>null</code> if a matching vendor could not be found
	*/
	public Vendor fetchByUuid_C_Last(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator);

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
	public Vendor[] findByUuid_C_PrevAndNext(long vendorId, String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException;

	/**
	* Removes all the vendors where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(String uuid, long companyId);

	/**
	* Returns the number of vendors where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching vendors
	*/
	public int countByUuid_C(String uuid, long companyId);

	/**
	* Returns all the vendors where hwId = &#63;.
	*
	* @param hwId the hw ID
	* @return the matching vendors
	*/
	public java.util.List<Vendor> findByhwId(String hwId);

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
	public java.util.List<Vendor> findByhwId(String hwId, int start, int end);

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
	public java.util.List<Vendor> findByhwId(String hwId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator);

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
	public java.util.List<Vendor> findByhwId(String hwId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first vendor in the ordered set where hwId = &#63;.
	*
	* @param hwId the hw ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vendor
	* @throws NoSuchVendorException if a matching vendor could not be found
	*/
	public Vendor findByhwId_First(String hwId,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException;

	/**
	* Returns the first vendor in the ordered set where hwId = &#63;.
	*
	* @param hwId the hw ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vendor, or <code>null</code> if a matching vendor could not be found
	*/
	public Vendor fetchByhwId_First(String hwId,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator);

	/**
	* Returns the last vendor in the ordered set where hwId = &#63;.
	*
	* @param hwId the hw ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vendor
	* @throws NoSuchVendorException if a matching vendor could not be found
	*/
	public Vendor findByhwId_Last(String hwId,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException;

	/**
	* Returns the last vendor in the ordered set where hwId = &#63;.
	*
	* @param hwId the hw ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vendor, or <code>null</code> if a matching vendor could not be found
	*/
	public Vendor fetchByhwId_Last(String hwId,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator);

	/**
	* Returns the vendors before and after the current vendor in the ordered set where hwId = &#63;.
	*
	* @param vendorId the primary key of the current vendor
	* @param hwId the hw ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vendor
	* @throws NoSuchVendorException if a vendor with the primary key could not be found
	*/
	public Vendor[] findByhwId_PrevAndNext(long vendorId, String hwId,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException;

	/**
	* Removes all the vendors where hwId = &#63; from the database.
	*
	* @param hwId the hw ID
	*/
	public void removeByhwId(String hwId);

	/**
	* Returns the number of vendors where hwId = &#63;.
	*
	* @param hwId the hw ID
	* @return the number of matching vendors
	*/
	public int countByhwId(String hwId);

	/**
	* Returns all the vendors where name = &#63;.
	*
	* @param name the name
	* @return the matching vendors
	*/
	public java.util.List<Vendor> findByname(String name);

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
	public java.util.List<Vendor> findByname(String name, int start, int end);

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
	public java.util.List<Vendor> findByname(String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator);

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
	public java.util.List<Vendor> findByname(String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first vendor in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vendor
	* @throws NoSuchVendorException if a matching vendor could not be found
	*/
	public Vendor findByname_First(String name,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException;

	/**
	* Returns the first vendor in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vendor, or <code>null</code> if a matching vendor could not be found
	*/
	public Vendor fetchByname_First(String name,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator);

	/**
	* Returns the last vendor in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vendor
	* @throws NoSuchVendorException if a matching vendor could not be found
	*/
	public Vendor findByname_Last(String name,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException;

	/**
	* Returns the last vendor in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vendor, or <code>null</code> if a matching vendor could not be found
	*/
	public Vendor fetchByname_Last(String name,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator);

	/**
	* Returns the vendors before and after the current vendor in the ordered set where name = &#63;.
	*
	* @param vendorId the primary key of the current vendor
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vendor
	* @throws NoSuchVendorException if a vendor with the primary key could not be found
	*/
	public Vendor[] findByname_PrevAndNext(long vendorId, String name,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException;

	/**
	* Removes all the vendors where name = &#63; from the database.
	*
	* @param name the name
	*/
	public void removeByname(String name);

	/**
	* Returns the number of vendors where name = &#63;.
	*
	* @param name the name
	* @return the number of matching vendors
	*/
	public int countByname(String name);

	/**
	* Returns all the vendors where description = &#63;.
	*
	* @param description the description
	* @return the matching vendors
	*/
	public java.util.List<Vendor> findBydescription(String description);

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
	public java.util.List<Vendor> findBydescription(String description,
		int start, int end);

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
	public java.util.List<Vendor> findBydescription(String description,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator);

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
	public java.util.List<Vendor> findBydescription(String description,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first vendor in the ordered set where description = &#63;.
	*
	* @param description the description
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vendor
	* @throws NoSuchVendorException if a matching vendor could not be found
	*/
	public Vendor findBydescription_First(String description,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException;

	/**
	* Returns the first vendor in the ordered set where description = &#63;.
	*
	* @param description the description
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vendor, or <code>null</code> if a matching vendor could not be found
	*/
	public Vendor fetchBydescription_First(String description,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator);

	/**
	* Returns the last vendor in the ordered set where description = &#63;.
	*
	* @param description the description
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vendor
	* @throws NoSuchVendorException if a matching vendor could not be found
	*/
	public Vendor findBydescription_Last(String description,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException;

	/**
	* Returns the last vendor in the ordered set where description = &#63;.
	*
	* @param description the description
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vendor, or <code>null</code> if a matching vendor could not be found
	*/
	public Vendor fetchBydescription_Last(String description,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator);

	/**
	* Returns the vendors before and after the current vendor in the ordered set where description = &#63;.
	*
	* @param vendorId the primary key of the current vendor
	* @param description the description
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vendor
	* @throws NoSuchVendorException if a vendor with the primary key could not be found
	*/
	public Vendor[] findBydescription_PrevAndNext(long vendorId,
		String description,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException;

	/**
	* Removes all the vendors where description = &#63; from the database.
	*
	* @param description the description
	*/
	public void removeBydescription(String description);

	/**
	* Returns the number of vendors where description = &#63;.
	*
	* @param description the description
	* @return the number of matching vendors
	*/
	public int countBydescription(String description);

	/**
	* Returns all the vendors where metadata = &#63;.
	*
	* @param metadata the metadata
	* @return the matching vendors
	*/
	public java.util.List<Vendor> findBymetadata(String metadata);

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
	public java.util.List<Vendor> findBymetadata(String metadata, int start,
		int end);

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
	public java.util.List<Vendor> findBymetadata(String metadata, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator);

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
	public java.util.List<Vendor> findBymetadata(String metadata, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first vendor in the ordered set where metadata = &#63;.
	*
	* @param metadata the metadata
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vendor
	* @throws NoSuchVendorException if a matching vendor could not be found
	*/
	public Vendor findBymetadata_First(String metadata,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException;

	/**
	* Returns the first vendor in the ordered set where metadata = &#63;.
	*
	* @param metadata the metadata
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vendor, or <code>null</code> if a matching vendor could not be found
	*/
	public Vendor fetchBymetadata_First(String metadata,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator);

	/**
	* Returns the last vendor in the ordered set where metadata = &#63;.
	*
	* @param metadata the metadata
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vendor
	* @throws NoSuchVendorException if a matching vendor could not be found
	*/
	public Vendor findBymetadata_Last(String metadata,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException;

	/**
	* Returns the last vendor in the ordered set where metadata = &#63;.
	*
	* @param metadata the metadata
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vendor, or <code>null</code> if a matching vendor could not be found
	*/
	public Vendor fetchBymetadata_Last(String metadata,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator);

	/**
	* Returns the vendors before and after the current vendor in the ordered set where metadata = &#63;.
	*
	* @param vendorId the primary key of the current vendor
	* @param metadata the metadata
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vendor
	* @throws NoSuchVendorException if a vendor with the primary key could not be found
	*/
	public Vendor[] findBymetadata_PrevAndNext(long vendorId, String metadata,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException;

	/**
	* Removes all the vendors where metadata = &#63; from the database.
	*
	* @param metadata the metadata
	*/
	public void removeBymetadata(String metadata);

	/**
	* Returns the number of vendors where metadata = &#63;.
	*
	* @param metadata the metadata
	* @return the number of matching vendors
	*/
	public int countBymetadata(String metadata);

	/**
	* Returns all the vendors where website = &#63;.
	*
	* @param website the website
	* @return the matching vendors
	*/
	public java.util.List<Vendor> findBywebsite(String website);

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
	public java.util.List<Vendor> findBywebsite(String website, int start,
		int end);

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
	public java.util.List<Vendor> findBywebsite(String website, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator);

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
	public java.util.List<Vendor> findBywebsite(String website, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first vendor in the ordered set where website = &#63;.
	*
	* @param website the website
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vendor
	* @throws NoSuchVendorException if a matching vendor could not be found
	*/
	public Vendor findBywebsite_First(String website,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException;

	/**
	* Returns the first vendor in the ordered set where website = &#63;.
	*
	* @param website the website
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vendor, or <code>null</code> if a matching vendor could not be found
	*/
	public Vendor fetchBywebsite_First(String website,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator);

	/**
	* Returns the last vendor in the ordered set where website = &#63;.
	*
	* @param website the website
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vendor
	* @throws NoSuchVendorException if a matching vendor could not be found
	*/
	public Vendor findBywebsite_Last(String website,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException;

	/**
	* Returns the last vendor in the ordered set where website = &#63;.
	*
	* @param website the website
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vendor, or <code>null</code> if a matching vendor could not be found
	*/
	public Vendor fetchBywebsite_Last(String website,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator);

	/**
	* Returns the vendors before and after the current vendor in the ordered set where website = &#63;.
	*
	* @param vendorId the primary key of the current vendor
	* @param website the website
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vendor
	* @throws NoSuchVendorException if a vendor with the primary key could not be found
	*/
	public Vendor[] findBywebsite_PrevAndNext(long vendorId, String website,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException;

	/**
	* Removes all the vendors where website = &#63; from the database.
	*
	* @param website the website
	*/
	public void removeBywebsite(String website);

	/**
	* Returns the number of vendors where website = &#63;.
	*
	* @param website the website
	* @return the number of matching vendors
	*/
	public int countBywebsite(String website);

	/**
	* Returns all the vendors where name = &#63; and description = &#63; and metadata = &#63;.
	*
	* @param name the name
	* @param description the description
	* @param metadata the metadata
	* @return the matching vendors
	*/
	public java.util.List<Vendor> findByndm(String name, String description,
		String metadata);

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
	public java.util.List<Vendor> findByndm(String name, String description,
		String metadata, int start, int end);

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
	public java.util.List<Vendor> findByndm(String name, String description,
		String metadata, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator);

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
	public java.util.List<Vendor> findByndm(String name, String description,
		String metadata, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator,
		boolean retrieveFromCache);

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
	public Vendor findByndm_First(String name, String description,
		String metadata,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException;

	/**
	* Returns the first vendor in the ordered set where name = &#63; and description = &#63; and metadata = &#63;.
	*
	* @param name the name
	* @param description the description
	* @param metadata the metadata
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vendor, or <code>null</code> if a matching vendor could not be found
	*/
	public Vendor fetchByndm_First(String name, String description,
		String metadata,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator);

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
	public Vendor findByndm_Last(String name, String description,
		String metadata,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException;

	/**
	* Returns the last vendor in the ordered set where name = &#63; and description = &#63; and metadata = &#63;.
	*
	* @param name the name
	* @param description the description
	* @param metadata the metadata
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vendor, or <code>null</code> if a matching vendor could not be found
	*/
	public Vendor fetchByndm_Last(String name, String description,
		String metadata,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator);

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
	public Vendor[] findByndm_PrevAndNext(long vendorId, String name,
		String description, String metadata,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException;

	/**
	* Removes all the vendors where name = &#63; and description = &#63; and metadata = &#63; from the database.
	*
	* @param name the name
	* @param description the description
	* @param metadata the metadata
	*/
	public void removeByndm(String name, String description, String metadata);

	/**
	* Returns the number of vendors where name = &#63; and description = &#63; and metadata = &#63;.
	*
	* @param name the name
	* @param description the description
	* @param metadata the metadata
	* @return the number of matching vendors
	*/
	public int countByndm(String name, String description, String metadata);

	/**
	* Caches the vendor in the entity cache if it is enabled.
	*
	* @param vendor the vendor
	*/
	public void cacheResult(Vendor vendor);

	/**
	* Caches the vendors in the entity cache if it is enabled.
	*
	* @param vendors the vendors
	*/
	public void cacheResult(java.util.List<Vendor> vendors);

	/**
	* Creates a new vendor with the primary key. Does not add the vendor to the database.
	*
	* @param vendorId the primary key for the new vendor
	* @return the new vendor
	*/
	public Vendor create(long vendorId);

	/**
	* Removes the vendor with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vendorId the primary key of the vendor
	* @return the vendor that was removed
	* @throws NoSuchVendorException if a vendor with the primary key could not be found
	*/
	public Vendor remove(long vendorId) throws NoSuchVendorException;

	public Vendor updateImpl(Vendor vendor);

	/**
	* Returns the vendor with the primary key or throws a {@link NoSuchVendorException} if it could not be found.
	*
	* @param vendorId the primary key of the vendor
	* @return the vendor
	* @throws NoSuchVendorException if a vendor with the primary key could not be found
	*/
	public Vendor findByPrimaryKey(long vendorId) throws NoSuchVendorException;

	/**
	* Returns the vendor with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param vendorId the primary key of the vendor
	* @return the vendor, or <code>null</code> if a vendor with the primary key could not be found
	*/
	public Vendor fetchByPrimaryKey(long vendorId);

	@Override
	public java.util.Map<java.io.Serializable, Vendor> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the vendors.
	*
	* @return the vendors
	*/
	public java.util.List<Vendor> findAll();

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
	public java.util.List<Vendor> findAll(int start, int end);

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
	public java.util.List<Vendor> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator);

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
	public java.util.List<Vendor> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the vendors from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of vendors.
	*
	* @return the number of vendors
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}