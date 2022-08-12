package com.fullteam.configuration;

import com.fullteam.dao.InMemoryTeamDao;
import com.fullteam.dao.TeamDao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class InMemoryDataConfig {
    @Bean
    @Scope("singleton") // this is needed for in-memory persistence
    public TeamDao getTeamDao() {
        return new InMemoryTeamDao();
    }
}
