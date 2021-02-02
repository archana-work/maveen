package com.ytp.mysql.demo.dao;

import org.springframework.data.repository.CrudRepository;
import com.ytp.mysql.demo.model.Product;

public interface ProductDao extends CrudRepository<Product, Integer> {


}


