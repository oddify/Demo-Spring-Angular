CREATE TABLE category
(
    id    BIGINT AUTO_INCREMENT NOT NULL,
    date  datetime              NULL,
    title VARCHAR(255)          NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE category_products
(
    category_id BIGINT NOT NULL,
    products_id BIGINT NOT NULL
);

CREATE TABLE jt_instructor
(
    id             BIGINT       NOT NULL,
    specialization VARCHAR(255) NULL,
    CONSTRAINT pk_jt_instructor PRIMARY KEY (id)
);

CREATE TABLE jt_mentor
(
    id         BIGINT       NOT NULL,
    comp_name  VARCHAR(255) NULL,
    avg_rating DOUBLE       NOT NULL,
    CONSTRAINT pk_jt_mentor PRIMARY KEY (id)
);

CREATE TABLE jt_ta
(
    id             BIGINT NOT NULL,
    no_of_sessions INT    NOT NULL,
    avg_rating     DOUBLE NOT NULL,
    CONSTRAINT pk_jt_ta PRIMARY KEY (id)
);

CREATE TABLE jt_users
(
    id       BIGINT       NOT NULL,
    name     VARCHAR(255) NULL,
    email    VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    CONSTRAINT pk_jt_users PRIMARY KEY (id)
);

CREATE TABLE mps_instructor
(
    id             BIGINT       NOT NULL,
    name           VARCHAR(255) NULL,
    email          VARCHAR(255) NULL,
    password       VARCHAR(255) NULL,
    specialization VARCHAR(255) NULL,
    CONSTRAINT pk_mps_instructor PRIMARY KEY (id)
);

CREATE TABLE mps_mentor
(
    id         BIGINT       NOT NULL,
    name       VARCHAR(255) NULL,
    email      VARCHAR(255) NULL,
    password   VARCHAR(255) NULL,
    comp_name  VARCHAR(255) NULL,
    avg_rating DOUBLE       NOT NULL,
    CONSTRAINT pk_mps_mentor PRIMARY KEY (id)
);

CREATE TABLE mps_ta
(
    id             BIGINT       NOT NULL,
    name           VARCHAR(255) NULL,
    email          VARCHAR(255) NULL,
    password       VARCHAR(255) NULL,
    no_of_sessions INT          NOT NULL,
    avg_rating     DOUBLE       NOT NULL,
    CONSTRAINT pk_mps_ta PRIMARY KEY (id)
);

CREATE TABLE product
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    date          datetime              NULL,
    title         VARCHAR(255)          NULL,
    price         DOUBLE                NOT NULL,
    category_id   BIGINT                NULL,
    `description` VARCHAR(255)          NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE st_users
(
    id             BIGINT       NOT NULL,
    user_typ       INT          NULL,
    name           VARCHAR(255) NULL,
    email          VARCHAR(255) NULL,
    password       VARCHAR(255) NULL,
    comp_name      VARCHAR(255) NULL,
    avg_rating     DOUBLE       NOT NULL,
    specialization VARCHAR(255) NULL,
    no_of_sessions INT          NOT NULL,
    CONSTRAINT pk_st_users PRIMARY KEY (id)
);

CREATE TABLE tpc_instructor
(
    id             BIGINT       NOT NULL,
    name           VARCHAR(255) NULL,
    email          VARCHAR(255) NULL,
    password       VARCHAR(255) NULL,
    specialization VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_instructor PRIMARY KEY (id)
);

CREATE TABLE tpc_mentor
(
    id         BIGINT       NOT NULL,
    name       VARCHAR(255) NULL,
    email      VARCHAR(255) NULL,
    password   VARCHAR(255) NULL,
    comp_name  VARCHAR(255) NULL,
    avg_rating DOUBLE       NOT NULL,
    CONSTRAINT pk_tpc_mentor PRIMARY KEY (id)
);

CREATE TABLE tpc_ta
(
    id             BIGINT       NOT NULL,
    name           VARCHAR(255) NULL,
    email          VARCHAR(255) NULL,
    password       VARCHAR(255) NULL,
    no_of_sessions INT          NOT NULL,
    avg_rating     DOUBLE       NOT NULL,
    CONSTRAINT pk_tpc_ta PRIMARY KEY (id)
);

CREATE TABLE tpc_users
(
    id       BIGINT       NOT NULL,
    name     VARCHAR(255) NULL,
    email    VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_users PRIMARY KEY (id)
);

ALTER TABLE category_products
    ADD CONSTRAINT uc_category_products_products UNIQUE (products_id);

ALTER TABLE jt_instructor
    ADD CONSTRAINT FK_JT_INSTRUCTOR_ON_ID FOREIGN KEY (id) REFERENCES jt_users (id);

ALTER TABLE jt_mentor
    ADD CONSTRAINT FK_JT_MENTOR_ON_ID FOREIGN KEY (id) REFERENCES jt_users (id);

ALTER TABLE jt_ta
    ADD CONSTRAINT FK_JT_TA_ON_ID FOREIGN KEY (id) REFERENCES jt_users (id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);

ALTER TABLE category_products
    ADD CONSTRAINT fk_catpro_on_category FOREIGN KEY (category_id) REFERENCES category (id);

ALTER TABLE category_products
    ADD CONSTRAINT fk_catpro_on_product FOREIGN KEY (products_id) REFERENCES product (id);