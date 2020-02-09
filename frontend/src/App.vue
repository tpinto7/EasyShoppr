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
  <div>
      <b-card>
        <img :src="recipes[currentIndex].imgUrl" center/>
        <b-btn @click="addToCart">Add to Cart</b-btn>
      </b-card>
      </div>
  <!--  -->
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
                recipes: [   {
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
    }],
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