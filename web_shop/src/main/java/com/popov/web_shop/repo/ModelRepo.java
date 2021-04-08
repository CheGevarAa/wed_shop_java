package com.popov.web_shop.repo;

import com.popov.web_shop.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ModelRepo extends JpaRepository<Model, Long>{
}
