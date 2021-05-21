package com.seo.app.Services.controller;

import com.seo.app.Services.domain.SeoRequestDomain;
import com.seo.app.Services.dto.DoneServiceDto;
import com.seo.app.Services.dto.ProgressDto;
import com.seo.app.Services.dto.SeoRequestDto;
import com.seo.app.Services.service.DoneService;
import com.seo.app.Services.service.ProgressService;
import com.seo.app.Services.service.SeoRequestService;
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

    @RequestMapping(value = "/show/progress", method = RequestMethod.POST)
    public List<ProgressDto> showProgress(@RequestParam(value = "id") int id){
        log.info("POST Call received at Progress/progress to User" + id);
        return progressService.getProgress(id);
    }

    @PostMapping(path = "/done")
    public String doneSeo(@RequestBody DoneServiceDto doneServiceDto) {
        log.info("POST Call received at SEO/done seo with DTO" + doneServiceDto);
        return doneService.addDoneService(doneServiceDto);
    }

    @RequestMapping(value = "/done/seo", method = RequestMethod.POST)
    public DoneServiceDto showSeo(@RequestParam(value = "id") int id){
        log.info("POST Call received at Seo/seo to User" + id);
        return doneService.done(id);
    }
}
