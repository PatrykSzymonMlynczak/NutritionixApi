package pl.manciak.nutritionixapi;

        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class NutritionixApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(NutritionixApiApplication.class, args);
    }

}
