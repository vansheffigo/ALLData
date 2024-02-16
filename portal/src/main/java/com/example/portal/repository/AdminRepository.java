package com.example.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.portal.entity.AdminEntity;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, Long> {
	@Query(value = "SELECT * FROM admin WHERE email = :email", nativeQuery = true)
	AdminEntity findByEmail(@Param("email") String email);

	@Query(value = "select  distinct ad.admin_id,ad.name,ad.email, ad.password   from admin ad join author au on ad.name= au.name", nativeQuery = true)
	List<AdminEntity> fetchCombined();
}