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

package it.scinti.lfr.secpg.sqlinjection.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link VendorService}.
 *
 * @author Brian Wing Shun Chan
 * @see VendorService
 * @generated
 */
@ProviderType
public class VendorServiceWrapper implements VendorService,
	ServiceWrapper<VendorService> {
	public VendorServiceWrapper(VendorService vendorService) {
		_vendorService = vendorService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _vendorService.getOSGiServiceIdentifier();
	}

	@Override
	public VendorService getWrappedService() {
		return _vendorService;
	}

	@Override
	public void setWrappedService(VendorService vendorService) {
		_vendorService = vendorService;
	}

	private VendorService _vendorService;
}