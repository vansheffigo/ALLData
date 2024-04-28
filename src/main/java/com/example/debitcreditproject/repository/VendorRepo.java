package com.example.debitcreditproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.debitcreditproject.entity.VendorEntityDetails;

@Repository
public interface VendorRepo extends JpaRepository<VendorEntityDetails, Long> {

}
