package com.example.debitcreditproject.dto.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class LinkDto {
	@JsonProperty("urls")
	List<String> urls;
}
