package com.seo.app.Services.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seo.app.Services.domain.DoneServiceDomain;
import com.seo.app.Services.dto.DoneServiceDto;
import com.seo.app.Services.repository.DoneServiceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<DoneServiceDto> done(int id){
        List<DoneServiceDomain> doneServiceDomain=doneServiceRepository.findAllByUser(id);
        ArrayList<DoneServiceDto> list = new ArrayList<>();
        for(int i=0;i<doneServiceDomain.size();i++) {
            DoneServiceDto doneServiceDto = new DoneServiceDto();
            doneServiceDto.setWebsite_name(doneServiceDomain.get(i).getWebsiteName());
            doneServiceDto.setWebsite_url(doneServiceDomain.get(i).getWebsiteUrl());
            doneServiceDto.setUser(doneServiceDomain.get(i).getUser());
            doneServiceDto.setGuidance(doneServiceDomain.get(i).getGuidance());
            list.add(doneServiceDto);
        }
        return list;
    }

    public Iterable<DoneServiceDomain> getDone() {
        return doneServiceRepository.findAll();
    }
}
