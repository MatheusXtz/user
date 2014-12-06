# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table user (
  id_user                   bigint not null,
  nome                      varchar(255),
  constraint pk_user primary key (id_user))
;

create sequence user_seq;




# --- !Downs

drop table if exists user cascade;

drop sequence if exists user_seq;

