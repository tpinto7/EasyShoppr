<template>
    <b-modal id="loginModal"  no-fade ref="loginModal" cancel-variant="outline-secondary" @keydown.enter.native.prevent="saveForm">

        <div slot="modal-header" class="d-flex w-100 h-100">
            <h5 class="modal-title align-self-center text-center">Login </h5>
            <button type="button" aria-label="Close" class="close" @click="hideModal"><i class="fa fa-times"></i></button>
        </div>

      <b-form>
      <b-form-group
        id="input-group-1"
        label="Email address:"
      >
        <b-form-input
          id="input-1"
          v-model="form.email"
          type="email"
          required
          placeholder="Enter email"
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="Password:" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="form.password"
          required
          placeholder="Enter password"
        ></b-form-input>
      </b-form-group>


        </b-form>



        <div slot="modal-footer" class="w-100">
            <div class="float-right"> 
                <b-btn variant="outline-secondary" @click="hideModal">Cancel</b-btn>
                <b-button type="reset" variant="danger" @click="onReset()">Reset</b-button>
                <b-btn type="button" variant="primary" @click="saveForm()" :disabled="false">Submit</b-btn>
            </div>
        </div>
    </b-modal>
</template>

<script>
    export default {
        data () {
            return {
             form: {
          email: '',
          password: ''
        },
                email: '',
                resourceName: "Group",
                availableGroups: [],
                selectedGroup: {}
            };
        },
        created(){
            // fill dropdown for adding new memberships
         

            }, 
        methods: {
            hideModal () {
                this.onReset();
                this.$refs.loginModal.hide();
            },
            async onReset(){
                this.email = '';
                this.password = '';
            },
            async saveForm(){
                let loginFields = {
                    email: this.form.email,
                    password: this.form.password
                }
                this.$axios.post("http://127.0.0.1:8000/api/login", loginFields).then((response) => {
                        this.$root.userStore.state.id = response.data.id;
                         this.$root.userStore.state.firstName = response.data.firstName;
                          this.$root.userStore.state.lastName = response.data.lastName;
                           this.$root.userStore.state.emailAddress = response.data.emailAddress;
                            this.$root.userStore.state.username = response.data.username;
                        this.$root.userStore.state.pantry = [];
                        this.$root.userStore.state.cart = [];
                        this.$root.$emit('logIn', response.data); 
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

