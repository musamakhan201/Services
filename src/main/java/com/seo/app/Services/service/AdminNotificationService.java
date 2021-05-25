package com.seo.app.Services.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seo.app.Services.domain.AdminNotificationDomain;
import com.seo.app.Services.dto.AdminNotificationDto;
import com.seo.app.Services.repository.AdminNotificationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminNotificationService {
    private final Logger log = LoggerFactory.getLogger(AdminNotificationService.class);

    @Autowired
    private AdminNotificationRepository adminNotificationRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public String addNotification(AdminNotificationDto adminNotificationDto){
        String responseMessage;
        AdminNotificationDomain adminNotificationDomain=objectMapper.convertValue(adminNotificationDto,AdminNotificationDomain.class);
        adminNotificationRepository.save(adminNotificationDomain);
        responseMessage="Notification Send";
        log.info(responseMessage);
        return responseMessage;
    }

    public List<AdminNotificationDto> showNotification(int id){
        List<AdminNotificationDomain> requestDomains=adminNotificationRepository.findAllByUser(id);
        log.info(requestDomains.toString());
        ArrayList<AdminNotificationDto> list = new ArrayList<>();
        for(int i=0;i<requestDomains.size();i++)
        {
            AdminNotificationDto adminNotificationDto=new AdminNotificationDto();
            adminNotificationDto.setNotificationId(requestDomains.get(i).getNotificationId());
            adminNotificationDto.setTitle(requestDomains.get(i).getTitle());
            adminNotificationDto.setBody(requestDomains.get(i).getBody());
            adminNotificationDto.setTime(requestDomains.get(i).getDate_time());
            adminNotificationDto.setUser(requestDomains.get(i).getUser());
            adminNotificationDto.setStatus(requestDomains.get(i).isStatus());
            list.add(adminNotificationDto);
            log.info(list.toString());
        }
        return list;
    }

    public String seen(int id)
    {
        AdminNotificationDomain adminNotificationDomain=adminNotificationRepository.findById(id);
        adminNotificationDomain.setStatus(true);
        adminNotificationRepository.save(adminNotificationDomain);
        String responseMessage = "Seen";
        log.info(responseMessage);
        return responseMessage;
    }
}
