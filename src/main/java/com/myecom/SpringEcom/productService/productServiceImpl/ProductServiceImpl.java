package com.myecom.SpringEcom.productService.productServiceImpl;

import com.myecom.SpringEcom.model.Product;
import com.myecom.SpringEcom.productService.ProductService;
import com.myecom.SpringEcom.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo){
        this.productRepo = productRepo;

    }

   public List<Product> getAllProducts(){
       List<Product> products = productRepo.findAll();
       return products;
    }

    public Product getProductById(int id){
        return productRepo.findById(id).orElse(null);
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getOriginalFilename());
        product.setImageData(imageFile.getBytes());
        return productRepo.save(product);
    }

    @Override
    public Product updatedProduct(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getOriginalFilename());
        product.setImageData(imageFile.getBytes());
        return productRepo.save(product);
    }


}
