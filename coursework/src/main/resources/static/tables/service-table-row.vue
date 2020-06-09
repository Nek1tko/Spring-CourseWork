<template>
    <div class="service-table-row" v-on:dblclick="edit">
        <div class="row id"> {{row_data.id}} </div>
        <div class="row name"> {{row_data.name}} </div>
        <div class="row costOur"> {{row_data.costOur}} </div>
        <div class="row costForeign"> {{row_data.costForeign}} </div>
        <div class="row">
            <input class="delete" type="button" value="Delete" v-on:click="remove">
        </div>
    </div>
</template>

<script>
    import {mapGetters, mapMutations} from "vuex";

    export default {
        name: "service-table-row",
        props: {
            row_data: {
                type: Object,
                default: () => {
                    return {}
                }
            }
        },
        computed: {
            ...mapGetters(["REQUEST", "ENTITIES"])
        },
        methods: {
            ...mapMutations(["SET_EDIT_MODE" ,"SET_ID", "SET_NAME", "SET_COST_FOREIGN", "SET_COST_OUR", "SET_AUTHORIZED"]),
            edit: function () {
                this.SET_ID(this.row_data.id)
                this.SET_NAME(this.row_data.name)
                this.SET_COST_OUR(this.row_data.costOur)
                this.SET_COST_FOREIGN(this.row_data.costForeign)
                this.SET_EDIT_MODE(true)
            },
            remove: function () {
                this.REQUEST.delete('/services/' + this.row_data.id).then(response => {
                    if (response.status === 200) {
                        this.ENTITIES.splice(this.ENTITIES.indexOf(this.row_data), 1)
                    }
                }).catch(error => {
                    if (error.response.status === 403 || error.response.status === 404) {
                        window.alert(error.response.data.message)
                    }
                    else if (error.response.status === 401) {
                        sessionStorage.jwtToken = ''
                        this.SET_AUTHORIZED(false)
                    }
                })
            }
        }
    }
</script>

<style scoped>
    .service-table-row {
        display: flex;
        justify-content: space-around;
    }
    .row {
        padding: 8px 8px;
        flex-basis: 20%;
        text-align: center;
        align-self: center;
    }
    .delete {
        padding: 8px 8px;
        max-width: 70px;
        align-self: center;
    }
</style>