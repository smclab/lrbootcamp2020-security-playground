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

package it.scinti.lfr.secpg.xssinjection.model;

import aQute.bnd.annotation.ProviderType;

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
 * This class is a wrapper for {@link Feedback}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Feedback
 * @generated
 */
@ProviderType
public class FeedbackWrapper implements Feedback, ModelWrapper<Feedback> {
	public FeedbackWrapper(Feedback feedback) {
		_feedback = feedback;
	}

	@Override
	public Class<?> getModelClass() {
		return Feedback.class;
	}

	@Override
	public String getModelClassName() {
		return Feedback.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("feedbackId", getFeedbackId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("email", getEmail());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long feedbackId = (Long)attributes.get("feedbackId");

		if (feedbackId != null) {
			setFeedbackId(feedbackId);
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

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	@Override
	public Object clone() {
		return new FeedbackWrapper((Feedback)_feedback.clone());
	}

	@Override
	public int compareTo(Feedback feedback) {
		return _feedback.compareTo(feedback);
	}

	/**
	* Returns the company ID of this feedback.
	*
	* @return the company ID of this feedback
	*/
	@Override
	public long getCompanyId() {
		return _feedback.getCompanyId();
	}

	/**
	* Returns the create date of this feedback.
	*
	* @return the create date of this feedback
	*/
	@Override
	public Date getCreateDate() {
		return _feedback.getCreateDate();
	}

	/**
	* Returns the description of this feedback.
	*
	* @return the description of this feedback
	*/
	@Override
	public String getDescription() {
		return _feedback.getDescription();
	}

	/**
	* Returns the email of this feedback.
	*
	* @return the email of this feedback
	*/
	@Override
	public String getEmail() {
		return _feedback.getEmail();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _feedback.getExpandoBridge();
	}

	/**
	* Returns the feedback ID of this feedback.
	*
	* @return the feedback ID of this feedback
	*/
	@Override
	public long getFeedbackId() {
		return _feedback.getFeedbackId();
	}

	/**
	* Returns the first name of this feedback.
	*
	* @return the first name of this feedback
	*/
	@Override
	public String getFirstName() {
		return _feedback.getFirstName();
	}

	/**
	* Returns the group ID of this feedback.
	*
	* @return the group ID of this feedback
	*/
	@Override
	public long getGroupId() {
		return _feedback.getGroupId();
	}

	/**
	* Returns the last name of this feedback.
	*
	* @return the last name of this feedback
	*/
	@Override
	public String getLastName() {
		return _feedback.getLastName();
	}

	/**
	* Returns the modified date of this feedback.
	*
	* @return the modified date of this feedback
	*/
	@Override
	public Date getModifiedDate() {
		return _feedback.getModifiedDate();
	}

	/**
	* Returns the primary key of this feedback.
	*
	* @return the primary key of this feedback
	*/
	@Override
	public long getPrimaryKey() {
		return _feedback.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _feedback.getPrimaryKeyObj();
	}

	/**
	* Returns the user ID of this feedback.
	*
	* @return the user ID of this feedback
	*/
	@Override
	public long getUserId() {
		return _feedback.getUserId();
	}

	/**
	* Returns the user name of this feedback.
	*
	* @return the user name of this feedback
	*/
	@Override
	public String getUserName() {
		return _feedback.getUserName();
	}

	/**
	* Returns the user uuid of this feedback.
	*
	* @return the user uuid of this feedback
	*/
	@Override
	public String getUserUuid() {
		return _feedback.getUserUuid();
	}

	/**
	* Returns the uuid of this feedback.
	*
	* @return the uuid of this feedback
	*/
	@Override
	public String getUuid() {
		return _feedback.getUuid();
	}

	@Override
	public int hashCode() {
		return _feedback.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _feedback.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _feedback.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _feedback.isNew();
	}

	@Override
	public void persist() {
		_feedback.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_feedback.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this feedback.
	*
	* @param companyId the company ID of this feedback
	*/
	@Override
	public void setCompanyId(long companyId) {
		_feedback.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this feedback.
	*
	* @param createDate the create date of this feedback
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_feedback.setCreateDate(createDate);
	}

	/**
	* Sets the description of this feedback.
	*
	* @param description the description of this feedback
	*/
	@Override
	public void setDescription(String description) {
		_feedback.setDescription(description);
	}

	/**
	* Sets the email of this feedback.
	*
	* @param email the email of this feedback
	*/
	@Override
	public void setEmail(String email) {
		_feedback.setEmail(email);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_feedback.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_feedback.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_feedback.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the feedback ID of this feedback.
	*
	* @param feedbackId the feedback ID of this feedback
	*/
	@Override
	public void setFeedbackId(long feedbackId) {
		_feedback.setFeedbackId(feedbackId);
	}

	/**
	* Sets the first name of this feedback.
	*
	* @param firstName the first name of this feedback
	*/
	@Override
	public void setFirstName(String firstName) {
		_feedback.setFirstName(firstName);
	}

	/**
	* Sets the group ID of this feedback.
	*
	* @param groupId the group ID of this feedback
	*/
	@Override
	public void setGroupId(long groupId) {
		_feedback.setGroupId(groupId);
	}

	/**
	* Sets the last name of this feedback.
	*
	* @param lastName the last name of this feedback
	*/
	@Override
	public void setLastName(String lastName) {
		_feedback.setLastName(lastName);
	}

	/**
	* Sets the modified date of this feedback.
	*
	* @param modifiedDate the modified date of this feedback
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_feedback.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_feedback.setNew(n);
	}

	/**
	* Sets the primary key of this feedback.
	*
	* @param primaryKey the primary key of this feedback
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_feedback.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_feedback.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this feedback.
	*
	* @param userId the user ID of this feedback
	*/
	@Override
	public void setUserId(long userId) {
		_feedback.setUserId(userId);
	}

	/**
	* Sets the user name of this feedback.
	*
	* @param userName the user name of this feedback
	*/
	@Override
	public void setUserName(String userName) {
		_feedback.setUserName(userName);
	}

	/**
	* Sets the user uuid of this feedback.
	*
	* @param userUuid the user uuid of this feedback
	*/
	@Override
	public void setUserUuid(String userUuid) {
		_feedback.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this feedback.
	*
	* @param uuid the uuid of this feedback
	*/
	@Override
	public void setUuid(String uuid) {
		_feedback.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Feedback> toCacheModel() {
		return _feedback.toCacheModel();
	}

	@Override
	public Feedback toEscapedModel() {
		return new FeedbackWrapper(_feedback.toEscapedModel());
	}

	@Override
	public String toString() {
		return _feedback.toString();
	}

	@Override
	public Feedback toUnescapedModel() {
		return new FeedbackWrapper(_feedback.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _feedback.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FeedbackWrapper)) {
			return false;
		}

		FeedbackWrapper feedbackWrapper = (FeedbackWrapper)obj;

		if (Objects.equals(_feedback, feedbackWrapper._feedback)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _feedback.getStagedModelType();
	}

	@Override
	public Feedback getWrappedModel() {
		return _feedback;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _feedback.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _feedback.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_feedback.resetOriginalValues();
	}

	private final Feedback _feedback;
}