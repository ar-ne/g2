/*==============================================================*/
/* Database name:  t6                                           */
/* DBMS name:      Microsoft SQL Server 2012                    */
/* Created on:     2019/1/12 16:47:17                           */
/*==============================================================*/


drop database t6
go

/*==============================================================*/
/* Database: t6                                                 */
/*==============================================================*/
create database t6
go

use t6
go

/*==============================================================*/
/* Table: Card                                                  */
/*==============================================================*/
create table Card (
   id                   numeric              identity,
   type                 varchar(254)         null,
   state                varchar(254)         null,
   amount               float                null,
   limit                float                null,
   constraint PK_CARD primary key (id)
)
go

/*==============================================================*/
/* Table: Machine                                               */
/*==============================================================*/
create table Machine (
   id                   numeric              identity,
   Uni_id               numeric              null,
   addr                 varchar(254)         null,
   constraint PK_MACHINE primary key (id)
)
go

/*==============================================================*/
/* Table: Unit                                                  */
/*==============================================================*/
create table Unit (
   id                   numeric              identity,
   type                 varchar(254)         null,
   account              varchar(254)         null,
   password             varchar(254)         null,
   pnum                 varchar(254)         null,
   constraint PK_UNIT primary key (id)
)
go

/*==============================================================*/
/* Table: Users                                                 */
/*==============================================================*/
create table Users (
   Car_id               numeric              null,
   name                 varchar(254)         not null,
   password             varchar(254)         not null,
   type                 int                  not null,
   constraint PK_USERS primary key (name)
)
go

/*==============================================================*/
/* Table: chargelog                                             */
/*==============================================================*/
create table chargelog (
   id                   numeric              identity,
   Car_id               numeric              null,
   Mac_id               numeric              null,
   name                 varchar(254)         null,
   amount               float                null,
   time                 datetime             null,
   result               int                  null,
   reason               varchar(254)         null,
   constraint PK_CHARGELOG primary key (id)
)
go

/*==============================================================*/
/* Table: consumelog                                            */
/*==============================================================*/
create table consumelog (
   id                   numeric              identity,
   Car_id               numeric              null,
   name                 varchar(254)         null,
   Mac_id               numeric              null,
   amount               float                null,
   time                 datetime             null,
   result               int                  null,
   reason               varchar(254)         null,
   constraint PK_CONSUMELOG primary key (id)
)
go

/*==============================================================*/
/* Table: schedule                                              */
/*==============================================================*/
create table schedule (
   id                   numeric              identity,
   start                datetime             null,
   stop                 datetime             null,
   address              varchar(254)         null,
   constraint PK_SCHEDULE primary key (id)
)
go

/*==============================================================*/
/* Table: stuff                                                 */
/*==============================================================*/
create table stuff (
   id                   numeric              identity,
   Uni_id               numeric              null,
   sch_id               numeric              null,
   name                 varchar(254)         null,
   constraint PK_STUFF primary key (id)
)
go

/*==============================================================*/
/* Table: usertype                                              */
/*==============================================================*/
create table usertype (
   type                 varchar(254)         not null,
   constraint PK_USERTYPE primary key (type)
)
go

alter table Card
   add constraint FK_CARD_REFERENCE_USERTYPE foreign key (type)
      references usertype (type)
go

alter table Machine
   add constraint FK_MACHINE_REFERENCE_UNIT foreign key (Uni_id)
      references Unit (id)
go

alter table Users
   add constraint FK_USERS_REFERENCE_CARD foreign key (Car_id)
      references Card (id)
go

alter table chargelog
   add constraint FK_CHARGELO_REFERENCE_CARD foreign key (Car_id)
      references Card (id)
go

alter table chargelog
   add constraint FK_CHARGELO_REFERENCE_MACHINE foreign key (Mac_id)
      references Machine (id)
go

alter table chargelog
   add constraint FK_CHARGELO_REFERENCE_USERS foreign key (name)
      references Users (name)
go

alter table consumelog
   add constraint FK_CONSUMEL_REFERENCE_MACHINE foreign key (Mac_id)
      references Machine (id)
go

alter table consumelog
   add constraint FK_CONSUMEL_REFERENCE_CARD foreign key (Car_id)
      references Card (id)
go

alter table consumelog
   add constraint FK_CONSUMEL_REFERENCE_USERS foreign key (name)
      references Users (name)
go

alter table stuff
   add constraint FK_STUFF_REFERENCE_UNIT foreign key (Uni_id)
      references Unit (id)
go

alter table stuff
   add constraint FK_STUFF_REFERENCE_SCHEDULE foreign key (sch_id)
      references schedule (id)
go

