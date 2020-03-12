package pl.manciak.nutritionixapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pl.manciak.nutritionixapi.Manager.MealManager;
import pl.manciak.nutritionixapi.dto.NutriResponse.Food;
import pl.manciak.nutritionixapi.dto.NutriResponse.NutritionixResponse;
import pl.manciak.nutritionixapi.entity.Meal;

import java.util.List;

@RestController
public class MainController {

    MealManager mealManager;

    @Autowired
    public MainController(MealManager mealManager) {
        this.mealManager = mealManager;
    }

    @GetMapping(path= "/nutrients/{query}")
    public Meal getNutrients(@PathVariable String query){

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

/*
        AtomicReference<Double> sumKcal = new AtomicReference<>(0D);

        foodList.stream().map(y -> y.getFoodName()).forEach(System.out::println);
        foodList.stream().map(y -> y.getNfCalories()).forEach(y -> sumKcal.updateAndGet(v -> v + y));
*/

        return mealManager.saveMeal(foodList,"nowy");
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
