package com.seo.app.Services.dto;

import lombok.*;


@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeoRequestDto {
    private int request_id;
    private String website_name;
    private String website_url;
    private String login_username;
    private String login_password;
    private String deadline;
    private String additional_comment;
    private String keywords;
    private String _time;
    private String url;
    private String host_name;
    private String host_password;
    private String type;
    private int user;

}
