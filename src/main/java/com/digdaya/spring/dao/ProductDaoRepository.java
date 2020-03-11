package com.digdaya.spring.dao;

import com.digdaya.spring.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductDaoRepository extends PagingAndSortingRepository<Product, Long> {

}
