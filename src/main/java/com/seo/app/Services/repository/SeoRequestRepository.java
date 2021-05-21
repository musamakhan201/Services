package com.seo.app.Services.repository;

import com.seo.app.Services.domain.SeoRequestDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeoRequestRepository extends JpaRepository<SeoRequestDomain,Integer> {
}
