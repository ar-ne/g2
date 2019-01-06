/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2012                    */
/* Created on:     2019/1/6 15:17:56                            */
/*==============================================================*/


if exists (select 1
            from  sysobjects
           where  id = object_id('Card')
            and   type = 'U')
   drop table Card
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Machine')
            and   type = 'U')
   drop table Machine
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Unit')
            and   type = 'U')
   drop table Unit
go

if exists (select 1
            from  sysobjects
           where  id = object_id('Users')
            and   type = 'U')
   drop table Users
go

if exists (select 1
            from  sysobjects
           where  id = object_id('charge_log')
            and   type = 'U')
   drop table charge_log
go

if exists (select 1
            from  sysobjects
           where  id = object_id('schedule')
            and   type = 'U')
   drop table schedule
go

if exists (select 1
            from  sysobjects
           where  id = object_id('stuff')
            and   type = 'U')
   drop table stuff
go

/*==============================================================*/
/* Table: Card                                                  */
/*==============================================================*/
create table Card (
   ¿¨ºÅ                   varchar(254)         not null,
   ×´Ì¬                   varchar(254)         null,
   Óà¶î                   float                null,
   constraint PK_CARD primary key (¿¨ºÅ)
)
go

/*==============================================================*/
/* Table: Machine                                               */
/*==============================================================*/
create table Machine (
   id                   varchar(254)         not null,
   did                  varchar(254)         not null,
   addr                 varchar(254)         null,
   constraint PK_MACHINE primary key (id, did)
)
go

/*==============================================================*/
/* Table: Unit                                                  */
/*==============================================================*/
create table Unit (
   id                   varchar(254)         not null,
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
   id                   varchar(254)         not null,
   name                 varchar(254)         not null,
   password             varchar(254)         not null,
   type                 varchar(254)         not null,
   cid                  varchar(254)         not null,
   constraint PK_USERS primary key (name, password, type)
)
go

/*==============================================================*/
/* Table: charge_log                                            */
/*==============================================================*/
create table charge_log (
   id                   varchar(254)         not null,
   amount               numeric              null,
   time                 datetime             null,
   uid                  varchar(254)         null,
   cid                  varchar(254)         null,
   mid                  varchar(254)         null,
   result               int                  null,
   reason               varchar(254)         null,
   constraint PK_CHARGE_LOG primary key (id)
)
go

/*==============================================================*/
/* Table: schedule                                              */
/*==============================================================*/
create table schedule (
   id                   varchar(254)         not null,
   "begin"              datetime             null,
   "end"                datetime             null,
   address              varchar(254)         null,
   constraint PK_SCHEDULE primary key (id)
)
go

/*==============================================================*/
/* Table: stuff                                                 */
/*==============================================================*/
create table stuff (
   id                   varchar(254)         not null,
   name                 varchar(254)         null,
   sid                  varchar(254)         null,
   did                  varchar(254)         null,
   constraint PK_STUFF primary key (id)
)
go

