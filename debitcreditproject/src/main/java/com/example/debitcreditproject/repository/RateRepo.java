package com.example.debitcreditproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.debitcreditproject.entity.RateEntity;

public interface RateRepo extends JpaRepository<RateEntity, Long> {

}
