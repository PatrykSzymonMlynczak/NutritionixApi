package pl.manciak.nutritionixapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.manciak.nutritionixapi.entity.FoodEntity;

@Repository
public interface FoodRepository extends JpaRepository<FoodEntity, Long> {

}
