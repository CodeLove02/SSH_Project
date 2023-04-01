package com.ssh.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssh.example.demo.repository.ArticleRepository;
import com.ssh.example.demo.util.Utility;
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

	
}