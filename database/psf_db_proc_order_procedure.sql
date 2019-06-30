CREATE DEFINER=`root`@`localhost` PROCEDURE `order_procedure`(in email varchar(254), 
                                            in product_name varchar(100), 
                                            in payment varchar(250),
                                            in quantity tinyint,
                                            in order_num int)
BEGIN
    
    declare _order_price double(8,2);
    declare product_id bigint;
    declare price double(7,2);
    declare order_price double(8,2);
    declare discount tinyint;
    declare user_type tinyint;
    declare dis tinyint;

    select users.user_type into user_type from users where users.email = email;

    select products.id_prod, products.prod_price, products.discount_for_premium_users
    into product_id, price, discount
    from products where products.prod_name = product_name;
   
    IF user_type = 0 then
        set discount = 0;
    end if;
   
    set dis = price * (discount / 100);
    set order_price = (price - dis) * quantity;
    
    insert into `order`(ORDER_PRICE, PAYMENT, QUANTITY, ORDER_NUM, PRODUCTS_ID_PROD)
    values(order_price, payment, quantity, order_num, product_id);
    
END