EasyShoppr was created in collaboration with Wegman's APIs. Valid Wegman's API keys are required for the project to run. 
EasyShoppr is a Pantry Management Tool to automate a user's shopping process. It suggests to the user different recipes, which they can add to their cart. The ingredients currently in a user's pantry is saved. As a result, when the user orders recipes, which is then broken down into individual ingredients using Wegman's APIs, only ingredients that the user does not have a sufficient quantity of will be bought. This allows the user to save money and time when they reach the grocery store. 

The user can log in to have their pantry information saved in the SpringBoot backend. 

![Log In](login.png)


To start the frontend: 
1. cd frontend 
2. npm run-script build

To run the backend server:
 1. cd target/
 2. java -jar springboot_vue-0.0.1-SNAPSHOT.jar
