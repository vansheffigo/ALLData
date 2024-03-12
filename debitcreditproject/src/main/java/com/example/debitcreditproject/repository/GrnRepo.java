package com.example.debitcreditproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.debitcreditproject.entity.GrnEntity;

@Repository
public interface GrnRepo extends JpaRepository<GrnEntity, String> {

}
