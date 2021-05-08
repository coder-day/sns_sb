package com.sbs.untact.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sbs.untact.dto.Article;
import com.sbs.untact.util.Util;

@Service
public class ArticleService {
	//게시물 저장 배열
	private List<Article> articles;
	// 글번호 전역변수
	private int articleLastId;
	
	//초기화 
	public ArticleService() {
		articles = new ArrayList<>();
		articleLastId = 0;
		//글 자동 생성
		makeTestData();
	}
	// 게시물 GET ID로 호출 함수
	
	public Article getArticleById(int id) {
		
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
	public void makeTestData() {
		for (int i = 0; i < 10; i++) {
			writeArticle("제목1","내용1");
		}
	}
	

	//게시물 수정 함수
	public boolean modifyArticle(int id, String title, String body) {
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
	public int writeArticle(String title, String body) {
		
		int id = articleLastId + 1;
		String regDate = Util.getNowDateStr();
		String updateDate = Util.getNowDateStr();
		
		Article article = new Article(id, regDate, updateDate, title, body);
		articles.add(article);
		articleLastId = id;
		
		return id;
	}
	
	// 게시물 삭제 함수
	public boolean deleteArticleById(int id) {
		
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
