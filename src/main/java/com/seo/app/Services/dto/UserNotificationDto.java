package com.seo.app.Services.dto;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserNotificationDto {
    private int notificationId;
    private String user;
    private String title;
    private String body;
    private String current_time;
}
