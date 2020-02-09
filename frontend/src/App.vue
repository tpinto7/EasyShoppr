<template>
    <div class="wrapper">
        <div>
  <b-navbar toggleable="lg" type="dark" variant="info">
    <b-navbar-brand href="#">EasyShoppr</b-navbar-brand>

    <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

    <b-collapse id="nav-collapse" is-nav>
     
      <!-- Right aligned nav items -->
      <b-navbar-nav class="ml-auto">
        <!-- <b-nav-form>
          <b-form-input size="sm" class="mr-sm-2" placeholder="Search"></b-form-input>
          <b-button size="sm" class="my-2 my-sm-0" type="submit">Search</b-button>
        </b-nav-form> -->
<i class="fa fa-fw fa-home" style="font-size:36px;" v-b-modal.pantryModal></i>
  <i class="fa fa-fw fa-shopping-cart" style="font-size:36px;" v-b-modal.cartModal></i>
  <i class="fa fa-fw fa-user" style="font-size:36px;" right v-b-modal.loginModal></i>
        <b-nav-item-dropdown right>
          <!-- Using 'button-content' slot -->
        
          <template v-slot:button-content>
            <em>{{user.firstName}} {{user.lastName}}</em>
          </template>
          <b-dropdown-item href="#">Profile</b-dropdown-item>
          <b-dropdown-item href="#">Sign Out</b-dropdown-item>
        </b-nav-item-dropdown>
      </b-navbar-nav>
    </b-collapse>
  </b-navbar>
  <div style="">
      <h2></h2>
  </div>
  <div style="background-color: rgb(228,228,228)">
  <div style="padding-top: 30px; margin-left: 20%; margin-right: 20%" >
      <b-card style="text-align: center; background-color: #17a2b8">
          <!-- <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
  <a class="next" onclick="plusSlides(1)">&#10095;</a> -->
        <img :src="recipes[currentIndex].imgUrl" style="max-width:50%; max-height:50%" center/>
        <h2 style="margin: 40px; color: white">{{recipes[currentIndex].title}}</h2>
        <b-btn @click="left" class="float-left">Left</b-btn>
        <b-btn @click="addToCart">Add to Cart</b-btn>
        <b-btn @click="right" class="float-right">Right</b-btn>
      </b-card>
      </div>
  <!--  -->
</div>
</div>
<pantry-modal></pantry-modal>
<login-modal></login-modal>
<cart-modal></cart-modal>
</div>

</template>

