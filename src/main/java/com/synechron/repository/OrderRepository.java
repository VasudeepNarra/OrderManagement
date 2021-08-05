package com.synechron.repository;

import com.synechron.modal.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import javax.persistence.EntityManager;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    Order findByOrderName(String name);
    //@Query(value = "SELECT * FROM ordermanagement.orders_tbl o where o.userorder_fk = :uid", nativeQuery = true)
    //List<Order> getOrderByUser(@Param("uid") int uid);
    
    /*@Autowired
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Order> getOrderInfo() {
		return em.createNamedStoredProcedureQuery("firstProcedure").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Order> getOrderInfoByName(String input) {
		return em.createNamedStoredProcedureQuery("secondProcedure").setParameter("ordName", input).getResultList();
	}*/
    
}
