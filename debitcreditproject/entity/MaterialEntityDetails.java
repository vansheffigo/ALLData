package com.example.debitcreditproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class MaterialEntityDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "material_code", length = 12)
	private String materialCode;
//
//	@OneToMany(mappedBy = "material")
//	private List<PoEntity> purchaseOrders;

}
