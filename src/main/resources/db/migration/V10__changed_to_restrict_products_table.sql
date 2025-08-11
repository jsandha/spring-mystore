alter table products
drop foreign key fk_category;

alter table products
    add constraint fk_category
        foreign key (category_id) references categories (id)
            on delete restrict;