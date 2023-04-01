package com.ssh.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleRepository {

	public void writeArticle(String title, String body);
	
	public int getLastInsertId();
	
}