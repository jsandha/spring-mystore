create table profiles
(
    id             BIGINT      primary key,
    bio            VARCHAR(255),
    phone_number   SMALLINT(12),
    date_of_birth  DATE,
    loyalty_points INT UNSIGNED default 0,
    FOREIGN KEY (id) references users (id)
);