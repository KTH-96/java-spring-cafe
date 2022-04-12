package com.kakao.cafe.web.dto;

public class PostRegisterDto {
    private String title;
    private String contents;

    public PostRegisterDto(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }
}
