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

@RestController
public class MainController {

    MealManager mealManager;
    ProductRepository productRepository;

    @Autowired
    public MainController(MealManager mealManager, ProductRepository productRepository) {

        this.mealManager = mealManager;
        this.productRepository = productRepository;
    }

    @GetMapping("/byFood/{food}")
    public List<Meal> getByFood(@PathVariable String food){

        ArrayList<Product> list = new ArrayList();
        list.add(productRepository.findByFoodName(food));

        return mealManager.getByFood(list);
    }

    @GetMapping(path= "/nutrients/{name}/{query}")
    public Meal getNutrients(@PathVariable String query, @PathVariable String name){

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("x-app-id", "79aa9128");
        httpHeaders.add("x-app-key", " 572a2aca954f58ec86da52844309b364");
        httpHeaders.add("Content-Type", "application/json");

        String body = "{\n    \"query\": \""+query+"\"\n}";

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

    @GetMapping(path= "/get/{mealName}")
    public Meal getMeal(@PathVariable String mealName){

        return mealManager.getMeal(mealName);
    }

    @DeleteMapping(path = "/delete/{mealName}")
    public  void deleteMeal(@PathVariable String mealName){

        mealManager.deleteMeal(mealName);
    }


    @GetMapping(path= "/loc/{c1},{c2},{dist},{limit}")
    public  Object getFoodPoints
                        (@PathVariable String c1,
                         @PathVariable String c2,
                         @PathVariable String dist,
                         @PathVariable String limit) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("x-app-id", "79aa9128");
        httpHeaders.add("x-app-key", " 572a2aca954f58ec86da52844309b364");
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity httpEntity = new HttpEntity(httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<NutritionixResponse> exchange = restTemplate
                .exchange("https://trackapi.nutritionix.com/v2/locations?ll="+c1+","+c2+"&distance="+dist+"m&limit="+limit+"",
                        HttpMethod.GET,
                        httpEntity,
                        NutritionixResponse.class);

        Object aaa = exchange.getBody();

        return aaa;
    }




}
