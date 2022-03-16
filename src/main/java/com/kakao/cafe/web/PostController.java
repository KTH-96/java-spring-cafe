package com.kakao.cafe.web;

import com.kakao.cafe.domain.posts.Post;
import com.kakao.cafe.domain.user.User;
import com.kakao.cafe.service.PostsService;
import com.kakao.cafe.web.dto.PostRegisterDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/qna")
public class PostController {
    private static final String SESSION_USER = "loginUser";
    private static Logger log = LoggerFactory.getLogger(PostController.class);
    private final PostsService postsService;

    @Autowired
    public PostController(PostsService postsService) {
        this.postsService = postsService;
    }

    @GetMapping("/form")
    public String form() {
        log.info("게시글 등록하기 폼 불러오기");
        return "qna/form";
    }

    @PostMapping("/form")
    public String registration(PostRegisterDto dto, HttpSession session) {
        log.info("게시글 등록하기");
        User user = (User) session.getAttribute(SESSION_USER);
        if (user == null) {
            return "redirect:/user/login";
        }
        Post post = new Post();
        post.writePost(user.getName(), dto.getTitle(), dto.getContents());
        postsService.qnaRegister(post);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String showContent(@PathVariable Long id, Model model) {
        log.info("게시글 번호 = {} 로 게시글 상세확인하기~", id);
        model.addAttribute("post", postsService.findPost(id));
        return "qna/show";
    }
}
