package com.seo.app.Services.repository;

import com.seo.app.Services.domain.SeoRequestDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeoRequestRepository extends JpaRepository<SeoRequestDomain,Integer> {
    List<SeoRequestDomain> findAllByUser(int id);
    SeoRequestDomain findById(int id);
}
