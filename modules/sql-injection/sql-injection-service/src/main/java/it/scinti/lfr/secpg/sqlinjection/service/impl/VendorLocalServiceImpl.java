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

import it.scinti.lfr.secpg.sqlinjection.model.Vendor;
import it.scinti.lfr.secpg.sqlinjection.service.base.VendorLocalServiceBaseImpl;

/**
 * The implementation of the vendor local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>it.scinti.lfr.secpg.sqlinjection.service.VendorLocalService</code>
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VendorLocalServiceBaseImpl
 */
public class VendorLocalServiceImpl extends VendorLocalServiceBaseImpl {
	public int searchVendorsCount(long companyId, String keyword) {
		return vendorFinder.searchVendorsCount(companyId, keyword);
	}

	public java.util.List<Vendor> searchVendors(long companyId, String keyword,
			int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<Vendor> orderByComparator) {
		return vendorFinder.searchVendors(companyId, keyword, start, end, orderByComparator);
	}
}