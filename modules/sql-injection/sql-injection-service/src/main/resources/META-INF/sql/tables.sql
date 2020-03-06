create table sqlj_Vendor (
	uuid_ VARCHAR(75) null,
	vendorId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	hwId VARCHAR(75) null,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	website VARCHAR(75) null,
	metadata VARCHAR(75) null
);