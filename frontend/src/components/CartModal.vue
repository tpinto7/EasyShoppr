<template>
    <b-modal id="cartModal" size="lg" no-fade ref="cartModal" cancel-variant="outline-secondary" @keydown.enter.native.prevent="saveForm">

        <div slot="modal-header" class="d-flex w-100 h-100">
            <h5 class="modal-title align-self-center text-center">{{user.firstName}} {{user.lastName}}'s Cart </h5>
            <button type="button" aria-label="Close" class="close" @click="hideModal"><i class="fa fa-times"></i></button>
        </div>
        <b-table striped hover :items="orders" :fields="fields"></b-table>
        <div class="float-right"> <b-btn variant="primary" @click="calculateIngredients" right>Calculate</b-btn>  </div>
        <br>
        <b-table striped hover :items="items"></b-table>
        <div slot="modal-footer" class="w-100">
            <div class="float-right"> 
             
                <b-btn variant="outline-secondary" @click="hideModal">Cancel</b-btn>
                <b-button type="reset" variant="danger" @click="onReset()">Reset</b-button>
                <b-btn type="button" variant="primary" @click="saveForm()" :disabled="false">Order</b-btn>
          
            </div>
        </div>
    </b-modal>
</template>

<script>
    export default {
        data () {
            return {
                orders: [],
                items: [
                    
                ],
                fields: [
                    "title", "servings"
                ],
                user: {
                    id: this.$root.userStore.state.id,
                    firstName: this.$root.userStore.state.firstName,
                    lastName: this.$root.userStore.state.lastName,
                    username: this.$root.userStore.state.username,
                    emailAdress:this.$root.userStore.state.emailAddress

                },
                email: '',
                resourceName: "Group",
                availableGroups: [],
                selectedGroup: {},
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
                
            };
        },
        created(){
            // fill dropdown for adding new memberships
         this.$root.$on('logIn', (response) => {
            // this.reloadCart();
            this.user = response;
        });
        this.$root.$on('cart', (response) => {
            this.reloadCart(response);
            
        });

            }, 
            
            computed: {
            //      items2: function(){
            //     // return this.$root.userStore.state.cart;
            // } ,
            // recipes: function(){
            //     let toReturn = [];
            //     let ob = this.$root.userStore.state.recipes
            //     for(recipe in ob){
            //         console.log("test")
            //         toReturn.push({name: recipe, servings: ob[recipe]})
            //     }
            //     return toReturn;
            // }
            },
        methods: {
            async calculateIngredients(){
                this.items = [];
                for(let j = 0; j < this.orders.length; ++j){
                    console.log(this.orders[j].index)
                let product = this.recipes[this.orders[j].index].wegmansProducts;
        
                for(let i = 0; i < product.length; i ++){
                   
                    let sku;
                    let baseUrl = 'https://api.wegmans.io/products/search?query=' + product[i].product + '&api-version=2018-10-18&subscription-key=' + this.subKey;
                     await this.$axios.get(baseUrl).then((response) => {
                        
                    sku = response.data.results[0].sku;
      
                });
                let value; 
                let unit;
                let name;
                let skuUrl = 'https://api.wegmans.io/products/' + sku + '?api-version=2018-10-18&Subscription-Key=' + this.subKey;
                    await this.$axios.get(skuUrl).then((response) => {
                        name = response.data.descriptions.consumer;
                        value = response.data.size.value;
                        unit = response.data.size.unitOfMeasure;
                    });
                // need to fix...
                // change to amount needed from recipe
                // console.log(this.orders[i].servings)
                var check = true;
                if(i > 0){
                    for(let k = 0; k < this.items.length; k++){
                        if(this.items[k].sku == sku){
                            check = false;
                            this.items[k].required += product[i].usedAmnt.split(" ")[0] * this.orders[j].servings;
                        }
                    }
                }
                if(check){
                    this.items.push({sku: sku, 
                            name: name, required: product[i].usedAmnt.split(" ")[0] * this.orders[j].servings , value: value, unit: unit, amount: 0})
                    }
                }
                }
                this.subtractPantry();
            },
            subtractPantry(){
                for(let i = 0; i < this.items.length; ++i ){
                    let check = true;
                    for(let j = 0; j < this.$root.userStore.state.pantry.length; ++j){
                        if(this.items[i].sku == this.$root.userStore.state.pantry[j].sku){
                            check = false;
                            if(this.items[i].required < this.$root.userStore.state.pantry[j].value){
                                this.$root.userStore.state.pantry[j].value -= this.items[i].required;
                            }
                            else{
                                this.items[i].required -= this.$root.userStore.state.pantry[j].value;
                                this.$root.userStore.state.pantry[j].value = 0;
                                this.items[i].amount = Math.ceil(this.items[i].required / this.items[i].value);
                                this.$root.userStore.state.pantry[j].value =  this.items[i].value * this.items[i].amount - this.items[i].required;
                                if(this.$root.userStore.state.pantry[j].value <= 0){
                                     this.$root.userStore.state.pantry.splice(j, j-1);
                                }
                            }
                            break;
                        }
                    }
                    if(check){
                        this.items[i].amount = Math.ceil(this.items[i].required / this.items[i].value);
                        if(this.items[i].value * this.items[i].amount - this.items[i].required > 0){
                             this.$root.userStore.state.pantry.push({sku: this.items[i].sku, 
                        name: this.items[i].name, value: this.items[i].value, unit: this.items[i].unit})
                        }
                    }
                }
            },
            reloadCart(response){
                var check = true;
                for(let i = 0; i < this.orders.length; ++i){
                    console.log(this.orders[i].title);
                    console.log(response);
                    if(this.orders[i].title === response.recipe ){
                        this.orders[i].servings++;
                        check = false;
                    }
                }
                if(check){
                    this.orders.push({title: response.recipe, index: response.currentIndex, servings: 1})
                }
            },
            hideModal () {
                this.resetDialog();
                this.$refs.cartModal.hide();
            },
            // Clean dialog after closing/saving
            resetDialog () {
                this.selectedGroup = {};
            },
            async onReset(){
                this.$root.userStore.state.cart = [];
            },
            async saveForm(){
                let loginFields = {
                    email: this.form.email,
                    password: this.form.password
                }
                this.$axios.post("http://127.0.0.1:8000/api/login", loginFields).then((response) => {
                   
                        this.$root.$emit('logIn', response.data); 
                       this.email = '';
                       this.password = '';
                       this.hideModal();
                }).catch();
            }
        }
    };
</script>

<style >
.modal-backdrop{
    opacity: .5;
}
</style>

