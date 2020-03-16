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

package it.scinti.lfr.secpg.sqlinjection.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import it.scinti.lfr.secpg.sqlinjection.exception.NoSuchVendorException;
import it.scinti.lfr.secpg.sqlinjection.model.Vendor;
import it.scinti.lfr.secpg.sqlinjection.model.impl.VendorImpl;
import it.scinti.lfr.secpg.sqlinjection.model.impl.VendorModelImpl;
import it.scinti.lfr.secpg.sqlinjection.service.persistence.VendorPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the vendor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VendorPersistence
 * @see it.scinti.lfr.secpg.sqlinjection.service.persistence.VendorUtil
 * @generated
 */
@ProviderType
public class VendorPersistenceImpl extends BasePersistenceImpl<Vendor>
	implements VendorPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VendorUtil} to access the vendor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VendorImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorModelImpl.FINDER_CACHE_ENABLED, VendorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorModelImpl.FINDER_CACHE_ENABLED, VendorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorModelImpl.FINDER_CACHE_ENABLED, VendorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorModelImpl.FINDER_CACHE_ENABLED, VendorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			VendorModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the vendors where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching vendors
	 */
	@Override
	public List<Vendor> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Vendor> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Vendor> findByUuid(String uuid, int start, int end,
		OrderByComparator<Vendor> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<Vendor> findByUuid(String uuid, int start, int end,
		OrderByComparator<Vendor> orderByComparator, boolean retrieveFromCache) {
		uuid = Objects.toString(uuid, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<Vendor> list = null;

		if (retrieveFromCache) {
			list = (List<Vendor>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Vendor vendor : list) {
					if (!uuid.equals(vendor.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_VENDOR_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VendorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<Vendor>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Vendor>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first vendor in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vendor
	 * @throws NoSuchVendorException if a matching vendor could not be found
	 */
	@Override
	public Vendor findByUuid_First(String uuid,
		OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException {
		Vendor vendor = fetchByUuid_First(uuid, orderByComparator);

		if (vendor != null) {
			return vendor;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchVendorException(msg.toString());
	}

	/**
	 * Returns the first vendor in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vendor, or <code>null</code> if a matching vendor could not be found
	 */
	@Override
	public Vendor fetchByUuid_First(String uuid,
		OrderByComparator<Vendor> orderByComparator) {
		List<Vendor> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last vendor in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vendor
	 * @throws NoSuchVendorException if a matching vendor could not be found
	 */
	@Override
	public Vendor findByUuid_Last(String uuid,
		OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException {
		Vendor vendor = fetchByUuid_Last(uuid, orderByComparator);

		if (vendor != null) {
			return vendor;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchVendorException(msg.toString());
	}

	/**
	 * Returns the last vendor in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vendor, or <code>null</code> if a matching vendor could not be found
	 */
	@Override
	public Vendor fetchByUuid_Last(String uuid,
		OrderByComparator<Vendor> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Vendor> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Vendor[] findByUuid_PrevAndNext(long vendorId, String uuid,
		OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException {
		uuid = Objects.toString(uuid, "");

		Vendor vendor = findByPrimaryKey(vendorId);

		Session session = null;

		try {
			session = openSession();

			Vendor[] array = new VendorImpl[3];

			array[0] = getByUuid_PrevAndNext(session, vendor, uuid,
					orderByComparator, true);

			array[1] = vendor;

			array[2] = getByUuid_PrevAndNext(session, vendor, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Vendor getByUuid_PrevAndNext(Session session, Vendor vendor,
		String uuid, OrderByComparator<Vendor> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VENDOR_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(VendorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vendor);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Vendor> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the vendors where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Vendor vendor : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(vendor);
		}
	}

	/**
	 * Returns the number of vendors where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching vendors
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VENDOR_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "vendor.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "vendor.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(vendor.uuid IS NULL OR vendor.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorModelImpl.FINDER_CACHE_ENABLED, VendorImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			VendorModelImpl.UUID_COLUMN_BITMASK |
			VendorModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the vendor where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchVendorException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching vendor
	 * @throws NoSuchVendorException if a matching vendor could not be found
	 */
	@Override
	public Vendor findByUUID_G(String uuid, long groupId)
		throws NoSuchVendorException {
		Vendor vendor = fetchByUUID_G(uuid, groupId);

		if (vendor == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchVendorException(msg.toString());
		}

		return vendor;
	}

	/**
	 * Returns the vendor where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching vendor, or <code>null</code> if a matching vendor could not be found
	 */
	@Override
	public Vendor fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the vendor where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching vendor, or <code>null</code> if a matching vendor could not be found
	 */
	@Override
	public Vendor fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Vendor) {
			Vendor vendor = (Vendor)result;

			if (!Objects.equals(uuid, vendor.getUuid()) ||
					(groupId != vendor.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_VENDOR_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<Vendor> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					Vendor vendor = list.get(0);

					result = vendor;

					cacheResult(vendor);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Vendor)result;
		}
	}

	/**
	 * Removes the vendor where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the vendor that was removed
	 */
	@Override
	public Vendor removeByUUID_G(String uuid, long groupId)
		throws NoSuchVendorException {
		Vendor vendor = findByUUID_G(uuid, groupId);

		return remove(vendor);
	}

	/**
	 * Returns the number of vendors where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching vendors
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VENDOR_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "vendor.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "vendor.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(vendor.uuid IS NULL OR vendor.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "vendor.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorModelImpl.FINDER_CACHE_ENABLED, VendorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorModelImpl.FINDER_CACHE_ENABLED, VendorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			VendorModelImpl.UUID_COLUMN_BITMASK |
			VendorModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the vendors where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching vendors
	 */
	@Override
	public List<Vendor> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Vendor> findByUuid_C(String uuid, long companyId, int start,
		int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<Vendor> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<Vendor> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<Vendor> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<Vendor> orderByComparator,
		boolean retrieveFromCache) {
		uuid = Objects.toString(uuid, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<Vendor> list = null;

		if (retrieveFromCache) {
			list = (List<Vendor>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Vendor vendor : list) {
					if (!uuid.equals(vendor.getUuid()) ||
							(companyId != vendor.getCompanyId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_VENDOR_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VendorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Vendor>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Vendor>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Vendor findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException {
		Vendor vendor = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (vendor != null) {
			return vendor;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchVendorException(msg.toString());
	}

	/**
	 * Returns the first vendor in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vendor, or <code>null</code> if a matching vendor could not be found
	 */
	@Override
	public Vendor fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Vendor> orderByComparator) {
		List<Vendor> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Vendor findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException {
		Vendor vendor = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (vendor != null) {
			return vendor;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchVendorException(msg.toString());
	}

	/**
	 * Returns the last vendor in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vendor, or <code>null</code> if a matching vendor could not be found
	 */
	@Override
	public Vendor fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Vendor> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Vendor> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Vendor[] findByUuid_C_PrevAndNext(long vendorId, String uuid,
		long companyId, OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException {
		uuid = Objects.toString(uuid, "");

		Vendor vendor = findByPrimaryKey(vendorId);

		Session session = null;

		try {
			session = openSession();

			Vendor[] array = new VendorImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, vendor, uuid,
					companyId, orderByComparator, true);

			array[1] = vendor;

			array[2] = getByUuid_C_PrevAndNext(session, vendor, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Vendor getByUuid_C_PrevAndNext(Session session, Vendor vendor,
		String uuid, long companyId,
		OrderByComparator<Vendor> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_VENDOR_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(VendorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vendor);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Vendor> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the vendors where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Vendor vendor : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(vendor);
		}
	}

	/**
	 * Returns the number of vendors where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching vendors
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VENDOR_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "vendor.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "vendor.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(vendor.uuid IS NULL OR vendor.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "vendor.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_HWID = new FinderPath(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorModelImpl.FINDER_CACHE_ENABLED, VendorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByhwId",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HWID = new FinderPath(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorModelImpl.FINDER_CACHE_ENABLED, VendorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByhwId",
			new String[] { String.class.getName() },
			VendorModelImpl.HWID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_HWID = new FinderPath(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByhwId",
			new String[] { String.class.getName() });

	/**
	 * Returns all the vendors where hwId = &#63;.
	 *
	 * @param hwId the hw ID
	 * @return the matching vendors
	 */
	@Override
	public List<Vendor> findByhwId(String hwId) {
		return findByhwId(hwId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Vendor> findByhwId(String hwId, int start, int end) {
		return findByhwId(hwId, start, end, null);
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
	@Override
	public List<Vendor> findByhwId(String hwId, int start, int end,
		OrderByComparator<Vendor> orderByComparator) {
		return findByhwId(hwId, start, end, orderByComparator, true);
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
	@Override
	public List<Vendor> findByhwId(String hwId, int start, int end,
		OrderByComparator<Vendor> orderByComparator, boolean retrieveFromCache) {
		hwId = Objects.toString(hwId, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HWID;
			finderArgs = new Object[] { hwId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_HWID;
			finderArgs = new Object[] { hwId, start, end, orderByComparator };
		}

		List<Vendor> list = null;

		if (retrieveFromCache) {
			list = (List<Vendor>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Vendor vendor : list) {
					if (!hwId.equals(vendor.getHwId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_VENDOR_WHERE);

			boolean bindHwId = false;

			if (hwId.isEmpty()) {
				query.append(_FINDER_COLUMN_HWID_HWID_3);
			}
			else {
				bindHwId = true;

				query.append(_FINDER_COLUMN_HWID_HWID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VendorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindHwId) {
					qPos.add(hwId);
				}

				if (!pagination) {
					list = (List<Vendor>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Vendor>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first vendor in the ordered set where hwId = &#63;.
	 *
	 * @param hwId the hw ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vendor
	 * @throws NoSuchVendorException if a matching vendor could not be found
	 */
	@Override
	public Vendor findByhwId_First(String hwId,
		OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException {
		Vendor vendor = fetchByhwId_First(hwId, orderByComparator);

		if (vendor != null) {
			return vendor;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("hwId=");
		msg.append(hwId);

		msg.append("}");

		throw new NoSuchVendorException(msg.toString());
	}

	/**
	 * Returns the first vendor in the ordered set where hwId = &#63;.
	 *
	 * @param hwId the hw ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vendor, or <code>null</code> if a matching vendor could not be found
	 */
	@Override
	public Vendor fetchByhwId_First(String hwId,
		OrderByComparator<Vendor> orderByComparator) {
		List<Vendor> list = findByhwId(hwId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last vendor in the ordered set where hwId = &#63;.
	 *
	 * @param hwId the hw ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vendor
	 * @throws NoSuchVendorException if a matching vendor could not be found
	 */
	@Override
	public Vendor findByhwId_Last(String hwId,
		OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException {
		Vendor vendor = fetchByhwId_Last(hwId, orderByComparator);

		if (vendor != null) {
			return vendor;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("hwId=");
		msg.append(hwId);

		msg.append("}");

		throw new NoSuchVendorException(msg.toString());
	}

	/**
	 * Returns the last vendor in the ordered set where hwId = &#63;.
	 *
	 * @param hwId the hw ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vendor, or <code>null</code> if a matching vendor could not be found
	 */
	@Override
	public Vendor fetchByhwId_Last(String hwId,
		OrderByComparator<Vendor> orderByComparator) {
		int count = countByhwId(hwId);

		if (count == 0) {
			return null;
		}

		List<Vendor> list = findByhwId(hwId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Vendor[] findByhwId_PrevAndNext(long vendorId, String hwId,
		OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException {
		hwId = Objects.toString(hwId, "");

		Vendor vendor = findByPrimaryKey(vendorId);

		Session session = null;

		try {
			session = openSession();

			Vendor[] array = new VendorImpl[3];

			array[0] = getByhwId_PrevAndNext(session, vendor, hwId,
					orderByComparator, true);

			array[1] = vendor;

			array[2] = getByhwId_PrevAndNext(session, vendor, hwId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Vendor getByhwId_PrevAndNext(Session session, Vendor vendor,
		String hwId, OrderByComparator<Vendor> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VENDOR_WHERE);

		boolean bindHwId = false;

		if (hwId.isEmpty()) {
			query.append(_FINDER_COLUMN_HWID_HWID_3);
		}
		else {
			bindHwId = true;

			query.append(_FINDER_COLUMN_HWID_HWID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(VendorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindHwId) {
			qPos.add(hwId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vendor);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Vendor> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the vendors where hwId = &#63; from the database.
	 *
	 * @param hwId the hw ID
	 */
	@Override
	public void removeByhwId(String hwId) {
		for (Vendor vendor : findByhwId(hwId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(vendor);
		}
	}

	/**
	 * Returns the number of vendors where hwId = &#63;.
	 *
	 * @param hwId the hw ID
	 * @return the number of matching vendors
	 */
	@Override
	public int countByhwId(String hwId) {
		hwId = Objects.toString(hwId, "");

		FinderPath finderPath = FINDER_PATH_COUNT_BY_HWID;

		Object[] finderArgs = new Object[] { hwId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VENDOR_WHERE);

			boolean bindHwId = false;

			if (hwId.isEmpty()) {
				query.append(_FINDER_COLUMN_HWID_HWID_3);
			}
			else {
				bindHwId = true;

				query.append(_FINDER_COLUMN_HWID_HWID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindHwId) {
					qPos.add(hwId);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_HWID_HWID_1 = "vendor.hwId IS NULL";
	private static final String _FINDER_COLUMN_HWID_HWID_2 = "vendor.hwId = ?";
	private static final String _FINDER_COLUMN_HWID_HWID_3 = "(vendor.hwId IS NULL OR vendor.hwId = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME = new FinderPath(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorModelImpl.FINDER_CACHE_ENABLED, VendorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByname",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME = new FinderPath(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorModelImpl.FINDER_CACHE_ENABLED, VendorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByname",
			new String[] { String.class.getName() },
			VendorModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByname",
			new String[] { String.class.getName() });

	/**
	 * Returns all the vendors where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching vendors
	 */
	@Override
	public List<Vendor> findByname(String name) {
		return findByname(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Vendor> findByname(String name, int start, int end) {
		return findByname(name, start, end, null);
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
	@Override
	public List<Vendor> findByname(String name, int start, int end,
		OrderByComparator<Vendor> orderByComparator) {
		return findByname(name, start, end, orderByComparator, true);
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
	@Override
	public List<Vendor> findByname(String name, int start, int end,
		OrderByComparator<Vendor> orderByComparator, boolean retrieveFromCache) {
		name = Objects.toString(name, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { name };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { name, start, end, orderByComparator };
		}

		List<Vendor> list = null;

		if (retrieveFromCache) {
			list = (List<Vendor>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Vendor vendor : list) {
					if (!name.equals(vendor.getName())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_VENDOR_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VendorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				if (!pagination) {
					list = (List<Vendor>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Vendor>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first vendor in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vendor
	 * @throws NoSuchVendorException if a matching vendor could not be found
	 */
	@Override
	public Vendor findByname_First(String name,
		OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException {
		Vendor vendor = fetchByname_First(name, orderByComparator);

		if (vendor != null) {
			return vendor;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append("}");

		throw new NoSuchVendorException(msg.toString());
	}

	/**
	 * Returns the first vendor in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vendor, or <code>null</code> if a matching vendor could not be found
	 */
	@Override
	public Vendor fetchByname_First(String name,
		OrderByComparator<Vendor> orderByComparator) {
		List<Vendor> list = findByname(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last vendor in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vendor
	 * @throws NoSuchVendorException if a matching vendor could not be found
	 */
	@Override
	public Vendor findByname_Last(String name,
		OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException {
		Vendor vendor = fetchByname_Last(name, orderByComparator);

		if (vendor != null) {
			return vendor;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append("}");

		throw new NoSuchVendorException(msg.toString());
	}

	/**
	 * Returns the last vendor in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vendor, or <code>null</code> if a matching vendor could not be found
	 */
	@Override
	public Vendor fetchByname_Last(String name,
		OrderByComparator<Vendor> orderByComparator) {
		int count = countByname(name);

		if (count == 0) {
			return null;
		}

		List<Vendor> list = findByname(name, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Vendor[] findByname_PrevAndNext(long vendorId, String name,
		OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException {
		name = Objects.toString(name, "");

		Vendor vendor = findByPrimaryKey(vendorId);

		Session session = null;

		try {
			session = openSession();

			Vendor[] array = new VendorImpl[3];

			array[0] = getByname_PrevAndNext(session, vendor, name,
					orderByComparator, true);

			array[1] = vendor;

			array[2] = getByname_PrevAndNext(session, vendor, name,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Vendor getByname_PrevAndNext(Session session, Vendor vendor,
		String name, OrderByComparator<Vendor> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VENDOR_WHERE);

		boolean bindName = false;

		if (name.isEmpty()) {
			query.append(_FINDER_COLUMN_NAME_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_NAME_NAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(VendorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindName) {
			qPos.add(name);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vendor);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Vendor> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the vendors where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	@Override
	public void removeByname(String name) {
		for (Vendor vendor : findByname(name, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(vendor);
		}
	}

	/**
	 * Returns the number of vendors where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching vendors
	 */
	@Override
	public int countByname(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = FINDER_PATH_COUNT_BY_NAME;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VENDOR_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "vendor.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "vendor.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(vendor.name IS NULL OR vendor.name = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DESCRIPTION =
		new FinderPath(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorModelImpl.FINDER_CACHE_ENABLED, VendorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBydescription",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCRIPTION =
		new FinderPath(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorModelImpl.FINDER_CACHE_ENABLED, VendorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBydescription",
			new String[] { String.class.getName() },
			VendorModelImpl.DESCRIPTION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DESCRIPTION = new FinderPath(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBydescription",
			new String[] { String.class.getName() });

	/**
	 * Returns all the vendors where description = &#63;.
	 *
	 * @param description the description
	 * @return the matching vendors
	 */
	@Override
	public List<Vendor> findBydescription(String description) {
		return findBydescription(description, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Vendor> findBydescription(String description, int start, int end) {
		return findBydescription(description, start, end, null);
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
	@Override
	public List<Vendor> findBydescription(String description, int start,
		int end, OrderByComparator<Vendor> orderByComparator) {
		return findBydescription(description, start, end, orderByComparator,
			true);
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
	@Override
	public List<Vendor> findBydescription(String description, int start,
		int end, OrderByComparator<Vendor> orderByComparator,
		boolean retrieveFromCache) {
		description = Objects.toString(description, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCRIPTION;
			finderArgs = new Object[] { description };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DESCRIPTION;
			finderArgs = new Object[] { description, start, end, orderByComparator };
		}

		List<Vendor> list = null;

		if (retrieveFromCache) {
			list = (List<Vendor>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Vendor vendor : list) {
					if (!description.equals(vendor.getDescription())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_VENDOR_WHERE);

			boolean bindDescription = false;

			if (description.isEmpty()) {
				query.append(_FINDER_COLUMN_DESCRIPTION_DESCRIPTION_3);
			}
			else {
				bindDescription = true;

				query.append(_FINDER_COLUMN_DESCRIPTION_DESCRIPTION_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VendorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDescription) {
					qPos.add(description);
				}

				if (!pagination) {
					list = (List<Vendor>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Vendor>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first vendor in the ordered set where description = &#63;.
	 *
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vendor
	 * @throws NoSuchVendorException if a matching vendor could not be found
	 */
	@Override
	public Vendor findBydescription_First(String description,
		OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException {
		Vendor vendor = fetchBydescription_First(description, orderByComparator);

		if (vendor != null) {
			return vendor;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("description=");
		msg.append(description);

		msg.append("}");

		throw new NoSuchVendorException(msg.toString());
	}

	/**
	 * Returns the first vendor in the ordered set where description = &#63;.
	 *
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vendor, or <code>null</code> if a matching vendor could not be found
	 */
	@Override
	public Vendor fetchBydescription_First(String description,
		OrderByComparator<Vendor> orderByComparator) {
		List<Vendor> list = findBydescription(description, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last vendor in the ordered set where description = &#63;.
	 *
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vendor
	 * @throws NoSuchVendorException if a matching vendor could not be found
	 */
	@Override
	public Vendor findBydescription_Last(String description,
		OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException {
		Vendor vendor = fetchBydescription_Last(description, orderByComparator);

		if (vendor != null) {
			return vendor;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("description=");
		msg.append(description);

		msg.append("}");

		throw new NoSuchVendorException(msg.toString());
	}

	/**
	 * Returns the last vendor in the ordered set where description = &#63;.
	 *
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vendor, or <code>null</code> if a matching vendor could not be found
	 */
	@Override
	public Vendor fetchBydescription_Last(String description,
		OrderByComparator<Vendor> orderByComparator) {
		int count = countBydescription(description);

		if (count == 0) {
			return null;
		}

		List<Vendor> list = findBydescription(description, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Vendor[] findBydescription_PrevAndNext(long vendorId,
		String description, OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException {
		description = Objects.toString(description, "");

		Vendor vendor = findByPrimaryKey(vendorId);

		Session session = null;

		try {
			session = openSession();

			Vendor[] array = new VendorImpl[3];

			array[0] = getBydescription_PrevAndNext(session, vendor,
					description, orderByComparator, true);

			array[1] = vendor;

			array[2] = getBydescription_PrevAndNext(session, vendor,
					description, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Vendor getBydescription_PrevAndNext(Session session,
		Vendor vendor, String description,
		OrderByComparator<Vendor> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VENDOR_WHERE);

		boolean bindDescription = false;

		if (description.isEmpty()) {
			query.append(_FINDER_COLUMN_DESCRIPTION_DESCRIPTION_3);
		}
		else {
			bindDescription = true;

			query.append(_FINDER_COLUMN_DESCRIPTION_DESCRIPTION_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(VendorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDescription) {
			qPos.add(description);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vendor);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Vendor> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the vendors where description = &#63; from the database.
	 *
	 * @param description the description
	 */
	@Override
	public void removeBydescription(String description) {
		for (Vendor vendor : findBydescription(description, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(vendor);
		}
	}

	/**
	 * Returns the number of vendors where description = &#63;.
	 *
	 * @param description the description
	 * @return the number of matching vendors
	 */
	@Override
	public int countBydescription(String description) {
		description = Objects.toString(description, "");

		FinderPath finderPath = FINDER_PATH_COUNT_BY_DESCRIPTION;

		Object[] finderArgs = new Object[] { description };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VENDOR_WHERE);

			boolean bindDescription = false;

			if (description.isEmpty()) {
				query.append(_FINDER_COLUMN_DESCRIPTION_DESCRIPTION_3);
			}
			else {
				bindDescription = true;

				query.append(_FINDER_COLUMN_DESCRIPTION_DESCRIPTION_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDescription) {
					qPos.add(description);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_DESCRIPTION_DESCRIPTION_1 = "vendor.description IS NULL";
	private static final String _FINDER_COLUMN_DESCRIPTION_DESCRIPTION_2 = "vendor.description = ?";
	private static final String _FINDER_COLUMN_DESCRIPTION_DESCRIPTION_3 = "(vendor.description IS NULL OR vendor.description = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_METADATA = new FinderPath(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorModelImpl.FINDER_CACHE_ENABLED, VendorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBymetadata",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_METADATA =
		new FinderPath(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorModelImpl.FINDER_CACHE_ENABLED, VendorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBymetadata",
			new String[] { String.class.getName() },
			VendorModelImpl.METADATA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_METADATA = new FinderPath(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBymetadata",
			new String[] { String.class.getName() });

	/**
	 * Returns all the vendors where metadata = &#63;.
	 *
	 * @param metadata the metadata
	 * @return the matching vendors
	 */
	@Override
	public List<Vendor> findBymetadata(String metadata) {
		return findBymetadata(metadata, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Vendor> findBymetadata(String metadata, int start, int end) {
		return findBymetadata(metadata, start, end, null);
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
	@Override
	public List<Vendor> findBymetadata(String metadata, int start, int end,
		OrderByComparator<Vendor> orderByComparator) {
		return findBymetadata(metadata, start, end, orderByComparator, true);
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
	@Override
	public List<Vendor> findBymetadata(String metadata, int start, int end,
		OrderByComparator<Vendor> orderByComparator, boolean retrieveFromCache) {
		metadata = Objects.toString(metadata, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_METADATA;
			finderArgs = new Object[] { metadata };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_METADATA;
			finderArgs = new Object[] { metadata, start, end, orderByComparator };
		}

		List<Vendor> list = null;

		if (retrieveFromCache) {
			list = (List<Vendor>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Vendor vendor : list) {
					if (!metadata.equals(vendor.getMetadata())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_VENDOR_WHERE);

			boolean bindMetadata = false;

			if (metadata.isEmpty()) {
				query.append(_FINDER_COLUMN_METADATA_METADATA_3);
			}
			else {
				bindMetadata = true;

				query.append(_FINDER_COLUMN_METADATA_METADATA_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VendorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindMetadata) {
					qPos.add(metadata);
				}

				if (!pagination) {
					list = (List<Vendor>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Vendor>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first vendor in the ordered set where metadata = &#63;.
	 *
	 * @param metadata the metadata
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vendor
	 * @throws NoSuchVendorException if a matching vendor could not be found
	 */
	@Override
	public Vendor findBymetadata_First(String metadata,
		OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException {
		Vendor vendor = fetchBymetadata_First(metadata, orderByComparator);

		if (vendor != null) {
			return vendor;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("metadata=");
		msg.append(metadata);

		msg.append("}");

		throw new NoSuchVendorException(msg.toString());
	}

	/**
	 * Returns the first vendor in the ordered set where metadata = &#63;.
	 *
	 * @param metadata the metadata
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vendor, or <code>null</code> if a matching vendor could not be found
	 */
	@Override
	public Vendor fetchBymetadata_First(String metadata,
		OrderByComparator<Vendor> orderByComparator) {
		List<Vendor> list = findBymetadata(metadata, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last vendor in the ordered set where metadata = &#63;.
	 *
	 * @param metadata the metadata
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vendor
	 * @throws NoSuchVendorException if a matching vendor could not be found
	 */
	@Override
	public Vendor findBymetadata_Last(String metadata,
		OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException {
		Vendor vendor = fetchBymetadata_Last(metadata, orderByComparator);

		if (vendor != null) {
			return vendor;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("metadata=");
		msg.append(metadata);

		msg.append("}");

		throw new NoSuchVendorException(msg.toString());
	}

	/**
	 * Returns the last vendor in the ordered set where metadata = &#63;.
	 *
	 * @param metadata the metadata
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vendor, or <code>null</code> if a matching vendor could not be found
	 */
	@Override
	public Vendor fetchBymetadata_Last(String metadata,
		OrderByComparator<Vendor> orderByComparator) {
		int count = countBymetadata(metadata);

		if (count == 0) {
			return null;
		}

		List<Vendor> list = findBymetadata(metadata, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Vendor[] findBymetadata_PrevAndNext(long vendorId, String metadata,
		OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException {
		metadata = Objects.toString(metadata, "");

		Vendor vendor = findByPrimaryKey(vendorId);

		Session session = null;

		try {
			session = openSession();

			Vendor[] array = new VendorImpl[3];

			array[0] = getBymetadata_PrevAndNext(session, vendor, metadata,
					orderByComparator, true);

			array[1] = vendor;

			array[2] = getBymetadata_PrevAndNext(session, vendor, metadata,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Vendor getBymetadata_PrevAndNext(Session session, Vendor vendor,
		String metadata, OrderByComparator<Vendor> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VENDOR_WHERE);

		boolean bindMetadata = false;

		if (metadata.isEmpty()) {
			query.append(_FINDER_COLUMN_METADATA_METADATA_3);
		}
		else {
			bindMetadata = true;

			query.append(_FINDER_COLUMN_METADATA_METADATA_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(VendorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindMetadata) {
			qPos.add(metadata);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vendor);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Vendor> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the vendors where metadata = &#63; from the database.
	 *
	 * @param metadata the metadata
	 */
	@Override
	public void removeBymetadata(String metadata) {
		for (Vendor vendor : findBymetadata(metadata, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(vendor);
		}
	}

	/**
	 * Returns the number of vendors where metadata = &#63;.
	 *
	 * @param metadata the metadata
	 * @return the number of matching vendors
	 */
	@Override
	public int countBymetadata(String metadata) {
		metadata = Objects.toString(metadata, "");

		FinderPath finderPath = FINDER_PATH_COUNT_BY_METADATA;

		Object[] finderArgs = new Object[] { metadata };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VENDOR_WHERE);

			boolean bindMetadata = false;

			if (metadata.isEmpty()) {
				query.append(_FINDER_COLUMN_METADATA_METADATA_3);
			}
			else {
				bindMetadata = true;

				query.append(_FINDER_COLUMN_METADATA_METADATA_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindMetadata) {
					qPos.add(metadata);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_METADATA_METADATA_1 = "vendor.metadata IS NULL";
	private static final String _FINDER_COLUMN_METADATA_METADATA_2 = "vendor.metadata = ?";
	private static final String _FINDER_COLUMN_METADATA_METADATA_3 = "(vendor.metadata IS NULL OR vendor.metadata = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_WEBSITE = new FinderPath(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorModelImpl.FINDER_CACHE_ENABLED, VendorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBywebsite",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WEBSITE =
		new FinderPath(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorModelImpl.FINDER_CACHE_ENABLED, VendorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBywebsite",
			new String[] { String.class.getName() },
			VendorModelImpl.WEBSITE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_WEBSITE = new FinderPath(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBywebsite",
			new String[] { String.class.getName() });

	/**
	 * Returns all the vendors where website = &#63;.
	 *
	 * @param website the website
	 * @return the matching vendors
	 */
	@Override
	public List<Vendor> findBywebsite(String website) {
		return findBywebsite(website, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Vendor> findBywebsite(String website, int start, int end) {
		return findBywebsite(website, start, end, null);
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
	@Override
	public List<Vendor> findBywebsite(String website, int start, int end,
		OrderByComparator<Vendor> orderByComparator) {
		return findBywebsite(website, start, end, orderByComparator, true);
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
	@Override
	public List<Vendor> findBywebsite(String website, int start, int end,
		OrderByComparator<Vendor> orderByComparator, boolean retrieveFromCache) {
		website = Objects.toString(website, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WEBSITE;
			finderArgs = new Object[] { website };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_WEBSITE;
			finderArgs = new Object[] { website, start, end, orderByComparator };
		}

		List<Vendor> list = null;

		if (retrieveFromCache) {
			list = (List<Vendor>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Vendor vendor : list) {
					if (!website.equals(vendor.getWebsite())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_VENDOR_WHERE);

			boolean bindWebsite = false;

			if (website.isEmpty()) {
				query.append(_FINDER_COLUMN_WEBSITE_WEBSITE_3);
			}
			else {
				bindWebsite = true;

				query.append(_FINDER_COLUMN_WEBSITE_WEBSITE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VendorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindWebsite) {
					qPos.add(website);
				}

				if (!pagination) {
					list = (List<Vendor>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Vendor>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first vendor in the ordered set where website = &#63;.
	 *
	 * @param website the website
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vendor
	 * @throws NoSuchVendorException if a matching vendor could not be found
	 */
	@Override
	public Vendor findBywebsite_First(String website,
		OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException {
		Vendor vendor = fetchBywebsite_First(website, orderByComparator);

		if (vendor != null) {
			return vendor;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("website=");
		msg.append(website);

		msg.append("}");

		throw new NoSuchVendorException(msg.toString());
	}

	/**
	 * Returns the first vendor in the ordered set where website = &#63;.
	 *
	 * @param website the website
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vendor, or <code>null</code> if a matching vendor could not be found
	 */
	@Override
	public Vendor fetchBywebsite_First(String website,
		OrderByComparator<Vendor> orderByComparator) {
		List<Vendor> list = findBywebsite(website, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last vendor in the ordered set where website = &#63;.
	 *
	 * @param website the website
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vendor
	 * @throws NoSuchVendorException if a matching vendor could not be found
	 */
	@Override
	public Vendor findBywebsite_Last(String website,
		OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException {
		Vendor vendor = fetchBywebsite_Last(website, orderByComparator);

		if (vendor != null) {
			return vendor;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("website=");
		msg.append(website);

		msg.append("}");

		throw new NoSuchVendorException(msg.toString());
	}

	/**
	 * Returns the last vendor in the ordered set where website = &#63;.
	 *
	 * @param website the website
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vendor, or <code>null</code> if a matching vendor could not be found
	 */
	@Override
	public Vendor fetchBywebsite_Last(String website,
		OrderByComparator<Vendor> orderByComparator) {
		int count = countBywebsite(website);

		if (count == 0) {
			return null;
		}

		List<Vendor> list = findBywebsite(website, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Vendor[] findBywebsite_PrevAndNext(long vendorId, String website,
		OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException {
		website = Objects.toString(website, "");

		Vendor vendor = findByPrimaryKey(vendorId);

		Session session = null;

		try {
			session = openSession();

			Vendor[] array = new VendorImpl[3];

			array[0] = getBywebsite_PrevAndNext(session, vendor, website,
					orderByComparator, true);

			array[1] = vendor;

			array[2] = getBywebsite_PrevAndNext(session, vendor, website,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Vendor getBywebsite_PrevAndNext(Session session, Vendor vendor,
		String website, OrderByComparator<Vendor> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VENDOR_WHERE);

		boolean bindWebsite = false;

		if (website.isEmpty()) {
			query.append(_FINDER_COLUMN_WEBSITE_WEBSITE_3);
		}
		else {
			bindWebsite = true;

			query.append(_FINDER_COLUMN_WEBSITE_WEBSITE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(VendorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindWebsite) {
			qPos.add(website);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vendor);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Vendor> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the vendors where website = &#63; from the database.
	 *
	 * @param website the website
	 */
	@Override
	public void removeBywebsite(String website) {
		for (Vendor vendor : findBywebsite(website, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(vendor);
		}
	}

	/**
	 * Returns the number of vendors where website = &#63;.
	 *
	 * @param website the website
	 * @return the number of matching vendors
	 */
	@Override
	public int countBywebsite(String website) {
		website = Objects.toString(website, "");

		FinderPath finderPath = FINDER_PATH_COUNT_BY_WEBSITE;

		Object[] finderArgs = new Object[] { website };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VENDOR_WHERE);

			boolean bindWebsite = false;

			if (website.isEmpty()) {
				query.append(_FINDER_COLUMN_WEBSITE_WEBSITE_3);
			}
			else {
				bindWebsite = true;

				query.append(_FINDER_COLUMN_WEBSITE_WEBSITE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindWebsite) {
					qPos.add(website);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_WEBSITE_WEBSITE_1 = "vendor.website IS NULL";
	private static final String _FINDER_COLUMN_WEBSITE_WEBSITE_2 = "vendor.website = ?";
	private static final String _FINDER_COLUMN_WEBSITE_WEBSITE_3 = "(vendor.website IS NULL OR vendor.website = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NDM = new FinderPath(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorModelImpl.FINDER_CACHE_ENABLED, VendorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByndm",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NDM = new FinderPath(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorModelImpl.FINDER_CACHE_ENABLED, VendorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByndm",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			},
			VendorModelImpl.NAME_COLUMN_BITMASK |
			VendorModelImpl.DESCRIPTION_COLUMN_BITMASK |
			VendorModelImpl.METADATA_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NDM = new FinderPath(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByndm",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the vendors where name = &#63; and description = &#63; and metadata = &#63;.
	 *
	 * @param name the name
	 * @param description the description
	 * @param metadata the metadata
	 * @return the matching vendors
	 */
	@Override
	public List<Vendor> findByndm(String name, String description,
		String metadata) {
		return findByndm(name, description, metadata, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Vendor> findByndm(String name, String description,
		String metadata, int start, int end) {
		return findByndm(name, description, metadata, start, end, null);
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
	@Override
	public List<Vendor> findByndm(String name, String description,
		String metadata, int start, int end,
		OrderByComparator<Vendor> orderByComparator) {
		return findByndm(name, description, metadata, start, end,
			orderByComparator, true);
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
	@Override
	public List<Vendor> findByndm(String name, String description,
		String metadata, int start, int end,
		OrderByComparator<Vendor> orderByComparator, boolean retrieveFromCache) {
		name = Objects.toString(name, "");
		description = Objects.toString(description, "");
		metadata = Objects.toString(metadata, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NDM;
			finderArgs = new Object[] { name, description, metadata };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NDM;
			finderArgs = new Object[] {
					name, description, metadata,
					
					start, end, orderByComparator
				};
		}

		List<Vendor> list = null;

		if (retrieveFromCache) {
			list = (List<Vendor>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Vendor vendor : list) {
					if (!name.equals(vendor.getName()) ||
							!description.equals(vendor.getDescription()) ||
							!metadata.equals(vendor.getMetadata())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_VENDOR_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				query.append(_FINDER_COLUMN_NDM_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NDM_NAME_2);
			}

			boolean bindDescription = false;

			if (description.isEmpty()) {
				query.append(_FINDER_COLUMN_NDM_DESCRIPTION_3);
			}
			else {
				bindDescription = true;

				query.append(_FINDER_COLUMN_NDM_DESCRIPTION_2);
			}

			boolean bindMetadata = false;

			if (metadata.isEmpty()) {
				query.append(_FINDER_COLUMN_NDM_METADATA_3);
			}
			else {
				bindMetadata = true;

				query.append(_FINDER_COLUMN_NDM_METADATA_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VendorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				if (bindDescription) {
					qPos.add(description);
				}

				if (bindMetadata) {
					qPos.add(metadata);
				}

				if (!pagination) {
					list = (List<Vendor>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Vendor>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Vendor findByndm_First(String name, String description,
		String metadata, OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException {
		Vendor vendor = fetchByndm_First(name, description, metadata,
				orderByComparator);

		if (vendor != null) {
			return vendor;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(", description=");
		msg.append(description);

		msg.append(", metadata=");
		msg.append(metadata);

		msg.append("}");

		throw new NoSuchVendorException(msg.toString());
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
	@Override
	public Vendor fetchByndm_First(String name, String description,
		String metadata, OrderByComparator<Vendor> orderByComparator) {
		List<Vendor> list = findByndm(name, description, metadata, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Vendor findByndm_Last(String name, String description,
		String metadata, OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException {
		Vendor vendor = fetchByndm_Last(name, description, metadata,
				orderByComparator);

		if (vendor != null) {
			return vendor;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(", description=");
		msg.append(description);

		msg.append(", metadata=");
		msg.append(metadata);

		msg.append("}");

		throw new NoSuchVendorException(msg.toString());
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
	@Override
	public Vendor fetchByndm_Last(String name, String description,
		String metadata, OrderByComparator<Vendor> orderByComparator) {
		int count = countByndm(name, description, metadata);

		if (count == 0) {
			return null;
		}

		List<Vendor> list = findByndm(name, description, metadata, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Vendor[] findByndm_PrevAndNext(long vendorId, String name,
		String description, String metadata,
		OrderByComparator<Vendor> orderByComparator)
		throws NoSuchVendorException {
		name = Objects.toString(name, "");
		description = Objects.toString(description, "");
		metadata = Objects.toString(metadata, "");

		Vendor vendor = findByPrimaryKey(vendorId);

		Session session = null;

		try {
			session = openSession();

			Vendor[] array = new VendorImpl[3];

			array[0] = getByndm_PrevAndNext(session, vendor, name, description,
					metadata, orderByComparator, true);

			array[1] = vendor;

			array[2] = getByndm_PrevAndNext(session, vendor, name, description,
					metadata, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Vendor getByndm_PrevAndNext(Session session, Vendor vendor,
		String name, String description, String metadata,
		OrderByComparator<Vendor> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_VENDOR_WHERE);

		boolean bindName = false;

		if (name.isEmpty()) {
			query.append(_FINDER_COLUMN_NDM_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_NDM_NAME_2);
		}

		boolean bindDescription = false;

		if (description.isEmpty()) {
			query.append(_FINDER_COLUMN_NDM_DESCRIPTION_3);
		}
		else {
			bindDescription = true;

			query.append(_FINDER_COLUMN_NDM_DESCRIPTION_2);
		}

		boolean bindMetadata = false;

		if (metadata.isEmpty()) {
			query.append(_FINDER_COLUMN_NDM_METADATA_3);
		}
		else {
			bindMetadata = true;

			query.append(_FINDER_COLUMN_NDM_METADATA_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(VendorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindName) {
			qPos.add(name);
		}

		if (bindDescription) {
			qPos.add(description);
		}

		if (bindMetadata) {
			qPos.add(metadata);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vendor);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Vendor> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the vendors where name = &#63; and description = &#63; and metadata = &#63; from the database.
	 *
	 * @param name the name
	 * @param description the description
	 * @param metadata the metadata
	 */
	@Override
	public void removeByndm(String name, String description, String metadata) {
		for (Vendor vendor : findByndm(name, description, metadata,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(vendor);
		}
	}

	/**
	 * Returns the number of vendors where name = &#63; and description = &#63; and metadata = &#63;.
	 *
	 * @param name the name
	 * @param description the description
	 * @param metadata the metadata
	 * @return the number of matching vendors
	 */
	@Override
	public int countByndm(String name, String description, String metadata) {
		name = Objects.toString(name, "");
		description = Objects.toString(description, "");
		metadata = Objects.toString(metadata, "");

		FinderPath finderPath = FINDER_PATH_COUNT_BY_NDM;

		Object[] finderArgs = new Object[] { name, description, metadata };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_VENDOR_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				query.append(_FINDER_COLUMN_NDM_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NDM_NAME_2);
			}

			boolean bindDescription = false;

			if (description.isEmpty()) {
				query.append(_FINDER_COLUMN_NDM_DESCRIPTION_3);
			}
			else {
				bindDescription = true;

				query.append(_FINDER_COLUMN_NDM_DESCRIPTION_2);
			}

			boolean bindMetadata = false;

			if (metadata.isEmpty()) {
				query.append(_FINDER_COLUMN_NDM_METADATA_3);
			}
			else {
				bindMetadata = true;

				query.append(_FINDER_COLUMN_NDM_METADATA_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				if (bindDescription) {
					qPos.add(description);
				}

				if (bindMetadata) {
					qPos.add(metadata);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_NDM_NAME_1 = "vendor.name IS NULL AND ";
	private static final String _FINDER_COLUMN_NDM_NAME_2 = "vendor.name = ? AND ";
	private static final String _FINDER_COLUMN_NDM_NAME_3 = "(vendor.name IS NULL OR vendor.name = '') AND ";
	private static final String _FINDER_COLUMN_NDM_DESCRIPTION_1 = "vendor.description IS NULL AND ";
	private static final String _FINDER_COLUMN_NDM_DESCRIPTION_2 = "vendor.description = ? AND ";
	private static final String _FINDER_COLUMN_NDM_DESCRIPTION_3 = "(vendor.description IS NULL OR vendor.description = '') AND ";
	private static final String _FINDER_COLUMN_NDM_METADATA_1 = "vendor.metadata IS NULL";
	private static final String _FINDER_COLUMN_NDM_METADATA_2 = "vendor.metadata = ?";
	private static final String _FINDER_COLUMN_NDM_METADATA_3 = "(vendor.metadata IS NULL OR vendor.metadata = '')";

	public VendorPersistenceImpl() {
		setModelClass(Vendor.class);

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
					"_dbColumnNames");

			field.setAccessible(true);

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("uuid", "uuid_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the vendor in the entity cache if it is enabled.
	 *
	 * @param vendor the vendor
	 */
	@Override
	public void cacheResult(Vendor vendor) {
		entityCache.putResult(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorImpl.class, vendor.getPrimaryKey(), vendor);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { vendor.getUuid(), vendor.getGroupId() }, vendor);

		vendor.resetOriginalValues();
	}

	/**
	 * Caches the vendors in the entity cache if it is enabled.
	 *
	 * @param vendors the vendors
	 */
	@Override
	public void cacheResult(List<Vendor> vendors) {
		for (Vendor vendor : vendors) {
			if (entityCache.getResult(VendorModelImpl.ENTITY_CACHE_ENABLED,
						VendorImpl.class, vendor.getPrimaryKey()) == null) {
				cacheResult(vendor);
			}
			else {
				vendor.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all vendors.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(VendorImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the vendor.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Vendor vendor) {
		entityCache.removeResult(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorImpl.class, vendor.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((VendorModelImpl)vendor, true);
	}

	@Override
	public void clearCache(List<Vendor> vendors) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Vendor vendor : vendors) {
			entityCache.removeResult(VendorModelImpl.ENTITY_CACHE_ENABLED,
				VendorImpl.class, vendor.getPrimaryKey());

			clearUniqueFindersCache((VendorModelImpl)vendor, true);
		}
	}

	protected void cacheUniqueFindersCache(VendorModelImpl vendorModelImpl) {
		Object[] args = new Object[] {
				vendorModelImpl.getUuid(), vendorModelImpl.getGroupId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
			vendorModelImpl, false);
	}

	protected void clearUniqueFindersCache(VendorModelImpl vendorModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					vendorModelImpl.getUuid(), vendorModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		if ((vendorModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					vendorModelImpl.getOriginalUuid(),
					vendorModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new vendor with the primary key. Does not add the vendor to the database.
	 *
	 * @param vendorId the primary key for the new vendor
	 * @return the new vendor
	 */
	@Override
	public Vendor create(long vendorId) {
		Vendor vendor = new VendorImpl();

		vendor.setNew(true);
		vendor.setPrimaryKey(vendorId);

		String uuid = PortalUUIDUtil.generate();

		vendor.setUuid(uuid);

		vendor.setCompanyId(companyProvider.getCompanyId());

		return vendor;
	}

	/**
	 * Removes the vendor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param vendorId the primary key of the vendor
	 * @return the vendor that was removed
	 * @throws NoSuchVendorException if a vendor with the primary key could not be found
	 */
	@Override
	public Vendor remove(long vendorId) throws NoSuchVendorException {
		return remove((Serializable)vendorId);
	}

	/**
	 * Removes the vendor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the vendor
	 * @return the vendor that was removed
	 * @throws NoSuchVendorException if a vendor with the primary key could not be found
	 */
	@Override
	public Vendor remove(Serializable primaryKey) throws NoSuchVendorException {
		Session session = null;

		try {
			session = openSession();

			Vendor vendor = (Vendor)session.get(VendorImpl.class, primaryKey);

			if (vendor == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVendorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vendor);
		}
		catch (NoSuchVendorException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Vendor removeImpl(Vendor vendor) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(vendor)) {
				vendor = (Vendor)session.get(VendorImpl.class,
						vendor.getPrimaryKeyObj());
			}

			if (vendor != null) {
				session.delete(vendor);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (vendor != null) {
			clearCache(vendor);
		}

		return vendor;
	}

	@Override
	public Vendor updateImpl(Vendor vendor) {
		boolean isNew = vendor.isNew();

		if (!(vendor instanceof VendorModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(vendor.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(vendor);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in vendor proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Vendor implementation " +
				vendor.getClass());
		}

		VendorModelImpl vendorModelImpl = (VendorModelImpl)vendor;

		if (Validator.isNull(vendor.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			vendor.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (vendor.getCreateDate() == null)) {
			if (serviceContext == null) {
				vendor.setCreateDate(now);
			}
			else {
				vendor.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!vendorModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				vendor.setModifiedDate(now);
			}
			else {
				vendor.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (vendor.isNew()) {
				session.save(vendor);

				vendor.setNew(false);
			}
			else {
				vendor = (Vendor)session.merge(vendor);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!VendorModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { vendorModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					vendorModelImpl.getUuid(), vendorModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
				args);

			args = new Object[] { vendorModelImpl.getHwId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_HWID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HWID,
				args);

			args = new Object[] { vendorModelImpl.getName() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
				args);

			args = new Object[] { vendorModelImpl.getDescription() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_DESCRIPTION, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCRIPTION,
				args);

			args = new Object[] { vendorModelImpl.getMetadata() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_METADATA, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_METADATA,
				args);

			args = new Object[] { vendorModelImpl.getWebsite() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_WEBSITE, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WEBSITE,
				args);

			args = new Object[] {
					vendorModelImpl.getName(), vendorModelImpl.getDescription(),
					vendorModelImpl.getMetadata()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_NDM, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NDM,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((vendorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { vendorModelImpl.getOriginalUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { vendorModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((vendorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vendorModelImpl.getOriginalUuid(),
						vendorModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						vendorModelImpl.getUuid(),
						vendorModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((vendorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HWID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { vendorModelImpl.getOriginalHwId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_HWID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HWID,
					args);

				args = new Object[] { vendorModelImpl.getHwId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_HWID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HWID,
					args);
			}

			if ((vendorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { vendorModelImpl.getOriginalName() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);

				args = new Object[] { vendorModelImpl.getName() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);
			}

			if ((vendorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCRIPTION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vendorModelImpl.getOriginalDescription()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DESCRIPTION, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCRIPTION,
					args);

				args = new Object[] { vendorModelImpl.getDescription() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DESCRIPTION, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCRIPTION,
					args);
			}

			if ((vendorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_METADATA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vendorModelImpl.getOriginalMetadata()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_METADATA, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_METADATA,
					args);

				args = new Object[] { vendorModelImpl.getMetadata() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_METADATA, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_METADATA,
					args);
			}

			if ((vendorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WEBSITE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vendorModelImpl.getOriginalWebsite()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_WEBSITE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WEBSITE,
					args);

				args = new Object[] { vendorModelImpl.getWebsite() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_WEBSITE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WEBSITE,
					args);
			}

			if ((vendorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NDM.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vendorModelImpl.getOriginalName(),
						vendorModelImpl.getOriginalDescription(),
						vendorModelImpl.getOriginalMetadata()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_NDM, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NDM,
					args);

				args = new Object[] {
						vendorModelImpl.getName(),
						vendorModelImpl.getDescription(),
						vendorModelImpl.getMetadata()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_NDM, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NDM,
					args);
			}
		}

		entityCache.putResult(VendorModelImpl.ENTITY_CACHE_ENABLED,
			VendorImpl.class, vendor.getPrimaryKey(), vendor, false);

		clearUniqueFindersCache(vendorModelImpl, false);
		cacheUniqueFindersCache(vendorModelImpl);

		vendor.resetOriginalValues();

		return vendor;
	}

	/**
	 * Returns the vendor with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the vendor
	 * @return the vendor
	 * @throws NoSuchVendorException if a vendor with the primary key could not be found
	 */
	@Override
	public Vendor findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVendorException {
		Vendor vendor = fetchByPrimaryKey(primaryKey);

		if (vendor == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVendorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return vendor;
	}

	/**
	 * Returns the vendor with the primary key or throws a {@link NoSuchVendorException} if it could not be found.
	 *
	 * @param vendorId the primary key of the vendor
	 * @return the vendor
	 * @throws NoSuchVendorException if a vendor with the primary key could not be found
	 */
	@Override
	public Vendor findByPrimaryKey(long vendorId) throws NoSuchVendorException {
		return findByPrimaryKey((Serializable)vendorId);
	}

	/**
	 * Returns the vendor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the vendor
	 * @return the vendor, or <code>null</code> if a vendor with the primary key could not be found
	 */
	@Override
	public Vendor fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(VendorModelImpl.ENTITY_CACHE_ENABLED,
				VendorImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Vendor vendor = (Vendor)serializable;

		if (vendor == null) {
			Session session = null;

			try {
				session = openSession();

				vendor = (Vendor)session.get(VendorImpl.class, primaryKey);

				if (vendor != null) {
					cacheResult(vendor);
				}
				else {
					entityCache.putResult(VendorModelImpl.ENTITY_CACHE_ENABLED,
						VendorImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(VendorModelImpl.ENTITY_CACHE_ENABLED,
					VendorImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return vendor;
	}

	/**
	 * Returns the vendor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param vendorId the primary key of the vendor
	 * @return the vendor, or <code>null</code> if a vendor with the primary key could not be found
	 */
	@Override
	public Vendor fetchByPrimaryKey(long vendorId) {
		return fetchByPrimaryKey((Serializable)vendorId);
	}

	@Override
	public Map<Serializable, Vendor> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Vendor> map = new HashMap<Serializable, Vendor>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Vendor vendor = fetchByPrimaryKey(primaryKey);

			if (vendor != null) {
				map.put(primaryKey, vendor);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(VendorModelImpl.ENTITY_CACHE_ENABLED,
					VendorImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Vendor)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_VENDOR_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Vendor vendor : (List<Vendor>)q.list()) {
				map.put(vendor.getPrimaryKeyObj(), vendor);

				cacheResult(vendor);

				uncachedPrimaryKeys.remove(vendor.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(VendorModelImpl.ENTITY_CACHE_ENABLED,
					VendorImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the vendors.
	 *
	 * @return the vendors
	 */
	@Override
	public List<Vendor> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Vendor> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Vendor> findAll(int start, int end,
		OrderByComparator<Vendor> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Vendor> findAll(int start, int end,
		OrderByComparator<Vendor> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Vendor> list = null;

		if (retrieveFromCache) {
			list = (List<Vendor>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_VENDOR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VENDOR;

				if (pagination) {
					sql = sql.concat(VendorModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Vendor>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Vendor>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the vendors from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Vendor vendor : findAll()) {
			remove(vendor);
		}
	}

	/**
	 * Returns the number of vendors.
	 *
	 * @return the number of vendors
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VENDOR);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return VendorModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the vendor persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(VendorImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_VENDOR = "SELECT vendor FROM Vendor vendor";
	private static final String _SQL_SELECT_VENDOR_WHERE_PKS_IN = "SELECT vendor FROM Vendor vendor WHERE vendorId IN (";
	private static final String _SQL_SELECT_VENDOR_WHERE = "SELECT vendor FROM Vendor vendor WHERE ";
	private static final String _SQL_COUNT_VENDOR = "SELECT COUNT(vendor) FROM Vendor vendor";
	private static final String _SQL_COUNT_VENDOR_WHERE = "SELECT COUNT(vendor) FROM Vendor vendor WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vendor.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Vendor exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Vendor exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(VendorPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}