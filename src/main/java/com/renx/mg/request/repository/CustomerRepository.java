package com.renx.mg.request.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renx.mg.request.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
