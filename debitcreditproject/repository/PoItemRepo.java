package com.example.debitcreditproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.debitcreditproject.entity.PoItemDetails;

@Repository
public interface PoItemRepo  extends JpaRepository<PoItemDetails, Long>{

}
