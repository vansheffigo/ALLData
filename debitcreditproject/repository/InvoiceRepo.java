package com.example.debitcreditproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.debitcreditproject.entity.InvoiceEntityDetails;

import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface InvoiceRepo extends JpaRepository<InvoiceEntityDetails, String> {
	@Modifying
	@Query(value = "update invoice_entity set status = :status where invoice_number = :invoiceNumber", nativeQuery = true)
	void updateStatus(@Param("status") String status, @Param("invoiceNumber") String invoiceNumber);

	@Query(value = "select status from invoice_entity where invoice_number=?1", nativeQuery = true)
	String findStatus(String invoiceNumber);

	@Modifying
	@Query(value = "update invoice_entity set booking_status = :bookingStatus where invoice_number = :invoiceNumber", nativeQuery = true)
	void updateBookingStatus(@Param("bookingStatus") String bookingStatus,
			@Param("invoiceNumber") String invoiceNumber);

	@Query(value = "select booking_status from invoice_entity where invoice_number=?1", nativeQuery = true)
	String findBookingStatus(String invoiceNumber);

	@Query(value = "SELECT invoice_number,invoice_amount,invoice_date,status,grn_items,booking_status,"
			+ "dispatchedquantity,po_itemid," + "grn_date,grn_number," + "gst,price,quantity,material_code,po_id,"
			+ "vendor_code" + " FROM get_all", nativeQuery = true)
	List<Object[]> getData();

}
