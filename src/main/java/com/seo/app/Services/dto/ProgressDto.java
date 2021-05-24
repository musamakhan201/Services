package com.seo.app.Services.dto;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProgressDto {
    private int progressId;
    private String percentage;
    private int user;
    private String _time;
}
