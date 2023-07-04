package com.works.services;

import com.works.entities.Product;
import com.works.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    final ProductRepository productRepository;
    //final CacheManager cacheManager;

    @CacheEvict(value = "productx", allEntries = true)
    public Product save( Product product ) {
        //cacheManager.getCache("product").clear();
        return productRepository.save(product);
    }

    @Cacheable(value = "productx")
    public List<Product> all() {
        return productRepository.findAll();
    }
    @CacheEvict(value = "productx", allEntries = true)
    public void delete(Long pid) {
        try {
            Optional<Product> optionalProduct = productRepository.findById(pid);
            if (optionalProduct.isPresent()) {
                productRepository.deleteById(pid);
            }
        }catch (Exception ex) {}
    }

}