<script>
import LoginModal from './components/LoginModal';
import PantryModal from './components/PantryModal';
import CartModal from './components/CartModal';
    export default {
        name: 'app',
        components: {
            'login-modal': LoginModal,
            'pantry-modal': PantryModal,
            'cart-modal': CartModal
        },
        data(){
            return{
                user: {
                    id: this.$root.userStore.state.id,
                    firstName: this.$root.userStore.state.firstName,
                    lastName: this.$root.userStore.state.lastName,
                    username: this.$root.userStore.state.username,
                    emailAdress:this.$root.userStore.state.emailAddress

                },
                pantry: {

                },
                subKey: '0980a1855df1499891dbc1489414132b',
                recipes: [
    {
      "title": "Antipasti Pull-Apart Bread",
      "url": "https://shop.wegmans.com/recipes/4051",
      "imgUrl": "https://assets-prd-weg.unataops.com/web/recipe_header/507f00c6b36748e497dcc126c69403f2.jpg",
      "totalCookTime": "1 hour 15 mins",
      "prepTime": "25 mins",
      "servings": "1 loaf, about 55 oz",
      "ingredients": [
        {
          "ingrAmntName": "Food You Feel Good About Canola Oil Cooking Spray"
        },
        {
          "ingrAmntName": "2 Tbsp Italian Classics Grated Pecorino Romano (Cheese Shop)"
        },
        {
          "ingrAmntName": "1 jar (6.7 oz) Italian Classics Basil Pesto Sauce"
        },
        {
          "ingrAmntName": "8 ciliegine fresh mozzarella (Mediterranean Bar), halved"
        },
        {
          "ingrAmntName": "8 roasted red tomatoes (Mediterranean Bar), halved"
        },
        {
          "ingrAmntName": "1 can (14 oz) Italian Classics Quartered Artichoke Hearts in Brine, drained"
        },
        {
          "ingrAmntName": "20 pitted Greek olives (Mediterranean Bar), halved"
        },
        {
          "ingrAmntName": "12 cloves roasted garlic (Mediterranean Bar)"
        },
        {
          "ingrAmntName": "5 peppadews (Mediterranean Bar), quartered"
        },
        {
          "ingrAmntName": "1 pkg (28 oz) Food You Feel Good About White Pizza Dough"
        },
        {
          "ingrAmntName": "Food You Feel Good About All Purpose Flour"
        }
      ],
      "wegmansProducts": [
        {
          "product": "Wegmans White Pizza Dough",
          "price": "$2.50",
          "initPkgAmnt": "28 oz",
          "usedAmnt": "28 oz"
        },
        {
          "product": "Wegmans Italian Classics Quartered Artichoke Hearts in Brine",
          "price": "$2.79",
          "usedAmnt": "14 oz"
        },
        {
          "product": "Wegmans Italian Classics Pecorino Romano Cheese -Grated",
          "price": "$5.28",
          "usedAmnt": "2 tbsp"
        },
        {
          "product": "Wegmans Italian Classics Basil Pesto Sauce",
          "price": "$3.99",
          "usedAmnt": "6.7 oz"
        },
        {
          "product": "Wegmans Peppadew Whole Peppers",
          "price": "$5.00",
          "usedAmnt": "5 units"
        },
        {
          "product": "Wegmans Self-Serve Mediterranean Olive Bar",
          "price": "$5.00",
          "usedAmnt": "20 units"
        },
        {
          "product": "Wegmans Canola Oil Cooking Spray",
          "price": "$1.49",
          "usedAmnt": "1 oz"
        },
        {
          "product": "Wegmans Roasted Red Tomatoes",
          "price": "$5.00",
          "usedAmnt": "8 units"
        },
        {
          "product": "Wegmans All Purpose Unbleached Flour",
          "price": "$1.49",
          "usedAmnt": "2 oz"
        }
      ],
      "procedure": [
        {
          "step": "Preheat oven to 350 degrees. Coat fluted tube pan generously with cooking spray; sprinkle bottom of pan with grated cheese. Set aside. Add basil pesto, ciliegine, tomatoes, artichokes, olives, garlic, peppadews, and any residual oil to large bowl; toss to combine. Set aside."
        },
        {
          "step": "Cut pizza dough into quarters; lightly dust each quarter with flour. Roll, one quarter at a time, into 12-inch long \"ropes.\" Cut each \"rope\" in 10-12 pieces. Roll each piece into a dough ball; add to pesto mixture in batches. Toss gently to coat."
        },
        {
          "step": "Add coated dough balls and pesto mixture evenly to tube pan. Set pan in center of baking sheet; bake 50-55 min until lightly golden brown and firm to touch. Cool 15 min; invert onto serving platter."
        }
      ]
    },
    {
      "title": "Asian Cauliflower \"Rice\" Lettuce Wraps",
      "url": "https://shop.wegmans.com/recipes/2995/asian-cauliflower-rice-lettuce-wraps",
      "imgUrl": "https://assets-prd-weg.unataops.com/web/recipe_header/7986c9265540449aa4fcea8de5d2de5e.jpg",
      "rating": "5.00 (10)",
      "totalCookTime": "55 mins",
      "prepTime": "35 mins",
      "servings": "4",
      "ingredients": [
        {
          "ingrAmntName": "1/2 of an 8 oz pkg Food You Feel Good About Farro, cooked per pkg directions"
        },
        {
          "ingrAmntName": "2 Tbsp Wegmans Pure Olive Oil"
        },
        {
          "ingrAmntName": "1 lb Food You Feel Good About Cauliflower Rice"
        },
        {
          "ingrAmntName": "1 head (about 1/4 lb) Shanghai bok choy, trimmed, thinly sliced"
        },
        {
          "ingrAmntName": "2 Tbsp peeled, minced fresh ginger"
        },
        {
          "ingrAmntName": "1 Tbsp minced Food You Feel Good About Cleaned & Cut Peeled Garlic"
        },
        {
          "ingrAmntName": "1/2 cup Wegmans Organic Matchstick Carrots"
        },
        {
          "ingrAmntName": "2 Tbsp Kikkoman Manjo Aji-Mirin Sweet Cooking Rice Seasoning"
        },
        {
          "ingrAmntName": "2 Tbsp Food You Feel Good About Pure Toasted Sesame Oil"
        },
        {
          "ingrAmntName": "2 Tbsp Food You Feel Good About Soy Sauce"
        },
        {
          "ingrAmntName": "1 bunch green onions, trimmed, thinly sliced"
        },
        {
          "ingrAmntName": "Salt to taste"
        },
        {
          "ingrAmntName": "1 pkg (7 oz) Food You Feel Good About Fresh Green Lettuce Leaves"
        },
        {
          "ingrAmntName": "1 Tbsp roasted salted whole cashews (Bulk Foods), chopped, for garnish"
        },
        {
          "ingrAmntName": "Food You Feel Good About Tom Tom Sauce to taste"
        }
      ],
      "wegmansProducts": [
        {
          "product": "Wegmans Farro",
          "price": "$2.99",
          "initPkgAmnt": "8 oz",
          "usedAmnt": "4 oz"
        },
        {
          "product": "Green Onions (Scallions)",
          "price": "$0.99",
          "initPkgAmnt": "1 bunch",
          "usedAmnt": "1 bunch"
        },
        {
          "product": "Shanghai Bok Choy",
          "price": "$0.32",
          "initPkgAmnt": "0.25 lb",
          "usedAmnt": "0.25 lb"
        },
        {
          "product": "Fresh Ginger",
          "price": "$0.70",
          "initPkgAmnt": "0.35 lb",
          "usedAmnt": "0.5 oz"
        },
        {
          "product": "Wegmans Green Lettuce Leaves",
          "price": "$3.99",
          "initPkgAmnt": "7 oz",
          "usedAmnt": "7 oz"
        },
        {
          "product": "Kikkoman Rice Seasoning, Sweet Cooking, Manjo Aji-Mirin",
          "price": "$4.49",
          "initPkgAmnt": "10 oz",
          "usedAmnt": "2 tbsp"
        },
        {
          "product": "Wegmans Cauliflower Rice",
          "price": "$4.99",
          "initPkgAmnt": "12 oz",
          "usedAmnt": "1 lb"
        },
        {
          "product": "Wegmans Garlic, Peeled",
          "price": "$3.99",
          "initPkgAmnt": "6 oz",
          "usedAmnt": "0.5 oz"
        },
        {
          "product": "Wegmans Pure Toasted Sesame Oil",
          "price": "$3.49",
          "initPkgAmnt": "5 oz",
          "usedAmnt": "2 tbsp"
        },
        {
          "product": "Wegmans 100% Mediterranean Blend Olive Oil, Pure",
          "price": "$3.99",
          "initPkgAmnt": "16.9 oz",
          "usedAmnt": "2 tbsp"
        },
        {
          "product": "Wegmans Soy Sauce",
          "price": "$3.29",
          "initPkgAmnt": "11.4 oz",
          "usedAmnt": "2 tbsp"
        },
        {
          "product": "Wegmans Tom Tom Sauce",
          "price": "$3.49",
          "initPkgAmnt": "12 oz",
          "usedAmnt": "0.5 oz"
        },
        {
          "product": "Wegmans Organic Matchstick Carrots",
          "price": "$1.99",
          "initPkgAmnt": "10 oz",
          "usedAmnt": "1 oz"
        }
      ],
      "procedure": [
        {
          "step": "Add olive oil to stir-fry pan on HIGH. Add farro; cook, stirring, 3-4 min until browned. Add cauliflower and bok choy; cook, stirring, 1-2 min. Add ginger, garlic, and carrots; cook, stirring, 1 min."
        },
        {
          "step": "Add mirin, sesame oil, soy sauce, and green onions; stir to combine. Cook, stirring, 2-3 min. Season with salt."
        },
        {
          "step": "Arrange lettuce leaves on serving platter; divide farro mixture evenly on leaves. Garnish with chopped cashews; drizzle with Tom Tom Sauce."
        }
      ]
    },
    {
      "title": "Blueberry & Yogurt Banana Split",
      "url": "https://shop.wegmans.com/recipes/1368",
      "imgUrl": "https://assets-prd-weg.unataops.com/web/recipe_header/8cbe4159aa4a4362a23da5db639837d7.jpg",
      "rating": "5.00 (1)",
      "totalCookTime": "5 mins",
      "prepTime": "5 mins",
      "servings": "1",
      "ingredients": [
        {
          "ingrAmntName": "1 banana, peeled, halved lengthwise"
        },
        {
          "ingrAmntName": "1 container (5.3 oz) Wegmans Organic Vanilla Greek Yogurt"
        },
        {
          "ingrAmntName": "1 strawberry, rinsed, hulled, sliced"
        },
        {
          "ingrAmntName": "1/4 cup blueberries, rinsed"
        },
        {
          "ingrAmntName": "2 Tbsp Wegmans Organic Vanilla Almond Granola"
        }
      ],
      "wegmansProducts": [
        {
          "product": "Blueberries",
          "price": "$4.99",
          "initPkgAmnt": "10 oz",
          "usedAmny": "5 oz"
        },
        {
          "product": "Wegmans Organic Vanilla & Almonds Granola",
          "price": "$3.99",
          "initPkgAmnt": "12 oz",
          "usedAmny": "2 oz"
        },
        {
          "product": "Strawberries",
          "price": "$3.99",
          "initPkgAmnt": "16 oz",
          "usedAmny": "3 oz",
     
        },
        {
          "product": "Wegmans Organic Greek Yogurt, Vanilla",
          "price": "$1.00",
          "initPkgAmnt": "5.3 oz",
          "usedAmny": "5.3 oz"
        },
        {
          "product": "Bananas, Each",
          "price": "$0.12",
          "initPkgAmnt": "1 lb",
          "usedAmny": "0.25 lb"
        }
      ],
      "procedure": [
        {
          "step": "Place banana halves in serving dish. Place 1/4 cup yogurt at each end of dish, between banana halves. Place strawberry slices in the center; top all with blueberries and granola."
        }
      ]
    },
    {
      "title": "Broccoli & Kimchi Stir Fry",
      "url": "https://shop.wegmans.com/recipes/4441/Broccoli-&-Kimchi-Stir-Fry",
      "imgUrl": "https://assets-prd-weg.unataops.com/web/recipe_header/a99af746db8646b3952aa83fab33faed.jpg",
      "totalCookTime": "15 mins",
      "prepTime": "10 mins",
      "servings": "4 1/2 Cups",
      "ingredients": [
        {
          "ingrAmntName": "1 Tbsp Wegmans Pure Olive Oil"
        },
        {
          "ingrAmntName": "1 tsp minced Food You Feel Good About Cleaned & Cut Peeled Garlic"
        },
        {
          "ingrAmntName": "1 tsp peeled, minced fresh ginger"
        },
        {
          "ingrAmntName": "1 pkg (12 oz) Wegmans Organic Just Picked Broccoli Florets (Frozen Foods), cooked per pkg directions"
        },
        {
          "ingrAmntName": "1/2 of a 14 oz jar Food You Feel Good About Spicy Kimchi, drained"
        },
        {
          "ingrAmntName": "1 tsp Food You Feel Good About Pure Toasted Sesame Oil"
        },
        {
          "ingrAmntName": "1/2 of a 14 oz pkg Wegmans Organic Firm Tofu, drained"
        }
      ],
      "wegmansProducts": [
        {
          "product": "Wegmans Pure Toasted Sesame Oil",
          "price": "$3.49",
          "initPkgAmnt": "5 oz",
          "usedAmnt": "1 tsp"
        },
        {
          "product": "Wegmans 100% Mediterranean Blend Olive Oil, Pure",
          "price": "$3.99",
          "initPkgAmnt": "16.9 oz",
          "usedAmnt": "1 tbsp"
        },
        {
          "product": "Wegmans Organic Firm Tofu",
          "price": "$1.79",
          "initPkgAmnt": "14 oz",
          "usedAmnt": "7 oz"
        },
        {
          "product": "Fresh Ginger",
          "price": "$0.70",
          "initPkgAmnt": "0.35 lb",
          "usedAmnt": "0.5 oz"
        },
        {
          "product": "Wegmans Garlic, Peeled",
          "price": "$3.99",
          "initPkgAmnt": "6 oz",
          "usedAmnt": "0.5 oz"
        },
        {
          "product": "Wegmans Organic Frozen Broccoli Florets",
          "price": "$2.29",
          "initPkgAmnt": "12 oz",
          "usedAmnt": "12 oz"
        }
      ],
      "procedure": [
        {
          "step": "Heat olive oil in stir-fry pan on HIGH until oil faintly smokes; add garlic and ginger. Cook, stirring, 15 sec."
        },
        {
          "step": "Add broccoli; cook, stirring, 1 min. Add kimchi and sesame oil; cook, stirring, 30 sec. Remove from heat."
        },
        {
          "step": "Heat tofu in microwave 1 min, 30 sec. Cut in 1/4-inch slices. Serve with stir fry."
        }
      ]
    },
    {
      "title": "Cauli-Pesto Pasta with Broccoli & Tomatoes",
      "url": "https://shop.wegmans.com/recipes/2449/cauli-pesto-pasta-with-broccoli-tomatoes",
      "imgUrl": "https://assets-prd-weg.unataops.com/web/recipe_header/90182f883adc43858d33329517423333.jpg",
      "rating": "4.74 (23)",
      "totalCookTime": "20 mins",
      "prepTime": "20 mins",
      "servings": "8",
      "ingredients": [
        {
          "ingrAmntName": "1 pkg (17.6 oz) Italian Classics Organic Barilotti Pasta, cooked per pkg directions (reserve 3/4 cup pasta water)"
        },
        {
          "ingrAmntName": "2 Tbsp Italian Classics Organic Extra Virgin Olive Oil"
        },
        {
          "ingrAmntName": "1 container (pint) Food You Feel Good About Grape Tomatoes"
        },
        {
          "ingrAmntName": "1 pkg (16 oz) Food You Feel Good About Just Picked Broccoli Florets (Frozen Foods), thawed"
        },
        {
          "ingrAmntName": "1/2 of a 16 oz pkg Wegmans Organic CauliCreme (Frozen Foods)"
        },
        {
          "ingrAmntName": "1 jar (6.7 oz) Italian Classics Basil Pesto Sauce"
        },
        {
          "ingrAmntName": "2 Tbsp Italian Classics Grated Parmigiano Reggiano (Cheese Shop)"
        },
        {
          "ingrAmntName": "Salt and pepper to taste"
        }
      ],
      "wegmansProducts": [
        {
          "product": "Wegmans Grape Tomatoes",
          "price": "$1.99",
          "initPkgAmnt": "1 pint",
          "usedAmnt": "1 pint"
        },
        {
          "product": "Wegmans Italian Classics Organic Extra Virgin Olive Oil",
          "price": "$7.99",
          "initPkgAmnt": "16.9 oz",
          "usedAmnt": "2 tbsp"
        },
        {
          "product": "Wegmans Italian Classics Basil Pesto Sauce",
          "price": "$3.99",
          "initPkgAmnt": "6.7 oz",
          "usedAmnt": "6.7 oz"
        },
        {
          "product": "Wegmans Organic CauliCreme",
          "price": "$3.99",
          "initPkgAmnt": "16 oz",
          "usedAmnt": ""
        },
        {
          "product": "Wegmans Frozen Broccoli Florets",
          "price": "$1.69",
          "initPkgAmnt": "16 oz",
          "usedAmnt": ""
        }
      ],
      "procedure": [
        {
          "step": "Heat oil in stockpot on MED-LOW. Add tomatoes; cook, stirring, 3-5 min. Add broccoli, reserved pasta water, caulicreme, pesto, and cheese; season with salt and pepper. Stir to combine."
        },
        {
          "step": "Add cooked pasta to stockpot; stir to combine. Heat until desired temp is reached."
        }
      ]
    },
    {
      "title": "Classic Sangria",
      "url": "https://shop.wegmans.com/recipes/3269",
      "imgUrl": "https://assets-prd-weg.unataops.com/web/recipe_header/2dfefb9c6b4d4c59b8c1ddaff2d0500a.jpg",
      "totalCookTime": "1 hour 10 mins",
      "prepTime": "10 mins",
      "servings": "1",
      "ingredients": [
        {
          "ingrAmntName": "1 cup water"
        },
        {
          "ingrAmntName": "1 cup Food You Feel Good About White Granulated Sugar"
        },
        {
          "ingrAmntName": "2 Tbsp (1 oz) Food You Feel Good About Orange Juice"
        },
        {
          "ingrAmntName": "2 Tbsp (1 oz) Grand Montand French Brandy VSOP"
        },
        {
          "ingrAmntName": "1/2 cup (4 oz) red wine"
        },
        {
          "ingrAmntName": "1/2 cup chopped apple"
        },
        {
          "ingrAmntName": "2 1/2 Tbsp chopped 1/5 orange"
        },
        {
          "ingrAmntName": "1/4 cup (2 oz) Wegmans W-Up Lemon Lime Soda"
        }
      ],
      "wegmansProducts": [
        {
          "product": "Valencia Oranges",
          "price": "2 for $3.00",
          "initPkgAmnt": "2 units",
          "usedAmnt": "0.2 units"
        },
        {
          "product": "Red Delicious Apples",
          "price": "$1.09",
          "initPkgAmnt": "0.55 lb",
          "usedAmnt": "0.25 lb"
        },
        {
          "product": "Wegmans 100% Cold Pressured Orange Juice",
          "price": "$4.00",
          "initPkgAmnt": "16 oz",
          "usedAmnt": "1 oz"
        },
        {
          "product": "Wegmans White Sugar, Granulated",
          "price": "$1.99",
          "initPkgAmnt": "4 lb",
          "usedAmnt": "0.44 lb"
        },
        {
          "product": "Wegmans W-Up Lemon Lime Soda",
          "price": "$0.75",
          "initPkgAmnt": "4 cups",
          "usedAmnt": "0.25 cups"
        }
      ],
      "procedure": [
        {
          "step": "Make simple syrup: Add water and sugar to small saucepan on LOW. Cook, stirring, until sugar is dissolved; chill. Set aside 2 Tbsp syrup; refrigerate remaining syrup for other drinks."
        },
        {
          "step": "Add orange juice, 2 Tbsp simple syrup, brandy, wine, apple, and orange to ice-filled wine glass; stir. Top with soda."
        }
      ]
    },
    {
      "title": "Egg, Spinach & Salmon on Latkes",
      "url": "https://shop.wegmans.com/recipes/3717/egg-spinach-salmon-on-latkes",
      "imgUrl": "https://assets-prd-weg.unataops.com/web/recipe_header/257db3b790bd443ca5ade1f552443537.jpg",
      "rating": "4.00 (2)",
      "totalCookTime": "30 mins",
      "prepTime": "30 mins",
      "servings": "6",
      "ingredients": [
        {
          "ingrAmntName": "1 pkg (6 pc) potato pancakes (Deli Dept), cooked per pkg directions"
        },
        {
          "ingrAmntName": "1 container (5 oz) Wegmans Organic Baby Spinach"
        },
        {
          "ingrAmntName": "1/2 of a 12 oz pkg Food You Feel Good About Smoked Nova Salmon"
        },
        {
          "ingrAmntName": "2 Tbsp Kedem White Wine Vinegar"
        },
        {
          "ingrAmntName": "6 Food You Feel Good About Large Eggs"
        },
        {
          "ingrAmntName": "6 Tbsp Gold's Extra Chunky Mild Salsa, divided"
        }
      ],
      "wegmansProducts": [
        {
          "product": "Wegmans One Dozen Large Eggs",
          "price": "$1.79",
          "initPkgAmnt": "24 oz",
          "usedAmnt": "12 oz"
        },
        {
          "product": "Wegmans Organic Baby Spinach",
          "price": "$2.49",
          "initPkgAmnt": "5 oz",
          "usedAmnt": "5 oz"
        },
        {
          "product": "Wegmans Smoked Nova Salmon, FAMILY PACK",
          "price": "$19.99",
          "initPkgAmnt": "12 oz",
          "usedAmnt": "6 oz"
        }
      ],
      "procedure": [
        {
          "step": "Place spinach and 2 Tbsp water in microwavable bowl; cover. Microwave on HIGH 2-3 min until wilted; drain. Portion spinach evenly on potato pancakes; top with layer of nova salmon."
        },
        {
          "step": "Fill large skillet with 2 inches of water; heat on HIGH until boiling. Add vinegar; reduce heat to MED to maintain simmer."
        },
        {
          "step": "Crack one egg into a small shallow bowl and carefully slip egg from bowl into simmering water. Quickly repeat until all eggs are in poaching water. Poach eggs about 3 min until whites are set; remove with slotted spoon onto spinach-topped potato pancakes."
        },
        {
          "step": "Top each potato pancake \"stack\" with 1 Tbsp salsa."
        }
      ]
    },
    {
      "title": "Greek Yogurt Pancakes",
      "url": "https://shop.wegmans.com/recipes/4187/greek-yogurt-pancakes",
      "imgUrl": "https://assets-prd-weg.unataops.com/web/recipe_header/c88207396c7c4dc7a5206bc280f2a180.jpg",
      "rating": "3.67 (3)",
      "totalCookTime": "15 mins",
      "prepTime": "15 mins",
      "servings": "4",
      "ingredients": [
        {
          "ingrAmntName": "2 containers (5.3 oz each) Wegmans Organic Blueberry Greek Yogurt"
        },
        {
          "ingrAmntName": "1 cup Food You Feel Good About Buttermilk Pancake Mix"
        },
        {
          "ingrAmntName": "1/2 cup water"
        },
        {
          "ingrAmntName": "1 tsp Food You Feel Good About Vegetable Oil"
        }
      ],
      "wegmansProducts": [
        {
          "product": "Wegmans Buttermilk Pancake Mix",
          "price": "$1.99",
          "initPkgAmnt": "32 oz",
          "usedAmnt": "4.25 oz"
        },
        {
          "product": "Wegmans Organic Greek Yogurt, Blueberry",
          "price": "$1.00",
          "initPkgAmnt": "5.3 oz",
          "usedAmnt": "10.6 oz"
        },
        {
          "product": "Wegmans Vegetable Oil",
          "price": "$1.59",
          "initPkgAmnt": "32 oz",
          "usedAmnt": "1 tsp"
        }
      ],
      "procedure": [
        {
          "step": "Add yogurt, pancake mix, and water to large bowl; stir to combine."
        },
        {
          "step": "Heat oil in pan on MED-HIGH. Pour 1/4 cup batter for each pancake into pan. Turn over when pancakes bubble on top and bottom is golden brown, about 1 min each side."
        }
      ]
    },
    {
      "title": "Hot Mulled Cider",
      "url": "https://shop.wegmans.com/recipes/912/hot-mulled-cider",
      "imgUrl": "https://assets-prd-weg.unataops.com/web/recipe_header/aac2bff4a7a5479ebe64cc0bdb525a60.jpg",
      "rating": "4.00 (3)",
      "totalCookTime": "15 mins",
      "prepTime": "15 mins",
      "servings": "8 cups",
      "ingredients": [
        {
          "ingrAmntName": "1 orange, washed"
        },
        {
          "ingrAmntName": "15 whole cloves"
        },
        {
          "ingrAmntName": "2 quarts Wegmans Apple Cider"
        },
        {
          "ingrAmntName": "3 whole cinnamon sticks"
        }
      ],
      "wegmansProducts": [
        {
          "product": "MCCORMICK Whole Cloves",
          "price": "$6.99",
          "initPkgAmnt": "0.62 oz",
          "usedAmnt": "0.2 oz"
        },
        {
          "product": "MCCORMICK Cinnamon Sticks",
          "price": "$6.99",
          "initPkgAmnt": "0.75 oz",
          "usedAmnt": "0.2 oz"
        },
        {
          "product": "Valencia Oranges",
          "price": "2 for $3.00",
          "initPkgAmnt": "2 units",
          "usedAmnt": "1 units"
        },
        {
          "product": "Wegmans Apple Cider",
          "price": "$5.49",
          "initPkgAmnt": "128 oz",
          "usedAmnt": "64 oz"
        }
      ],
      "procedure": [
        {
          "step": "Peel orange and insert cloves into peel."
        },
        {
          "step": "Combine apple cider, orange peel and cinnamon sticks in large stockpot. Remove sections from orange and squeeze any remaining juice from membranes into cider mixture."
        },
        {
          "step": "Simmer slowly on MED until hot and steamy, about 10 min; do not boil. Remove cinnamon sticks and orange peel."
        }
      ]
    },
    {
      "title": "Skillet Spinach & Ricotta Pizza",
      "url": "https://shop.wegmans.com/recipes/3171/skillet-spinach-ricotta-pizza",
      "imgUrl": "https://assets-prd-weg.unataops.com/web/recipe_header/fe1cacc696e248e7a8a122c8cf9563ba.jpg",
      "rating": "5.00 (2)",
      "totalCookTime": "2 hours 30 mins",
      "prepTime": "15 mins",
      "servings": "4",
      "ingredients": [
        {
          "ingrAmntName": "1 pkg (28 oz) Food You Feel Good About White Pizza Dough"
        },
        {
          "ingrAmntName": "1 Tbsp + 1/4 tsp Wegmans Pure Olive Oil, divided"
        },
        {
          "ingrAmntName": "Food You Feel Good About All Purpose Flour"
        },
        {
          "ingrAmntName": "1 Tbsp Wegmans Organic Basting Oil"
        },
        {
          "ingrAmntName": "3 Tbsp Italian Classics Grated Italian Blend (Cheese Shop), divided"
        },
        {
          "ingrAmntName": "1 cup (about 4 oz) Wegmans Shredded Mozzarella Cheese Pizza Topping (Pizza Dept)"
        },
        {
          "ingrAmntName": "4 oz (about 2/3 cup) fresh ricotta (Cheese Shop)"
        },
        {
          "ingrAmntName": "1/2 of a 9 oz pkg Food You Feel Good About Fresh Spinach, cooked per pkg directions"
        },
        {
          "ingrAmntName": "1/4 tsp garlic powder"
        }
      ],
      "wegmansProducts": [
        {
          "product": "Wegmans White Pizza Dough",
          "price": "$2.50",
          "initPkgAmnt": "28 oz",
          "usedAmnt": "28 oz"
        },
        {
          "product": "Wegmans Organic Basting Oil",
          "price": "$6.99",
          "initPkgAmnt": "8 oz",
          "usedAmnt": "1 tbsp"
        },
        {
          "product": "Wegmans Shredded Mozzarella Cheese, Pizza Topping",
          "price": "$4.99",
          "initPkgAmnt": "1 lb",
          "usedAmnt": "4 oz"
        },
        {
          "product": "MCCORMICK Garlic Powder",
          "price": "$3.99",
          "initPkgAmnt": "3.12 oz",
          "usedAmnt": "0.25 tsp"
        },
        {
          "product": "Wegmans 100% Mediterranean Blend Olive Oil, Pure",
          "price": "$3.99",
          "initPkgAmnt": "16.9 oz",
          "usedAmnt": "1.5 tbsp"
        },
        {
          "product": "Wegmans Spinach",
          "price": "$3.99",
          "initPkgAmnt": "9 oz",
          "usedAmnt": "4.5 oz"
        },
        {
          "product": "Wegmans All Purpose Unbleached Flour",
          "price": "$1.49",
          "initPkgAmnt": "5 lb",
          "usedAmnt": "2 oz"
        }
      ],
      "procedure": [
        {
          "step": "Divide dough into 2 equal pieces; refrigerate half for later use. Form remaining dough into ball. Coat large bowl with 1/4 tsp olive oil; place dough ball in bowl. Cover bowl with plastic wrap. Let dough come to room temp, about 1-2 hours."
        },
        {
          "step": "Preheat oven to 500 degrees with rack in center. Place 12-inch cast-iron skillet in preheated oven 10 min. Remove skillet carefully from oven using oven mitts; set on heat-safe surface. Brush skillet carefully with remaining olive oil. Shape dough ball on lightly floured surface into 12-inch round, pressing out any air bubbles. Transfer to skillet carefully; form to fit bottom of skillet."
        },
        {
          "step": "Brush crust evenly with basting oil; top with 1 Tbsp grated cheese and mozzarella. Break ricotta into smaller pieces; sprinkle evenly on crust. Top crust with cooked spinach; sprinkle with garlic powder and remaining grated cheese."
        },
        {
          "step": "Bake 12-15 min. Remove skillet carefully from oven using oven mitts; transfer pizza to cutting board with spatula. Slice."
        }
      ]
    }
  ],
                currentIndex: 0
            }
        },
        computed: {
            // user: function(){
            //     return { id: '',
            //         firstName: this.$root.userStore.state.firstName,
            //         lastName: 'In',
            //         username: '',
            //         emailAdress: ''
            //     }
            // }
            items2: function(){
                return this.$root.userStore.state.pantry;
            } 
        },
        created(){
           this.$root.$on('logIn', (response) => {
            this.user = response;
        });
        console.log(this.$root.userStore.state.id);
        },
        methods: {
            left: function(){
                this.currentIndex--;
                if(this.currentIndex < 0){
                    this.currentIndex = 9;
                }
            },
            right: function(){
                this.currentIndex++;
                if(this.currentIndex > 9){
                    this.currentIndex = 0;
                }
            },
            
            addToCart: async function(){
                let recipe = this.recipes[this.currentIndex].title;
                // let product = this.recipes[this.currentIndex].wegmansProducts;
        
                // for(let i = 0; i < product.length; i ++){
                   
                //     let sku;
                //     let baseUrl = 'https://api.wegmans.io/products/search?query=' + product[i].product + '&api-version=2018-10-18&subscription-key=' + this.subKey;
                //      await this.$axios.get(baseUrl).then((response) => {
                        
                //     sku = response.data.results[0].sku;
      
                // });
                // let value; 
                // let unit;
                // let name;
                // let skuUrl = 'https://api.wegmans.io/products/' + sku + '?api-version=2018-10-18&Subscription-Key=' + this.subKey;
                //     await this.$axios.get(skuUrl).then((response) => {
                //         name = response.data.descriptions.consumer;
                //         value = response.data.size.value;
                //         unit = response.data.size.unitOfMeasure;
                //     });
                // // need to fix...
                // this.$root.userStore.state.cart.push({sku: sku, 
                //         name: name, value: value, unit: unit})
                // let addUrl = 'http://127.0.0.1:8000/api/' + this.user.id + '/pantry?sku=' +  sku + '&value=' + value + '&unit=' + unit + '&name=' + name;
                // // await this.$axios.post(addUrl).then((response) => {
               
                // //     });
                // }
                this.$root.$emit('cart', {recipe: recipe, currentIndex: this.currentIndex});
                console.log(this.$root.userStore.state.recipes);
            }
        }
    }

