package com.psf.psfrest.repository;

import com.psf.psfrest.model.OrderDetails;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ProceduresRepository extends CrudRepository<OrderDetails, Integer> {
    @Transactional
    @Procedure(procedureName = "order_procedure")
    void order(@Param("email") String mail,
               @Param("product_name") String productName,
               @Param("payment") String payment,
               @Param("quantity") int quantity,
               @Param("order_num") int orderNum);

    @Transactional
    @Procedure(procedureName = "additions_procedure_premium")
    void additionsForPremiumUsers(@Param("product_name") String productName,
                                  @Param("order_num") int orderNum,
                                  @Param("addition_name") String additionName);

    @Transactional
    @Procedure(procedureName = "complete_order_procedure")
    void completeOrder(@Param("order_num") int orderNum, @Param("user_mail") String userMail);


}
