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

package it.scinti.lfr.secpg.xssinjection.service.persistence.impl;

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

import it.scinti.lfr.secpg.xssinjection.exception.NoSuchFeedbackException;
import it.scinti.lfr.secpg.xssinjection.model.Feedback;
import it.scinti.lfr.secpg.xssinjection.model.impl.FeedbackImpl;
import it.scinti.lfr.secpg.xssinjection.model.impl.FeedbackModelImpl;
import it.scinti.lfr.secpg.xssinjection.service.persistence.FeedbackPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.sql.Timestamp;

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
 * The persistence implementation for the feedback service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FeedbackPersistence
 * @see it.scinti.lfr.secpg.xssinjection.service.persistence.FeedbackUtil
 * @generated
 */
@ProviderType
public class FeedbackPersistenceImpl extends BasePersistenceImpl<Feedback>
	implements FeedbackPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FeedbackUtil} to access the feedback persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FeedbackImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackModelImpl.FINDER_CACHE_ENABLED, FeedbackImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackModelImpl.FINDER_CACHE_ENABLED, FeedbackImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackModelImpl.FINDER_CACHE_ENABLED, FeedbackImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackModelImpl.FINDER_CACHE_ENABLED, FeedbackImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			FeedbackModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the feedbacks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching feedbacks
	 */
	@Override
	public List<Feedback> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the feedbacks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of feedbacks
	 * @param end the upper bound of the range of feedbacks (not inclusive)
	 * @return the range of matching feedbacks
	 */
	@Override
	public List<Feedback> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the feedbacks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of feedbacks
	 * @param end the upper bound of the range of feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching feedbacks
	 */
	@Override
	public List<Feedback> findByUuid(String uuid, int start, int end,
		OrderByComparator<Feedback> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the feedbacks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of feedbacks
	 * @param end the upper bound of the range of feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching feedbacks
	 */
	@Override
	public List<Feedback> findByUuid(String uuid, int start, int end,
		OrderByComparator<Feedback> orderByComparator, boolean retrieveFromCache) {
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

		List<Feedback> list = null;

		if (retrieveFromCache) {
			list = (List<Feedback>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Feedback feedback : list) {
					if (!uuid.equals(feedback.getUuid())) {
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

			query.append(_SQL_SELECT_FEEDBACK_WHERE);

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
				query.append(FeedbackModelImpl.ORDER_BY_JPQL);
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
					list = (List<Feedback>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Feedback>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first feedback in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feedback
	 * @throws NoSuchFeedbackException if a matching feedback could not be found
	 */
	@Override
	public Feedback findByUuid_First(String uuid,
		OrderByComparator<Feedback> orderByComparator)
		throws NoSuchFeedbackException {
		Feedback feedback = fetchByUuid_First(uuid, orderByComparator);

		if (feedback != null) {
			return feedback;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchFeedbackException(msg.toString());
	}

	/**
	 * Returns the first feedback in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feedback, or <code>null</code> if a matching feedback could not be found
	 */
	@Override
	public Feedback fetchByUuid_First(String uuid,
		OrderByComparator<Feedback> orderByComparator) {
		List<Feedback> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last feedback in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feedback
	 * @throws NoSuchFeedbackException if a matching feedback could not be found
	 */
	@Override
	public Feedback findByUuid_Last(String uuid,
		OrderByComparator<Feedback> orderByComparator)
		throws NoSuchFeedbackException {
		Feedback feedback = fetchByUuid_Last(uuid, orderByComparator);

		if (feedback != null) {
			return feedback;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchFeedbackException(msg.toString());
	}

	/**
	 * Returns the last feedback in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feedback, or <code>null</code> if a matching feedback could not be found
	 */
	@Override
	public Feedback fetchByUuid_Last(String uuid,
		OrderByComparator<Feedback> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Feedback> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the feedbacks before and after the current feedback in the ordered set where uuid = &#63;.
	 *
	 * @param feedbackId the primary key of the current feedback
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next feedback
	 * @throws NoSuchFeedbackException if a feedback with the primary key could not be found
	 */
	@Override
	public Feedback[] findByUuid_PrevAndNext(long feedbackId, String uuid,
		OrderByComparator<Feedback> orderByComparator)
		throws NoSuchFeedbackException {
		uuid = Objects.toString(uuid, "");

		Feedback feedback = findByPrimaryKey(feedbackId);

		Session session = null;

		try {
			session = openSession();

			Feedback[] array = new FeedbackImpl[3];

			array[0] = getByUuid_PrevAndNext(session, feedback, uuid,
					orderByComparator, true);

			array[1] = feedback;

			array[2] = getByUuid_PrevAndNext(session, feedback, uuid,
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

	protected Feedback getByUuid_PrevAndNext(Session session,
		Feedback feedback, String uuid,
		OrderByComparator<Feedback> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FEEDBACK_WHERE);

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
			query.append(FeedbackModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(feedback);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Feedback> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the feedbacks where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Feedback feedback : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(feedback);
		}
	}

	/**
	 * Returns the number of feedbacks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching feedbacks
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FEEDBACK_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "feedback.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "feedback.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(feedback.uuid IS NULL OR feedback.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackModelImpl.FINDER_CACHE_ENABLED, FeedbackImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			FeedbackModelImpl.UUID_COLUMN_BITMASK |
			FeedbackModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the feedback where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchFeedbackException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching feedback
	 * @throws NoSuchFeedbackException if a matching feedback could not be found
	 */
	@Override
	public Feedback findByUUID_G(String uuid, long groupId)
		throws NoSuchFeedbackException {
		Feedback feedback = fetchByUUID_G(uuid, groupId);

		if (feedback == null) {
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

			throw new NoSuchFeedbackException(msg.toString());
		}

		return feedback;
	}

	/**
	 * Returns the feedback where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching feedback, or <code>null</code> if a matching feedback could not be found
	 */
	@Override
	public Feedback fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the feedback where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching feedback, or <code>null</code> if a matching feedback could not be found
	 */
	@Override
	public Feedback fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Feedback) {
			Feedback feedback = (Feedback)result;

			if (!Objects.equals(uuid, feedback.getUuid()) ||
					(groupId != feedback.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_FEEDBACK_WHERE);

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

				List<Feedback> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					Feedback feedback = list.get(0);

					result = feedback;

					cacheResult(feedback);
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
			return (Feedback)result;
		}
	}

	/**
	 * Removes the feedback where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the feedback that was removed
	 */
	@Override
	public Feedback removeByUUID_G(String uuid, long groupId)
		throws NoSuchFeedbackException {
		Feedback feedback = findByUUID_G(uuid, groupId);

		return remove(feedback);
	}

	/**
	 * Returns the number of feedbacks where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching feedbacks
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_FEEDBACK_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "feedback.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "feedback.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(feedback.uuid IS NULL OR feedback.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "feedback.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackModelImpl.FINDER_CACHE_ENABLED, FeedbackImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackModelImpl.FINDER_CACHE_ENABLED, FeedbackImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			FeedbackModelImpl.UUID_COLUMN_BITMASK |
			FeedbackModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the feedbacks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching feedbacks
	 */
	@Override
	public List<Feedback> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the feedbacks where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of feedbacks
	 * @param end the upper bound of the range of feedbacks (not inclusive)
	 * @return the range of matching feedbacks
	 */
	@Override
	public List<Feedback> findByUuid_C(String uuid, long companyId, int start,
		int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the feedbacks where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of feedbacks
	 * @param end the upper bound of the range of feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching feedbacks
	 */
	@Override
	public List<Feedback> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<Feedback> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the feedbacks where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of feedbacks
	 * @param end the upper bound of the range of feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching feedbacks
	 */
	@Override
	public List<Feedback> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<Feedback> orderByComparator,
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

		List<Feedback> list = null;

		if (retrieveFromCache) {
			list = (List<Feedback>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Feedback feedback : list) {
					if (!uuid.equals(feedback.getUuid()) ||
							(companyId != feedback.getCompanyId())) {
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

			query.append(_SQL_SELECT_FEEDBACK_WHERE);

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
				query.append(FeedbackModelImpl.ORDER_BY_JPQL);
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
					list = (List<Feedback>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Feedback>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first feedback in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feedback
	 * @throws NoSuchFeedbackException if a matching feedback could not be found
	 */
	@Override
	public Feedback findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Feedback> orderByComparator)
		throws NoSuchFeedbackException {
		Feedback feedback = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (feedback != null) {
			return feedback;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchFeedbackException(msg.toString());
	}

	/**
	 * Returns the first feedback in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feedback, or <code>null</code> if a matching feedback could not be found
	 */
	@Override
	public Feedback fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Feedback> orderByComparator) {
		List<Feedback> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last feedback in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feedback
	 * @throws NoSuchFeedbackException if a matching feedback could not be found
	 */
	@Override
	public Feedback findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Feedback> orderByComparator)
		throws NoSuchFeedbackException {
		Feedback feedback = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (feedback != null) {
			return feedback;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchFeedbackException(msg.toString());
	}

	/**
	 * Returns the last feedback in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feedback, or <code>null</code> if a matching feedback could not be found
	 */
	@Override
	public Feedback fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Feedback> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Feedback> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the feedbacks before and after the current feedback in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param feedbackId the primary key of the current feedback
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next feedback
	 * @throws NoSuchFeedbackException if a feedback with the primary key could not be found
	 */
	@Override
	public Feedback[] findByUuid_C_PrevAndNext(long feedbackId, String uuid,
		long companyId, OrderByComparator<Feedback> orderByComparator)
		throws NoSuchFeedbackException {
		uuid = Objects.toString(uuid, "");

		Feedback feedback = findByPrimaryKey(feedbackId);

		Session session = null;

		try {
			session = openSession();

			Feedback[] array = new FeedbackImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, feedback, uuid,
					companyId, orderByComparator, true);

			array[1] = feedback;

			array[2] = getByUuid_C_PrevAndNext(session, feedback, uuid,
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

	protected Feedback getByUuid_C_PrevAndNext(Session session,
		Feedback feedback, String uuid, long companyId,
		OrderByComparator<Feedback> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_FEEDBACK_WHERE);

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
			query.append(FeedbackModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(feedback);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Feedback> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the feedbacks where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Feedback feedback : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(feedback);
		}
	}

	/**
	 * Returns the number of feedbacks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching feedbacks
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_FEEDBACK_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "feedback.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "feedback.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(feedback.uuid IS NULL OR feedback.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "feedback.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAIL = new FinderPath(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackModelImpl.FINDER_CACHE_ENABLED, FeedbackImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByemail",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL = new FinderPath(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackModelImpl.FINDER_CACHE_ENABLED, FeedbackImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByemail",
			new String[] { String.class.getName() },
			FeedbackModelImpl.EMAIL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAIL = new FinderPath(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByemail",
			new String[] { String.class.getName() });

	/**
	 * Returns all the feedbacks where email = &#63;.
	 *
	 * @param email the email
	 * @return the matching feedbacks
	 */
	@Override
	public List<Feedback> findByemail(String email) {
		return findByemail(email, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the feedbacks where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param email the email
	 * @param start the lower bound of the range of feedbacks
	 * @param end the upper bound of the range of feedbacks (not inclusive)
	 * @return the range of matching feedbacks
	 */
	@Override
	public List<Feedback> findByemail(String email, int start, int end) {
		return findByemail(email, start, end, null);
	}

	/**
	 * Returns an ordered range of all the feedbacks where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param email the email
	 * @param start the lower bound of the range of feedbacks
	 * @param end the upper bound of the range of feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching feedbacks
	 */
	@Override
	public List<Feedback> findByemail(String email, int start, int end,
		OrderByComparator<Feedback> orderByComparator) {
		return findByemail(email, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the feedbacks where email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param email the email
	 * @param start the lower bound of the range of feedbacks
	 * @param end the upper bound of the range of feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching feedbacks
	 */
	@Override
	public List<Feedback> findByemail(String email, int start, int end,
		OrderByComparator<Feedback> orderByComparator, boolean retrieveFromCache) {
		email = Objects.toString(email, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL;
			finderArgs = new Object[] { email };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAIL;
			finderArgs = new Object[] { email, start, end, orderByComparator };
		}

		List<Feedback> list = null;

		if (retrieveFromCache) {
			list = (List<Feedback>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Feedback feedback : list) {
					if (!email.equals(feedback.getEmail())) {
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

			query.append(_SQL_SELECT_FEEDBACK_WHERE);

			boolean bindEmail = false;

			if (email.isEmpty()) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
			}
			else {
				bindEmail = true;

				query.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FeedbackModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmail) {
					qPos.add(email);
				}

				if (!pagination) {
					list = (List<Feedback>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Feedback>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first feedback in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feedback
	 * @throws NoSuchFeedbackException if a matching feedback could not be found
	 */
	@Override
	public Feedback findByemail_First(String email,
		OrderByComparator<Feedback> orderByComparator)
		throws NoSuchFeedbackException {
		Feedback feedback = fetchByemail_First(email, orderByComparator);

		if (feedback != null) {
			return feedback;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("email=");
		msg.append(email);

		msg.append("}");

		throw new NoSuchFeedbackException(msg.toString());
	}

	/**
	 * Returns the first feedback in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feedback, or <code>null</code> if a matching feedback could not be found
	 */
	@Override
	public Feedback fetchByemail_First(String email,
		OrderByComparator<Feedback> orderByComparator) {
		List<Feedback> list = findByemail(email, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last feedback in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feedback
	 * @throws NoSuchFeedbackException if a matching feedback could not be found
	 */
	@Override
	public Feedback findByemail_Last(String email,
		OrderByComparator<Feedback> orderByComparator)
		throws NoSuchFeedbackException {
		Feedback feedback = fetchByemail_Last(email, orderByComparator);

		if (feedback != null) {
			return feedback;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("email=");
		msg.append(email);

		msg.append("}");

		throw new NoSuchFeedbackException(msg.toString());
	}

	/**
	 * Returns the last feedback in the ordered set where email = &#63;.
	 *
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feedback, or <code>null</code> if a matching feedback could not be found
	 */
	@Override
	public Feedback fetchByemail_Last(String email,
		OrderByComparator<Feedback> orderByComparator) {
		int count = countByemail(email);

		if (count == 0) {
			return null;
		}

		List<Feedback> list = findByemail(email, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the feedbacks before and after the current feedback in the ordered set where email = &#63;.
	 *
	 * @param feedbackId the primary key of the current feedback
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next feedback
	 * @throws NoSuchFeedbackException if a feedback with the primary key could not be found
	 */
	@Override
	public Feedback[] findByemail_PrevAndNext(long feedbackId, String email,
		OrderByComparator<Feedback> orderByComparator)
		throws NoSuchFeedbackException {
		email = Objects.toString(email, "");

		Feedback feedback = findByPrimaryKey(feedbackId);

		Session session = null;

		try {
			session = openSession();

			Feedback[] array = new FeedbackImpl[3];

			array[0] = getByemail_PrevAndNext(session, feedback, email,
					orderByComparator, true);

			array[1] = feedback;

			array[2] = getByemail_PrevAndNext(session, feedback, email,
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

	protected Feedback getByemail_PrevAndNext(Session session,
		Feedback feedback, String email,
		OrderByComparator<Feedback> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FEEDBACK_WHERE);

		boolean bindEmail = false;

		if (email.isEmpty()) {
			query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
		}
		else {
			bindEmail = true;

			query.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
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
			query.append(FeedbackModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindEmail) {
			qPos.add(email);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(feedback);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Feedback> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the feedbacks where email = &#63; from the database.
	 *
	 * @param email the email
	 */
	@Override
	public void removeByemail(String email) {
		for (Feedback feedback : findByemail(email, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(feedback);
		}
	}

	/**
	 * Returns the number of feedbacks where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching feedbacks
	 */
	@Override
	public int countByemail(String email) {
		email = Objects.toString(email, "");

		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMAIL;

		Object[] finderArgs = new Object[] { email };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FEEDBACK_WHERE);

			boolean bindEmail = false;

			if (email.isEmpty()) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
			}
			else {
				bindEmail = true;

				query.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmail) {
					qPos.add(email);
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

	private static final String _FINDER_COLUMN_EMAIL_EMAIL_1 = "feedback.email IS NULL";
	private static final String _FINDER_COLUMN_EMAIL_EMAIL_2 = "feedback.email = ?";
	private static final String _FINDER_COLUMN_EMAIL_EMAIL_3 = "(feedback.email IS NULL OR feedback.email = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LASTNAME = new FinderPath(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackModelImpl.FINDER_CACHE_ENABLED, FeedbackImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBylastName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LASTNAME =
		new FinderPath(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackModelImpl.FINDER_CACHE_ENABLED, FeedbackImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBylastName",
			new String[] { String.class.getName() },
			FeedbackModelImpl.LASTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LASTNAME = new FinderPath(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBylastName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the feedbacks where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @return the matching feedbacks
	 */
	@Override
	public List<Feedback> findBylastName(String lastName) {
		return findBylastName(lastName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the feedbacks where lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lastName the last name
	 * @param start the lower bound of the range of feedbacks
	 * @param end the upper bound of the range of feedbacks (not inclusive)
	 * @return the range of matching feedbacks
	 */
	@Override
	public List<Feedback> findBylastName(String lastName, int start, int end) {
		return findBylastName(lastName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the feedbacks where lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lastName the last name
	 * @param start the lower bound of the range of feedbacks
	 * @param end the upper bound of the range of feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching feedbacks
	 */
	@Override
	public List<Feedback> findBylastName(String lastName, int start, int end,
		OrderByComparator<Feedback> orderByComparator) {
		return findBylastName(lastName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the feedbacks where lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lastName the last name
	 * @param start the lower bound of the range of feedbacks
	 * @param end the upper bound of the range of feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching feedbacks
	 */
	@Override
	public List<Feedback> findBylastName(String lastName, int start, int end,
		OrderByComparator<Feedback> orderByComparator, boolean retrieveFromCache) {
		lastName = Objects.toString(lastName, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LASTNAME;
			finderArgs = new Object[] { lastName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LASTNAME;
			finderArgs = new Object[] { lastName, start, end, orderByComparator };
		}

		List<Feedback> list = null;

		if (retrieveFromCache) {
			list = (List<Feedback>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Feedback feedback : list) {
					if (!lastName.equals(feedback.getLastName())) {
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

			query.append(_SQL_SELECT_FEEDBACK_WHERE);

			boolean bindLastName = false;

			if (lastName.isEmpty()) {
				query.append(_FINDER_COLUMN_LASTNAME_LASTNAME_3);
			}
			else {
				bindLastName = true;

				query.append(_FINDER_COLUMN_LASTNAME_LASTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FeedbackModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLastName) {
					qPos.add(lastName);
				}

				if (!pagination) {
					list = (List<Feedback>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Feedback>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first feedback in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feedback
	 * @throws NoSuchFeedbackException if a matching feedback could not be found
	 */
	@Override
	public Feedback findBylastName_First(String lastName,
		OrderByComparator<Feedback> orderByComparator)
		throws NoSuchFeedbackException {
		Feedback feedback = fetchBylastName_First(lastName, orderByComparator);

		if (feedback != null) {
			return feedback;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lastName=");
		msg.append(lastName);

		msg.append("}");

		throw new NoSuchFeedbackException(msg.toString());
	}

	/**
	 * Returns the first feedback in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feedback, or <code>null</code> if a matching feedback could not be found
	 */
	@Override
	public Feedback fetchBylastName_First(String lastName,
		OrderByComparator<Feedback> orderByComparator) {
		List<Feedback> list = findBylastName(lastName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last feedback in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feedback
	 * @throws NoSuchFeedbackException if a matching feedback could not be found
	 */
	@Override
	public Feedback findBylastName_Last(String lastName,
		OrderByComparator<Feedback> orderByComparator)
		throws NoSuchFeedbackException {
		Feedback feedback = fetchBylastName_Last(lastName, orderByComparator);

		if (feedback != null) {
			return feedback;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lastName=");
		msg.append(lastName);

		msg.append("}");

		throw new NoSuchFeedbackException(msg.toString());
	}

	/**
	 * Returns the last feedback in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feedback, or <code>null</code> if a matching feedback could not be found
	 */
	@Override
	public Feedback fetchBylastName_Last(String lastName,
		OrderByComparator<Feedback> orderByComparator) {
		int count = countBylastName(lastName);

		if (count == 0) {
			return null;
		}

		List<Feedback> list = findBylastName(lastName, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the feedbacks before and after the current feedback in the ordered set where lastName = &#63;.
	 *
	 * @param feedbackId the primary key of the current feedback
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next feedback
	 * @throws NoSuchFeedbackException if a feedback with the primary key could not be found
	 */
	@Override
	public Feedback[] findBylastName_PrevAndNext(long feedbackId,
		String lastName, OrderByComparator<Feedback> orderByComparator)
		throws NoSuchFeedbackException {
		lastName = Objects.toString(lastName, "");

		Feedback feedback = findByPrimaryKey(feedbackId);

		Session session = null;

		try {
			session = openSession();

			Feedback[] array = new FeedbackImpl[3];

			array[0] = getBylastName_PrevAndNext(session, feedback, lastName,
					orderByComparator, true);

			array[1] = feedback;

			array[2] = getBylastName_PrevAndNext(session, feedback, lastName,
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

	protected Feedback getBylastName_PrevAndNext(Session session,
		Feedback feedback, String lastName,
		OrderByComparator<Feedback> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FEEDBACK_WHERE);

		boolean bindLastName = false;

		if (lastName.isEmpty()) {
			query.append(_FINDER_COLUMN_LASTNAME_LASTNAME_3);
		}
		else {
			bindLastName = true;

			query.append(_FINDER_COLUMN_LASTNAME_LASTNAME_2);
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
			query.append(FeedbackModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindLastName) {
			qPos.add(lastName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(feedback);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Feedback> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the feedbacks where lastName = &#63; from the database.
	 *
	 * @param lastName the last name
	 */
	@Override
	public void removeBylastName(String lastName) {
		for (Feedback feedback : findBylastName(lastName, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(feedback);
		}
	}

	/**
	 * Returns the number of feedbacks where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @return the number of matching feedbacks
	 */
	@Override
	public int countBylastName(String lastName) {
		lastName = Objects.toString(lastName, "");

		FinderPath finderPath = FINDER_PATH_COUNT_BY_LASTNAME;

		Object[] finderArgs = new Object[] { lastName };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FEEDBACK_WHERE);

			boolean bindLastName = false;

			if (lastName.isEmpty()) {
				query.append(_FINDER_COLUMN_LASTNAME_LASTNAME_3);
			}
			else {
				bindLastName = true;

				query.append(_FINDER_COLUMN_LASTNAME_LASTNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLastName) {
					qPos.add(lastName);
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

	private static final String _FINDER_COLUMN_LASTNAME_LASTNAME_1 = "feedback.lastName IS NULL";
	private static final String _FINDER_COLUMN_LASTNAME_LASTNAME_2 = "feedback.lastName = ?";
	private static final String _FINDER_COLUMN_LASTNAME_LASTNAME_3 = "(feedback.lastName IS NULL OR feedback.lastName = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DESCRIPTION =
		new FinderPath(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackModelImpl.FINDER_CACHE_ENABLED, FeedbackImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBydescription",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCRIPTION =
		new FinderPath(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackModelImpl.FINDER_CACHE_ENABLED, FeedbackImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBydescription",
			new String[] { String.class.getName() },
			FeedbackModelImpl.DESCRIPTION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DESCRIPTION = new FinderPath(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBydescription",
			new String[] { String.class.getName() });

	/**
	 * Returns all the feedbacks where description = &#63;.
	 *
	 * @param description the description
	 * @return the matching feedbacks
	 */
	@Override
	public List<Feedback> findBydescription(String description) {
		return findBydescription(description, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the feedbacks where description = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param description the description
	 * @param start the lower bound of the range of feedbacks
	 * @param end the upper bound of the range of feedbacks (not inclusive)
	 * @return the range of matching feedbacks
	 */
	@Override
	public List<Feedback> findBydescription(String description, int start,
		int end) {
		return findBydescription(description, start, end, null);
	}

	/**
	 * Returns an ordered range of all the feedbacks where description = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param description the description
	 * @param start the lower bound of the range of feedbacks
	 * @param end the upper bound of the range of feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching feedbacks
	 */
	@Override
	public List<Feedback> findBydescription(String description, int start,
		int end, OrderByComparator<Feedback> orderByComparator) {
		return findBydescription(description, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the feedbacks where description = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param description the description
	 * @param start the lower bound of the range of feedbacks
	 * @param end the upper bound of the range of feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching feedbacks
	 */
	@Override
	public List<Feedback> findBydescription(String description, int start,
		int end, OrderByComparator<Feedback> orderByComparator,
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

		List<Feedback> list = null;

		if (retrieveFromCache) {
			list = (List<Feedback>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Feedback feedback : list) {
					if (!description.equals(feedback.getDescription())) {
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

			query.append(_SQL_SELECT_FEEDBACK_WHERE);

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
				query.append(FeedbackModelImpl.ORDER_BY_JPQL);
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
					list = (List<Feedback>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Feedback>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first feedback in the ordered set where description = &#63;.
	 *
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feedback
	 * @throws NoSuchFeedbackException if a matching feedback could not be found
	 */
	@Override
	public Feedback findBydescription_First(String description,
		OrderByComparator<Feedback> orderByComparator)
		throws NoSuchFeedbackException {
		Feedback feedback = fetchBydescription_First(description,
				orderByComparator);

		if (feedback != null) {
			return feedback;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("description=");
		msg.append(description);

		msg.append("}");

		throw new NoSuchFeedbackException(msg.toString());
	}

	/**
	 * Returns the first feedback in the ordered set where description = &#63;.
	 *
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feedback, or <code>null</code> if a matching feedback could not be found
	 */
	@Override
	public Feedback fetchBydescription_First(String description,
		OrderByComparator<Feedback> orderByComparator) {
		List<Feedback> list = findBydescription(description, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last feedback in the ordered set where description = &#63;.
	 *
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feedback
	 * @throws NoSuchFeedbackException if a matching feedback could not be found
	 */
	@Override
	public Feedback findBydescription_Last(String description,
		OrderByComparator<Feedback> orderByComparator)
		throws NoSuchFeedbackException {
		Feedback feedback = fetchBydescription_Last(description,
				orderByComparator);

		if (feedback != null) {
			return feedback;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("description=");
		msg.append(description);

		msg.append("}");

		throw new NoSuchFeedbackException(msg.toString());
	}

	/**
	 * Returns the last feedback in the ordered set where description = &#63;.
	 *
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feedback, or <code>null</code> if a matching feedback could not be found
	 */
	@Override
	public Feedback fetchBydescription_Last(String description,
		OrderByComparator<Feedback> orderByComparator) {
		int count = countBydescription(description);

		if (count == 0) {
			return null;
		}

		List<Feedback> list = findBydescription(description, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the feedbacks before and after the current feedback in the ordered set where description = &#63;.
	 *
	 * @param feedbackId the primary key of the current feedback
	 * @param description the description
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next feedback
	 * @throws NoSuchFeedbackException if a feedback with the primary key could not be found
	 */
	@Override
	public Feedback[] findBydescription_PrevAndNext(long feedbackId,
		String description, OrderByComparator<Feedback> orderByComparator)
		throws NoSuchFeedbackException {
		description = Objects.toString(description, "");

		Feedback feedback = findByPrimaryKey(feedbackId);

		Session session = null;

		try {
			session = openSession();

			Feedback[] array = new FeedbackImpl[3];

			array[0] = getBydescription_PrevAndNext(session, feedback,
					description, orderByComparator, true);

			array[1] = feedback;

			array[2] = getBydescription_PrevAndNext(session, feedback,
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

	protected Feedback getBydescription_PrevAndNext(Session session,
		Feedback feedback, String description,
		OrderByComparator<Feedback> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FEEDBACK_WHERE);

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
			query.append(FeedbackModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(feedback);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Feedback> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the feedbacks where description = &#63; from the database.
	 *
	 * @param description the description
	 */
	@Override
	public void removeBydescription(String description) {
		for (Feedback feedback : findBydescription(description,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(feedback);
		}
	}

	/**
	 * Returns the number of feedbacks where description = &#63;.
	 *
	 * @param description the description
	 * @return the number of matching feedbacks
	 */
	@Override
	public int countBydescription(String description) {
		description = Objects.toString(description, "");

		FinderPath finderPath = FINDER_PATH_COUNT_BY_DESCRIPTION;

		Object[] finderArgs = new Object[] { description };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FEEDBACK_WHERE);

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

	private static final String _FINDER_COLUMN_DESCRIPTION_DESCRIPTION_1 = "feedback.description IS NULL";
	private static final String _FINDER_COLUMN_DESCRIPTION_DESCRIPTION_2 = "feedback.description = ?";
	private static final String _FINDER_COLUMN_DESCRIPTION_DESCRIPTION_3 = "(feedback.description IS NULL OR feedback.description = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATEDATE =
		new FinderPath(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackModelImpl.FINDER_CACHE_ENABLED, FeedbackImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycreateDate",
			new String[] {
				Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDATE =
		new FinderPath(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackModelImpl.FINDER_CACHE_ENABLED, FeedbackImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycreateDate",
			new String[] { Date.class.getName() },
			FeedbackModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CREATEDATE = new FinderPath(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycreateDate",
			new String[] { Date.class.getName() });

	/**
	 * Returns all the feedbacks where createDate = &#63;.
	 *
	 * @param createDate the create date
	 * @return the matching feedbacks
	 */
	@Override
	public List<Feedback> findBycreateDate(Date createDate) {
		return findBycreateDate(createDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the feedbacks where createDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param createDate the create date
	 * @param start the lower bound of the range of feedbacks
	 * @param end the upper bound of the range of feedbacks (not inclusive)
	 * @return the range of matching feedbacks
	 */
	@Override
	public List<Feedback> findBycreateDate(Date createDate, int start, int end) {
		return findBycreateDate(createDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the feedbacks where createDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param createDate the create date
	 * @param start the lower bound of the range of feedbacks
	 * @param end the upper bound of the range of feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching feedbacks
	 */
	@Override
	public List<Feedback> findBycreateDate(Date createDate, int start, int end,
		OrderByComparator<Feedback> orderByComparator) {
		return findBycreateDate(createDate, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the feedbacks where createDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param createDate the create date
	 * @param start the lower bound of the range of feedbacks
	 * @param end the upper bound of the range of feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching feedbacks
	 */
	@Override
	public List<Feedback> findBycreateDate(Date createDate, int start, int end,
		OrderByComparator<Feedback> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDATE;
			finderArgs = new Object[] { _getTime(createDate) };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATEDATE;
			finderArgs = new Object[] {
					_getTime(createDate),
					
					start, end, orderByComparator
				};
		}

		List<Feedback> list = null;

		if (retrieveFromCache) {
			list = (List<Feedback>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Feedback feedback : list) {
					if (!Objects.equals(createDate, feedback.getCreateDate())) {
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

			query.append(_SQL_SELECT_FEEDBACK_WHERE);

			boolean bindCreateDate = false;

			if (createDate == null) {
				query.append(_FINDER_COLUMN_CREATEDATE_CREATEDATE_1);
			}
			else {
				bindCreateDate = true;

				query.append(_FINDER_COLUMN_CREATEDATE_CREATEDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FeedbackModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCreateDate) {
					qPos.add(new Timestamp(createDate.getTime()));
				}

				if (!pagination) {
					list = (List<Feedback>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Feedback>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first feedback in the ordered set where createDate = &#63;.
	 *
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feedback
	 * @throws NoSuchFeedbackException if a matching feedback could not be found
	 */
	@Override
	public Feedback findBycreateDate_First(Date createDate,
		OrderByComparator<Feedback> orderByComparator)
		throws NoSuchFeedbackException {
		Feedback feedback = fetchBycreateDate_First(createDate,
				orderByComparator);

		if (feedback != null) {
			return feedback;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("createDate=");
		msg.append(createDate);

		msg.append("}");

		throw new NoSuchFeedbackException(msg.toString());
	}

	/**
	 * Returns the first feedback in the ordered set where createDate = &#63;.
	 *
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feedback, or <code>null</code> if a matching feedback could not be found
	 */
	@Override
	public Feedback fetchBycreateDate_First(Date createDate,
		OrderByComparator<Feedback> orderByComparator) {
		List<Feedback> list = findBycreateDate(createDate, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last feedback in the ordered set where createDate = &#63;.
	 *
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feedback
	 * @throws NoSuchFeedbackException if a matching feedback could not be found
	 */
	@Override
	public Feedback findBycreateDate_Last(Date createDate,
		OrderByComparator<Feedback> orderByComparator)
		throws NoSuchFeedbackException {
		Feedback feedback = fetchBycreateDate_Last(createDate, orderByComparator);

		if (feedback != null) {
			return feedback;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("createDate=");
		msg.append(createDate);

		msg.append("}");

		throw new NoSuchFeedbackException(msg.toString());
	}

	/**
	 * Returns the last feedback in the ordered set where createDate = &#63;.
	 *
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feedback, or <code>null</code> if a matching feedback could not be found
	 */
	@Override
	public Feedback fetchBycreateDate_Last(Date createDate,
		OrderByComparator<Feedback> orderByComparator) {
		int count = countBycreateDate(createDate);

		if (count == 0) {
			return null;
		}

		List<Feedback> list = findBycreateDate(createDate, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the feedbacks before and after the current feedback in the ordered set where createDate = &#63;.
	 *
	 * @param feedbackId the primary key of the current feedback
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next feedback
	 * @throws NoSuchFeedbackException if a feedback with the primary key could not be found
	 */
	@Override
	public Feedback[] findBycreateDate_PrevAndNext(long feedbackId,
		Date createDate, OrderByComparator<Feedback> orderByComparator)
		throws NoSuchFeedbackException {
		Feedback feedback = findByPrimaryKey(feedbackId);

		Session session = null;

		try {
			session = openSession();

			Feedback[] array = new FeedbackImpl[3];

			array[0] = getBycreateDate_PrevAndNext(session, feedback,
					createDate, orderByComparator, true);

			array[1] = feedback;

			array[2] = getBycreateDate_PrevAndNext(session, feedback,
					createDate, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Feedback getBycreateDate_PrevAndNext(Session session,
		Feedback feedback, Date createDate,
		OrderByComparator<Feedback> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FEEDBACK_WHERE);

		boolean bindCreateDate = false;

		if (createDate == null) {
			query.append(_FINDER_COLUMN_CREATEDATE_CREATEDATE_1);
		}
		else {
			bindCreateDate = true;

			query.append(_FINDER_COLUMN_CREATEDATE_CREATEDATE_2);
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
			query.append(FeedbackModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCreateDate) {
			qPos.add(new Timestamp(createDate.getTime()));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(feedback);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Feedback> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the feedbacks where createDate = &#63; from the database.
	 *
	 * @param createDate the create date
	 */
	@Override
	public void removeBycreateDate(Date createDate) {
		for (Feedback feedback : findBycreateDate(createDate,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(feedback);
		}
	}

	/**
	 * Returns the number of feedbacks where createDate = &#63;.
	 *
	 * @param createDate the create date
	 * @return the number of matching feedbacks
	 */
	@Override
	public int countBycreateDate(Date createDate) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CREATEDATE;

		Object[] finderArgs = new Object[] { _getTime(createDate) };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FEEDBACK_WHERE);

			boolean bindCreateDate = false;

			if (createDate == null) {
				query.append(_FINDER_COLUMN_CREATEDATE_CREATEDATE_1);
			}
			else {
				bindCreateDate = true;

				query.append(_FINDER_COLUMN_CREATEDATE_CREATEDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCreateDate) {
					qPos.add(new Timestamp(createDate.getTime()));
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

	private static final String _FINDER_COLUMN_CREATEDATE_CREATEDATE_1 = "feedback.createDate IS NULL";
	private static final String _FINDER_COLUMN_CREATEDATE_CREATEDATE_2 = "feedback.createDate = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATEDATEANDEMAIL =
		new FinderPath(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackModelImpl.FINDER_CACHE_ENABLED, FeedbackImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycreateDateAndEmail",
			new String[] {
				Date.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDATEANDEMAIL =
		new FinderPath(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackModelImpl.FINDER_CACHE_ENABLED, FeedbackImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBycreateDateAndEmail",
			new String[] { Date.class.getName(), String.class.getName() },
			FeedbackModelImpl.CREATEDATE_COLUMN_BITMASK |
			FeedbackModelImpl.EMAIL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CREATEDATEANDEMAIL = new FinderPath(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBycreateDateAndEmail",
			new String[] { Date.class.getName(), String.class.getName() });

	/**
	 * Returns all the feedbacks where createDate = &#63; and email = &#63;.
	 *
	 * @param createDate the create date
	 * @param email the email
	 * @return the matching feedbacks
	 */
	@Override
	public List<Feedback> findBycreateDateAndEmail(Date createDate, String email) {
		return findBycreateDateAndEmail(createDate, email, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the feedbacks where createDate = &#63; and email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param createDate the create date
	 * @param email the email
	 * @param start the lower bound of the range of feedbacks
	 * @param end the upper bound of the range of feedbacks (not inclusive)
	 * @return the range of matching feedbacks
	 */
	@Override
	public List<Feedback> findBycreateDateAndEmail(Date createDate,
		String email, int start, int end) {
		return findBycreateDateAndEmail(createDate, email, start, end, null);
	}

	/**
	 * Returns an ordered range of all the feedbacks where createDate = &#63; and email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param createDate the create date
	 * @param email the email
	 * @param start the lower bound of the range of feedbacks
	 * @param end the upper bound of the range of feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching feedbacks
	 */
	@Override
	public List<Feedback> findBycreateDateAndEmail(Date createDate,
		String email, int start, int end,
		OrderByComparator<Feedback> orderByComparator) {
		return findBycreateDateAndEmail(createDate, email, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the feedbacks where createDate = &#63; and email = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param createDate the create date
	 * @param email the email
	 * @param start the lower bound of the range of feedbacks
	 * @param end the upper bound of the range of feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching feedbacks
	 */
	@Override
	public List<Feedback> findBycreateDateAndEmail(Date createDate,
		String email, int start, int end,
		OrderByComparator<Feedback> orderByComparator, boolean retrieveFromCache) {
		email = Objects.toString(email, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDATEANDEMAIL;
			finderArgs = new Object[] { _getTime(createDate), email };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATEDATEANDEMAIL;
			finderArgs = new Object[] {
					_getTime(createDate), email,
					
					start, end, orderByComparator
				};
		}

		List<Feedback> list = null;

		if (retrieveFromCache) {
			list = (List<Feedback>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Feedback feedback : list) {
					if (!Objects.equals(createDate, feedback.getCreateDate()) ||
							!email.equals(feedback.getEmail())) {
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

			query.append(_SQL_SELECT_FEEDBACK_WHERE);

			boolean bindCreateDate = false;

			if (createDate == null) {
				query.append(_FINDER_COLUMN_CREATEDATEANDEMAIL_CREATEDATE_1);
			}
			else {
				bindCreateDate = true;

				query.append(_FINDER_COLUMN_CREATEDATEANDEMAIL_CREATEDATE_2);
			}

			boolean bindEmail = false;

			if (email.isEmpty()) {
				query.append(_FINDER_COLUMN_CREATEDATEANDEMAIL_EMAIL_3);
			}
			else {
				bindEmail = true;

				query.append(_FINDER_COLUMN_CREATEDATEANDEMAIL_EMAIL_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FeedbackModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCreateDate) {
					qPos.add(new Timestamp(createDate.getTime()));
				}

				if (bindEmail) {
					qPos.add(email);
				}

				if (!pagination) {
					list = (List<Feedback>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Feedback>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Returns the first feedback in the ordered set where createDate = &#63; and email = &#63;.
	 *
	 * @param createDate the create date
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feedback
	 * @throws NoSuchFeedbackException if a matching feedback could not be found
	 */
	@Override
	public Feedback findBycreateDateAndEmail_First(Date createDate,
		String email, OrderByComparator<Feedback> orderByComparator)
		throws NoSuchFeedbackException {
		Feedback feedback = fetchBycreateDateAndEmail_First(createDate, email,
				orderByComparator);

		if (feedback != null) {
			return feedback;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("createDate=");
		msg.append(createDate);

		msg.append(", email=");
		msg.append(email);

		msg.append("}");

		throw new NoSuchFeedbackException(msg.toString());
	}

	/**
	 * Returns the first feedback in the ordered set where createDate = &#63; and email = &#63;.
	 *
	 * @param createDate the create date
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feedback, or <code>null</code> if a matching feedback could not be found
	 */
	@Override
	public Feedback fetchBycreateDateAndEmail_First(Date createDate,
		String email, OrderByComparator<Feedback> orderByComparator) {
		List<Feedback> list = findBycreateDateAndEmail(createDate, email, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last feedback in the ordered set where createDate = &#63; and email = &#63;.
	 *
	 * @param createDate the create date
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feedback
	 * @throws NoSuchFeedbackException if a matching feedback could not be found
	 */
	@Override
	public Feedback findBycreateDateAndEmail_Last(Date createDate,
		String email, OrderByComparator<Feedback> orderByComparator)
		throws NoSuchFeedbackException {
		Feedback feedback = fetchBycreateDateAndEmail_Last(createDate, email,
				orderByComparator);

		if (feedback != null) {
			return feedback;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("createDate=");
		msg.append(createDate);

		msg.append(", email=");
		msg.append(email);

		msg.append("}");

		throw new NoSuchFeedbackException(msg.toString());
	}

	/**
	 * Returns the last feedback in the ordered set where createDate = &#63; and email = &#63;.
	 *
	 * @param createDate the create date
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feedback, or <code>null</code> if a matching feedback could not be found
	 */
	@Override
	public Feedback fetchBycreateDateAndEmail_Last(Date createDate,
		String email, OrderByComparator<Feedback> orderByComparator) {
		int count = countBycreateDateAndEmail(createDate, email);

		if (count == 0) {
			return null;
		}

		List<Feedback> list = findBycreateDateAndEmail(createDate, email,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the feedbacks before and after the current feedback in the ordered set where createDate = &#63; and email = &#63;.
	 *
	 * @param feedbackId the primary key of the current feedback
	 * @param createDate the create date
	 * @param email the email
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next feedback
	 * @throws NoSuchFeedbackException if a feedback with the primary key could not be found
	 */
	@Override
	public Feedback[] findBycreateDateAndEmail_PrevAndNext(long feedbackId,
		Date createDate, String email,
		OrderByComparator<Feedback> orderByComparator)
		throws NoSuchFeedbackException {
		email = Objects.toString(email, "");

		Feedback feedback = findByPrimaryKey(feedbackId);

		Session session = null;

		try {
			session = openSession();

			Feedback[] array = new FeedbackImpl[3];

			array[0] = getBycreateDateAndEmail_PrevAndNext(session, feedback,
					createDate, email, orderByComparator, true);

			array[1] = feedback;

			array[2] = getBycreateDateAndEmail_PrevAndNext(session, feedback,
					createDate, email, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Feedback getBycreateDateAndEmail_PrevAndNext(Session session,
		Feedback feedback, Date createDate, String email,
		OrderByComparator<Feedback> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_FEEDBACK_WHERE);

		boolean bindCreateDate = false;

		if (createDate == null) {
			query.append(_FINDER_COLUMN_CREATEDATEANDEMAIL_CREATEDATE_1);
		}
		else {
			bindCreateDate = true;

			query.append(_FINDER_COLUMN_CREATEDATEANDEMAIL_CREATEDATE_2);
		}

		boolean bindEmail = false;

		if (email.isEmpty()) {
			query.append(_FINDER_COLUMN_CREATEDATEANDEMAIL_EMAIL_3);
		}
		else {
			bindEmail = true;

			query.append(_FINDER_COLUMN_CREATEDATEANDEMAIL_EMAIL_2);
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
			query.append(FeedbackModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCreateDate) {
			qPos.add(new Timestamp(createDate.getTime()));
		}

		if (bindEmail) {
			qPos.add(email);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(feedback);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Feedback> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the feedbacks where createDate = &#63; and email = &#63; from the database.
	 *
	 * @param createDate the create date
	 * @param email the email
	 */
	@Override
	public void removeBycreateDateAndEmail(Date createDate, String email) {
		for (Feedback feedback : findBycreateDateAndEmail(createDate, email,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(feedback);
		}
	}

	/**
	 * Returns the number of feedbacks where createDate = &#63; and email = &#63;.
	 *
	 * @param createDate the create date
	 * @param email the email
	 * @return the number of matching feedbacks
	 */
	@Override
	public int countBycreateDateAndEmail(Date createDate, String email) {
		email = Objects.toString(email, "");

		FinderPath finderPath = FINDER_PATH_COUNT_BY_CREATEDATEANDEMAIL;

		Object[] finderArgs = new Object[] { _getTime(createDate), email };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_FEEDBACK_WHERE);

			boolean bindCreateDate = false;

			if (createDate == null) {
				query.append(_FINDER_COLUMN_CREATEDATEANDEMAIL_CREATEDATE_1);
			}
			else {
				bindCreateDate = true;

				query.append(_FINDER_COLUMN_CREATEDATEANDEMAIL_CREATEDATE_2);
			}

			boolean bindEmail = false;

			if (email.isEmpty()) {
				query.append(_FINDER_COLUMN_CREATEDATEANDEMAIL_EMAIL_3);
			}
			else {
				bindEmail = true;

				query.append(_FINDER_COLUMN_CREATEDATEANDEMAIL_EMAIL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCreateDate) {
					qPos.add(new Timestamp(createDate.getTime()));
				}

				if (bindEmail) {
					qPos.add(email);
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

	private static final String _FINDER_COLUMN_CREATEDATEANDEMAIL_CREATEDATE_1 = "feedback.createDate IS NULL AND ";
	private static final String _FINDER_COLUMN_CREATEDATEANDEMAIL_CREATEDATE_2 = "feedback.createDate = ? AND ";
	private static final String _FINDER_COLUMN_CREATEDATEANDEMAIL_EMAIL_1 = "feedback.email IS NULL";
	private static final String _FINDER_COLUMN_CREATEDATEANDEMAIL_EMAIL_2 = "feedback.email = ?";
	private static final String _FINDER_COLUMN_CREATEDATEANDEMAIL_EMAIL_3 = "(feedback.email IS NULL OR feedback.email = '')";

	public FeedbackPersistenceImpl() {
		setModelClass(Feedback.class);

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
	 * Caches the feedback in the entity cache if it is enabled.
	 *
	 * @param feedback the feedback
	 */
	@Override
	public void cacheResult(Feedback feedback) {
		entityCache.putResult(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackImpl.class, feedback.getPrimaryKey(), feedback);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { feedback.getUuid(), feedback.getGroupId() }, feedback);

		feedback.resetOriginalValues();
	}

	/**
	 * Caches the feedbacks in the entity cache if it is enabled.
	 *
	 * @param feedbacks the feedbacks
	 */
	@Override
	public void cacheResult(List<Feedback> feedbacks) {
		for (Feedback feedback : feedbacks) {
			if (entityCache.getResult(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
						FeedbackImpl.class, feedback.getPrimaryKey()) == null) {
				cacheResult(feedback);
			}
			else {
				feedback.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all feedbacks.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FeedbackImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the feedback.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Feedback feedback) {
		entityCache.removeResult(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackImpl.class, feedback.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((FeedbackModelImpl)feedback, true);
	}

	@Override
	public void clearCache(List<Feedback> feedbacks) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Feedback feedback : feedbacks) {
			entityCache.removeResult(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
				FeedbackImpl.class, feedback.getPrimaryKey());

			clearUniqueFindersCache((FeedbackModelImpl)feedback, true);
		}
	}

	protected void cacheUniqueFindersCache(FeedbackModelImpl feedbackModelImpl) {
		Object[] args = new Object[] {
				feedbackModelImpl.getUuid(), feedbackModelImpl.getGroupId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
			feedbackModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		FeedbackModelImpl feedbackModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					feedbackModelImpl.getUuid(), feedbackModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		if ((feedbackModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					feedbackModelImpl.getOriginalUuid(),
					feedbackModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new feedback with the primary key. Does not add the feedback to the database.
	 *
	 * @param feedbackId the primary key for the new feedback
	 * @return the new feedback
	 */
	@Override
	public Feedback create(long feedbackId) {
		Feedback feedback = new FeedbackImpl();

		feedback.setNew(true);
		feedback.setPrimaryKey(feedbackId);

		String uuid = PortalUUIDUtil.generate();

		feedback.setUuid(uuid);

		feedback.setCompanyId(companyProvider.getCompanyId());

		return feedback;
	}

	/**
	 * Removes the feedback with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param feedbackId the primary key of the feedback
	 * @return the feedback that was removed
	 * @throws NoSuchFeedbackException if a feedback with the primary key could not be found
	 */
	@Override
	public Feedback remove(long feedbackId) throws NoSuchFeedbackException {
		return remove((Serializable)feedbackId);
	}

	/**
	 * Removes the feedback with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the feedback
	 * @return the feedback that was removed
	 * @throws NoSuchFeedbackException if a feedback with the primary key could not be found
	 */
	@Override
	public Feedback remove(Serializable primaryKey)
		throws NoSuchFeedbackException {
		Session session = null;

		try {
			session = openSession();

			Feedback feedback = (Feedback)session.get(FeedbackImpl.class,
					primaryKey);

			if (feedback == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFeedbackException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(feedback);
		}
		catch (NoSuchFeedbackException nsee) {
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
	protected Feedback removeImpl(Feedback feedback) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(feedback)) {
				feedback = (Feedback)session.get(FeedbackImpl.class,
						feedback.getPrimaryKeyObj());
			}

			if (feedback != null) {
				session.delete(feedback);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (feedback != null) {
			clearCache(feedback);
		}

		return feedback;
	}

	@Override
	public Feedback updateImpl(Feedback feedback) {
		boolean isNew = feedback.isNew();

		if (!(feedback instanceof FeedbackModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(feedback.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(feedback);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in feedback proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Feedback implementation " +
				feedback.getClass());
		}

		FeedbackModelImpl feedbackModelImpl = (FeedbackModelImpl)feedback;

		if (Validator.isNull(feedback.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			feedback.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (feedback.getCreateDate() == null)) {
			if (serviceContext == null) {
				feedback.setCreateDate(now);
			}
			else {
				feedback.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!feedbackModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				feedback.setModifiedDate(now);
			}
			else {
				feedback.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (feedback.isNew()) {
				session.save(feedback);

				feedback.setNew(false);
			}
			else {
				feedback = (Feedback)session.merge(feedback);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!FeedbackModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { feedbackModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					feedbackModelImpl.getUuid(),
					feedbackModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
				args);

			args = new Object[] { feedbackModelImpl.getEmail() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMAIL, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL,
				args);

			args = new Object[] { feedbackModelImpl.getLastName() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_LASTNAME, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LASTNAME,
				args);

			args = new Object[] { feedbackModelImpl.getDescription() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_DESCRIPTION, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCRIPTION,
				args);

			args = new Object[] { feedbackModelImpl.getCreateDate() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_CREATEDATE, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDATE,
				args);

			args = new Object[] {
					feedbackModelImpl.getCreateDate(),
					feedbackModelImpl.getEmail()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_CREATEDATEANDEMAIL,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDATEANDEMAIL,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((feedbackModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { feedbackModelImpl.getOriginalUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { feedbackModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((feedbackModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						feedbackModelImpl.getOriginalUuid(),
						feedbackModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						feedbackModelImpl.getUuid(),
						feedbackModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((feedbackModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						feedbackModelImpl.getOriginalEmail()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMAIL, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL,
					args);

				args = new Object[] { feedbackModelImpl.getEmail() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EMAIL, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL,
					args);
			}

			if ((feedbackModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LASTNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						feedbackModelImpl.getOriginalLastName()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LASTNAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LASTNAME,
					args);

				args = new Object[] { feedbackModelImpl.getLastName() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LASTNAME, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LASTNAME,
					args);
			}

			if ((feedbackModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCRIPTION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						feedbackModelImpl.getOriginalDescription()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DESCRIPTION, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCRIPTION,
					args);

				args = new Object[] { feedbackModelImpl.getDescription() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DESCRIPTION, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCRIPTION,
					args);
			}

			if ((feedbackModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						feedbackModelImpl.getOriginalCreateDate()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CREATEDATE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDATE,
					args);

				args = new Object[] { feedbackModelImpl.getCreateDate() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CREATEDATE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDATE,
					args);
			}

			if ((feedbackModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDATEANDEMAIL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						feedbackModelImpl.getOriginalCreateDate(),
						feedbackModelImpl.getOriginalEmail()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CREATEDATEANDEMAIL,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDATEANDEMAIL,
					args);

				args = new Object[] {
						feedbackModelImpl.getCreateDate(),
						feedbackModelImpl.getEmail()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CREATEDATEANDEMAIL,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDATEANDEMAIL,
					args);
			}
		}

		entityCache.putResult(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
			FeedbackImpl.class, feedback.getPrimaryKey(), feedback, false);

		clearUniqueFindersCache(feedbackModelImpl, false);
		cacheUniqueFindersCache(feedbackModelImpl);

		feedback.resetOriginalValues();

		return feedback;
	}

	/**
	 * Returns the feedback with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the feedback
	 * @return the feedback
	 * @throws NoSuchFeedbackException if a feedback with the primary key could not be found
	 */
	@Override
	public Feedback findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFeedbackException {
		Feedback feedback = fetchByPrimaryKey(primaryKey);

		if (feedback == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFeedbackException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return feedback;
	}

	/**
	 * Returns the feedback with the primary key or throws a {@link NoSuchFeedbackException} if it could not be found.
	 *
	 * @param feedbackId the primary key of the feedback
	 * @return the feedback
	 * @throws NoSuchFeedbackException if a feedback with the primary key could not be found
	 */
	@Override
	public Feedback findByPrimaryKey(long feedbackId)
		throws NoSuchFeedbackException {
		return findByPrimaryKey((Serializable)feedbackId);
	}

	/**
	 * Returns the feedback with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the feedback
	 * @return the feedback, or <code>null</code> if a feedback with the primary key could not be found
	 */
	@Override
	public Feedback fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
				FeedbackImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Feedback feedback = (Feedback)serializable;

		if (feedback == null) {
			Session session = null;

			try {
				session = openSession();

				feedback = (Feedback)session.get(FeedbackImpl.class, primaryKey);

				if (feedback != null) {
					cacheResult(feedback);
				}
				else {
					entityCache.putResult(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
						FeedbackImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
					FeedbackImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return feedback;
	}

	/**
	 * Returns the feedback with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param feedbackId the primary key of the feedback
	 * @return the feedback, or <code>null</code> if a feedback with the primary key could not be found
	 */
	@Override
	public Feedback fetchByPrimaryKey(long feedbackId) {
		return fetchByPrimaryKey((Serializable)feedbackId);
	}

	@Override
	public Map<Serializable, Feedback> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Feedback> map = new HashMap<Serializable, Feedback>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Feedback feedback = fetchByPrimaryKey(primaryKey);

			if (feedback != null) {
				map.put(primaryKey, feedback);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
					FeedbackImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Feedback)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_FEEDBACK_WHERE_PKS_IN);

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

			for (Feedback feedback : (List<Feedback>)q.list()) {
				map.put(feedback.getPrimaryKeyObj(), feedback);

				cacheResult(feedback);

				uncachedPrimaryKeys.remove(feedback.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(FeedbackModelImpl.ENTITY_CACHE_ENABLED,
					FeedbackImpl.class, primaryKey, nullModel);
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
	 * Returns all the feedbacks.
	 *
	 * @return the feedbacks
	 */
	@Override
	public List<Feedback> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the feedbacks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of feedbacks
	 * @param end the upper bound of the range of feedbacks (not inclusive)
	 * @return the range of feedbacks
	 */
	@Override
	public List<Feedback> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the feedbacks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of feedbacks
	 * @param end the upper bound of the range of feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of feedbacks
	 */
	@Override
	public List<Feedback> findAll(int start, int end,
		OrderByComparator<Feedback> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the feedbacks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of feedbacks
	 * @param end the upper bound of the range of feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of feedbacks
	 */
	@Override
	public List<Feedback> findAll(int start, int end,
		OrderByComparator<Feedback> orderByComparator, boolean retrieveFromCache) {
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

		List<Feedback> list = null;

		if (retrieveFromCache) {
			list = (List<Feedback>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_FEEDBACK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FEEDBACK;

				if (pagination) {
					sql = sql.concat(FeedbackModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Feedback>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Feedback>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the feedbacks from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Feedback feedback : findAll()) {
			remove(feedback);
		}
	}

	/**
	 * Returns the number of feedbacks.
	 *
	 * @return the number of feedbacks
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_FEEDBACK);

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
		return FeedbackModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the feedback persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(FeedbackImpl.class.getName());
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

	private Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_FEEDBACK = "SELECT feedback FROM Feedback feedback";
	private static final String _SQL_SELECT_FEEDBACK_WHERE_PKS_IN = "SELECT feedback FROM Feedback feedback WHERE feedbackId IN (";
	private static final String _SQL_SELECT_FEEDBACK_WHERE = "SELECT feedback FROM Feedback feedback WHERE ";
	private static final String _SQL_COUNT_FEEDBACK = "SELECT COUNT(feedback) FROM Feedback feedback";
	private static final String _SQL_COUNT_FEEDBACK_WHERE = "SELECT COUNT(feedback) FROM Feedback feedback WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "feedback.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Feedback exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Feedback exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(FeedbackPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}