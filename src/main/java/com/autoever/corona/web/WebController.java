package com.autoever.corona.web;


import com.autoever.corona.webservice.domain.PostsMainResponseDto;
import com.autoever.corona.webservice.domain.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class WebController {

    private PostsService postsService;

    @GetMapping("/") // @RequestMapping(value="/", method = RequestMethod.GET)
    public String main(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "main";
    }
}
