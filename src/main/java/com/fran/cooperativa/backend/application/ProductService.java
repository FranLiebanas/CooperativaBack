package com.fran.cooperativa.backend.application;

import com.fran.cooperativa.backend.domain.model.Product;
import com.fran.cooperativa.backend.domain.port.IProductRepository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class ProductService {

    private final IProductRepository iProductRepository;
    private final UploadFile uploadFile;
    private final String defaultImageUrl = "path/to/default/image.jpg"; // Set the default image URL

    public ProductService(IProductRepository iProductRepository, UploadFile uploadFile) {
        this.iProductRepository = iProductRepository;
        this.uploadFile = uploadFile;
    }

    public Product save(Product product, MultipartFile multipartFile) throws IOException {
        if (product.getId() != 0) { // When modifying an existing product
            if (multipartFile != null) {
                product.setUrlImage(uploadFile.upload(multipartFile));
            }
        } else { // When creating a new product
            if (multipartFile != null) {
                product.setUrlImage(uploadFile.upload(multipartFile));
            } else {
                // Set a default image URL if multipartFile is null for a new product
                product.setUrlImage(defaultImageUrl);
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
