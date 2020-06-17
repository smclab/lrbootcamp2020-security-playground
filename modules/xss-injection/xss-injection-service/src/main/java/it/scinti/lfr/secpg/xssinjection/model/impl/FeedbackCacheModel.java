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

package it.scinti.lfr.secpg.xssinjection.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import it.scinti.lfr.secpg.xssinjection.model.Feedback;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Feedback in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Feedback
 * @generated
 */
@ProviderType
public class FeedbackCacheModel implements CacheModel<Feedback>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FeedbackCacheModel)) {
			return false;
		}

		FeedbackCacheModel feedbackCacheModel = (FeedbackCacheModel)obj;

		if (feedbackId == feedbackCacheModel.feedbackId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, feedbackId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", feedbackId=");
		sb.append(feedbackId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", email=");
		sb.append(email);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Feedback toEntityModel() {
		FeedbackImpl feedbackImpl = new FeedbackImpl();

		if (uuid == null) {
			feedbackImpl.setUuid("");
		}
		else {
			feedbackImpl.setUuid(uuid);
		}

		feedbackImpl.setFeedbackId(feedbackId);
		feedbackImpl.setGroupId(groupId);
		feedbackImpl.setCompanyId(companyId);
		feedbackImpl.setUserId(userId);

		if (userName == null) {
			feedbackImpl.setUserName("");
		}
		else {
			feedbackImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			feedbackImpl.setCreateDate(null);
		}
		else {
			feedbackImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			feedbackImpl.setModifiedDate(null);
		}
		else {
			feedbackImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (firstName == null) {
			feedbackImpl.setFirstName("");
		}
		else {
			feedbackImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			feedbackImpl.setLastName("");
		}
		else {
			feedbackImpl.setLastName(lastName);
		}

		if (email == null) {
			feedbackImpl.setEmail("");
		}
		else {
			feedbackImpl.setEmail(email);
		}

		if (description == null) {
			feedbackImpl.setDescription("");
		}
		else {
			feedbackImpl.setDescription(description);
		}

		feedbackImpl.resetOriginalValues();

		return feedbackImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		feedbackId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		email = objectInput.readUTF();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(feedbackId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (firstName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (lastName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public String uuid;
	public long feedbackId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String firstName;
	public String lastName;
	public String email;
	public String description;
}