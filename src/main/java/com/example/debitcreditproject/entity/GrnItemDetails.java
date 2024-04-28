package com.example.debitcreditproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "GrnItemsDetails")
public class GrnItemDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "grn_id")
	private GrnEntityDetails grn;

	@ManyToOne
	@JoinColumn(name = "po_itemid")
	private PoItemDetails poitem;

	@Column(name = "dispatchedquantity")
	private Long dispatchedquantity;

	@Column(name = "AcceptedQuantity")
	private long acceptedquantity;

	@OneToOne(mappedBy = "grnitems")
	private InvoiceEntityDetails invoice;

}