</script>

<style>

    element.style {
        background-color: rgb(10, 47, 88);
    }

    body {
        background-color: black;
        font-family: "Helvetica Neue", Helvetica, "PingFang SC", "Hiragino Sans GB", "Microsoft YaHei", "微软雅黑", Arial, sans-serif;
        margin: 0;
        display: flex;
        min-height: 100vh;
        flex-direction: column;
    }

    .el-menu, body, html {
        height: 100%;
    }

    .wrapper {

        position: relative;
    }

    footer, div {
        display: block;
    }

    

    .container {
        padding-top: 70px;
        flex: 1;
    }

    .container, .wrapper {
        height: 100%;
    }

    .menu {
        height: 100%;
        background-color: #eef1f6;
    }

    .content {
        padding-top: 25px;
        padding-right: 25px;
        padding-bottom: 125px;
        padding-left: 25px;
    }

    .footer {
        height: 120px;
        background-color: #324057;
        color: #a4aebd;
        width: 100%;
        z-index: 1000;
        margin-top: -120px;
        line-height: 1;
        font-size: 22px;
    }
    .prev, .next {
  cursor: pointer;
  position: absolute;
  top: 50%;
  width: auto;
  margin-top: -22px;
  padding: 16px;
  color: white;
  font-weight: bold;
  font-size: 18px;
  transition: 0.6s ease;
  border-radius: 0 3px 3px 0;
  user-select: none;
}

</style>