/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2015/7/25 15:31:07                           */
/*==============================================================*/


drop table if exists tb_lx;

drop table if exists tb_manager;

drop table if exists tb_order;

drop table if exists tb_pl;

drop table if exists tb_sc;

drop table if exists tb_sp;

drop table if exists tb_user;

/*==============================================================*/
/* Table: tb_lx           商品类型表                                      */
/*==============================================================*/
create table tb_lx
(
   lx_id                varchar(20) not null,
   lx_name              varchar(20),
   primary key (lx_id)
);

/*==============================================================*/
/* Table: tb_manager           管理员信息表                                 */
/*==============================================================*/
create table tb_manager
(
   manager_id           varchar(20) not null,
   manager_name         varchar(20),
   manager_password     varchar(20),
   manager_sex          char(4),
   manager_phone        varchar(20),
   manager_email        varchar(30),
   manager_address      varchar(30),
   primary key (manager_id)
);

/*==============================================================*/
/* Table: tb_order                订单表                              */
/*==============================================================*/
create table tb_order
(
   order_id             varchar(20) not null,
   sp_detail            varchar(50),
   order_sl             int(4),
   order_address        varchar(50),
   order_state          varchar(20),
   user_id              varchar(20),
   primary key (order_id)
);

/*==============================================================*/
/* Table: tb_pl                      评论表                         */
/*==============================================================*/
create table tb_pl
(
   pl_id                int(4) not null,
   pl_date              date,
   pl_nr                varchar(100),
   sp_id                varchar(20),
   user_id              varchar(20),
   pl_hf                varchar(100),
   primary key (pl_id)
);

/*==============================================================*/
/* Table: tb_sc                        收藏表                         */
/*==============================================================*/
create table tb_sc
(
   user_id              varchar(20) not null,
   sp_id                varchar(20) not null,
   primary key (user_id, sp_id)
);

/*==============================================================*/
/* Table: tb_sp                          商品表                       */
/*==============================================================*/
create table tb_sp
(
   sp_id                varchar(20) not null,
   sp_nname             varchar(30),
   sp_pp                varchar(30),
   sp_cs                varchar(40),
   sp_scj               int(4),
   sp_yhj               int(4),
   sp_xq                varchar(100),
   sp_mcj               int(4),
   sp_pic               varchar(20),
   sp_kc                int(4),
   sp_osl               int(4),
   sp_state             varchar(20),
   sp_odate             date,
   sp_ps                varchar(20),
   lx_id                varchar(20),
   primary key (sp_id)
);

/*==============================================================*/
/* Table: tb_user                        会员表                       */
/*==============================================================*/
create table tb_user
(
   user_id              varchar(20) not null,
   pl_id                int(4),
   user_name            varchar(20),
   user_password        char(4),
   user_phone           varchar(20),
   user_sex             varchar(20),
   user_email           varchar(30),
   user_age             varchar(20),
   user_loc             varchar(30),
   user_fen             int(4),
   primary key (user_id)
);

alter table tb_order add constraint FK_user_id foreign key (user_id)
      references tb_user (user_id) on delete restrict on update restrict;

alter table tb_pl add constraint FK_sp_id foreign key (sp_id)
      references tb_sp (sp_id) on delete restrict on update restrict;

alter table tb_pl add constraint FK_user_id foreign key (user_id)
      references tb_user (user_id) on delete restrict on update restrict;

alter table tb_sc add constraint FK_sp_id foreign key (sp_id)
      references tb_sp (sp_id) on delete restrict on update restrict;

alter table tb_sc add constraint FK_user_id foreign key (user_id)
      references tb_user (user_id) on delete restrict on update restrict;

alter table tb_sp add constraint FK_lx_id foreign key (lx_id)
      references tb_lx (lx_id) on delete restrict on update restrict;

alter table tb_user add constraint FK_pl_id foreign key (pl_id)
      references tb_pl (pl_id) on delete restrict on update restrict;

