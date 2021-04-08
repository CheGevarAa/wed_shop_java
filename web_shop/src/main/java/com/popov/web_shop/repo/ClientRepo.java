package com.popov.web_shop.repo;

import com.popov.web_shop.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ClientRepo extends JpaRepository<Client, Long>{
}
