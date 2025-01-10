create user SPARK_TEST;
grant dba to SPARK_TEST;

create table SPARK_TEST.LTEST1(
    ID int primary key,
    COL varchar(10)
);
insert into SPARK_TEST.LTEST1 values (1, '梁嘉成');
insert into SPARK_TEST.LTEST1 values (2, '杨德柳');
commit;