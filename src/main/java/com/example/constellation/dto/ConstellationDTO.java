package com.example.constellation.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConstellationDTO {
	private Integer month;
	private String name;
	private String engName;
	private String description;
	private String imageURL;
}
