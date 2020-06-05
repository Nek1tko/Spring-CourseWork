<template>
    <div>
        <input type="text" placeholder="username" v-model="username">
        <input type="password" v-model="password">
        <input type="button" value="sign in" v-on:click="signin">
    </div>
</template>

<script>
    import {mapActions, mapGetters, mapMutations} from "vuex";

    export default {
        name: "auth-form",
        computed: {
            ...mapGetters(["PASSWORD", "USERNAME"]),
            username: {
                get: function () {
                    return this.USERNAME
                },
                set: function (username) {
                    this.SET_USERNAME(username)
                }
            },
            password: {
                get: function () {
                    return this.PASSWORD
                },
                set: function (password) {
                    this.SET_PASSWORD(password)
                }
            }
        },
        methods: {
            ...mapActions(["SEND_AUTH_REQUEST"]),
            ...mapMutations(["SET_PASSWORD", "SET_USERNAME"]),
            signin: function () {
                this.SEND_AUTH_REQUEST()
            }
        }
    }
</script>

<style scoped>

</style>