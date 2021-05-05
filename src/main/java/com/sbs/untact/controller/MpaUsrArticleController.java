package com.sbs.untact.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbs.untact.util.Util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Controller
public class MpaUsrArticleController {
	private int articleLastId = 0;

	@RequestMapping("/mpaUsr/article/doWrite")
	@ResponseBody
//	public Map<String, Object> doWrite(String title, String body) {
	public ResultData doWrite(String title, String body) {
		int id = articleLastId + 1;
		String regDate = Util.getNowDateStr();
		String updateDate = Util.getNowDateStr();

		Article article = new Article(id, regDate, updateDate, title, body);

		articleLastId = id;

//		Map<String, Object> rsData = new HashMap<>();
//		rsData.put("resultCode", "S-1");
//		rsData.put("msg", id + "번 글이 작성 되었습니다.");
//		rsData.put("article", article);
//		return rsData;
		
		return new ResultData("S-1", id + "번 글이 작성 되었습니다.", article);
	}
}

@AllArgsConstructor
@Data
class ResultData {
	private String resultData;
	private String msg;
	private Article article;
}


class Article {
	private int id;
	private String regDate;
	private String updateDate;
	private String title;
	private String body;

	public Article(int id, String regDate, String updateDate, String title, String body) {
		super();
		this.id = id;
		this.regDate = regDate;
		this.updateDate = updateDate;
		this.title = title;
		this.body = body;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", regDate=" + regDate + ", updateDate=" + updateDate + ", title=" + title
				+ ", body=" + body + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
