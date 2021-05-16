package com.sbs.untact.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Article {
	private int id;
	private String regDate;
	private String updateDate;
	private int boardId;
	private int memberId;
	private String title;
	private String body;
	private boolean blindStatus;
    private String blindDate;
    private boolean delStatus;
    private String delDate;
    private int hitCount;
    private int repliesCount;
    private int likeCount;
    private int dislikeCount;
}
