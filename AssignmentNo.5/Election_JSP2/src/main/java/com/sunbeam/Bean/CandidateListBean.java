package com.sunbeam.Bean;

import java.util.ArrayList;
import java.util.List;

import com.sunbeam.dao.CandidateDao;
import com.sunbeam.dao.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class CandidateListBean {
	private List<Candidate> candidateList;
	public CandidateListBean() {
		this.candidateList = new ArrayList<Candidate>();
	}
	public List<Candidate> getCandidateList() {
		return candidateList;
	}
	public void setCandidateList(List<Candidate> candidateList) {
		this.candidateList = candidateList;
	}
	public void fetchCandidates() {
		try(CandidateDao candDao = new CandidateDaoImpl()) {
			candidateList = candDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
