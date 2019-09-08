package com.udemy.restservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.restservices.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
