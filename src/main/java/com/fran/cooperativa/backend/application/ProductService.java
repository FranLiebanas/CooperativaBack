package com.fran.cooperativa.backend.application;

import com.fran.cooperativa.backend.domain.model.Product;
import com.fran.cooperativa.backend.domain.port.IProductRepository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class ProductService {

    private final IProductRepository iProductRepository;
    private final UploadFile uploadFile;

    public ProductService(IProductRepository iProductRepository, UploadFile uploadFile) {
        this.iProductRepository = iProductRepository;
        this.uploadFile = uploadFile;
    }

    public Product save(Product product, MultipartFile multipartFile) throws IOException {
        if (product.getId() != 0) { // When modifying an existing product
            if (multipartFile != null) {
                product.setUrlImage(uploadFile.upload(multipartFile));
            }
        } else {
            if (multipartFile != null) {
                product.setUrlImage(uploadFile.upload(multipartFile));
            } else {
                // Handle the case where multipartFile is null for a new product
                throw new IllegalArgumentException("New product must have an image file");
            }
        }
        return this.iProductRepository.save(product);
    }

    public Iterable<Product> findAll() {
        return this.iProductRepository.findAll();
    }

    public Product findById(Integer id) {
        return this.iProductRepository.findById(id);
    }

    public void deleteById(Integer id) {
        iProductRepository.deleteById(id);
    }
}




