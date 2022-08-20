package com.fullteam.service;

import com.fullteam.model.Profile;
import com.fullteam.service.dao.ProfileDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    ProfileDao profileDao;

    @Autowired
    public ProfileService(ProfileDao profileDao) {
        this.profileDao = profileDao;
    }

    public void addProfile(Profile profile) {
        profileDao.addProfile(profile);
    }

    public Integer getFirstFreeId() {
        Integer id = 0;
        while (profileDao.profileIds().contains(id)) {
            id++;
        }
        return id;
    }

    public Profile getProfile(int id) {
        return profileDao.getProfile(id);
    }

}
