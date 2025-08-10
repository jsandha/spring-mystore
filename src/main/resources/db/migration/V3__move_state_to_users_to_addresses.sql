alter table users
drop column state;

alter table adresses
    add state varchar(255) not null;