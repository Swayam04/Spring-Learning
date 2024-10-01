package org.example.services;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class ProductService {

    public ProductService() {
        System.out.println("ProductService created");
    }

}
