package pl.manciak.nutritionixapi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.manciak.nutritionixapi.Repository.ProductRepository;
import pl.manciak.nutritionixapi.entity.Product;
import pl.manciak.nutritionixapi.entity.ProductId;

@Service
public class ProductService {

    ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public boolean ifExistsByName(String name){
        return productRepository.existsByProductName(name);
    }

    public boolean ifExists(ProductId productId){
        return productRepository.existsByProductId(productId);
    }

    public Product getProductByName(String name){
        return productRepository.findByProductName(name);
    }

    public Product getProductByProductId(ProductId productId){
        return productRepository.findByProductId(productId);
    }


}
