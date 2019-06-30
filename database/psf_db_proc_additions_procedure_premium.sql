CREATE DEFINER=`root`@`localhost` CREATE PROCEDURE `additions_procedure_premium` (
                                            in product_name varchar(100), 
                                            in order_num int,
                                            in addition_name varchar(100))
BEGIN
    declare _order_price double(8,2);
    declare product_id bigint;
    declare _addition_id varchar(100);
    declare _id_order bigint;
    
    
    select products.id_prod into product_id from products where products.prod_name = product_name;
    select `order`.id_order into _id_order from `order` where `order`.order_num = order_num;
    select additions.id_add into _addition_id from `additions` where additions.add_name = addition_name;
    
    
    insert into `order_has_additions`(ORDER_ID_ORDER, ORDER_PRODUCTS_ID_PROD, ADDITIONS_ID_ADD)
    values(_id_order, product_id, _addition_id);
    
END