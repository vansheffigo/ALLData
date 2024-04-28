package com.example.debitcreditproject.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class VendorEntityDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "vendor_code", length = 15)
	private String vendorCode;
	@OneToMany(mappedBy = "vendor")
	private List<PoEntityDetails> purchaseOrders;
}
