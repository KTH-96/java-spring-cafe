package com.kakao.cafe.web.dto;

public class PostUpdateDto {
    private String title;
    private String contents;

    public PostUpdateDto(String title, String contents) {
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
