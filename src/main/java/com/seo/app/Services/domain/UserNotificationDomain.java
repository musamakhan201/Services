package com.seo.app.Services.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@ToString
@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name = "user_notifications")
public class UserNotificationDomain {
    private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("notification_id")
    @Column(name = "notification_id")
    private int notificationId;
    private String user;
    private String title;
    private String body;
    private String current_time;
    public UserNotificationDomain() {
        ZonedDateTime utc = ZonedDateTime.now(ZoneOffset.UTC);
        current_time = utc.format(DateTimeFormatter.ofPattern(DATETIME_FORMAT));
    }
}
