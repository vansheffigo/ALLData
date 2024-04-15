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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "PoItemsDetails")
public class PoItemDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "po_Itemid")
	private Long id;

	@Column(name = "gst")
	private int gst;

	@ManyToOne
	@JoinColumn(name = "Po_id")
	private PoEntityDetails poid;

	@ManyToOne
	@JoinColumn(name = "material_code")
	private MaterialEntityDetails poItemMaterial;

	@JoinColumn(name = "item_price")
	private String price;

	@Column(name = "Quantity")
	private Long quantity;

	@OneToMany(mappedBy = "poitem")
	private List<GrnItemDetails> grn_items;

	@OneToOne(mappedBy = "poitems")
	private RateEntityDetails poItem;

}
