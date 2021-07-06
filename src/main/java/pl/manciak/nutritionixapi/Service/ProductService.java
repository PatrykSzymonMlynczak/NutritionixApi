package pl.manciak.nutritionixapi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.manciak.nutritionixapi.Repository.ProductRepository;
import pl.manciak.nutritionixapi.entity.Product;

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

    public boolean ifExists(String name){
        return productRepository.existsByFoodName(name);
    }

    public Product getProductByName(String name){
        return productRepository.findByFoodName(name);
    }


}
