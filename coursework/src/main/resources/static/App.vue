<template>
  <div id="app">
      <div v-if="IS_AUTHORIZED">
          <navigation-bar />
          <car-table v-if="CARS" :cars_data="ENTITIES" />
          <work-table v-if="WORKS" :works_data="ENTITIES" />
          <service-table v-if="SERVICES" :services_data="ENTITIES" />
          <master-table v-if="MASTERS" :masters_data="ENTITIES" />
      </div>
      <div v-else>
          <auth-form />
      </div>
  </div>
</template>

<script>
    import {mapGetters, mapMutations} from 'vuex'
import carTable from './tables/car-table.vue'
import NavigationBar from "./components/navigation-bar.vue";
import WorkTable from "./tables/work-table.vue";
import ServiceTable from "./tables/service-table.vue";
import MasterTable from "./tables/master-table.vue";
import AuthForm from "./auth/auth-form.vue";

export default {
    name: 'App',
    components: {
        AuthForm,
        MasterTable,
        ServiceTable,
        WorkTable,
        NavigationBar,
        carTable
    },
    data: () => {
        return{}
    },
    computed: {
        ...mapGetters(["ENTITIES", "CARS", "SERVICES", "WORKS", "MASTERS", "IS_AUTHORIZED"])
    },

    methods: {
        ...mapMutations(["SET_AUTHORIZED", "SET_JWT_TOKEN"]),
    },
    mounted() {
        if (localStorage.isAuthorized) {
            this.SET_AUTHORIZED(localStorage.isAuthorized)
            this.SET_JWT_TOKEN(localStorage.jwtToken)
        }
    }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
