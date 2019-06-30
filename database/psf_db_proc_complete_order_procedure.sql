
CREATE DEFINER=`root`@`localhost` PROCEDURE `complete_order_procedure`(in order_num int,
                                            in user_mail varchar(254)
                                            )
BEGIN
    
    declare _points smallint;
    declare _monthly_orders smallint;
    declare _id_user bigint;
    declare _total_price double(9,2);
    declare total_order_price double(8,2);
    declare total_add_price double(5,2);
    declare _id_order bigint;
    
    
    select id_user into _id_user from users where users.email = user_mail;
    
   # select id_order into _id_order from `order` order by id_order desc limit 1;
    
    select sum(`order`.order_price) into total_order_price from `order` where `order`.order_num = order_num;
    select sum(`additions`.add_price) into total_add_price 
    from additions, order_has_additions, `order`
    where 
        order_has_additions.order_id_order = `order`.id_order
        and
        order_has_additions.additions_id_add = additions.id_add
        and
        `order`.ORDER_NUM = order_num;
    
    if total_add_price is null then
        set total_add_price = 0;
    end if;

    set _total_price = total_order_price + total_add_price;
   
    insert into orders (USERS_ID_USER, TOTAL_PRICE, ORDERS_ORDER_NUM)
    values(_id_user, _total_price, order_num);
    
    select users.points into _points from users where users.email = user_mail;
    select users.monthly_orders into _monthly_orders from users where users.email = user_mail;

    update users
    set points = _points + ROUND(_total_price) / 100,
    monthly_orders = _monthly_orders + 1
    where users.email = user_mail;

END






