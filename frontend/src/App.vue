<template>
    <div class="wrapper">
        <div>
  <b-navbar toggleable="lg" type="dark" variant="info">
    <b-navbar-brand href="#">EasyShoppr</b-navbar-brand>

    <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

    <b-collapse id="nav-collapse" is-nav>
      <b-navbar-nav>
        <b-nav-item href="#">Link</b-nav-item>
        <b-nav-item href="#" disabled>Disabled</b-nav-item>
      </b-navbar-nav>

      <!-- Right aligned nav items -->
      <b-navbar-nav class="ml-auto">
        <!-- <b-nav-form>
          <b-form-input size="sm" class="mr-sm-2" placeholder="Search"></b-form-input>
          <b-button size="sm" class="my-2 my-sm-0" type="submit">Search</b-button>
        </b-nav-form> -->

  <i class="fa fa-fw fa-shopping-cart" style="font-size:36px;"></i>
  <i class="fa fa-fw fa-user" style="font-size:36px;" right></i>
        <b-nav-item-dropdown right>
          <!-- Using 'button-content' slot -->
        
          <template v-slot:button-content>
            <em>User</em>
          </template>
          <b-dropdown-item href="#">Profile</b-dropdown-item>
          <b-dropdown-item href="#">Sign Out</b-dropdown-item>
        </b-nav-item-dropdown>
      </b-navbar-nav>
    </b-collapse>
  </b-navbar>
  <div>
      <b-card>
        <img :src="recipes[currentIndex].imgUrl" center/>
        <b-btn @click="addToCart">Add to Cart</b-btn>
      </b-card>
      </div>
  <!--  -->
</div>
</div>

</template>

<script>

    export default {
        name: 'app',
        components: {

        },
        data(){
            return{
                recipes: [  {
   "recipeName": "Acorn Squash with Asian Flavors",
   "url": "https://shop.wegmans.com/recipes/2995/asian-cauliflower-rice-lettuce-wraps",
   "imgUrl": "https://assets-prd-weg.unataops.com/web/recipe_header/7986c9265540449aa4fcea8de5d2de5e.jpg",
   "totalCookTime": "55 mins",
   "prepTime": "35 mins",
   "servings": "4",
   "rating": "5.00 (10)",
   "ingredients": [
    {
     "ingrAmountName": "1/2 of an 8 oz pkg Food You Feel Good About Farro, cooked per pkg directions"
    },
    {
     "ingrAmountName": "2 Tbsp Wegmans Pure Olive Oil"
    },
    {
     "ingrAmountName": "1 lb Food You Feel Good About Cauliflower Rice"
    },
    {
     "ingrAmountName": "1 head (about 1/4 lb) Shanghai bok choy, trimmed, thinly sliced"
    },
    {
     "ingrAmountName": "2 Tbsp peeled, minced fresh ginger"
    },
    {
     "ingrAmountName": "1 Tbsp minced Food You Feel Good About Cleaned & Cut Peeled Garlic"
    },
    {
     "ingrAmountName": "1/2 cup Wegmans Organic Matchstick Carrots"
    },
    {
     "ingrAmountName": "2 Tbsp Kikkoman Manjo Aji-Mirin Sweet Cooking Rice Seasoning"
    },
    {
     "ingrAmountName": "2 Tbsp Food You Feel Good About Pure Toasted Sesame Oil"
    },
    {
     "ingrAmountName": "2 Tbsp Food You Feel Good About Soy Sauce"
    },
    {
     "ingrAmountName": "1 bunch green onions, trimmed, thinly sliced"
    },
    {
     "ingrAmountName": "Salt to taste"
    },
    {
     "ingrAmountName": "1 pkg (7 oz) Food You Feel Good About Fresh Green Lettuce Leaves"
    },
    {
     "ingrAmountName": "1 Tbsp roasted salted whole cashews (Bulk Foods), chopped, for garnish"
    },
    {
     "ingrAmountName": "Food You Feel Good About Tom Tom Sauce to taste"
    }
   ],
   "wegmansProduct": [
    {
     "productName": "Wegmans Farro",
     "price": "$2.99"
    },
    {
     "productName": "Green Onions (Scallions)",
     "price": "$0.99"
    },
    {
     "productName": "Shanghai Bok Choy",
     "price": "$0.32"
    },
    {
     "productName": "Fresh Ginger",
     "price": "$0.70"
    },
    {
     "productName": "Wegmans Green Lettuce Leaves",
     "price": "$3.99"
    },
    {
     "productName": "Kikkoman Rice Seasoning, Sweet Cooking, Manjo Aji-Mirin",
     "price": "$4.49"
    },
    {
     "productName": "Wegmans Cauliflower Rice",
     "price": "$4.99"
    },
    {
     "productName": "Wegmans Garlic, Peeled",
     "price": "$3.99"
    },
    {
     "productName": "Wegmans Pure Toasted Sesame Oil",
     "price": "$3.49"
    },
    {
     "productName": "Wegmans 100% Mediterranean Blend Olive Oil, Pure",
     "price": "$3.99"
    },
    {
     "productName": "Wegmans Soy Sauce",
     "price": "$3.29"
    },
    {
     "productName": "Wegmans Tom Tom Sauce",
     "price": "$3.49"
    },
    {
     "productName": "Wegmans Organic Matchstick Carrots",
     "price": "$1.99"
    }
   ]
  }],
                currentIndex: 0
            }
        },
        computed: {
            sat: function(){
                return this.saturation
            }
        },
        created(){
         
        },
        methods: {
            addToCart: function(){
                console.log("test");
                for(let i = 0; i < this.recipes[this.currentIndex]; i ++){
                    
                }
            }
        }
    }

</script>

<style>

    element.style {
        background-color: rgb(10, 47, 88);
    }

    body {
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

</style>