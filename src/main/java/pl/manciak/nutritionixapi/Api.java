package pl.manciak.nutritionixapi;

import org.springframework.http.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pl.manciak.nutritionixapi.dto.Food;
import pl.manciak.nutritionixapi.dto.NutritionixResponse;

import java.util.List;

//TODO

@RestController
public class Api{

    @GetMapping(path= "/get/{query}")
    public  List<Food> addEmployee(@PathVariable String query){

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("x-app-id", "79aa9128");
        httpHeaders.add("x-app-key", " 572a2aca954f58ec86da52844309b364");
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        //String query = "for breakfast i ate 2 eggs, bacon, and french toast";
        String body = "{\n    \"query\": \""+query+"\"\n}";

        HttpEntity httpEntity = new HttpEntity(body, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<NutritionixResponse> exchange = restTemplate.exchange("https://trackapi.nutritionix.com/v2/natural/nutrients",
                HttpMethod.POST,
                httpEntity,
                NutritionixResponse.class );

        List<Food> foodList = exchange.getBody().getFoods();
        System.out.println(foodList.get(0).getNfCalories());
        return foodList;
    }
}
