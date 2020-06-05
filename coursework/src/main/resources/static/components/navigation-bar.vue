<template>
        <ul>
            <li v-on:click="works" v-bind:class="{active: WORKS}"> Works </li>
            <li v-on:click="cars" v-bind:class="{active: CARS}"> Cars </li>
            <li v-on:click="services" v-bind:class="{active: SERVICES}"> Services </li>
            <li v-on:click="masters" v-bind:class="{active: MASTERS}"> Masters </li>
        </ul>
</template>

<script>
    import {mapActions, mapGetters} from "vuex";
    export default {
        name: "navigation-bar",
        computed: {
            ...mapGetters(["CARS", "SERVICES", "WORKS", "MASTERS"])
        },
        methods: {
            ...mapActions(["GET_CARS", "GET_WORKS", "GET_SERVICES", "GET_MASTERS"]),
            cars: function () {
                this.GET_CARS()
            },
            works: function () {
                this.GET_WORKS()
            },
            services: function() {
                this.GET_SERVICES()
            },
            masters: function () {
                this.GET_MASTERS()
            }
        }
    }
</script>

<style scoped>
    ul {
        list-style-type: none;
        margin: 0;
        padding: 0;
        width: 25%;
        background-color: #f1f1f1;
        height: 100%;
        position: fixed;
        overflow: auto;
    }

    li {
        display: block;
        color: #000;
        padding: 8px 16px;
        text-decoration: none;
        text-align: center;
        border-bottom: 1px solid #555;
    }

    li:hover {
        background-color: #555;
        color: white;
    }

    .active {
        background-color: #4CAF50;
        color: white;
    }
</style>