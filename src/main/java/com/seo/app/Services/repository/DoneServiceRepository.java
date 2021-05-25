package com.seo.app.Services.repository;

import com.seo.app.Services.domain.DoneServiceDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoneServiceRepository extends JpaRepository<DoneServiceDomain, Integer> {
    List<DoneServiceDomain> findAllByUser(int id);
}
