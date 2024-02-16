package com.example.portal.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AddFavoriteDto {
	@JsonProperty("user_id")
	Long userId;
	@JsonProperty("course_id")
	Long courseId;

}
