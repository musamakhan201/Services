package com.seo.app.Services.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seo.app.Services.domain.UserNotificationDomain;
import com.seo.app.Services.dto.UserNotificationDto;
import com.seo.app.Services.repository.UserNotificationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserNotificationService {
    private final Logger log = LoggerFactory.getLogger(UserNotificationService.class);

    @Autowired
    private UserNotificationRepository userNotificationRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public String addNotification(UserNotificationDto userNotificationDto){
        String responseMessage;
        UserNotificationDomain userNotificationDomain=objectMapper.convertValue(userNotificationDto,UserNotificationDomain.class);
        userNotificationRepository.save(userNotificationDomain);
        responseMessage="Notification Send";
        log.info(responseMessage);
        return responseMessage;
    }

    public Iterable<UserNotificationDomain> getNotifications() {
        return userNotificationRepository.findAll();
    }
}
