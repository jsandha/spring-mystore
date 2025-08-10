alter table adresses
drop foreign key adresses_users_id_fk;

rename table adresses to addresses;

alter table addresses
    add constraint addresses_users_id_fk
        foreign key (user_id) references users (id);