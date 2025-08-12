alter table wishlist
drop foreign key fk_wishlist_on_user;

alter table wishlist
    add constraint fk_wishlist_on_user
        foreign key (user_id) references users (id)
            on delete cascade;
