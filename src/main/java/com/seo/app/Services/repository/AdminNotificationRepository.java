package com.seo.app.Services.repository;

import com.seo.app.Services.domain.AdminNotificationDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminNotificationRepository extends JpaRepository<AdminNotificationDomain, Integer> {
    List<AdminNotificationDomain> findAllByUser(int id);
}
