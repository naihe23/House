
drop table  if exists Admin ;

drop table  if exists House_sall ;

drop table  if exists User ;

drop table  if exists order_recode ;

drop table  if exists request_order ;

drop table  if exists staff ;

drop table  if exists work_recode ;

/*==============================================================*/
/* Table: Admin                                                 */
/*==============================================================*/
create table Admin
(
   admin_ID             integer generated by default as identity(start with 1,increment by 1)  not null,
   staff_ID             integer,
   primary key (admin_ID)
);

/*==============================================================*/
/* Table: House_sall                                            */
/*==============================================================*/
create table House_sall
(
   house_ID              integer generated by default as identity(start with 1,increment by 1)  not null,
   house_type           varchar(20),
   house_floor_num      integer,
   house_place          varchar(100),
   house_build_year     date,
   house_state          integer default 0,
   house_standard       varchar(20),
   house_price          numeric(10,0),
   house_size           integer,
   house_owner          varchar(10),
   primary key (house_ID)
);

/*==============================================================*/
/* Table: User                                                  */
/*==============================================================*/
create table User (
   user_ID               integer generated by default as identity(start with 1,increment by 1)  not null,
   user_name            varchar(20),
   user_password        numeric(16,0),
   user_sex             varchar(2),
   user_real_name       varchar(20),
   user_age             integer,
   user_balance         numeric(15),
   user_state           integer default 0,
   user_phone           numeric(11,0),
   user_IDnumber        numeric(18,0),
   primary key (user_ID)
);

/*==============================================================*/
/* Table: order_recode                                          */
/*==============================================================*/
create table order_recode
(
   order_ID              integer generated by default as identity(start with 1,increment by 1)  not null,
   house_ID             integer,
   staff_ID             integer,
   user_ID              integer,
   time                 datetime,
   primary key (order_ID)
);

/*==============================================================*/
/* Table: request_order                                         */
/*==============================================================*/
create table request_order
(
   request_ID           integer generated by default as identity(start with 1,increment by 1)  not null,
   house_ID             integer,
   user_ID              integer,
   time                 datetime,
   request_state        integer default 0,
   primary key (request_ID)
);

/*==============================================================*/
/* Table: staff                                                 */
/*==============================================================*/
create table staff
(
   staff_ID              integer generated by default as identity(start with 1,increment by 1)  not null,
   staff_name           varchar(20),
   staff_password       numeric(16,0),
   staff_sex            varchar(10),
   staff_real_name      varchar(20),
   staff_age            integer,
   staff_state          integer default 0,
   primary key (staff_ID)
);

/*==============================================================*/
/* Table: work_recode                                           */
/*==============================================================*/
create table work_recode
(
   work_ID               integer generated by default as identity(start with 1,increment by 1)  not null,
   staff_ID             integer,
   user_ID              integer,
   time                 datetime,
   primary key (work_ID)
);

alter table Admin add constraint FK_fk_admin_staff foreign key (staff_ID)
      references staff (staff_ID) on delete cascade on update restrict;

alter table order_recode add constraint FK_fk_order_house foreign key (house_ID)
      references House_sall (house_ID) on delete cascade on update restrict;

alter table order_recode add constraint FK_fk_order_staff foreign key (staff_ID)
      references staff (staff_ID) on delete cascade on update restrict;

alter table order_recode add constraint FK_fk_order_user foreign key (user_ID)
      references User (user_ID) on delete cascade on update restrict;

alter table request_order add constraint FK_fk_request_house foreign key (house_ID)
      references House_sall (house_ID) on delete cascade on update restrict;

alter table request_order add constraint FK_fk_request_user foreign key (user_ID)
      references User (user_ID) on delete cascade on update restrict;

alter table work_recode add constraint FK_fk_work_staff foreign key (staff_ID)
      references staff (staff_ID) on delete cascade on update restrict;

alter table work_recode add constraint FK_fk_work_user foreign key (user_ID)
      references User (user_ID) on delete cascade on update restrict;
