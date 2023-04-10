package com.ssh.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssh.example.demo.repository.ArticleRepository;
import com.ssh.example.demo.util.Utility;
import com.ssh.example.demo.vo.Article;
import com.ssh.example.demo.vo.ResultData;

@Service
public class ArticleService {
	
	private ArticleRepository articleRepository;
	
	@Autowired
	public ArticleService (ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}
	
	
	public ResultData<Integer> writeArticle(String title, String body) {
		articleRepository.writeArticle(title, body);
		int id = articleRepository.getLastInsertId();
		return ResultData.from("S-1", Utility.f("%d번 게시물이 생성되었습니다", id), id);
	}
	
	public Article getArticle(int id) {
		return articleRepository.getArticle(id);
	}

	public void deleteArticle(int id) {
		articleRepository.deleteArticle(id);
	}

	public ResultData<Article> modifyArticle(int id, String title, String body) {
		articleRepository.modifyArticle(id, title, body);
		
		Article article = getArticle(id);
		
		return ResultData.from("S-1", Utility.f("%d번 게시물을 수정했습니다", id), "article", article);
	}

	public List<Article> getArticles() {
		return articleRepository.getArticles();
	}

	
	public ResultData actorCanModify(int loginedMemberId, Article article) {
		
		if(loginedMemberId != article.getMemberId()) {
			return ResultData.from("F-B", "해당 게시물에 대한 권한이 없습니다");
		}
		
		return ResultData.from("S-1", "수정 가능");
	}

	
}