create index IX_FDC8051B on sqlj_Vendor (description[$COLUMN_LENGTH:75$]);
create index IX_4AE0CEEF on sqlj_Vendor (hwId[$COLUMN_LENGTH:75$]);
create index IX_D2AC94D4 on sqlj_Vendor (metadata[$COLUMN_LENGTH:75$]);
create index IX_D4F8AFDF on sqlj_Vendor (name[$COLUMN_LENGTH:75$], description[$COLUMN_LENGTH:75$], metadata[$COLUMN_LENGTH:75$]);
create index IX_25BC8F65 on sqlj_Vendor (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_4F7BAB27 on sqlj_Vendor (uuid_[$COLUMN_LENGTH:75$], groupId);
create index IX_5114347A on sqlj_Vendor (website[$COLUMN_LENGTH:75$]);