package com.fullteam.repository;

import com.fullteam.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile,Long> {

    Profile findByUsername(String username);
}
