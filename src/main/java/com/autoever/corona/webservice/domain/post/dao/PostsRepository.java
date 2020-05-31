package com.autoever.corona.webservice.domain.post.dao;

import com.autoever.corona.webservice.domain.post.domain.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts as p ORDER BY p.id DESC")
    Stream<Posts> findAllDesc();
}
