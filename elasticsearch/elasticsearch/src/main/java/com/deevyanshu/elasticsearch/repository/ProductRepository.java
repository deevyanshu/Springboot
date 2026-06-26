package com.deevyanshu.elasticsearch.repository;

import com.deevyanshu.elasticsearch.Entity.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ElasticsearchRepository<Product,Integer> {
}
