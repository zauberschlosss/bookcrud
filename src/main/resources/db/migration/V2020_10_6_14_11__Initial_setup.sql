create table if not exists author (
    id       BIGINT(20)  NOT NULL AUTO_INCREMENT,
    name     VARCHAR(50) NULL,
    primary key (id)
);

create table if not exists book (
    id       BIGINT(20)  NOT NULL AUTO_INCREMENT,
    name     VARCHAR(100) NULL,
    year     DATE        NULL,
    isbn     VARCHAR(50) NULL,
    image_uri VARCHAR(200) NULL,
    primary key (id)
);

create table if not exists userr (
    id           BIGINT(20) NOT NULL AUTO_INCREMENT,
    username     VARCHAR(50) NULL,
    password     VARCHAR(50) NULL,
    email        VARCHAR(100) NULL,
    dob          DATE NULL,
    primary key (id)
);

create table if not exists book_user_book_entity_refs (
    user_entity_id           BIGINT(20) null,
    book_entity_id            BIGINT(20) null,
    user_book_entity_refs_id           BIGINT(20) null,
    foreign key (user_entity_id) references userr(id),
    foreign key (book_entity_id) references book(id)
);

create table if not exists userr_user_book_entity_refs (
    user_entity_id           BIGINT(20) null,
    book_entity_id            BIGINT(20) null,
    user_book_entity_refs_id           BIGINT(20) null,
    foreign key (user_entity_id) references userr(id),
    foreign key (book_entity_id) references book(id)
);

create table if not exists user_book_ref (
    id                BIGINT(20) null,
    user_id           BIGINT(20) null,
    book_id            BIGINT(20) null,
    is_deleted          BIT,
    foreign key (user_id) references userr(id),
    foreign key (book_id) references book(id)
);

CREATE TABLE IF NOT EXISTS shape (
    id            BIGINT(20) NOT NULL AUTO_INCREMENT,
    color         VARCHAR(7) NULL,
    label         VARCHAR(50) NULL,
    coordinates   VARCHAR(1000) NULL,
    geometry_name VARCHAR(10) NULL,
    PRIMARY KEY (id)
);

create table if not exists author_book_ref (
    author_id          BIGINT(20) null,
    book_id            BIGINT(20) null,
    foreign key (author_id) references author(id),
    foreign key (book_id) references book(id)
);