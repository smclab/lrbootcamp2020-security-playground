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

package it.scinti.lfr.secpg.sqlinjection.service.impl;

import com.liferay.portal.kernel.exception.PortalException;

import java.util.Date;

import it.scinti.lfr.secpg.sqlinjection.model.Vendor;
import it.scinti.lfr.secpg.sqlinjection.service.base.VendorLocalServiceBaseImpl;

/**
 * The implementation of the vendor local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>it.scinti.lfr.secpg.sqlinjection.service.VendorLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VendorLocalServiceBaseImpl
 */
public class VendorLocalServiceImpl extends VendorLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>it.scinti.lfr.secpg.sqlinjection.service.VendorLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>it.scinti.lfr.secpg.sqlinjection.service.VendorLocalServiceUtil</code>.
	 */

	public Vendor fetchVendorByName(String name) {
		return vendorPersistence.fetchByname_First(name, null);
	}
	public Vendor fetchVendorByHwId(String hwId) {
		return vendorPersistence.fetchByhwId_First(hwId, null);
	}

	public Vendor addVendor(long companyId, String name, String description,String hwId, String metadata, String website) throws PortalException {
		long vendorId = counterLocalService.increment();
		Vendor vendor = vendorPersistence.create(vendorId);

		vendor.setCreateDate(new Date());
		vendor.setCompanyId(companyId);

		vendor.setName(name);
		vendor.setDescription(description);
		vendor.setHwId(hwId);
		vendor.setMetadata(metadata);
		vendor.setWebsite(website);
		
		return vendorLocalService.updateVendor(vendor);
		
	}
	public int searchVendorsCount(long companyId, String keyword) {
		return vendorFinder.searchVendorsCount(companyId, keyword);
	}

	public java.util.List<Vendor> searchVendors(long companyId, String keyword,
			int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator) {
		return vendorFinder.searchVendors(companyId, keyword, start, end, orderByComparator);
	}
}