package com.myecom.SpringEcom.productService;

import com.myecom.SpringEcom.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(int id);

    Product addProduct(Product product, MultipartFile imageFile) throws IOException;

    Product updatedProduct(Product product, MultipartFile imageFile) throws IOException;
}
