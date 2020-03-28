package pl.manciak.nutritionixapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.manciak.nutritionixapi.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByFoodName(String name);
    boolean existsByFoodName(String name);

}
