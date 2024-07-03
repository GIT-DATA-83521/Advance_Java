package com.sunbeam.Bean;

import com.sunbeam.dao.CandidateDao;
import com.sunbeam.dao.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class DeleteCandBean {
	private int id;
	private int count;
	public DeleteCandBean() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void deleteCandidate()
	{
		try(CandidateDao candDao = new CandidateDaoImpl()){
			count=candDao.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
