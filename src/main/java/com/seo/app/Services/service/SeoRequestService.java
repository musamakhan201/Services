package com.seo.app.Services.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seo.app.Services.domain.SeoRequestDomain;
import com.seo.app.Services.dto.SeoRequestDto;
import com.seo.app.Services.repository.SeoRequestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        responseMessage="Request Send to Admin against ID "+seoRequestDomain.getRequestId();
        log.info(responseMessage);
        return responseMessage;
    }
    public Iterable<SeoRequestDomain> getRequests() {
        return seoRequestRepository.findAll();
    }

    public List<SeoRequestDto> viewRequests(int id){
        List<SeoRequestDomain> requestDomains=seoRequestRepository.findAllByUser(id);
        log.info(requestDomains.toString());
        ArrayList<SeoRequestDto> list = new ArrayList<>();
        for(int i=0;i<requestDomains.size();i++)
        {
            SeoRequestDto requestDto=new SeoRequestDto();
            requestDto.setRequest_id(requestDomains.get(i).getRequestId());
            requestDto.setWebsite_name(requestDomains.get(i).getWebsiteName());
            requestDto.setWebsite_url(requestDomains.get(i).getWebsiteUrl());
            requestDto.setLogin_password(requestDomains.get(i).getLoginPassword());
            requestDto.setLogin_username(requestDomains.get(i).getLoginUsername());
            requestDto.setDeadline(requestDomains.get(i).getDeadlineTime());
            requestDto.setAdditional_comment(requestDomains.get(i).getAdditionalComment());
            requestDto.setKeywords(requestDomains.get(i).getKeywords());
            requestDto.set_time(requestDomains.get(i).getTime());
            log.info(requestDto.toString());
            list.add(requestDto);
            log.info(list.toString());
        }
        return list;
    }
    public String delete(int id)
    {
        SeoRequestDomain seoRequestDomain=seoRequestRepository.findById(id);
        seoRequestRepository.delete(seoRequestDomain);
        return "deleted";
    }

}
