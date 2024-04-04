package com.example.debitcreditproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class InvoiceEntity {

	@Id
	@Column(name = "invoice_number", length = 16)
	private String invoiceNumber;
	@Column(name = "booking_status")
	private String bookingStatus;
	@Column(name = "invoice_date")
	private String invoiceDate;
	@Column(nullable = false)
	private String status = "new";
//	occurs when partial deliverly of product is their
	@OneToOne
	@JoinColumn(name = "grn_items")
	private GrnItem grnitems;

	@Column(name = "invoiceAmount")
	private String amount;

}
