package com.kakao.cafe.web;

import com.kakao.cafe.domain.posts.Post;
import com.kakao.cafe.domain.user.User;
import com.kakao.cafe.service.PostsService;
import com.kakao.cafe.web.dto.PostRegisterDto;
import com.kakao.cafe.web.dto.PostUpdateDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/qna")
public class PostController {
    private static final String SESSION_NAME = "sessionUser";
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
        User user = (User) session.getAttribute(SESSION_NAME);
        if (user == null) {
            return "redirect:/user/login";
        }
        Post post = new Post();
        post.writePost(user.getUserId(), dto.getTitle(), dto.getContents());
        postsService.qnaRegister(post);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String showContent(@PathVariable Long id, Model model) {
        log.info("게시글 번호 = {} 로 게시글 상세확인하기~", id);
        model.addAttribute("post", postsService.findPost(id));
        return "qna/show";
    }

    @GetMapping("/update_form")
    public String updateForm(Model model, HttpSession session) {
        log.info("수정 폼 입니다");
        User user = (User) session.getAttribute(SESSION_NAME);
        if (user == null) {
            return "redirect:/user/login";
        }
        Post post = postsService.findWriter(user.getUserId());
        if (!user.getUserId().equals(post.getWriter())) {
            log.info("수정 권한은 자신의 게시물에만 해당됩니다");
            return "redirect:/";
        }
        model.addAttribute("post", post);
        return "qna/update_form";
    }

    @PutMapping("/{writer}/update")
    public String update(@PathVariable String writer, PostUpdateDto dto, HttpSession session) {
        log.info("{}게시글 수정 하기", writer);
        User user = (User) session.getAttribute(SESSION_NAME);
        if (user == null) {
            return "redirect:/user/login";
        }
        Post post = postsService.findWriter(writer);
        post.updateContent(dto.getTitle(), dto.getContents());
        postsService.update(writer, post);
        return "redirect:/";
    }

    @DeleteMapping("/{writer}/delete")
    public String delete(@PathVariable String writer, HttpSession session) {
        log.info("{}게시글 삭제 하기", writer);
        User user = (User) session.getAttribute(SESSION_NAME);
        if (user == null || user.getUserId().equals(writer)) {
            log.info("세션시간이 만료되었거나 자신이 작성한 게시글이 아님");
            return "redirect:/user/login";
        }
        postsService.delete(writer);
        return "redirect:/";
    }
}
