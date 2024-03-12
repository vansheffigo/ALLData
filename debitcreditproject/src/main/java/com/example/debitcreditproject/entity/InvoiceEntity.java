package com.example.debitcreditproject.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
public class InvoiceEntity {

	@Id
	@Column(name = "invoice_number", length = 16)
	private String invoiceNumber;

	

	@Column(name = "total")
	private Long total;
	
	@Getter
	@Setter
	@Column(name = "invoice_date")
	private String invoiceDate;

	public void setInvoiceDate(LocalDate invoiceDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		this.invoiceDate = invoiceDate.format(formatter);
	}

	// Custom method to get invoice date as LocalDate
	public LocalDate getInvoiceDate() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		return LocalDate.parse(invoiceDate, formatter);
	}

//	occurs when partial deliverly of product is their
	
	@ManyToOne
	@JoinColumn(name = "po_no")
	private PoEntity po;
	@OneToOne
	@JoinColumn(name = "grn_id")
	private GrnEntity grn;

}
