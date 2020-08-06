/* Таблица пользователей */
create table users
(
    id       bigint       not null auto_increment,
    username varchar(10) references students (username),
    password varchar(255) not null,
    role_id  bigint,
    primary key (id)
);

/* Таблица ролей */
create table roles
(
    id   bigint not null auto_increment,
    name varchar(255),
    primary key (id)
);

create table faculties
(
    id   bigint not null auto_increment,
    name varchar(255),
    primary key (id)
);

/* Таблица студентов */
create table students
(
    id         bigint       not null auto_increment,
    username   varchar(10)  not null unique,
    first_name varchar(255) not null,
    last_name  varchar(255) not null,
    birth_date date,
    ent_ball   tinyint,
    email      varchar(255) not null,
    faculty_id bigint,
    primary key (id)
);