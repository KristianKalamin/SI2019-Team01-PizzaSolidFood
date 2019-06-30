INSERT INTO products (PROD_NAME, PROD_PRICE, PROD_SIZE, DISCOUNT_FOR_PREMIUM_USERS, PROD_DESCRIPTION, IMAGE)
VALUES ('Napoletana','12.35','100','20','mozzarella cheese, baked ham, mushroom, artichoke and tomato and pizza pugliese, prepared with tomato, mozzarella and onions','img/peperoni.jpg');

INSERT INTO products (PROD_NAME, PROD_PRICE, PROD_SIZE, DISCOUNT_FOR_PREMIUM_USERS, PROD_DESCRIPTION, IMAGE)
VALUES ('Margherita','15.99','100','69','San Marzano tomatoes, mozzarella fior di latte, fresh basil, salt and extra-virgin olive oil','img/mergherita.jpg');

INSERT INTO products (PROD_NAME, PROD_PRICE, PROD_SIZE, DISCOUNT_FOR_PREMIUM_USERS, PROD_DESCRIPTION, IMAGE)
VALUES ('Quattro stagioni','20.99','100','21','artichokes, tomatoes or basil, mushrooms and ham or prosciutto, or olives','img/quattro_stagioni.jpg');


INSERT INTO users (USER_NAME, USER_LASTNAME, EMAIL, USER_TYPE, ADDRESS, POINTS, MONTHLY_ORDERS)
VALUES ('Elijah','Agbabah','ilijah.agbabah@tfzr.rs','2','Jovana Popovica 29','69','8');

INSERT INTO users (USER_NAME, USER_LASTNAME, EMAIL, USER_TYPE, ADDRESS, POINTS, MONTHLY_ORDERS)
VALUES ('Nikolah','Turudijah','nikolah.turudijah@tfzr.rs','1','dorm','911','7');

INSERT INTO users (USER_NAME, USER_LASTNAME, EMAIL, USER_TYPE, ADDRESS, POINTS, MONTHLY_ORDERS)
VALUES ('Mihalh','Kristianh','mihalah.kristianh@tfzr.rs','0','across the street of faculty','420','21');


INSERT INTO additions (ADD_NAME, ADD_PRICE)
VALUES ('Bacon','0.50');

INSERT INTO additions (ADD_NAME, ADD_PRICE)
VALUES ('Cheese','0.25');

INSERT INTO additions (ADD_NAME, ADD_PRICE)
VALUES ('Mushroom','0.75');


delete from order_has_additions;
delete from `order`;
delete from orders;


call order_procedure('nikolah.turudijah@tfzr.rs','Quattro stagioni', 'paypal','1','123456');
call additions_procedure_premium('Quattro stagioni','123456', 'Cheese');
call complete_order_procedure('123456', 'nikolah.turudijah@tfzr.rs');
