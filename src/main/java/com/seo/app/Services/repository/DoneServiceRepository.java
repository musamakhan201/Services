package com.seo.app.Services.repository;

import com.seo.app.Services.domain.DoneServiceDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoneServiceRepository extends JpaRepository<DoneServiceDomain, Integer> {
    DoneServiceDomain findById(int id);
}
