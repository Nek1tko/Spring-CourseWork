<template>
    <div class="work-table-row" v-on:dblclick="edit">
        <div class="row id"> {{row_data.id}} </div>
        <div class="row dateWork"> {{row_data.dateWork}} </div>
        <div class="row carId"> {{row_data.carId}} </div>
        <div class="row masterId"> {{row_data.masterId}} </div>
        <div class="row serviceId"> {{row_data.serviceId}} </div>
        <input class="row delete" type="button" value="delete" v-on:click="remove">
    </div>
</template>

<script>
    import axios from 'axios'
    import {mapGetters, mapMutations} from "vuex";
    export default {
        name: "work-table-row",
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
            ...mapMutations(["SET_DATE_WORK" ,"SET_ID", "SET_CAR_ID", "SET_MASTER_ID", "SET_SERVICE_ID", "SET_EDIT_MODE"]),
            edit: function () {
                this.SET_ID(this.row_data.id)
                this.SET_DATE_WORK(this.row_data.dateWork)
                this.SET_CAR_ID(this.row_data.carId)
                this.SET_MASTER_ID(this.row_data.masterId)
                this.SET_SERVICE_ID(this.row_data.serviceId)
                this.SET_EDIT_MODE(true)
            },
            remove: function () {
                this.REQUEST.delete('/works/' + this.row_data.id).then(response => {
                    if (response.status === 200) {
                        this.ENTITIES.splice(this.ENTITIES.indexOf(this.row_data), 1)
                    }
                })
            }
        }
    }
</script>

<style scoped>
    .work-table-row {
        display: flex;
        justify-content: space-around;
    }
    .row {
        padding: 8px 8px;
        flex-basis: 16.6%;
        text-align: left;
        align-self: center;
    }
</style>