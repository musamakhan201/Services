package com.seo.app.Services.controller;

import com.seo.app.Services.domain.SeoRequestDomain;
import com.seo.app.Services.domain.UserNotificationDomain;
import com.seo.app.Services.dto.*;
import com.seo.app.Services.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("seo")
public class Controller {
    private final Logger log = LoggerFactory.getLogger(Controller.class);

    @Autowired
    private SeoRequestService seoRequestService;

    @Autowired
    private ProgressService progressService;

    @Autowired
    private DoneService doneService;

    @Autowired
    private AdminNotificationService adminNotificationService;

    @Autowired
    private UserNotificationService userNotificationService;

    @PostMapping(path = "/service")
    public String getStatus(@RequestBody SeoRequestDto seoRequestDto) {
        log.info("POST Call received at Requests/add request with DTO" + seoRequestDto);
        return seoRequestService.requestService(seoRequestDto);
    }

    @RequestMapping(value = "/service",method = RequestMethod.GET)
    public Iterable<SeoRequestDomain> getServices(){
        return seoRequestService.getRequests();
    }

    @PostMapping(path = "/progress")
    public String progress(@RequestBody ProgressDto progressDto) {
        log.info("POST Call received at Progress/add progress with DTO" + progressDto);
        return progressService.addProgress(progressDto);
    }

    @RequestMapping(value = "/view/request", method = RequestMethod.POST)
    public List<SeoRequestDto> showRequests(@RequestParam(value = "user") int id){
        log.info("POST Call received at User/requests to User" + id);
        return seoRequestService.viewRequests(id);
    }

    @RequestMapping(value = "/delete/request", method = RequestMethod.POST)
    public String deleteRequests(@RequestParam(value = "id") int id){
        log.info("POST Call received at User/requests to User" + id);
        return seoRequestService.delete(id);
    }

    @RequestMapping(value = "/show/progress", method = RequestMethod.POST)
    public List<ProgressDto> showProgress(@RequestParam(value = "user") int id){
        log.info("POST Call received at Progress/progress to User" + id);
        return progressService.getProgress(id);
    }

    @PostMapping(path = "/done")
    public String doneSeo(@RequestBody DoneServiceDto doneServiceDto) {
        log.info("POST Call received at SEO/done seo with DTO" + doneServiceDto);
        return doneService.addDoneService(doneServiceDto);
    }

    @RequestMapping(value = "/done/seo", method = RequestMethod.POST)
    public DoneServiceDto showSeo(@RequestParam(value = "user") int id){
        log.info("POST Call received at Seo/seo to User" + id);
        return doneService.done(id);
    }

    @PostMapping(path = "/admin/notify")
    public String adminNotification(@RequestBody AdminNotificationDto adminNotificationDto) {
        log.info("POST Call received at Admin/add notification with DTO" + adminNotificationDto);
        return adminNotificationService.addNotification(adminNotificationDto);
    }

    @PostMapping(path = "/user/notify")
    public String userNotification(@RequestBody UserNotificationDto userNotificationDto) {
        log.info("POST Call received at User/add notification with DTO" + userNotificationDto);
        return userNotificationService.addNotification(userNotificationDto);
    }

    @RequestMapping(value = "/admin/view/notification", method = RequestMethod.POST)
    public List<AdminNotificationDto> showNotifications(@RequestParam(value = "user") int id){
        log.info("POST Call received at Notification/Notification to User" + id);
        return adminNotificationService.showNotification(id);
    }

    @RequestMapping(value = "/admin/seen", method = RequestMethod.POST)
    public String setSeen(@RequestParam(value = "user") int id){
        log.info("POST Call received at Notification/Notification to User" + id);
        return adminNotificationService.seen(id);
    }

    @RequestMapping(value = "/user/seen", method = RequestMethod.POST)
    public String userSeen(@RequestParam(value = "user") int id){
        log.info("POST Call received at Notification/Notification to User" + id);
        return userNotificationService.seen(id);
    }

    @RequestMapping(value = "/user/view/notification",method = RequestMethod.GET)
    public Iterable<UserNotificationDomain> getNotifications(){
        return userNotificationService.getNotifications();
    }
}
