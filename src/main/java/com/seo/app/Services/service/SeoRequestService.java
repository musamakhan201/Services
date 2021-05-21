package com.seo.app.Services.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seo.app.Services.domain.SeoRequestDomain;
import com.seo.app.Services.dto.SeoRequestDto;
import com.seo.app.Services.repository.SeoRequestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeoRequestService {
    private final Logger log = LoggerFactory.getLogger(SeoRequestService.class);

    @Autowired
    private SeoRequestRepository seoRequestRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public String requestService(SeoRequestDto seoRequestDto){
        String responseMessage;
        SeoRequestDomain seoRequestDomain=objectMapper.convertValue(seoRequestDto,SeoRequestDomain.class);
        seoRequestRepository.save(seoRequestDomain);
        responseMessage="Request Send to Admin";
        log.info(responseMessage);
        return responseMessage;
    }
    public Iterable<SeoRequestDomain> getRequests() {
        return seoRequestRepository.findAll();
    }
}
