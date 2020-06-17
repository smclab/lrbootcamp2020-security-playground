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

package it.scinti.lfr.secpg.xssinjection.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Feedback. This utility wraps
 * {@link it.scinti.lfr.secpg.xssinjection.service.impl.FeedbackLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see FeedbackLocalService
 * @see it.scinti.lfr.secpg.xssinjection.service.base.FeedbackLocalServiceBaseImpl
 * @see it.scinti.lfr.secpg.xssinjection.service.impl.FeedbackLocalServiceImpl
 * @generated
 */
@ProviderType
public class FeedbackLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.scinti.lfr.secpg.xssinjection.service.impl.FeedbackLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the feedback to the database. Also notifies the appropriate model listeners.
	*
	* @param feedback the feedback
	* @return the feedback that was added
	*/
	public static it.scinti.lfr.secpg.xssinjection.model.Feedback addFeedback(
		it.scinti.lfr.secpg.xssinjection.model.Feedback feedback) {
		return getService().addFeedback(feedback);
	}

	/**
	* Creates a new feedback with the primary key. Does not add the feedback to the database.
	*
	* @param feedbackId the primary key for the new feedback
	* @return the new feedback
	*/
	public static it.scinti.lfr.secpg.xssinjection.model.Feedback createFeedback(
		long feedbackId) {
		return getService().createFeedback(feedbackId);
	}

	/**
	* Deletes the feedback from the database. Also notifies the appropriate model listeners.
	*
	* @param feedback the feedback
	* @return the feedback that was removed
	*/
	public static it.scinti.lfr.secpg.xssinjection.model.Feedback deleteFeedback(
		it.scinti.lfr.secpg.xssinjection.model.Feedback feedback) {
		return getService().deleteFeedback(feedback);
	}

	/**
	* Deletes the feedback with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param feedbackId the primary key of the feedback
	* @return the feedback that was removed
	* @throws PortalException if a feedback with the primary key could not be found
	*/
	public static it.scinti.lfr.secpg.xssinjection.model.Feedback deleteFeedback(
		long feedbackId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteFeedback(feedbackId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.scinti.lfr.secpg.xssinjection.model.impl.FeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.scinti.lfr.secpg.xssinjection.model.impl.FeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static it.scinti.lfr.secpg.xssinjection.model.Feedback fetchFeedback(
		long feedbackId) {
		return getService().fetchFeedback(feedbackId);
	}

	/**
	* Returns the feedback matching the UUID and group.
	*
	* @param uuid the feedback's UUID
	* @param groupId the primary key of the group
	* @return the matching feedback, or <code>null</code> if a matching feedback could not be found
	*/
	public static it.scinti.lfr.secpg.xssinjection.model.Feedback fetchFeedbackByUuidAndGroupId(
		String uuid, long groupId) {
		return getService().fetchFeedbackByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	/**
	* Returns the feedback with the primary key.
	*
	* @param feedbackId the primary key of the feedback
	* @return the feedback
	* @throws PortalException if a feedback with the primary key could not be found
	*/
	public static it.scinti.lfr.secpg.xssinjection.model.Feedback getFeedback(
		long feedbackId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getFeedback(feedbackId);
	}

	/**
	* Returns the feedback matching the UUID and group.
	*
	* @param uuid the feedback's UUID
	* @param groupId the primary key of the group
	* @return the matching feedback
	* @throws PortalException if a matching feedback could not be found
	*/
	public static it.scinti.lfr.secpg.xssinjection.model.Feedback getFeedbackByUuidAndGroupId(
		String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getFeedbackByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the feedbacks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link it.scinti.lfr.secpg.xssinjection.model.impl.FeedbackModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of feedbacks
	* @param end the upper bound of the range of feedbacks (not inclusive)
	* @return the range of feedbacks
	*/
	public static java.util.List<it.scinti.lfr.secpg.xssinjection.model.Feedback> getFeedbacks(
		int start, int end) {
		return getService().getFeedbacks(start, end);
	}

	/**
	* Returns all the feedbacks matching the UUID and company.
	*
	* @param uuid the UUID of the feedbacks
	* @param companyId the primary key of the company
	* @return the matching feedbacks, or an empty list if no matches were found
	*/
	public static java.util.List<it.scinti.lfr.secpg.xssinjection.model.Feedback> getFeedbacksByUuidAndCompanyId(
		String uuid, long companyId) {
		return getService().getFeedbacksByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of feedbacks matching the UUID and company.
	*
	* @param uuid the UUID of the feedbacks
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of feedbacks
	* @param end the upper bound of the range of feedbacks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching feedbacks, or an empty list if no matches were found
	*/
	public static java.util.List<it.scinti.lfr.secpg.xssinjection.model.Feedback> getFeedbacksByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<it.scinti.lfr.secpg.xssinjection.model.Feedback> orderByComparator) {
		return getService()
				   .getFeedbacksByUuidAndCompanyId(uuid, companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of feedbacks.
	*
	* @return the number of feedbacks
	*/
	public static int getFeedbacksCount() {
		return getService().getFeedbacksCount();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the feedback in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param feedback the feedback
	* @return the feedback that was updated
	*/
	public static it.scinti.lfr.secpg.xssinjection.model.Feedback updateFeedback(
		it.scinti.lfr.secpg.xssinjection.model.Feedback feedback) {
		return getService().updateFeedback(feedback);
	}

	public static FeedbackLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<FeedbackLocalService, FeedbackLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(FeedbackLocalService.class);

		ServiceTracker<FeedbackLocalService, FeedbackLocalService> serviceTracker =
			new ServiceTracker<FeedbackLocalService, FeedbackLocalService>(bundle.getBundleContext(),
				FeedbackLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}