package com.example.OrderService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.OrderService.model.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

//	@Query("SELECT o FROM orderTBL o WHERE o.name = :name")
//    public List<Order> findOrderByName(@Param("name") String name);
//
//	@Query("SELECT o FROM orderTBL o WHERE o.name = :name AND o.id= :id AND o.price= :price")
//    public List<Order> findOrderFiltering(@Param("name") String name,@Param("id") String id,@Param("price") String price);

}
