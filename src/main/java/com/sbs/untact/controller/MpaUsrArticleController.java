package com.sbs.untact.controller;


import java.util.List;
import java.util.ArrayList;


import com.sbs.untact.dto.Article;
import com.sbs.untact.dto.ResultData;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbs.untact.util.Util;

@Controller
public class MpaUsrArticleController {
	//게시물 저장 배열
	private List<Article> articles;
	// 글번호 전역변수
	private int articleLastId;
	
	//초기화 
	public MpaUsrArticleController() {
		articles = new ArrayList<>();
		articleLastId = 0;
		//글 자동 생성
		makeTestData();
	}

	
	// 게시물 쓰기
	@RequestMapping("/mpaUsr/article/doWrite")
	@ResponseBody
	public ResultData doWrite(String title, String body) {
		int id = writeArticle(title, body);

		Article article = getArticleById(id);
		return new ResultData("S-1", id + "번 글이 작성되었습니다.", "article", article);
	}
	
	
	// 게시물 수정
	@RequestMapping("/mpaUsr/article/doModify")
	@ResponseBody
	public ResultData doModify(int id, String title, String body) {
		boolean modified = modifyArticle(id,title, body);
		if ( modified  == false ) {
			return new ResultData("F-1", id + "번 글이 없습니다.", "id", id);
		}
		return new ResultData("S-1", id + "번 글이 수정 되었습니다.","article", getArticleById(id));	
	}

	// 게시물 삭제
	@RequestMapping("/mpaUsr/article/doDelete")
	@ResponseBody
	public ResultData doDelete(int id) {
		boolean deleted = deleteArticleById(id);

		if ( deleted  == false ) {
			return new ResultData("F-1", id + "번 글이 없습니다.", "id", id);
		}
		return new ResultData("S-1", id + "번 글이 삭제 되었습니다.","id", id);
	}

	



	// GET 게시물 호출
	@RequestMapping("/mpaUsr/article/getArticle")
	@ResponseBody
	public ResultData getArticle(int id) {
		
		Article article = getArticleById(id);
		
		if ( article == null ) {
			return new ResultData("F-1", id + "번 글은 존재 하지 않습니다.", "id", id);
		}
		return new ResultData("S-1", article.getId() + "번 글입니다.", "article", article);
	}

	
	// 게시물 GET ID로 호출 함수
	
	private Article getArticleById(int id) {
		
		//리스트 반복-> 향상된 for문
		for ( Article article : articles ) {
			if (article.getId() == id ) {
				return article;
			}
		}
		//리스트 반복 정석
//		for ( int i = 0; i < articles.size(); i++) {
//			Article article = articles.get(i);
//			
//			if ( article.getId() == id ) {
//				return article;
//			}
//		}
		
		return null;
	}
	// 시작시 자동 글 등록(테스트)
	private void makeTestData() {
		for (int i = 0; i < 10; i++) {
			writeArticle("제목1","내용1");
		}
	}
	

	//게시물 수정 함수
	private boolean modifyArticle(int id, String title, String body) {
		Article article = getArticleById(id);
		
		if ( article == null) {
			return false;
		}
		
		article.setUpdateDate(Util.getNowDateStr());
		article.setTitle(title);
		article.setBody(body);
		
		return true;
	}

	
	
	// 게시물 쓰기 함수
	private int writeArticle(String title, String body) {
		
		int id = articleLastId + 1;
		String regDate = Util.getNowDateStr();
		String updateDate = Util.getNowDateStr();
		
		Article article = new Article(id, regDate, updateDate, title, body);
		articles.add(article);
		articleLastId = id;
		
		return id;
	}
	
	// 게시물 삭제 함수
	private boolean deleteArticleById(int id) {
		
		Article article = getArticleById(id);
		
		if ( article == null) {
			return false;
		}
		
		articles.remove(article);
		return true;
		// articles.remove(1) --> 2번째 글 삭제
//		for ( Article article : articles ) {
//			if (article.getId() == id ) {
//				articles.remove(article);
//				return true;
//			}
//		}
//		
//		return false;
	}
}


