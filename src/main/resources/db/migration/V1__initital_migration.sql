create table users
(
    id       bigint auto_increment
        primary key,
    nme      varchar(225) not null,
    email    varchar(255) not null,
    password int          null comment 'varchar(255)'
);

create table adresses
(
    id      bigint auto_increment
        primary key,
    street  varchar(255) not null,
    city    varchar(255) not null,
    zip     varchar(255) not null,
    user_id bigint       not null,
    constraint adresses_users_id_fk
        foreign key (user_id) references users (id)
);

