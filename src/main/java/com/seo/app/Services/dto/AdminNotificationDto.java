package com.seo.app.Services.dto;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminNotificationDto {
    private int notificationId;
    private String user;
    private String title;
    private String body;
    private String time;
}
