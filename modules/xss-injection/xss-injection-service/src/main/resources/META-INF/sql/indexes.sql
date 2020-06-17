create index IX_14C09DD6 on xssj_Feedback (createDate, email[$COLUMN_LENGTH:75$]);
create index IX_DE9F4E34 on xssj_Feedback (description[$COLUMN_LENGTH:65536$]);
create index IX_E4B1AA54 on xssj_Feedback (email[$COLUMN_LENGTH:75$]);
create index IX_7D9ED8ED on xssj_Feedback (lastName[$COLUMN_LENGTH:75$]);
create index IX_EFB40DEC on xssj_Feedback (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_4C7F1F6E on xssj_Feedback (uuid_[$COLUMN_LENGTH:75$], groupId);