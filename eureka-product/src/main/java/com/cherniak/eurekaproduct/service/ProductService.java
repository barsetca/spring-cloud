package com.cherniak.eurekaproduct.service;


import com.cherniak.common.ProductDto;
import com.cherniak.eurekaproduct.model.Product;
import com.cherniak.eurekaproduct.perository.ProductRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public ProductDto getProductById(long id){
        Product product = findById(id).orElseThrow(() ->
            new IllegalArgumentException("Product by id = " + id + " not exists"));
        return new ProductDto(product.getId(), product.getTitle(), product.getCost());
    }

    public Page<Product> findAll(Specification<Product> spec, int page, int size) {
        return productRepository.findAll(spec, PageRequest.of(page, size));
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<ProductDto> getAllFromProducts() {
        return findAll().stream().map(p -> new ProductDto(p.getId(), p.getTitle(), p.getCost())).collect(
            Collectors.toList());
    }



    @Transactional
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    public void deleteAll() {
        productRepository.deleteAll();
    }

    @Transactional
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public boolean existsById(Long id){
        return productRepository.existsById(id);
    }

    public boolean existsByTitle(String title){
        return productRepository.existsByTitle(title);
    }

}
