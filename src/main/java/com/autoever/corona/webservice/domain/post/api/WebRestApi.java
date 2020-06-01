package com.autoever.corona.webservice.domain.post.api;

import com.autoever.corona.webservice.domain.post.application.PostsService;
import com.autoever.corona.webservice.domain.post.dto.PostsSaveRequestDto;
import com.autoever.corona.webservice.domain.post.exception.BasicException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class WebRestApi {

    private PostsService postsService;

    @GetMapping("/hello")
    public String hello(){
        return "hell world";
    }

    @GetMapping("/exception")
    public void yieldException(){
        throw new BasicException("test Exception");
    }

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto){
        return postsService.save(dto);
    }
}