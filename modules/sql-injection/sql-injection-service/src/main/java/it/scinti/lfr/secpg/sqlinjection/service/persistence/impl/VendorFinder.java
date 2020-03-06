package it.scinti.lfr.secpg.sqlinjection.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public interface VendorFinder {

	public int searchVendorsCount(long companyId, String keyword);

	public java.util.List<it.scinti.lfr.secpg.sqlinjection.model.Vendor>
		searchVendors(
			long companyId, String keyword, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<it.scinti.lfr.secpg.sqlinjection.model.Vendor>
					orderByComparator);

}