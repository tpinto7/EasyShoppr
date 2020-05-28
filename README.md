EasyShoppr was created in collaboration with Wegman's APIs. Valid Wegman's API keys are required for the project to run. 
EasyShoppr is a Pantry Management Tool to automate a user's shopping process. It suggests to the user different recipes, which they can add to their cart. The ingredients currently in a user's pantry is saved. As a result, when the user orders recipes, which is then broken down into individual ingredients using Wegman's APIs, only ingredients that the user does not have a sufficient quantity of will be bought. This allows the user to save money and time when they reach the grocery store. 

![Log In](https://github.com/tpinto7/EasyShoppr/blob/master/login.PNG)
The user can log in to have their pantry information saved in the SpringBoot backend. 

![Recipes](https://github.com/tpinto7/EasyShoppr/blob/master/Recipes.PNG)
Recipes can be browsed by clicking the left and right buttons. When the user finds a recipe they like, they can click the Add to Cart button.

![Order](https://github.com/tpinto7/EasyShoppr/blob/master/Order.PNG)
In this example, an Antipasti recipe has been added to cart. By clicking 'Calculate', an algorithm will factor in the ingredients, and their quantity required, to the user's current ingredients in their pantry. The amount of each ingredient and their cost will correspondingly be displayed to the user. As well, the ingredients required to be purchased will be displayed in a table and their location in the Wegman's store will be displayed.

![Order2](https://github.com/tpinto7/EasyShoppr/blob/master/Order2.PNG)
After ordering the recipe again, the ingredients required will be decreased since the leftovers from the previous order are saved. 

![Pantry](https://github.com/tpinto7/EasyShoppr/blob/master/Pantry.PNG)
After these 2 orders, the remaining ingredients can be seen in the pantry.

To start the frontend: 
1. cd frontend 
2. npm run-script build

To run the backend server:
 1. cd target/
 2. java -jar springboot_vue-0.0.1-SNAPSHOT.jar
