package com.example.debitcreditproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "PoItems")
public class PoItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "po_items")
	private Long poItems;
	@ManyToOne
	@JoinColumn(name = "purchase_order_id")
	private PoEntity poItem;

	@ManyToOne
	@JoinColumn(name = "material_id")
	private MaterialEntity poItemMaterial;
}
