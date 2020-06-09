<template>
    <div class="singin">
        <h2>Sign in</h2>
        <form>
            <input type="text" placeholder="username" v-model="username">
            <input type="password" placeholder="password" v-model="password" autocomplete="on">
        </form>
        <input class="button" type="button" value="Sign in" v-on:click="signin">
        <input class="button" type="button" value="Register" v-on:click="register">
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
            ...mapActions(["SEND_AUTH_REQUEST", "SEND_REGISTRATION_REQUEST"]),
            ...mapMutations(["SET_PASSWORD", "SET_USERNAME"]),
            signin: function () {
                this.SEND_AUTH_REQUEST()
            },
            register: function () {
                this.SEND_REGISTRATION_REQUEST()
            }
        }
    }
</script>

<style scoped>
    .singin {
        border: 1px solid rgba(15, 10, 10, 0.3);
        padding: 3em;
        border-radius: 5px;
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translateX(-50%) translateY(-50%);
    }
    h2 {
        margin-top: 0px;
        font-family: "Source Sans";
        font-weight: lighter;
        color: #170f1e;
        font-size: 50px;
        text-align: center;
    }
    input {
        display: block;
        width: 320px;
        height: 50px;
        background: rgba(0, 0, 0, 0.3);
        outline: none;
        border: 1px solid rgba(0, 0, 0, 0.5);
        font-family: "Source Sans";
        font-weight: lighter;
        font-size: 14px;
        margin-bottom: 10px;
        padding-left: 10px;
        border-radius: 5px;
    }
    .button {
        width: 332px;
        height: 50px;
        font-size: 16px;
        background: #000;
        font-weight: lighter;
        color: #f1f1f1;
        border: 0px;
        border-radius: 5px;

    }
</style>