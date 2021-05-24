package com.seo.app.Services.dto;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoneServiceDto {
    private int seo_id;
    private String website_name;
    private String website_url;
    private String guidance;
    private int user;
}
