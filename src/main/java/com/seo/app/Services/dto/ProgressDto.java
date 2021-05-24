package com.seo.app.Services.dto;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProgressDto {
    private int progress_id;
    private String percentage;
    private int user;
    private String _time;
}
