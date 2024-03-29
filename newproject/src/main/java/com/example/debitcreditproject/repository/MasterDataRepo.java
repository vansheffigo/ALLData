package com.example.debitcreditproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.debitcreditproject.entity.MasterData;

@Repository
public interface MasterDataRepo extends JpaRepository<MasterData, Long> {

	Optional<MasterData> findByGrnNumber(String grnNumber);

	@Query(value = "SELECT quantity FROM master_table WHERE grn_number = ?1", nativeQuery = true)
	Long findQuantityByGrnNumber(String grnNumber);

	@Query(value = "Select po_gst from master_table where po_no=?1", nativeQuery = true)
	Long getPoGst(String poNo);
}
