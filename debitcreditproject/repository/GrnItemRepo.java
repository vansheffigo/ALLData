package com.example.debitcreditproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.debitcreditproject.entity.GrnItem;

@Repository
public interface GrnItemRepo extends JpaRepository<GrnItem, Long> {

}
