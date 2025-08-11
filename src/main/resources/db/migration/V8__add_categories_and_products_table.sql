create table categories
(
    id   TINYINT  AUTO_INCREMENT  primary key,
    name VARCHAR(255) not null
);

create table products
(
    id          BIGINT AUTO_INCREMENT primary key,
    name        VARCHAR(255)   not null,
    price       DECIMAL(10, 2) not null,
    category_id TINYINT,
    constraint fk_category
        foreign key (category_id) references categories (id)
            on delete restrict
);
