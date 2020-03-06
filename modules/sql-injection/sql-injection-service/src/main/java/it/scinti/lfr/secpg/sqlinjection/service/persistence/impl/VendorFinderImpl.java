package it.scinti.lfr.secpg.sqlinjection.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.util.dao.orm.CustomSQLUtil;

import java.util.Iterator;
import java.util.List;

import it.scinti.lfr.secpg.sqlinjection.model.Vendor;
import it.scinti.lfr.secpg.sqlinjection.model.impl.VendorImpl;
import it.scinti.lfr.secpg.sqlinjection.model.impl.VendorModelImpl;

public class VendorFinderImpl 
	extends VendorFinderBaseImpl implements VendorFinder {

	public static final String SEARCH_VENDORS_COUNT =
		Vendor.class.getName() + ".searchVendorsCount";

	public static final String SEARCH_VENDORS =
		Vendor.class.getName() + ".searchVendors";
	
	public int searchVendorsCount(
		long companyId,
		String keyword) {
		
		keyword = StringUtil.toLowerCase(keyword);
		
		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(SEARCH_VENDORS_COUNT);
			
			sql = StringUtil.replace(
				sql, "[$BankAssociation$]", 
				VendorModelImpl.TABLE_NAME);

			SQLQuery q = session.createSynchronizedSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);
			
			qPos.add(companyId);
			qPos.add(keyword);
			
			Iterator<Long> itr = q.iterate();

			if (itr.hasNext()) {
				Long count = itr.next();

				if (count != null) {
					return count.intValue();
				}
			}
			return 0;
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}
	public List<Vendor> searchVendors(
		long companyId,
		String keyword,
		int start,
		int end,
		OrderByComparator<Vendor> orderByComparator) {
		
		keyword = StringUtil.toLowerCase(keyword);
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(SEARCH_VENDORS);

			String orderBy = (orderByComparator == null) ? 
				"name" : orderByComparator.getOrderBy();
			
			sql = StringUtil.replace(sql, "[$ORDER_BY$]", "ORDER BY " + orderBy);

			sql = StringUtil.replace(
				sql, "[$BankAssociation$]", 
				VendorModelImpl.TABLE_NAME);

				SQLQuery q = session.createSynchronizedSQLQuery(sql);

			q.addEntity("Vendor", VendorImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);
			qPos.add(keyword);
						
			return (List<Vendor>)
				QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}

	}
}
