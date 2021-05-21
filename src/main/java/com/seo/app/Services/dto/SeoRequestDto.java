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
    private String deadline;
    private String additional_comment;
    private int id;
}