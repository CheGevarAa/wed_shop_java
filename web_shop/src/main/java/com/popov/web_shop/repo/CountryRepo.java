package com.popov.web_shop.repo;

import com.popov.web_shop.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CountryRepo extends JpaRepository<Country, Long>{
}
