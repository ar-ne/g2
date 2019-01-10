/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2012                    */
/* Created on:     2019/1/10 14:32:36                           */
/*==============================================================*/


if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Card') and o.name = 'FK_CARD_REFERENCE_USERTYPE')
alter table Card
   drop constraint FK_CARD_REFERENCE_USERTYPE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Machine') and o.name = 'FK_MACHINE_REFERENCE_UNIT')
alter table Machine
   drop constraint FK_MACHINE_REFERENCE_UNIT
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('Users') and o.name = 'FK_USERS_REFERENCE_CARD')
alter table Users
   drop constraint FK_USERS_REFERENCE_CARD
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('chargelog') and o.name = 'FK_CHARGELO_REFERENCE_CARD')
alter table chargelog
   drop constraint FK_CHARGELO_REFERENCE_CARD
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('chargelog') and o.name = 'FK_CHARGELO_REFERENCE_MACHINE')
alter table chargelog
   drop constraint FK_CHARGELO_REFERENCE_MACHINE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('chargelog') and o.name = 'FK_CHARGELO_REFERENCE_USERS')
alter table chargelog
   drop constraint FK_CHARGELO_REFERENCE_USERS
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('consumelog') and o.name = 'FK_CONSUMEL_REFERENCE_MACHINE')
alter table consumelog
   drop constraint FK_CONSUMEL_REFERENCE_MACHINE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('consumelog') and o.name = 'FK_CONSUMEL_REFERENCE_CARD')
alter table consumelog
   drop constraint FK_CONSUMEL_REFERENCE_CARD
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('consumelog') and o.name = 'FK_CONSUMEL_REFERENCE_USERS')
alter table consumelog
   drop constraint FK_CONSUMEL_REFERENCE_USERS
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('stuff') and o.name = 'FK_STUFF_REFERENCE_UNIT')
alter table stuff
   drop constraint FK_STUFF_REFERENCE_UNIT
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('stuff') and o.name = 'FK_STUFF_REFERENCE_SCHEDULE')
alter table stuff
   drop constraint FK_STUFF_REFERENCE_SCHEDULE
go

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
           where  id = object_id('chargelog')
            and   type = 'U')
   drop table chargelog
go

if exists (select 1
            from  sysobjects
           where  id = object_id('consumelog')
            and   type = 'U')
   drop table consumelog
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

if exists (select 1
            from  sysobjects
           where  id = object_id('usertype')
            and   type = 'U')
   drop table usertype
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
   id                   numeric              not null,
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

