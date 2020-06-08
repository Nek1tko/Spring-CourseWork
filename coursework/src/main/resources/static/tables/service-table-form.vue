<template>
    <div class="service-table-form">
        <input v-if="this.IS_EDIT_MODE" type="button" value="edit" v-on:click="edit">
        <input v-else type="button" value="add" v-on:click="add">
        <input type="text" placeholder="name" v-model="name">
        <input type="number" placeholder="cost_our" v-model="costOur">
        <input type="number" placeholder="cost_foreign" v-model="costForeign">
    </div>
</template>


<script>
    import axios from 'axios'
    import {mapGetters, mapMutations} from "vuex";

    export default {
        name: "service-table-form",
        computed: {
            ...mapGetters(["REQUEST", "INDEX", "ID" , "NAME", "COST_OUR", "COST_FOREIGN", "IS_EDIT_MODE", "ENTITIES"]),
            name: {
                get: function() {
                    return this.NAME
                },
                set: function(name) {
                    this.SET_NAME(name)
                }
            },
            costOur: {
                get: function() {
                    return this.COST_OUR
                },
                set: function(cost_our) {
                    this.SET_COST_OUR(cost_our)
                }
            },
            costForeign: {
                get: function() {
                    return this.COST_FOREIGN
                },
                set: function(cost_foreign) {
                    this.SET_COST_FOREIGN(cost_foreign)
                }
            },
        },
        methods: {
            ...mapMutations(["SET_EDIT_MODE" ,"SET_ID", "SET_NAME", "SET_COST_FOREIGN", "SET_COST_OUR"]),
            add: function () {
                this.REQUEST.post('/services', {
                    "name": this.NAME,
                    "costOur": this.COST_OUR,
                    "costForeign": this.COST_FOREIGN
                }).then((result) => {
                    this.ENTITIES.push(result.data)
                })
                this.SET_NAME('')
                this.SET_COST_OUR('')
                this.SET_COST_FOREIGN('')
            },
            edit: function () {
                this.REQUEST.post('/services', {
                    "id": this.ID,
                    "name": this.NAME,
                    "costOur": this.COST_OUR,
                    "costForeign": this.COST_FOREIGN
                }).then((result) => {
                    this.ENTITIES.splice(this.INDEX(result.data.id), 1, result.data)
                })
                this.SET_ID('')
                this.SET_NAME('')
                this.SET_COST_OUR('')
                this.SET_COST_FOREIGN('')
                this.SET_EDIT_MODE(false)
            }
        }
    }
</script>

<style scoped>
    .service-table-form {
        display: flex;
        justify-content: space-around;
        margin-top: 0px;
    }

    input {
        padding: 8px 16px;
        flex-basis: 25%;
        align-items: center;
    }
</style>