package com.ssh.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssh.example.demo.service.ArticleService;
import com.ssh.example.demo.util.Utility;
import com.ssh.example.demo.vo.ResultData;

@Controller
public class UsrArticleController {

	private ArticleService articleService;
	
	@Autowired
	public UsrArticleController(ArticleService articleService) {
		this.articleService = articleService;
		
	}

	

	@RequestMapping("/usr/article/doWrite")
	@ResponseBody
	public ResultData<Integer> doWrite(String title, String body) {

		if (Utility.empty(title)) {
			return ResultData.from("F-1","제목을 입력해주세요");
		}
		if (Utility.empty(body)) {
			return ResultData.from("F-2","내용을 입력해주세요");
		}

		ResultData<Integer> writeArticleRd = articleService.writeArticle(title, body);

		int id = (Integer)writeArticleRd.getData1();

		return ResultData.from(writeArticleRd.getResultCode(),writeArticleRd.getMsg(), id);

	}
}