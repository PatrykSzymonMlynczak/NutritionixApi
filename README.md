# NutritionixApi

Applicationn as well as my previous project DziabajApp_2.0 allows to counting calories and other macro ingerdients. 
This solution is connecting with external api of Nutritionix and after composing meal by just giving the names of the products and their quantity
it summarize all meal's parameters, also saving it in database.

#### What would I do if I would decide to continue developing the project ?
Products are duplicating in database whenever new meal with same products is added, so I would find better conception of saving products & meals.


### Technologies used in project: 
* Java 8
* Spring: 
  * Boot
  * Web
  * Data JPA
* Maven 
* MySQL
* REST


Enter the selected products with quantity as a body, and name of meal as path variable:
![nutritionix](https://user-images.githubusercontent.com/44747531/121747823-44d63d00-cb08-11eb-8afe-9bebaebff0fc.PNG)

App will response with JSON consisting all particular products, and summarized all, also saving it to database as a meal
![image](https://user-images.githubusercontent.com/44747531/121748191-d645af00-cb08-11eb-9d7f-ad41ba7cb97e.png)

