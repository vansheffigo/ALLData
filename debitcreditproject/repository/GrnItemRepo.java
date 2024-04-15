package com.example.debitcreditproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.debitcreditproject.entity.GrnItemDetails;

@Repository
public interface GrnItemRepo extends JpaRepository<GrnItemDetails, Long> {

}
