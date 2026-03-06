package com.aranna.project5_e_commerce.service;

import com.aranna.project5_e_commerce.entity.Product;
import com.aranna.project5_e_commerce.model.ProductResponse;
import com.aranna.project5_e_commerce.repo.ProductRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class ProductServiceImple implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    private ProductResponse mapToResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .image(product.getImage())
                .price(product.getPrice())
                .brand(product.getBrand())
                .type(product.getType())
                .build();
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        log.info("Fetching all products.");
        return productRepo.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponse getProductById(Integer id) {
        log.info("Fetching product id: {}", id);
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        return mapToResponse(product);
    }

    @Override
    public Page<ProductResponse> getProducts(Pageable pageable, Integer brandId, Integer typeId, String keyword) {
        log.info("Fetching products with filters - Brand: {}, Type: {}, Keyword: {}", brandId, typeId, keyword);

        Specification<Product> spec = Specification.where((Specification<Product>) null);

        if (brandId != null) {
            spec = spec.and((root, query, cb) -> cb.equal(root.get("brand").get("id"), brandId));
        }
        if (typeId != null) {
            spec = spec.and((root, query, cb) -> cb.equal(root.get("type").get("id"), typeId));
        }
        if (keyword != null && !keyword.isEmpty()) {
            spec = spec.and((root, query, cb) -> cb.like(root.get("name"), "%" + keyword + "%"));
        }
        return productRepo.findAll(spec, pageable).map(this::mapToResponse);
    }
}