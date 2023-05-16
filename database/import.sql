
-- bloodtype
INSERT INTO public.bloodtype (id, type) VALUES (DEFAULT, 'A+');
INSERT INTO public.bloodtype (id, type) VALUES (DEFAULT, 'A-');
INSERT INTO public.bloodtype (id, type) VALUES (DEFAULT, 'B+');
INSERT INTO public.bloodtype (id, type) VALUES (DEFAULT, 'B-');
INSERT INTO public.bloodtype (id, type) VALUES (DEFAULT, 'AB+');
INSERT INTO public.bloodtype (id, type) VALUES (DEFAULT, 'AB-');
INSERT INTO public.bloodtype (id, type) VALUES (DEFAULT, '0+');
INSERT INTO public.bloodtype (id, type) VALUES (DEFAULT, '0-');

-- category

INSERT INTO public.category (id, name) VALUES (DEFAULT, 'Kidney');
INSERT INTO public.category (id, name) VALUES (DEFAULT, 'Heart');
INSERT INTO public.category (id, name) VALUES (DEFAULT, 'Lungs');
INSERT INTO public.category (id, name) VALUES (DEFAULT, 'Liver');


-- contact
INSERT INTO public.contact (id, firstname, lastname) VALUES (DEFAULT, 'Anti', 'Paeorg');
INSERT INTO public.contact (id, firstname, lastname) VALUES (DEFAULT, 'Kaarel', 'J');
INSERT INTO public.contact (id, firstname, lastname) VALUES (DEFAULT, 'Jack', 'Ripper');
INSERT INTO public.contact (id, firstname, lastname) VALUES (DEFAULT, 'Chuck ', 'Whorries');

-- country

INSERT INTO public.country (id, name)
VALUES
    (DEFAULT, 'Austria'),
    (DEFAULT, 'Belgium'),
    (DEFAULT, 'Bulgaria'),
    (DEFAULT, 'Croatia'),
    (DEFAULT, 'Cyprus'),
    (DEFAULT, 'Czech Republic'),
    (DEFAULT, 'Denmark'),
    (DEFAULT, 'Estonia'),
    (DEFAULT, 'Finland'),
    (DEFAULT, 'France'),
    (DEFAULT, 'Germany'),
    (DEFAULT, 'Greece'),
    (DEFAULT, 'Hungary'),
    (DEFAULT, 'Ireland'),
    (DEFAULT, 'Italy'),
    (DEFAULT, 'Latvia'),
    (DEFAULT, 'Lithuania'),
    (DEFAULT, 'Luxembourg'),
    (DEFAULT, 'Malta'),
    (DEFAULT, 'Netherlands'),
    (DEFAULT, 'Poland'),
    (DEFAULT, 'Portugal'),
    (DEFAULT, 'Romania'),
    (DEFAULT, 'Slovakia'),
    (DEFAULT, 'Slovenia'),
    (DEFAULT, 'Spain'),
    (DEFAULT, 'Sweden');



-- gender

INSERT INTO public.gender (id, name) VALUES (DEFAULT, 'male');
INSERT INTO public.gender (id, name) VALUES (DEFAULT, 'female');

-- image

