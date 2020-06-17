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

package it.scinti.lfr.secpg.xssinjection.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import it.scinti.lfr.secpg.xssinjection.model.Feedback;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.Date;
import java.util.List;

/**
 * The persistence utility for the feedback service. This utility wraps {@link it.scinti.lfr.secpg.xssinjection.service.persistence.impl.FeedbackPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FeedbackPersistence
 * @see it.scinti.lfr.secpg.xssinjection.service.persistence.impl.FeedbackPersistenceImpl
 * @generated
 */
@ProviderType
public class FeedbackUtil {
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
	public static void clearCache(Feedback feedback) {
		getPersistence().clearCache(feedback);
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
	public static List<Feedback> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Feedback> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Feedback> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Feedback> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Feedback update(Feedback feedback) {
		return getPersistence().update(feedback);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Feedback update(Feedback feedback,
		ServiceContext serviceContext) {
		return getPersistence().update(feedback, serviceContext);
	}

	/**
	* Returns all the feedbacks where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching feedbacks
	*/
	public static List<Feedback> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<Feedback> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<Feedback> findByUuid(String uuid, int start, int end,
		OrderByComparator<Feedback> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static List<Feedback> findByUuid(String uuid, int start, int end,
		OrderByComparator<Feedback> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first feedback in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching feedback
	* @throws NoSuchFeedbackException if a matching feedback could not be found
	*/
	public static Feedback findByUuid_First(String uuid,
		OrderByComparator<Feedback> orderByComparator)
		throws it.scinti.lfr.secpg.xssinjection.exception.NoSuchFeedbackException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first feedback in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching feedback, or <code>null</code> if a matching feedback could not be found
	*/
	public static Feedback fetchByUuid_First(String uuid,
		OrderByComparator<Feedback> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last feedback in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching feedback
	* @throws NoSuchFeedbackException if a matching feedback could not be found
	*/
	public static Feedback findByUuid_Last(String uuid,
		OrderByComparator<Feedback> orderByComparator)
		throws it.scinti.lfr.secpg.xssinjection.exception.NoSuchFeedbackException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last feedback in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching feedback, or <code>null</code> if a matching feedback could not be found
	*/
	public static Feedback fetchByUuid_Last(String uuid,
		OrderByComparator<Feedback> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static Feedback[] findByUuid_PrevAndNext(long feedbackId,
		String uuid, OrderByComparator<Feedback> orderByComparator)
		throws it.scinti.lfr.secpg.xssinjection.exception.NoSuchFeedbackException {
		return getPersistence()
				   .findByUuid_PrevAndNext(feedbackId, uuid, orderByComparator);
	}

	/**
	* Removes all the feedbacks where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of feedbacks where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching feedbacks
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the feedback where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchFeedbackException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching feedback
	* @throws NoSuchFeedbackException if a matching feedback could not be found
	*/
	public static Feedback findByUUID_G(String uuid, long groupId)
		throws it.scinti.lfr.secpg.xssinjection.exception.NoSuchFeedbackException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the feedback where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching feedback, or <code>null</code> if a matching feedback could not be found
	*/
	public static Feedback fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the feedback where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching feedback, or <code>null</code> if a matching feedback could not be found
	*/
	public static Feedback fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the feedback where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the feedback that was removed
	*/
	public static Feedback removeByUUID_G(String uuid, long groupId)
		throws it.scinti.lfr.secpg.xssinjection.exception.NoSuchFeedbackException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of feedbacks where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching feedbacks
	*/
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the feedbacks where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching feedbacks
	*/
	public static List<Feedback> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
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
	public static List<Feedback> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
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
	public static List<Feedback> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<Feedback> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
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
	public static List<Feedback> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<Feedback> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
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
	public static Feedback findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Feedback> orderByComparator)
		throws it.scinti.lfr.secpg.xssinjection.exception.NoSuchFeedbackException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first feedback in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching feedback, or <code>null</code> if a matching feedback could not be found
	*/
	public static Feedback fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Feedback> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
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
	public static Feedback findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Feedback> orderByComparator)
		throws it.scinti.lfr.secpg.xssinjection.exception.NoSuchFeedbackException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last feedback in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching feedback, or <code>null</code> if a matching feedback could not be found
	*/
	public static Feedback fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Feedback> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
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
	public static Feedback[] findByUuid_C_PrevAndNext(long feedbackId,
		String uuid, long companyId,
		OrderByComparator<Feedback> orderByComparator)
		throws it.scinti.lfr.secpg.xssinjection.exception.NoSuchFeedbackException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(feedbackId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the feedbacks where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of feedbacks where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching feedbacks
	*/
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the feedbacks where email = &#63;.
	*
	* @param email the email
	* @return the matching feedbacks
	*/
	public static List<Feedback> findByemail(String email) {
		return getPersistence().findByemail(email);
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
	public static List<Feedback> findByemail(String email, int start, int end) {
		return getPersistence().findByemail(email, start, end);
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
	public static List<Feedback> findByemail(String email, int start, int end,
		OrderByComparator<Feedback> orderByComparator) {
		return getPersistence().findByemail(email, start, end, orderByComparator);
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
	public static List<Feedback> findByemail(String email, int start, int end,
		OrderByComparator<Feedback> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByemail(email, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first feedback in the ordered set where email = &#63;.
	*
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching feedback
	* @throws NoSuchFeedbackException if a matching feedback could not be found
	*/
	public static Feedback findByemail_First(String email,
		OrderByComparator<Feedback> orderByComparator)
		throws it.scinti.lfr.secpg.xssinjection.exception.NoSuchFeedbackException {
		return getPersistence().findByemail_First(email, orderByComparator);
	}

	/**
	* Returns the first feedback in the ordered set where email = &#63;.
	*
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching feedback, or <code>null</code> if a matching feedback could not be found
	*/
	public static Feedback fetchByemail_First(String email,
		OrderByComparator<Feedback> orderByComparator) {
		return getPersistence().fetchByemail_First(email, orderByComparator);
	}

	/**
	* Returns the last feedback in the ordered set where email = &#63;.
	*
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching feedback
	* @throws NoSuchFeedbackException if a matching feedback could not be found
	*/
	public static Feedback findByemail_Last(String email,
		OrderByComparator<Feedback> orderByComparator)
		throws it.scinti.lfr.secpg.xssinjection.exception.NoSuchFeedbackException {
		return getPersistence().findByemail_Last(email, orderByComparator);
	}

	/**
	* Returns the last feedback in the ordered set where email = &#63;.
	*
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching feedback, or <code>null</code> if a matching feedback could not be found
	*/
	public static Feedback fetchByemail_Last(String email,
		OrderByComparator<Feedback> orderByComparator) {
		return getPersistence().fetchByemail_Last(email, orderByComparator);
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
	public static Feedback[] findByemail_PrevAndNext(long feedbackId,
		String email, OrderByComparator<Feedback> orderByComparator)
		throws it.scinti.lfr.secpg.xssinjection.exception.NoSuchFeedbackException {
		return getPersistence()
				   .findByemail_PrevAndNext(feedbackId, email, orderByComparator);
	}

	/**
	* Removes all the feedbacks where email = &#63; from the database.
	*
	* @param email the email
	*/
	public static void removeByemail(String email) {
		getPersistence().removeByemail(email);
	}

	/**
	* Returns the number of feedbacks where email = &#63;.
	*
	* @param email the email
	* @return the number of matching feedbacks
	*/
	public static int countByemail(String email) {
		return getPersistence().countByemail(email);
	}

	/**
	* Returns all the feedbacks where lastName = &#63;.
	*
	* @param lastName the last name
	* @return the matching feedbacks
	*/
	public static List<Feedback> findBylastName(String lastName) {
		return getPersistence().findBylastName(lastName);
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
	public static List<Feedback> findBylastName(String lastName, int start,
		int end) {
		return getPersistence().findBylastName(lastName, start, end);
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
	public static List<Feedback> findBylastName(String lastName, int start,
		int end, OrderByComparator<Feedback> orderByComparator) {
		return getPersistence()
				   .findBylastName(lastName, start, end, orderByComparator);
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
	public static List<Feedback> findBylastName(String lastName, int start,
		int end, OrderByComparator<Feedback> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBylastName(lastName, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first feedback in the ordered set where lastName = &#63;.
	*
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching feedback
	* @throws NoSuchFeedbackException if a matching feedback could not be found
	*/
	public static Feedback findBylastName_First(String lastName,
		OrderByComparator<Feedback> orderByComparator)
		throws it.scinti.lfr.secpg.xssinjection.exception.NoSuchFeedbackException {
		return getPersistence().findBylastName_First(lastName, orderByComparator);
	}

	/**
	* Returns the first feedback in the ordered set where lastName = &#63;.
	*
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching feedback, or <code>null</code> if a matching feedback could not be found
	*/
	public static Feedback fetchBylastName_First(String lastName,
		OrderByComparator<Feedback> orderByComparator) {
		return getPersistence()
				   .fetchBylastName_First(lastName, orderByComparator);
	}

	/**
	* Returns the last feedback in the ordered set where lastName = &#63;.
	*
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching feedback
	* @throws NoSuchFeedbackException if a matching feedback could not be found
	*/
	public static Feedback findBylastName_Last(String lastName,
		OrderByComparator<Feedback> orderByComparator)
		throws it.scinti.lfr.secpg.xssinjection.exception.NoSuchFeedbackException {
		return getPersistence().findBylastName_Last(lastName, orderByComparator);
	}

	/**
	* Returns the last feedback in the ordered set where lastName = &#63;.
	*
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching feedback, or <code>null</code> if a matching feedback could not be found
	*/
	public static Feedback fetchBylastName_Last(String lastName,
		OrderByComparator<Feedback> orderByComparator) {
		return getPersistence().fetchBylastName_Last(lastName, orderByComparator);
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
	public static Feedback[] findBylastName_PrevAndNext(long feedbackId,
		String lastName, OrderByComparator<Feedback> orderByComparator)
		throws it.scinti.lfr.secpg.xssinjection.exception.NoSuchFeedbackException {
		return getPersistence()
				   .findBylastName_PrevAndNext(feedbackId, lastName,
			orderByComparator);
	}

	/**
	* Removes all the feedbacks where lastName = &#63; from the database.
	*
	* @param lastName the last name
	*/
	public static void removeBylastName(String lastName) {
		getPersistence().removeBylastName(lastName);
	}

	/**
	* Returns the number of feedbacks where lastName = &#63;.
	*
	* @param lastName the last name
	* @return the number of matching feedbacks
	*/
	public static int countBylastName(String lastName) {
		return getPersistence().countBylastName(lastName);
	}

	/**
	* Returns all the feedbacks where description = &#63;.
	*
	* @param description the description
	* @return the matching feedbacks
	*/
	public static List<Feedback> findBydescription(String description) {
		return getPersistence().findBydescription(description);
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
	public static List<Feedback> findBydescription(String description,
		int start, int end) {
		return getPersistence().findBydescription(description, start, end);
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
	public static List<Feedback> findBydescription(String description,
		int start, int end, OrderByComparator<Feedback> orderByComparator) {
		return getPersistence()
				   .findBydescription(description, start, end, orderByComparator);
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
	public static List<Feedback> findBydescription(String description,
		int start, int end, OrderByComparator<Feedback> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBydescription(description, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first feedback in the ordered set where description = &#63;.
	*
	* @param description the description
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching feedback
	* @throws NoSuchFeedbackException if a matching feedback could not be found
	*/
	public static Feedback findBydescription_First(String description,
		OrderByComparator<Feedback> orderByComparator)
		throws it.scinti.lfr.secpg.xssinjection.exception.NoSuchFeedbackException {
		return getPersistence()
				   .findBydescription_First(description, orderByComparator);
	}

	/**
	* Returns the first feedback in the ordered set where description = &#63;.
	*
	* @param description the description
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching feedback, or <code>null</code> if a matching feedback could not be found
	*/
	public static Feedback fetchBydescription_First(String description,
		OrderByComparator<Feedback> orderByComparator) {
		return getPersistence()
				   .fetchBydescription_First(description, orderByComparator);
	}

	/**
	* Returns the last feedback in the ordered set where description = &#63;.
	*
	* @param description the description
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching feedback
	* @throws NoSuchFeedbackException if a matching feedback could not be found
	*/
	public static Feedback findBydescription_Last(String description,
		OrderByComparator<Feedback> orderByComparator)
		throws it.scinti.lfr.secpg.xssinjection.exception.NoSuchFeedbackException {
		return getPersistence()
				   .findBydescription_Last(description, orderByComparator);
	}

	/**
	* Returns the last feedback in the ordered set where description = &#63;.
	*
	* @param description the description
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching feedback, or <code>null</code> if a matching feedback could not be found
	*/
	public static Feedback fetchBydescription_Last(String description,
		OrderByComparator<Feedback> orderByComparator) {
		return getPersistence()
				   .fetchBydescription_Last(description, orderByComparator);
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
	public static Feedback[] findBydescription_PrevAndNext(long feedbackId,
		String description, OrderByComparator<Feedback> orderByComparator)
		throws it.scinti.lfr.secpg.xssinjection.exception.NoSuchFeedbackException {
		return getPersistence()
				   .findBydescription_PrevAndNext(feedbackId, description,
			orderByComparator);
	}

	/**
	* Removes all the feedbacks where description = &#63; from the database.
	*
	* @param description the description
	*/
	public static void removeBydescription(String description) {
		getPersistence().removeBydescription(description);
	}

	/**
	* Returns the number of feedbacks where description = &#63;.
	*
	* @param description the description
	* @return the number of matching feedbacks
	*/
	public static int countBydescription(String description) {
		return getPersistence().countBydescription(description);
	}

	/**
	* Returns all the feedbacks where createDate = &#63;.
	*
	* @param createDate the create date
	* @return the matching feedbacks
	*/
	public static List<Feedback> findBycreateDate(Date createDate) {
		return getPersistence().findBycreateDate(createDate);
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
	public static List<Feedback> findBycreateDate(Date createDate, int start,
		int end) {
		return getPersistence().findBycreateDate(createDate, start, end);
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
	public static List<Feedback> findBycreateDate(Date createDate, int start,
		int end, OrderByComparator<Feedback> orderByComparator) {
		return getPersistence()
				   .findBycreateDate(createDate, start, end, orderByComparator);
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
	public static List<Feedback> findBycreateDate(Date createDate, int start,
		int end, OrderByComparator<Feedback> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBycreateDate(createDate, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first feedback in the ordered set where createDate = &#63;.
	*
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching feedback
	* @throws NoSuchFeedbackException if a matching feedback could not be found
	*/
	public static Feedback findBycreateDate_First(Date createDate,
		OrderByComparator<Feedback> orderByComparator)
		throws it.scinti.lfr.secpg.xssinjection.exception.NoSuchFeedbackException {
		return getPersistence()
				   .findBycreateDate_First(createDate, orderByComparator);
	}

	/**
	* Returns the first feedback in the ordered set where createDate = &#63;.
	*
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching feedback, or <code>null</code> if a matching feedback could not be found
	*/
	public static Feedback fetchBycreateDate_First(Date createDate,
		OrderByComparator<Feedback> orderByComparator) {
		return getPersistence()
				   .fetchBycreateDate_First(createDate, orderByComparator);
	}

	/**
	* Returns the last feedback in the ordered set where createDate = &#63;.
	*
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching feedback
	* @throws NoSuchFeedbackException if a matching feedback could not be found
	*/
	public static Feedback findBycreateDate_Last(Date createDate,
		OrderByComparator<Feedback> orderByComparator)
		throws it.scinti.lfr.secpg.xssinjection.exception.NoSuchFeedbackException {
		return getPersistence()
				   .findBycreateDate_Last(createDate, orderByComparator);
	}

	/**
	* Returns the last feedback in the ordered set where createDate = &#63;.
	*
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching feedback, or <code>null</code> if a matching feedback could not be found
	*/
	public static Feedback fetchBycreateDate_Last(Date createDate,
		OrderByComparator<Feedback> orderByComparator) {
		return getPersistence()
				   .fetchBycreateDate_Last(createDate, orderByComparator);
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
	public static Feedback[] findBycreateDate_PrevAndNext(long feedbackId,
		Date createDate, OrderByComparator<Feedback> orderByComparator)
		throws it.scinti.lfr.secpg.xssinjection.exception.NoSuchFeedbackException {
		return getPersistence()
				   .findBycreateDate_PrevAndNext(feedbackId, createDate,
			orderByComparator);
	}

	/**
	* Removes all the feedbacks where createDate = &#63; from the database.
	*
	* @param createDate the create date
	*/
	public static void removeBycreateDate(Date createDate) {
		getPersistence().removeBycreateDate(createDate);
	}

	/**
	* Returns the number of feedbacks where createDate = &#63;.
	*
	* @param createDate the create date
	* @return the number of matching feedbacks
	*/
	public static int countBycreateDate(Date createDate) {
		return getPersistence().countBycreateDate(createDate);
	}

	/**
	* Returns all the feedbacks where createDate = &#63; and email = &#63;.
	*
	* @param createDate the create date
	* @param email the email
	* @return the matching feedbacks
	*/
	public static List<Feedback> findBycreateDateAndEmail(Date createDate,
		String email) {
		return getPersistence().findBycreateDateAndEmail(createDate, email);
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
	public static List<Feedback> findBycreateDateAndEmail(Date createDate,
		String email, int start, int end) {
		return getPersistence()
				   .findBycreateDateAndEmail(createDate, email, start, end);
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
	public static List<Feedback> findBycreateDateAndEmail(Date createDate,
		String email, int start, int end,
		OrderByComparator<Feedback> orderByComparator) {
		return getPersistence()
				   .findBycreateDateAndEmail(createDate, email, start, end,
			orderByComparator);
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
	public static List<Feedback> findBycreateDateAndEmail(Date createDate,
		String email, int start, int end,
		OrderByComparator<Feedback> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findBycreateDateAndEmail(createDate, email, start, end,
			orderByComparator, retrieveFromCache);
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
	public static Feedback findBycreateDateAndEmail_First(Date createDate,
		String email, OrderByComparator<Feedback> orderByComparator)
		throws it.scinti.lfr.secpg.xssinjection.exception.NoSuchFeedbackException {
		return getPersistence()
				   .findBycreateDateAndEmail_First(createDate, email,
			orderByComparator);
	}

	/**
	* Returns the first feedback in the ordered set where createDate = &#63; and email = &#63;.
	*
	* @param createDate the create date
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching feedback, or <code>null</code> if a matching feedback could not be found
	*/
	public static Feedback fetchBycreateDateAndEmail_First(Date createDate,
		String email, OrderByComparator<Feedback> orderByComparator) {
		return getPersistence()
				   .fetchBycreateDateAndEmail_First(createDate, email,
			orderByComparator);
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
	public static Feedback findBycreateDateAndEmail_Last(Date createDate,
		String email, OrderByComparator<Feedback> orderByComparator)
		throws it.scinti.lfr.secpg.xssinjection.exception.NoSuchFeedbackException {
		return getPersistence()
				   .findBycreateDateAndEmail_Last(createDate, email,
			orderByComparator);
	}

	/**
	* Returns the last feedback in the ordered set where createDate = &#63; and email = &#63;.
	*
	* @param createDate the create date
	* @param email the email
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching feedback, or <code>null</code> if a matching feedback could not be found
	*/
	public static Feedback fetchBycreateDateAndEmail_Last(Date createDate,
		String email, OrderByComparator<Feedback> orderByComparator) {
		return getPersistence()
				   .fetchBycreateDateAndEmail_Last(createDate, email,
			orderByComparator);
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
	public static Feedback[] findBycreateDateAndEmail_PrevAndNext(
		long feedbackId, Date createDate, String email,
		OrderByComparator<Feedback> orderByComparator)
		throws it.scinti.lfr.secpg.xssinjection.exception.NoSuchFeedbackException {
		return getPersistence()
				   .findBycreateDateAndEmail_PrevAndNext(feedbackId,
			createDate, email, orderByComparator);
	}

	/**
	* Removes all the feedbacks where createDate = &#63; and email = &#63; from the database.
	*
	* @param createDate the create date
	* @param email the email
	*/
	public static void removeBycreateDateAndEmail(Date createDate, String email) {
		getPersistence().removeBycreateDateAndEmail(createDate, email);
	}

	/**
	* Returns the number of feedbacks where createDate = &#63; and email = &#63;.
	*
	* @param createDate the create date
	* @param email the email
	* @return the number of matching feedbacks
	*/
	public static int countBycreateDateAndEmail(Date createDate, String email) {
		return getPersistence().countBycreateDateAndEmail(createDate, email);
	}

	/**
	* Caches the feedback in the entity cache if it is enabled.
	*
	* @param feedback the feedback
	*/
	public static void cacheResult(Feedback feedback) {
		getPersistence().cacheResult(feedback);
	}

	/**
	* Caches the feedbacks in the entity cache if it is enabled.
	*
	* @param feedbacks the feedbacks
	*/
	public static void cacheResult(List<Feedback> feedbacks) {
		getPersistence().cacheResult(feedbacks);
	}

	/**
	* Creates a new feedback with the primary key. Does not add the feedback to the database.
	*
	* @param feedbackId the primary key for the new feedback
	* @return the new feedback
	*/
	public static Feedback create(long feedbackId) {
		return getPersistence().create(feedbackId);
	}

	/**
	* Removes the feedback with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param feedbackId the primary key of the feedback
	* @return the feedback that was removed
	* @throws NoSuchFeedbackException if a feedback with the primary key could not be found
	*/
	public static Feedback remove(long feedbackId)
		throws it.scinti.lfr.secpg.xssinjection.exception.NoSuchFeedbackException {
		return getPersistence().remove(feedbackId);
	}

	public static Feedback updateImpl(Feedback feedback) {
		return getPersistence().updateImpl(feedback);
	}

	/**
	* Returns the feedback with the primary key or throws a {@link NoSuchFeedbackException} if it could not be found.
	*
	* @param feedbackId the primary key of the feedback
	* @return the feedback
	* @throws NoSuchFeedbackException if a feedback with the primary key could not be found
	*/
	public static Feedback findByPrimaryKey(long feedbackId)
		throws it.scinti.lfr.secpg.xssinjection.exception.NoSuchFeedbackException {
		return getPersistence().findByPrimaryKey(feedbackId);
	}

	/**
	* Returns the feedback with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param feedbackId the primary key of the feedback
	* @return the feedback, or <code>null</code> if a feedback with the primary key could not be found
	*/
	public static Feedback fetchByPrimaryKey(long feedbackId) {
		return getPersistence().fetchByPrimaryKey(feedbackId);
	}

	public static java.util.Map<java.io.Serializable, Feedback> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the feedbacks.
	*
	* @return the feedbacks
	*/
	public static List<Feedback> findAll() {
		return getPersistence().findAll();
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
	public static List<Feedback> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Feedback> findAll(int start, int end,
		OrderByComparator<Feedback> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<Feedback> findAll(int start, int end,
		OrderByComparator<Feedback> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the feedbacks from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of feedbacks.
	*
	* @return the number of feedbacks
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static FeedbackPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<FeedbackPersistence, FeedbackPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(FeedbackPersistence.class);

		ServiceTracker<FeedbackPersistence, FeedbackPersistence> serviceTracker = new ServiceTracker<FeedbackPersistence, FeedbackPersistence>(bundle.getBundleContext(),
				FeedbackPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}