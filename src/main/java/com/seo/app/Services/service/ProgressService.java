package com.seo.app.Services.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seo.app.Services.domain.ProgressDomain;
import com.seo.app.Services.dto.ProgressDto;
import com.seo.app.Services.repository.ProgressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProgressService {
    private final Logger log = LoggerFactory.getLogger(ProgressService.class);

    @Autowired
    private ProgressRepository progressRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public String addProgress(ProgressDto progressDto){
        String responseMessage;
        ProgressDomain progressDomain=objectMapper.convertValue(progressDto,ProgressDomain.class);
        progressRepository.save(progressDomain);
        responseMessage="Progress Added";
        log.info(responseMessage);
        return responseMessage;
    }

    public List<ProgressDto> getProgress(int id){
        List<ProgressDomain> progressDomain=progressRepository.findAllByUser(id);
        log.info(progressDomain.toString());
        ArrayList<ProgressDto> progressList = new ArrayList<>();
        for(int i=0;i<progressDomain.size();i++)
        {
            ProgressDto progressDto=objectMapper.convertValue(progressDomain.get(i),ProgressDto.class);
            progressList.add(progressDto);
            log.info(progressList.toString());
        }
        return progressList;
    }
}
