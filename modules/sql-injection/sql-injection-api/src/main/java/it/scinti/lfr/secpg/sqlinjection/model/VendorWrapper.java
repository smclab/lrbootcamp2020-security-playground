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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Vendor}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Vendor
 * @generated
 */
public class VendorWrapper implements ModelWrapper<Vendor>, Vendor {

	public VendorWrapper(Vendor vendor) {
		_vendor = vendor;
	}

	@Override
	public Class<?> getModelClass() {
		return Vendor.class;
	}

	@Override
	public String getModelClassName() {
		return Vendor.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("vendorId", getVendorId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("hwId", getHwId());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("website", getWebsite());
		attributes.put("metadata", getMetadata());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long vendorId = (Long)attributes.get("vendorId");

		if (vendorId != null) {
			setVendorId(vendorId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String hwId = (String)attributes.get("hwId");

		if (hwId != null) {
			setHwId(hwId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String website = (String)attributes.get("website");

		if (website != null) {
			setWebsite(website);
		}

		String metadata = (String)attributes.get("metadata");

		if (metadata != null) {
			setMetadata(metadata);
		}
	}

	@Override
	public Object clone() {
		return new VendorWrapper((Vendor)_vendor.clone());
	}

	@Override
	public int compareTo(it.scinti.lfr.secpg.sqlinjection.model.Vendor vendor) {
		return _vendor.compareTo(vendor);
	}

	/**
	 * Returns the company ID of this vendor.
	 *
	 * @return the company ID of this vendor
	 */
	@Override
	public long getCompanyId() {
		return _vendor.getCompanyId();
	}

	/**
	 * Returns the create date of this vendor.
	 *
	 * @return the create date of this vendor
	 */
	@Override
	public Date getCreateDate() {
		return _vendor.getCreateDate();
	}

	/**
	 * Returns the description of this vendor.
	 *
	 * @return the description of this vendor
	 */
	@Override
	public String getDescription() {
		return _vendor.getDescription();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _vendor.getExpandoBridge();
	}

	/**
	 * Returns the group ID of this vendor.
	 *
	 * @return the group ID of this vendor
	 */
	@Override
	public long getGroupId() {
		return _vendor.getGroupId();
	}

	/**
	 * Returns the hw ID of this vendor.
	 *
	 * @return the hw ID of this vendor
	 */
	@Override
	public String getHwId() {
		return _vendor.getHwId();
	}

	/**
	 * Returns the metadata of this vendor.
	 *
	 * @return the metadata of this vendor
	 */
	@Override
	public String getMetadata() {
		return _vendor.getMetadata();
	}

	/**
	 * Returns the modified date of this vendor.
	 *
	 * @return the modified date of this vendor
	 */
	@Override
	public Date getModifiedDate() {
		return _vendor.getModifiedDate();
	}

	/**
	 * Returns the name of this vendor.
	 *
	 * @return the name of this vendor
	 */
	@Override
	public String getName() {
		return _vendor.getName();
	}

	/**
	 * Returns the primary key of this vendor.
	 *
	 * @return the primary key of this vendor
	 */
	@Override
	public long getPrimaryKey() {
		return _vendor.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _vendor.getPrimaryKeyObj();
	}

	/**
	 * Returns the user ID of this vendor.
	 *
	 * @return the user ID of this vendor
	 */
	@Override
	public long getUserId() {
		return _vendor.getUserId();
	}

	/**
	 * Returns the user name of this vendor.
	 *
	 * @return the user name of this vendor
	 */
	@Override
	public String getUserName() {
		return _vendor.getUserName();
	}

	/**
	 * Returns the user uuid of this vendor.
	 *
	 * @return the user uuid of this vendor
	 */
	@Override
	public String getUserUuid() {
		return _vendor.getUserUuid();
	}

	/**
	 * Returns the uuid of this vendor.
	 *
	 * @return the uuid of this vendor
	 */
	@Override
	public String getUuid() {
		return _vendor.getUuid();
	}

	/**
	 * Returns the vendor ID of this vendor.
	 *
	 * @return the vendor ID of this vendor
	 */
	@Override
	public long getVendorId() {
		return _vendor.getVendorId();
	}

	/**
	 * Returns the website of this vendor.
	 *
	 * @return the website of this vendor
	 */
	@Override
	public String getWebsite() {
		return _vendor.getWebsite();
	}

	@Override
	public int hashCode() {
		return _vendor.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _vendor.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _vendor.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _vendor.isNew();
	}

	@Override
	public void persist() {
		_vendor.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_vendor.setCachedModel(cachedModel);
	}

	/**
	 * Sets the company ID of this vendor.
	 *
	 * @param companyId the company ID of this vendor
	 */
	@Override
	public void setCompanyId(long companyId) {
		_vendor.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this vendor.
	 *
	 * @param createDate the create date of this vendor
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_vendor.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this vendor.
	 *
	 * @param description the description of this vendor
	 */
	@Override
	public void setDescription(String description) {
		_vendor.setDescription(description);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_vendor.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_vendor.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_vendor.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the group ID of this vendor.
	 *
	 * @param groupId the group ID of this vendor
	 */
	@Override
	public void setGroupId(long groupId) {
		_vendor.setGroupId(groupId);
	}

	/**
	 * Sets the hw ID of this vendor.
	 *
	 * @param hwId the hw ID of this vendor
	 */
	@Override
	public void setHwId(String hwId) {
		_vendor.setHwId(hwId);
	}

	/**
	 * Sets the metadata of this vendor.
	 *
	 * @param metadata the metadata of this vendor
	 */
	@Override
	public void setMetadata(String metadata) {
		_vendor.setMetadata(metadata);
	}

	/**
	 * Sets the modified date of this vendor.
	 *
	 * @param modifiedDate the modified date of this vendor
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_vendor.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this vendor.
	 *
	 * @param name the name of this vendor
	 */
	@Override
	public void setName(String name) {
		_vendor.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_vendor.setNew(n);
	}

	/**
	 * Sets the primary key of this vendor.
	 *
	 * @param primaryKey the primary key of this vendor
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_vendor.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_vendor.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the user ID of this vendor.
	 *
	 * @param userId the user ID of this vendor
	 */
	@Override
	public void setUserId(long userId) {
		_vendor.setUserId(userId);
	}

	/**
	 * Sets the user name of this vendor.
	 *
	 * @param userName the user name of this vendor
	 */
	@Override
	public void setUserName(String userName) {
		_vendor.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this vendor.
	 *
	 * @param userUuid the user uuid of this vendor
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_vendor.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this vendor.
	 *
	 * @param uuid the uuid of this vendor
	 */
	@Override
	public void setUuid(String uuid) {
		_vendor.setUuid(uuid);
	}

	/**
	 * Sets the vendor ID of this vendor.
	 *
	 * @param vendorId the vendor ID of this vendor
	 */
	@Override
	public void setVendorId(long vendorId) {
		_vendor.setVendorId(vendorId);
	}

	/**
	 * Sets the website of this vendor.
	 *
	 * @param website the website of this vendor
	 */
	@Override
	public void setWebsite(String website) {
		_vendor.setWebsite(website);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<it.scinti.lfr.secpg.sqlinjection.model.Vendor> toCacheModel() {

		return _vendor.toCacheModel();
	}

	@Override
	public it.scinti.lfr.secpg.sqlinjection.model.Vendor toEscapedModel() {
		return new VendorWrapper(_vendor.toEscapedModel());
	}

	@Override
	public String toString() {
		return _vendor.toString();
	}

	@Override
	public it.scinti.lfr.secpg.sqlinjection.model.Vendor toUnescapedModel() {
		return new VendorWrapper(_vendor.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _vendor.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VendorWrapper)) {
			return false;
		}

		VendorWrapper vendorWrapper = (VendorWrapper)obj;

		if (Objects.equals(_vendor, vendorWrapper._vendor)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _vendor.getStagedModelType();
	}

	@Override
	public Vendor getWrappedModel() {
		return _vendor;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _vendor.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _vendor.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_vendor.resetOriginalValues();
	}

	private final Vendor _vendor;

}