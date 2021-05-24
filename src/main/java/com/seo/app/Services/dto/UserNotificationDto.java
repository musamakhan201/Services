package com.seo.app.Services.dto;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserNotificationDto {
    private int notificationId;
    private int user;
    private String title;
    private String body;
    private boolean status;
}
