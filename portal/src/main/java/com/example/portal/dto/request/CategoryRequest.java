package com.example.portal.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CategoryRequest {
	@JsonProperty("category_name")
	private String categoryName;
	@JsonProperty("category_description")
	private String categoryDescription;

}
