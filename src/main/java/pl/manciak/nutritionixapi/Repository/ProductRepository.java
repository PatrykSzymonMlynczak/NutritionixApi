package pl.manciak.nutritionixapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.manciak.nutritionixapi.entity.Product;
import pl.manciak.nutritionixapi.entity.ProductId;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByProductName(String name);
    Product findByProductId(ProductId productId);
    boolean existsByProductName(String name);
    boolean existsByProductId(ProductId productId);

}
