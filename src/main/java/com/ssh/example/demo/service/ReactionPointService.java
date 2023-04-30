package com.ssh.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssh.example.demo.repository.ReactionPointRepository;
import com.ssh.example.demo.vo.ReactionPoint;

@Service
public class ReactionPointService {
	private ReactionPointRepository reactionPointRepository;

	@Autowired
	public ReactionPointService(ReactionPointRepository reactionPointRepository) {
		this.reactionPointRepository = reactionPointRepository;
	}

	public ReactionPoint getReactionPoint(int loginedMemberId, int id) {
		return reactionPointRepository.getReactionPoint(loginedMemberId, id);
	}

	public int doGoodReactionPoint(int loginedMemberId, int id) {
		return reactionPointRepository.doGoodReactionPoint(loginedMemberId, id);
	}

	public int doBadReactionPoint(int loginedMemberId, int id) {
		return reactionPointRepository.doBadReactionPoint(loginedMemberId, id);
	}
	
	
}