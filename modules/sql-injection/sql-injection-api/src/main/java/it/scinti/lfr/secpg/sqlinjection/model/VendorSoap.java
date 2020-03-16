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

package it.scinti.lfr.secpg.sqlinjection.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link it.scinti.lfr.secpg.sqlinjection.service.http.VendorServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see it.scinti.lfr.secpg.sqlinjection.service.http.VendorServiceSoap
 * @generated
 */
@ProviderType
public class VendorSoap implements Serializable {
	public static VendorSoap toSoapModel(Vendor model) {
		VendorSoap soapModel = new VendorSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setVendorId(model.getVendorId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setHwId(model.getHwId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setWebsite(model.getWebsite());
		soapModel.setMetadata(model.getMetadata());

		return soapModel;
	}

	public static VendorSoap[] toSoapModels(Vendor[] models) {
		VendorSoap[] soapModels = new VendorSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VendorSoap[][] toSoapModels(Vendor[][] models) {
		VendorSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VendorSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VendorSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VendorSoap[] toSoapModels(List<Vendor> models) {
		List<VendorSoap> soapModels = new ArrayList<VendorSoap>(models.size());

		for (Vendor model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VendorSoap[soapModels.size()]);
	}

	public VendorSoap() {
	}

	public long getPrimaryKey() {
		return _vendorId;
	}

	public void setPrimaryKey(long pk) {
		setVendorId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getVendorId() {
		return _vendorId;
	}

	public void setVendorId(long vendorId) {
		_vendorId = vendorId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getHwId() {
		return _hwId;
	}

	public void setHwId(String hwId) {
		_hwId = hwId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getWebsite() {
		return _website;
	}

	public void setWebsite(String website) {
		_website = website;
	}

	public String getMetadata() {
		return _metadata;
	}

	public void setMetadata(String metadata) {
		_metadata = metadata;
	}

	private String _uuid;
	private long _vendorId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _hwId;
	private String _name;
	private String _description;
	private String _website;
	private String _metadata;
}