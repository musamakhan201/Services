package com.seo.app.Services.repository;

import com.seo.app.Services.domain.ProgressDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgressRepository extends JpaRepository<ProgressDomain,Integer> {
   List<ProgressDomain> findAllByUser(int id);
}
