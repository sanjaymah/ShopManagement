package com.shopping.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shopping.model.Shop;

@Repository
public interface ShopRepository extends CrudRepository<Shop,Long> {
        
        Shop findByName(String name);

}
