package com.project1_spring_mvc_backend.project1_spring_mvc_backend.service;

import java.util.Date;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project1_spring_mvc_backend.project1_spring_mvc_backend.model.ProductModel;
import com.project1_spring_mvc_backend.project1_spring_mvc_backend.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductModel productModel;
    @Autowired
    public ProductRepository productRepository;

    ProductService(ProductModel productModel) {
        this.productModel = productModel;
    }

    public List<ProductModel> getAllProducts() {
        return productRepository.findAll();
    }

    public ProductModel addProduct(ProductModel product, MultipartFile image) throws Exception {

        product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());
        product.setImageData(image.getBytes());

        return productRepository.save(product);
    }

    public ProductModel findById(int productId) {
        return productRepository.findById(productId).orElse(null);
    }

    public String loadProduct() {
        List<ProductModel> products = new ArrayList<>();
        System.out.println(productRepository.findById(10001));
        // 1. GPU
        products.add(ProductModel.builder()
                .name("ROG Astral RTX 5090")
                .description("Flagship 32GB VRAM GPU")
                .brand("NVIDIA")
                .price(new BigDecimal("250000.00"))
                .category("Electronics")
                .releaseDate(getDateTime(2025, 1, 30))
                .productAvailable(true)
                .stockQuantity(50).build());

        // 2. CPU
        products.add(ProductModel.builder()
                .name("Core i7-14700K")
                .description("20-Core Unlocked Desktop Processor")
                .brand("Intel")
                .price(new BigDecimal("45000.00"))
                .category("Electronics")
                .releaseDate(getDateTime(2023, 10, 17))
                .productAvailable(true)
                .stockQuantity(120).build());

        // 3. Laptop
        products.add(ProductModel.builder()
                .name("MacBook Pro M3 Max").description("16-inch, 128GB Unified Memory").brand("Apple")
                .price(new BigDecimal("450000.00")).category("Computers")
                .releaseDate(getDateTime(2023, 11, 7)).productAvailable(true).stockQuantity(30).build());

        // 4. Smartphone
        products.add(ProductModel.builder()
                .name("Samsung Galaxy S24 Ultra").description("AI Integrated Smartphone 512GB").brand("Samsung")
                .price(new BigDecimal("145000.00")).category("Mobile")
                .releaseDate(getDateTime(2024, 1, 25)).productAvailable(true).stockQuantity(200).build());

        // 5. Monitor
        products.add(ProductModel.builder()
                .name("Odyssey Neo G9").description("49-inch Curved Gaming Monitor").brand("Samsung")
                .price(new BigDecimal("180000.00")).category("Peripherals")
                .releaseDate(getDateTime(2023, 5, 10)).productAvailable(true).stockQuantity(15).build());

        // 6. Keyboard
        products.add(ProductModel.builder()
                .name("Logitech G Pro X 2").description("Wireless Mechanical Gaming Keyboard").brand("Logitech")
                .price(new BigDecimal("18000.00")).category("Accessories")
                .releaseDate(getDateTime(2023, 8, 12)).productAvailable(true).stockQuantity(300).build());

        // 7. Console
        products.add(ProductModel.builder()
                .name("PlayStation 5 Pro").description("8K Support High Performance Console").brand("Sony")
                .price(new BigDecimal("85000.00")).category("Gaming")
                .releaseDate(getDateTime(2024, 11, 15)).productAvailable(true).stockQuantity(85).build());

        // 8. SSD
        products.add(ProductModel.builder()
                .name("Samsung 990 Pro 2TB").description("PCIe Gen4 NVMe M.2 SSD").brand("Samsung")
                .price(new BigDecimal("22000.00")).category("Storage")
                .releaseDate(getDateTime(2022, 11, 20)).productAvailable(true).stockQuantity(500).build());

        // 9. RAM
        products.add(ProductModel.builder()
                .name("Corsair Dominator Titanium 64GB").description("DDR5 7200MHz RAM Kit").brand("Corsair")
                .price(new BigDecimal("35000.00")).category("Memory")
                .releaseDate(getDateTime(2023, 9, 5)).productAvailable(true).stockQuantity(150).build());

        // 10. Mouse
        products.add(ProductModel.builder()
                .name("Razer DeathAdder V3 Pro").description("Ultra-lightweight Wireless Mouse").brand("Razer")
                .price(new BigDecimal("15000.00")).category("Accessories")
                .releaseDate(getDateTime(2023, 2, 22)).productAvailable(true).stockQuantity(450).build());
        productRepository.saveAll(products);
        return "Added Successfully.";
    }

    public static Date getDateTime(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        return calendar.getTime();

    }

    public ResponseEntity<?> updateProduct(int productId, ProductModel newProductModel, MultipartFile imageFile) {
        try {
            
            ProductModel previousProduct=productRepository.findById(productId).orElse(null);
            System.out.println(productModel);
            System.out.println(previousProduct);
        if (previousProduct!=null){
            if(newProductModel.getName()!=null){
                previousProduct.setName(newProductModel.getName());
            }
            if(newProductModel.getBrand()!=null){
                previousProduct.setBrand(newProductModel.getBrand());
            }
            if(newProductModel.getCategory()!=null){
                previousProduct.setCategory(newProductModel.getCategory());;
            }
            if(newProductModel.getDescription()!=null){
                previousProduct.setDescription(newProductModel.getDescription());;
            }
            if(imageFile!=null){
                previousProduct.setImageData(imageFile.getBytes());;
            }
            if(newProductModel.getImageName()!=null){
                previousProduct.setImageName(newProductModel.getImageName());;
            }
            if(newProductModel.getImageType()!=null){
                previousProduct.setImageType(newProductModel.getImageType());;
            }
            if(newProductModel.getPrice()!=null){
                previousProduct.setPrice(newProductModel.getPrice());
            }
            if(newProductModel.getReleaseDate()!=null){
                previousProduct.setReleaseDate(newProductModel.getReleaseDate());;
            }
            if(newProductModel.getStockQuantity()!=0){
                previousProduct.setStockQuantity(newProductModel.getStockQuantity());;
            }
            productRepository.save(previousProduct);
        }
    return ResponseEntity.status(HttpStatus.OK).body(previousProduct);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    
}
