package com.example.debitcreditproject.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class PoEntityDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "po_id", length = 12)
	private String poNumber;

	@ManyToOne
	@JoinColumn(name = "vendor_code")
	private VendorEntityDetails vendor;

	@OneToMany(mappedBy = "poid")
	private List<PoItemDetails> poitems;

}
