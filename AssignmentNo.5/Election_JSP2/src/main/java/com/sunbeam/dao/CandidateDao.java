package com.sunbeam.dao;



import java.util.List;

import com.sunbeam.pojos.Candidate;

public interface CandidateDao extends AutoCloseable {
	public int updatePassword(String newPassword,int candId) throws Exception;
	int deleteById(int id) throws Exception;
	public Candidate findById(int id) throws Exception ;
	List<Candidate> findAll() throws Exception;
	int incrementVote(int candidateId) throws Exception;
	List<Candidate> findByParty(String givenParty) throws Exception;
	int save(Candidate c) throws Exception;
	int update(Candidate c) throws Exception;
	List<Candidate> getCandidatewiseVotes() throws Exception;
}