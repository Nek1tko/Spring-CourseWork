<template>
  <div id="app">
      <div v-if="this.AUTHORIZED">
          <navigation-bar />
          <car-table v-if="CARS" :cars_data="ENTITIES" />
          <work-table v-if="WORKS" :works_data="ENTITIES" />
          <service-table v-if="SERVICES" :services_data="ENTITIES" />
          <master-table v-if="MASTERS" :masters_data="ENTITIES" />
          <log-out />
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
import LogOut from "./components/log-out.vue";

export default {
    name: 'App',
    components: {
        LogOut,
        AuthForm,
        MasterTable,
        ServiceTable,
        WorkTable,
        NavigationBar,
        carTable
    },
    computed: {
        ...mapGetters(["ENTITIES", "CARS", "SERVICES", "WORKS", "MASTERS", "AUTHORIZED"])
    },
    created() {
        this.SET_JWT_TOKEN(sessionStorage.jwtToken)
        if(sessionStorage.jwtToken) {
            this.SET_AUTHORIZED(true)
        }
    },
    methods: {
        ...mapMutations(["SET_AUTHORIZED", "SET_JWT_TOKEN"]),
    }
}
</script>

<style>
#app {
    font-family: "Source Sans";
    color: #2c3e50;
    width: 100%;
    height: 100vh;
    display: table;
}
</style>
