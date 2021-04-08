package com.popov.web_shop.repo;

import com.popov.web_shop.entity.ClientProfile;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ClientProfileRepo extends JpaRepository<ClientProfile, Long>{
}
