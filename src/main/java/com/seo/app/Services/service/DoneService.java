package com.seo.app.Services.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seo.app.Services.domain.DoneServiceDomain;
import com.seo.app.Services.dto.DoneServiceDto;
import com.seo.app.Services.repository.DoneServiceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoneService {
    private final Logger log = LoggerFactory.getLogger(DoneService.class);

    @Autowired
    private DoneServiceRepository doneServiceRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public String addDoneService(DoneServiceDto doneServiceDto){
        String responseMessage;
        DoneServiceDomain doneServiceDomain=objectMapper.convertValue(doneServiceDto,DoneServiceDomain.class);
        doneServiceRepository.save(doneServiceDomain);
        responseMessage="SEO Done";
        log.info(responseMessage);
        return responseMessage;
    }

    public DoneServiceDto done(int id){
        DoneServiceDomain doneServiceDomain=doneServiceRepository.findById(id);
        DoneServiceDto doneServiceDto=new DoneServiceDto();
        doneServiceDto.setWebsite_name(doneServiceDomain.getWebsiteName());
        doneServiceDto.setWebsite_url(doneServiceDomain.getWebsiteUrl());
        doneServiceDto.setId(doneServiceDomain.getId());
        doneServiceDto.setGuidance(doneServiceDomain.getGuidance());
        return doneServiceDto;
    }
}
