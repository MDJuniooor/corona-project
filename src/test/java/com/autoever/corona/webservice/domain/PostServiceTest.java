package com.autoever.corona.webservice.domain;

import com.autoever.corona.webservice.domain.post.application.PostsService;
import com.autoever.corona.webservice.domain.post.domain.Posts;
import com.autoever.corona.webservice.domain.post.dao.PostsRepository;
import com.autoever.corona.webservice.domain.post.dto.PostsSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostServiceTest {

    @Autowired
    private PostsService postsService;

    @Autowired
    private PostsRepository postsRepository;

    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void saveDtoDataInPostsTable(){
        //given
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                .author("mmdsds@naver.com")
                .content("test")
                .title("test title")
                .build();

        //when
        postsService.save(dto);

        //then
        Posts posts = postsRepository.findAll().get(0);
        assertThat(posts.getAuthor(), is(dto.getAuthor()));
        assertThat(posts.getContent(), is(dto.getContent()));
        assertThat(posts.getTitle(), is(dto.getTitle()));
    }
}
