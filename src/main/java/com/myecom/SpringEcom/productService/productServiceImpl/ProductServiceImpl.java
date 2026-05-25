package com.myecom.SpringEcom.productService.productServiceImpl;

import com.myecom.SpringEcom.model.Product;
import com.myecom.SpringEcom.productService.ProductService;
import com.myecom.SpringEcom.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo){
        this.productRepo = productRepo;

    }

   public List<Product> getAllProducts(){
       return productRepo.findAll();
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

    @Override
    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }

    @Override
    public List<Product> searchProducts(String keyword) {

        //return List.of();
        return productRepo.searchProducts(keyword);
    }


}
