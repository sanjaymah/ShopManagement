package com.shopping.service;

import java.util.Date;
import java.util.List;

public interface ShopService {
        
        void addAShop(String name, String cateory,String address, String owner );
        
        void deleteAShop(String name, Long id);
        
        List findShops();
        
       // long getGeneratedKey(String name,String category, String address, String owner);
        
}
