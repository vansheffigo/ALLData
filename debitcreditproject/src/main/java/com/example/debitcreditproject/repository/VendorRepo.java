package com.example.debitcreditproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.debitcreditproject.entity.VendorEntity;

@Repository
public interface VendorRepo extends JpaRepository<VendorEntity, String> {

}
