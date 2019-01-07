/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2012                    */
/* Created on:     2019/1/7 11:34:54                            */
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
   id                   numeric              identity,
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
   did                  numeric              not null,
   addr                 varchar(254)         null,
   constraint PK_MACHINE primary key (id, did)
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
   id                   numeric              identity,
   name                 varchar(254)         not null,
   password             varchar(254)         not null,
   type                 varchar(254)         not null,
   cid                  numeric              not null,
   constraint PK_USERS primary key (name, password, type)
)
go

/*==============================================================*/
/* Table: charge_log                                            */
/*==============================================================*/
create table charge_log (
   id                   numeric              identity,
   amount               float                null,
   time                 datetime             null,
   uid                  numeric              null,
   cid                  numeric              null,
   mid                  numeric              null,
   result               int                  null,
   reason               varchar(254)         null,
   constraint PK_CHARGE_LOG primary key (id)
)
go

/*==============================================================*/
/* Table: schedule                                              */
/*==============================================================*/
create table schedule (
   id                   numeric              identity,
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
   id                   numeric              identity,
   name                 varchar(254)         null,
   sid                  varchar(254)         null,
   did                  varchar(254)         null,
   constraint PK_STUFF primary key (id)
)
go

