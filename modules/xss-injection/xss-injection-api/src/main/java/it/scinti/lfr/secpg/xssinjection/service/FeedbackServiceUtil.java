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
 * Provides the remote service utility for Feedback. This utility wraps
 * {@link it.scinti.lfr.secpg.xssinjection.service.impl.FeedbackServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see FeedbackService
 * @see it.scinti.lfr.secpg.xssinjection.service.base.FeedbackServiceBaseImpl
 * @see it.scinti.lfr.secpg.xssinjection.service.impl.FeedbackServiceImpl
 * @generated
 */
@ProviderType
public class FeedbackServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link it.scinti.lfr.secpg.xssinjection.service.impl.FeedbackServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static FeedbackService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<FeedbackService, FeedbackService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(FeedbackService.class);

		ServiceTracker<FeedbackService, FeedbackService> serviceTracker = new ServiceTracker<FeedbackService, FeedbackService>(bundle.getBundleContext(),
				FeedbackService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}