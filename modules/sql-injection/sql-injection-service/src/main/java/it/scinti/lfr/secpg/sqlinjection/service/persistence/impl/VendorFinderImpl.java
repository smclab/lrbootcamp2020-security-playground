package it.scinti.lfr.secpg.sqlinjection.service.persistence.impl;

import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import it.scinti.lfr.secpg.sqlinjection.model.Vendor;
import it.scinti.lfr.secpg.sqlinjection.model.impl.VendorImpl;
import it.scinti.lfr.secpg.sqlinjection.model.impl.VendorModelImpl;
import it.scinti.lfr.secpg.sqlinjection.service.persistence.VendorFinder;

public class VendorFinderImpl 
	extends VendorFinderBaseImpl implements VendorFinder {

	public static final String SEARCH_VENDORS_COUNT =
		VendorFinder.class.getName() + ".searchVendorsCount";

	public static final String SEARCH_VENDORS =
		VendorFinder.class.getName() + ".searchVendors";
	
	public int searchVendorsCount(
		long companyId,
		String keyword) {
		
		keyword = "%" + StringUtil.toLowerCase(keyword) + "%";
		
		Session session = null;

		try {
			session = openSession();

			String sql = _customSQL.get(getClass(), SEARCH_VENDORS_COUNT);
			
			sql = StringUtil.replace(
				sql, "[$Vendor$]", 
				VendorModelImpl.TABLE_NAME);

			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);
			
			qPos.add(companyId);
			qPos.add(keyword);
			qPos.add(keyword);
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
		
		keyword = "%"+ StringUtil.toLowerCase(keyword) + "%";
		
		Session session = null;
		try {
			session = openSession();
			String sql = _customSQL.get(getClass(), SEARCH_VENDORS);

			String orderBy = (orderByComparator == null) ? 
				"[$Vendor$].name" : orderByComparator.getOrderBy();
			
			StringBundler sb = new StringBundler();

/*
 * Safe version:
 * 
			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, "", orderByComparator);
			}
			sql = StringUtil.replace(sql, "[$ORDER_BY$]",
				sb.toString());

*/

/*
 * Vulnerable to SQL Injection attacks version:
 */

			sql = StringUtil.replace(sql, "[$ORDER_BY$]", " ORDER BY " + orderBy);
/*
 */
			sql = StringUtil.replace(
				sql, "[$Vendor$]", 
				VendorModelImpl.TABLE_NAME);

				SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("Vendor", VendorImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);
			qPos.add(keyword);
			qPos.add(keyword);
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
	
	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return VendorModelImpl.TABLE_COLUMNS_MAP;
	}

	@ServiceReference(type = CustomSQL.class)
	private CustomSQL _customSQL;
}
