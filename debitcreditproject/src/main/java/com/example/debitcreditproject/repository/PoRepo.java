package com.example.debitcreditproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.debitcreditproject.entity.PoEntity;

@Repository
public interface PoRepo extends JpaRepository<PoEntity, String> {

}
