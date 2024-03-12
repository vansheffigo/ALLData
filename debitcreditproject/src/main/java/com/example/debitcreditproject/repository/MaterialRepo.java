package com.example.debitcreditproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.debitcreditproject.entity.MaterialEntity;

@Repository

public interface MaterialRepo extends JpaRepository<MaterialEntity, String> {

}
