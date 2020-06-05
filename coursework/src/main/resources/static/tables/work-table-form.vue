<template>
    <div class="work-form">
        <input v-if="this.IS_EDIT_MODE" type="button" value="edit" v-on:click="edit">
        <input v-else type="button" value="add" v-on:click="add">
        <input type="date" placeholder="date_work" v-model="dateWork">
        <input type="number" placeholder="car_id" v-model="carId">
        <input type="number" placeholder="master_id" v-model="masterId">
        <input type="number" placeholder="service_id" v-model="serviceId">
    </div>
</template>


<script>
    import {mapGetters, mapMutations} from "vuex";

    export default {
        name: "work-table-form",
        computed: {
            ...mapGetters(["INDEX", "IS_EDIT_MODE", "REQUEST", "INDEX", "ID", "DATE_WORK", "CAR_ID", "MASTER_ID", "SERVICE_ID", "ENTITIES"]),
            dateWork: {
                get() {
                    return this.DATE_WORK
                },
                set(dateWork) {
                    this.SET_DATE_WORK(dateWork)
                }
            },
            carId: {
                get() {
                    return this.CAR_ID
                },
                set(carId) {
                    this.SET_CAR_ID(carId)
                }
            },
            masterId: {
                get() {
                    return this.MASTER_ID
                },
                set(masterId) {
                    this.SET_MASTER_ID(masterId)
                }
            },
            serviceId: {
                get() {
                    return this.SERVICE_ID
                },
                set(serviceId) {
                    this.SET_SERVICE_ID(serviceId)
                }
            },
        },
        methods: {
            ...mapMutations(["SET_DATE_WORK" ,"SET_ID", "SET_CAR_ID", "SET_MASTER_ID", "SET_SERVICE_ID", "SET_EDIT_MODE"]),
            add: function () {
                this.REQUEST.post('/works', {
                    "dateWork": this.DATE_WORK,
                    "carId": this.CAR_ID,
                    "masterId": this.MASTER_ID,
                    "serviceId": this.SERVICE_ID
                }).then((result) => {
                    this.ENTITIES.push(result.data)
                })
                this.SET_DATE_WORK('')
                this.SET_CAR_ID('')
                this.SET_MASTER_ID('')
                this.SET_SERVICE_ID('')
            },
            edit: function () {
                this.REQUEST.post('/works', {
                    "id": this.ID,
                    "dateWork": this.DATE_WORK,
                    "carId": this.CAR_ID,
                    "masterId": this.MASTER_ID,
                    "serviceId": this.SERVICE_ID
                }).then((result) => {
                    this.ENTITIES.splice(this.INDEX(result.data.id), 1, result.data)
                })
                this.SET_EDIT_MODE(false)
                this.SET_ID('')
                this.SET_DATE_WORK('')
                this.SET_CAR_ID('')
                this.SET_MASTER_ID('')
                this.SET_SERVICE_ID('')
            }
        }
    }
</script>

<style scoped>
    .work-form {
        display: flex;
        justify-content: space-around;
        margin-top: 0px;
    }

    .work-form input {
        padding: 8px 16px;
        flex-basis: 20%;
        align-items: center;
    }
</style>