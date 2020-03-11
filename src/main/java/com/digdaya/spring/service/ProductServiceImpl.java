package com.digdaya.spring.service;

import com.digdaya.spring.dao.ProductDaoRepository;
import com.digdaya.spring.model.Category;
import com.digdaya.spring.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    final static Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    private ProductDaoRepository productDaoRepository;

    @Autowired
    public ProductServiceImpl(ProductDaoRepository productDaoRepository) {
        this.productDaoRepository = productDaoRepository;
    }

    @Override
    public Product save(Product product) {
        Category category = null;
        Category parentCategory = null;

        if(product.getCategory() == null) {
            logger.info("Product Category is null :");
        } else {
            logger.info("Product Category is not null :" + product.getCategory());
            logger.info("Product Category is not null ID :" + product.getCategory().getId());
        }

        if(product.getParentCategory() == null) {
            logger.info("Product Parent Category is null :");
        } else {
            logger.info("Product Parent Category is not null :" + product.getParentCategory());
            logger.info("Product Parent Category is not null ID :" + product.getParentCategory().getId());
        }

        return productDaoRepository.save(product);
    }

    @Override
    public Optional<Product> get(Long id) {
        return productDaoRepository.findById(id);
    }

    @Override
    public Page<Product> getProductsByPage(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("productCode").descending());
        return productDaoRepository.findAll(pageable);
    }

    @Override
    public void update(Product product) {
        productDaoRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productDaoRepository.deleteById(id);
    }
}
