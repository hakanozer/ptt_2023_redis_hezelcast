package com.works.redisrepositories;

import com.works.redismodels.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import java.util.List;

public interface NoteRedisRepository extends JpaRepository<Note, String> {

    //List<Note> findByTitleContainsOrDetailContains(String title, String detail);

}
