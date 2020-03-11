package pl.manciak.nutritionixapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.manciak.nutritionixapi.entity.Nutriensts;

@Repository
public interface NutrientsRepository extends JpaRepository<Nutriensts, Long> {
}
