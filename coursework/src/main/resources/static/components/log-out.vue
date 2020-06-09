<template>
    <input type="button" value="Log out" v-on:click="logOut">
</template>

<script>
    import {mapMutations} from "vuex";

    export default {
        name: "log-out",

        methods: {
            ...mapMutations(["SET_AUTHORIZED", "SET_JWT_TOKEN"]),
            logOut: function () {
                this.SET_AUTHORIZED(false)
                this.SET_JWT_TOKEN('')
                sessionStorage.jwtToken = ''
            }
        }
    }
</script>

<style scoped>
    input {
        position: absolute;
        top: 10px;
        right: 5px;
        width: 70px;
        height: 30px;
    }
</style>