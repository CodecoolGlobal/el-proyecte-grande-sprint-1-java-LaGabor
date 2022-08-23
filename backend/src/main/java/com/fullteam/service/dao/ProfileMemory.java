package com.fullteam.service.dao;

import com.fullteam.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class ProfileMemory implements ProfileDao {
    private Set<Profile> storage = new HashSet<>();

    @Autowired
    public ProfileMemory(List<Profile> storage) {
        this.storage = new HashSet<>(storage);
    }

    @Override
    public void addProfile(Profile profile) {
        storage.add(profile);
    }

    @Override
    public List<Integer> profileIds() {
        return storage.stream().map(Profile::getId).collect(Collectors.toList());
    }

    @Override
    public Profile getProfile(int id) {
        return storage.stream().filter(profile -> profile.getId() == id).findFirst().orElse(null);
    }
}
