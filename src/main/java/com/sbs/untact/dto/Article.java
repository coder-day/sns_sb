package com.sbs.untact.dto;


import lombok.Data;
import lombok.AllArgsConstructor;

public @AllArgsConstructor
@Data
class Article {
	private int id;
	private String regDate;
	private String updateDate;
	private String title;
	private String body;
}
