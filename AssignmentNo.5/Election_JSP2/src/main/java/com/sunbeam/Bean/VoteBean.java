package com.sunbeam.Bean;

import com.sunbeam.dao.CandidateDao;
import com.sunbeam.dao.CandidateDaoImpl;
import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoImpl;
import com.sunbeam.pojos.User;


public class VoteBean {

    private User user;
    private int id;
    private int count;
    private int uid; 
    

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
    
   
    public void setUid(int uid) {
        this.uid = uid;
    }

    public VoteBean() {
        
    }

    public void incrementVote() {
        if (checkStatus()) {
            try (CandidateDao candDao = new CandidateDaoImpl()) {
                count = candDao.incrementVote(id);
            } catch (Exception e) {
                e.printStackTrace();
            }

            try (UserDao userDao = new UserDaoImpl()) {
                userDao.updateStatus(uid, true); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean checkStatus() {
        try (UserDao userDao = new UserDaoImpl()) {
            user = userDao.findById(uid);
            return user.getStatus() == 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}