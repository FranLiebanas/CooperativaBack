package com.fran.cooperativa.backend.infrastructure.config;

import com.fran.cooperativa.backend.application.*;
import com.fran.cooperativa.backend.domain.port.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public UserService userService(IUserRepository iUserRepository){

        return new UserService(iUserRepository);
    }
    @Bean
    public CategoryService categoryService(ICategoryRepository iCategoryRepository){
        return new CategoryService(iCategoryRepository);
    }

    @Bean
    public ProductService productService(IProductRepository iProductRepository){
        return new ProductService(iProductRepository);
    }


    @Bean
    public OrderService orderService(IOrderRepository iOrderRepository){

        return new OrderService(iOrderRepository);
    }

    @Bean
    public InvoiceService invoiceService(IInvoiceRepository iInvoiceRepository) {
        return new InvoiceService(iInvoiceRepository);
    }

}
