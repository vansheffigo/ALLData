package com.example.debitcreditproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.debitcreditproject.entity.InvoiceEntity;

@Repository
public interface InvoiceRepo extends JpaRepository<InvoiceEntity, String> {

}
