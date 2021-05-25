package com.seo.app.Services.repository;

import com.seo.app.Services.domain.UserNotificationDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserNotificationRepository extends JpaRepository<UserNotificationDomain, Integer> {
    UserNotificationDomain findById(int id);
}