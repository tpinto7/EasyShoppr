<template>
    <b-modal id="pantryModal" no-fade ref="pantryModal" cancel-variant="outline-secondary" @keydown.enter.native.prevent="saveForm">

        <div slot="modal-header" class="d-flex w-100 h-100">
            <h5 class="modal-title align-self-center text-center">{{user.firstName}} {{user.lastName}}'s Pantry </h5>
            <button type="button" aria-label="Close" class="close" @click="hideModal"><i class="fa fa-times"></i></button>
        </div>
 <b-table striped hover :items="items2"></b-table>

        <div slot="modal-footer" class="w-100">
            <div class="float-right"> 
             
            </div>
        </div>
    </b-modal>
</template>

<script>
    export default {
        data () {
            return {
                items: [

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
                
            };
        },
        computed:{
            items2: function(){
                return this.$root.userStore.state.pantry;
            } 
        },
        created(){
            // fill dropdown for adding new memberships
         this.$root.$on('logIn', (response) => {
            this.user = response;
            this.reloadPantry();
        });

            }, 
        methods: {
            reloadPantry(){
                let url = 'http://127.0.0.1:8000/api/' + this.$root.userStore.state.id + '/pantry'
                this.$axios.get(url).then((response) => {
                    let itemsZ = response.data;
                    console.log(response.data)
                    for(let itemI = 0; itemI < itemsZ.length; itemI++){
                        let item = itemsZ[itemI]
                        this.$root.userStore.state.pantry.push({sku: item.sku, 
                        name: item.name, value: item.value, unit: item.unit})
                        // console.log(items[item])
                    }
                   
                })
            },
            hideModal () {
                this.resetDialog();
                this.$refs.pantryModal.hide();
            },
            // Clean dialog after closing/saving
            resetDialog () {
                this.selectedGroup = {};
            },
            async onReset(){
                this.email = '';
                this.password = '';
            },
        }
    };
</script>

<style >
.modal-backdrop{
    opacity: .5;
}
</style>

