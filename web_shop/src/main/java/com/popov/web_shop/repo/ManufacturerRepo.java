package com.popov.web_shop.repo;

import com.popov.web_shop.entity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ManufacturerRepo extends JpaRepository<Manufacturer, Long>{
}
