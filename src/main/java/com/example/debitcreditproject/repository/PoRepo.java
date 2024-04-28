package com.example.debitcreditproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.debitcreditproject.entity.PoEntityDetails;

@Repository
public interface PoRepo extends JpaRepository<PoEntityDetails, Long> {

}