-- product
INSERT INTO public.product (id, age, description, available_at, price, status, category_id, country_id, gender_id, bloodtype_id, image_id) VALUES (DEFAULT, 21, 'Healthy. Non-smoker. Non-Drinker. Saint in a previous life.', '2023-05-31', 6000, 'A', 1, 14, 1, 6, null);
INSERT INTO public.product (id, age, description, available_at, price, status, category_id, country_id, gender_id, bloodtype_id, image_id) VALUES (DEFAULT, 55, 'In good health. Fit.', '2023-11-16', 8000, 'A', 1, 8, 2, 5, null);
INSERT INTO public.product (id, age, description, available_at, price, status, category_id, country_id, gender_id, bloodtype_id, image_id) VALUES (DEFAULT, 69, 'Slightly used but still works with minor errors.', '2021-12-23', 17000, 'A', 2, 22, 2, 8, null);
INSERT INTO public.product (id, age, description, available_at, price, status, category_id, country_id, gender_id, bloodtype_id, image_id) VALUES (DEFAULT, 56, 'Beats like a Swiss clock.', '2022-08-17', 26000, 'A', 2, 2, 1, 3, null);
INSERT INTO public.product (id, age, description, available_at, price, status, category_id, country_id, gender_id, bloodtype_id, image_id) VALUES (DEFAULT, 22, 'Marathon runners lungs. Well-tested. A rare find.', '2023-10-05', 45000, 'A', 3, 5, 1, 7, null);
INSERT INTO public.product (id, age, description, available_at, price, status, category_id, country_id, gender_id, bloodtype_id, image_id) VALUES (DEFAULT, 43, 'Was a balloon seller in a previous life. Good lung capacity. May include some helium.', '2023-01-01', 36000, 'A', 3, 11, 2, 3, null);
INSERT INTO public.product (id, age, description, available_at, price, status, category_id, country_id, gender_id, bloodtype_id, image_id) VALUES (DEFAULT, 75, 'Cat got your liver? Buy it here!', '2023-05-03', 10000, 'A', 4, 15, 2, 6, null);
INSERT INTO public.product (id, age, description, available_at, price, status, category_id, country_id, gender_id, bloodtype_id, image_id) VALUES (DEFAULT, 15, 'Gone too soon. Good liver, though.', '2022-09-11', 58000, 'A', 4, 11, 1, 1, null);

-- role
INSERT INTO public.role (id, name) VALUES (DEFAULT, 'user');
INSERT INTO public.role (id, name) VALUES (DEFAULT, 'admin');

-- user
INSERT INTO public."user" (id, email, password, status, image_id, contact_id, role_id) VALUES (DEFAULT, 'admin@gmail.com', '123', 'A', null, 2, 2);
INSERT INTO public."user" (id, email, password, status, image_id, contact_id, role_id) VALUES (DEFAULT, 'user@gmail.com', '123', 'A', null, 1, 1);
INSERT INTO public."user" (id, email, password, status, image_id, contact_id, role_id) VALUES (DEFAULT, 'grimreaper@yahoo.com', '123', 'A', null, 3, 1);
INSERT INTO public."user" (id, email, password, status, image_id, contact_id, role_id) VALUES (DEFAULT, 'noproblems@hotmail.com', '123', 'A', null, 4, 1);


-- user_product
INSERT INTO public.user_product (id, product_id, seller_id, buyer_id) VALUES (DEFAULT, 1, 4, null);
INSERT INTO public.user_product (id, product_id, seller_id, buyer_id) VALUES (DEFAULT, 4, 3, null);
INSERT INTO public.user_product (id, product_id, seller_id, buyer_id) VALUES (DEFAULT, 3, 4, null);
INSERT INTO public.user_product (id, product_id, seller_id, buyer_id) VALUES (DEFAULT, 2, 2, null);
INSERT INTO public.user_product (id, product_id, seller_id, buyer_id) VALUES (DEFAULT, 2, 3, null);
INSERT INTO public.user_product (id, product_id, seller_id, buyer_id) VALUES (DEFAULT, 4, 2, null);
INSERT INTO public.user_product (id, product_id, seller_id, buyer_id) VALUES (DEFAULT, 4, 2, null);
INSERT INTO public.user_product (id, product_id, seller_id, buyer_id) VALUES (DEFAULT, 3, 3, null);

-- favourite

INSERT INTO public.favorite (id, buyer_id, product_id) VALUES (DEFAULT, 2, 4);
INSERT INTO public.favorite (id, buyer_id, product_id) VALUES (DEFAULT, 2, 2);
INSERT INTO public.favorite (id, buyer_id, product_id) VALUES (DEFAULT, 3, 4);
