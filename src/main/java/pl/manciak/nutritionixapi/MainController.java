package pl.manciak.nutritionixapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pl.manciak.nutritionixapi.Manager.MealManager;
import pl.manciak.nutritionixapi.Repository.ProductRepository;
import pl.manciak.nutritionixapi.dto.NutriResponse.Food;
import pl.manciak.nutritionixapi.dto.NutriResponse.NutritionixResponse;
import pl.manciak.nutritionixapi.entity.Meal;
import pl.manciak.nutritionixapi.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class MainController {

    MealManager mealManager;
    ProductRepository productRepository;

    @Autowired
    public MainController(MealManager mealManager, ProductRepository productRepository) {

        this.mealManager = mealManager;
        this.productRepository = productRepository;
    }

    @GetMapping("/food/{foodName}")
    public List<Meal> getByFood(@PathVariable String foodName){

        ArrayList<Product> list = new ArrayList();
        list.add(productRepository.findByFoodName(foodName));

        return mealManager.getByFood(list);
    }

    /** This method is using external service - Nutritionix
     *  as query it accepts any number of products in form:
     *      key = "productName"
     *      value = "servingSize"
     *  in case of giving a measure of weight instead of quantity
     *  the number should be divided by single space from measure
     *  eg.
     *  key = "cucumber", value = "100 grams"
     *  key = "radish", value = "5"
     */
    @GetMapping(path= "/nutrients/{name}/")
    public Meal getNutrients(@RequestParam Map<String, String> params, @PathVariable String name){
        HttpHeaders httpHeaders = prepareHeader();
        String body = prepareQuery(params);
        HttpEntity httpEntity = new HttpEntity(body, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<NutritionixResponse> exchange = restTemplate
                .exchange("https://trackapi.nutritionix.com/v2/natural/nutrients",
                        HttpMethod.POST,
                        httpEntity,
                        NutritionixResponse.class );

        List<Food> foodList = exchange.getBody().getFoods();
        return mealManager.saveMeal(foodList,name);
    }

    private HttpHeaders prepareHeader() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("x-app-id", "79aa9128");
        httpHeaders.add("x-app-key", " 572a2aca954f58ec86da52844309b364");
        httpHeaders.add("Content-Type", "application/json");
        return httpHeaders;
    }

    private String prepareQuery(Map<String, String> params) {
        StringBuilder query = new StringBuilder();
        for(Map.Entry<String,String> entry : params.entrySet()){
            query.append(entry.getValue());
            query.append(" ");
            query.append(entry.getKey());
            query.append(" ");
        }
        return "{\n    \"query\": \""+query+"\"\n}";
    }

    @GetMapping(path= "/{mealName}")
    public Meal getMeal(@PathVariable String mealName){
        return mealManager.getMeal(mealName);
    }

    @DeleteMapping(path = "/{mealName}")
    public  void deleteMeal(@PathVariable String mealName){
        mealManager.deleteMeal(mealName);
    }

}
