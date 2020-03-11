package com.digdaya.spring.service;

import com.digdaya.spring.model.Product;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ProductService {

    Product save(Product product);
    Optional<Product> get(Long id);
    Page<Product> getProductsByPage(Integer pageNumber, Integer pageSize);
    void update(Product product);
    void delete(Long id);
}
