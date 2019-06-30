USE `psf_db`;
CREATE  OR REPLACE VIEW `order_with_addition` AS
select 
    `order`.`ID_ORDER`,
    users.user_name,
    users.user_lastname,
    #users.user_address, not in use
    users.user_type,
    orders.total_price,
    `order`.date_time,
    `order`.payment,
    `order`.quantity,
    `order`.order_num,
    products.prod_name,
    products.prod_price,
    products.discount_for_premium_users,
    additions.add_name,
    additions.add_price

from users, orders, `order`, products, additions, order_has_additions
where
    users.id_user = orders.users_id_user
    and
    orders.orders_order_num = `order`.order_num
    and
    `order`.products_id_prod = products.id_prod
    and
    `order`.id_order = order_has_additions.order_id_order
    and
    additions.id_add = order_has_additions.additions_id_add;



CREATE VIEW `order_without_addition` AS
    SELECT 
        `order`.`ID_ORDER` AS `id_order`,
        `users`.`USER_NAME` AS `user_name`,
        `users`.`USER_LASTNAME` AS `user_lastname`,
        `users`.`USER_TYPE` AS `user_type`,
        `orders`.`TOTAL_PRICE` AS `total_price`,
        `order`.`DATE_TIME` AS `date_time`,
        `order`.`PAYMENT` AS `payment`,
        `order`.`QUANTITY` AS `quantity`,
        `order`.`ORDER_NUM` AS `order_num`,
        `products`.`PROD_NAME` AS `prod_name`,
        `products`.`PROD_PRICE` AS `prod_price`,
        `products`.`DISCOUNT_FOR_PREMIUM_USERS` AS `discount_for_premium_users`
    FROM
        (((`users`
        JOIN `orders`)
        JOIN `order`)
        JOIN `products`)
        JOIN `additions`)
        JOIN `order_has_additions`)
    WHERE
        ((`users`.`ID_USER` = `orders`.`users_ID_USER`)
            AND (`orders`.`ORDERS_ORDER_NUM` = `order`.`ORDER_NUM`)
            AND (`order`.`products_ID_PROD` = `products`.`ID_PROD`))