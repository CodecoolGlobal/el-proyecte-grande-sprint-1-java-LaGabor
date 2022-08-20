package com.fullteam.service.dao;

import com.fullteam.model.Profile;

import java.util.List;

public interface ProfileDao {

    void addProfile(Profile profile);

    List<Integer> profileIds();

    Profile getProfile(int id);
}
