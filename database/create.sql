-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-05-16 08:50:50.153
-- tables
-- Table: bloodgroup
CREATE TABLE bloodgroup (
                            id serial  NOT NULL,
                            type varchar(10)  NOT NULL,
                            CONSTRAINT bloodgroup_pk PRIMARY KEY (id)
);
-- Table: category
CREATE TABLE category (
                          id serial  NOT NULL,
                          name varchar(50)  NOT NULL,
                          CONSTRAINT category_pk PRIMARY KEY (id)
);
-- Table: contact
CREATE TABLE contact (
                         id serial  NOT NULL,
                         firstname varchar(50)  NOT NULL,
                         lastname varchar(50)  NOT NULL,
                         CONSTRAINT contact_pk PRIMARY KEY (id)
);
-- Table: country
CREATE TABLE country (
                         id serial  NOT NULL,
                         name varchar(255)  NOT NULL,
                         CONSTRAINT country_pk PRIMARY KEY (id)
);
-- Table: favorite
CREATE TABLE favorite (
                          id serial  NOT NULL,
                          buyer_id int  NOT NULL,
                          product_id int  NOT NULL,
                          CONSTRAINT favorite_pk PRIMARY KEY (id)
);
-- Table: gender
CREATE TABLE gender (
                        id serial  NOT NULL,
                        name varchar(255)  NOT NULL,
                        CONSTRAINT gender_pk PRIMARY KEY (id)
);
-- Table: image
CREATE TABLE image (
                       id serial  NOT NULL,
                       data bytea  NOT NULL,
                       CONSTRAINT image_pk PRIMARY KEY (id)
);
-- Table: product
CREATE TABLE product (
                         id serial  NOT NULL,
                         age int  NOT NULL,
                         description text  NOT NULL,
                         available_at date  NOT NULL,
                         price int  NOT NULL,
                         status char(1)  NOT NULL,
                         category_id int  NOT NULL,
                         country_id int  NOT NULL,
                         gender_id int  NOT NULL,
                         bloodgroup_id int  NOT NULL,
                         image_id int  NULL,
                         CONSTRAINT product_pk PRIMARY KEY (id)
);
-- Table: role
CREATE TABLE role (
                      id serial  NOT NULL,
                      name varchar(50)  NOT NULL,
                      CONSTRAINT role_pk PRIMARY KEY (id)
);
-- Table: user
CREATE TABLE "user" (
                        id serial  NOT NULL,
                        email varchar(50)  NOT NULL,
                        password varchar(50)  NOT NULL,
                        status char(1)  NOT NULL,
                        image_id int  NULL,
                        contact_id int  NULL,
                        role_id int  NOT NULL,
                        CONSTRAINT user_pk PRIMARY KEY (id)
);
-- Table: user_product
CREATE TABLE user_product (
                              id serial  NOT NULL,
                              product_id int  NOT NULL,
                              seller_id int  NOT NULL,
                              buyer_id int  NULL,
                              CONSTRAINT user_product_pk PRIMARY KEY (id)
);
-- foreign keys
-- Reference: favorite_product (table: favorite)
ALTER TABLE favorite ADD CONSTRAINT favorite_product
    FOREIGN KEY (product_id)
        REFERENCES product (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;
-- Reference: favorite_user (table: favorite)
ALTER TABLE favorite ADD CONSTRAINT favorite_user
    FOREIGN KEY (buyer_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;
-- Reference: product_bloodgroup (table: product)
ALTER TABLE product ADD CONSTRAINT product_bloodgroup
    FOREIGN KEY (bloodgroup_id)
        REFERENCES bloodgroup (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;
-- Reference: product_category (table: product)
ALTER TABLE product ADD CONSTRAINT product_category
    FOREIGN KEY (category_id)
        REFERENCES category (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;
-- Reference: product_country (table: product)
ALTER TABLE product ADD CONSTRAINT product_country
    FOREIGN KEY (country_id)
        REFERENCES country (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;
-- Reference: product_gender (table: product)
ALTER TABLE product ADD CONSTRAINT product_gender
    FOREIGN KEY (gender_id)
        REFERENCES gender (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;
-- Reference: product_image (table: product)
ALTER TABLE product ADD CONSTRAINT product_image
    FOREIGN KEY (image_id)
        REFERENCES image (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;
-- Reference: user_data (table: user)
ALTER TABLE "user" ADD CONSTRAINT user_data
    FOREIGN KEY (contact_id)
        REFERENCES contact (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;
-- Reference: user_image (table: user)
ALTER TABLE "user" ADD CONSTRAINT user_image
    FOREIGN KEY (image_id)
        REFERENCES image (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;
-- Reference: user_product_buyer (table: user_product)
ALTER TABLE user_product ADD CONSTRAINT user_product_buyer
    FOREIGN KEY (buyer_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;
-- Reference: user_product_product (table: user_product)
ALTER TABLE user_product ADD CONSTRAINT user_product_product
    FOREIGN KEY (product_id)
        REFERENCES product (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;
-- Reference: user_product_seller (table: user_product)
ALTER TABLE user_product ADD CONSTRAINT user_product_seller
    FOREIGN KEY (seller_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;
-- Reference: user_role (table: user)
ALTER TABLE "user" ADD CONSTRAINT user_role
    FOREIGN KEY (role_id)
        REFERENCES role (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;
-- End of file.