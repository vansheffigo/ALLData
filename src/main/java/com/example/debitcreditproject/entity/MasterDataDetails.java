package com.example.debitcreditproject.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "MasterTable")
public class MasterDataDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "vendor_code")
	private String vendorCode;

	@Column(name = "s_invoiceNo")
	private String supplementaryInvoiceNo;

	@Column(name = "po_no")
	private String poNumber;

	@Column(name = "material_code")
	private String materialCode;

	@Column(name = "grn_no")
	private String grnNumber;

	@Column(name = "invoice_date")
	private Date invoiceDate;

	@Column(name = "po_gst")
	private Long poGst;
	@Column(name = "grn_date")
	private Date grnDate;

	@Column(name = "quantity")
	private Long quantity;

	@Column(name = "total_price")
	private Long totalPrice;

}
