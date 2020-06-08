<template>
    <div class="car-table-row" v-on:dblclick="edit">
        <div class="row id"> {{row_data.id}} </div>
        <div class="row mark"> {{row_data.mark}} </div>
        <div class="row num"> {{row_data.num}} </div>
        <div class="row color"> {{row_data.color}} </div>
        <input class="row foreign" type="checkbox" v-model="row_data.foreign" disabled="true">
        <div class="row">
            <input class="delete" type="button" value="Delete" v-on:click="remove">
        </div>
    </div>
</template>

<script>
    import {mapGetters, mapMutations} from "vuex";
    export default {
        name: "car-table-row",
        props: {
            row_data: {
                type: Object,
                default: () => {
                    return {}
                }
            }
        },
        computed: {
            ...mapGetters(["ENTITIES", "REQUEST"])
        },
        methods: {
            ...mapMutations(["SET_EDIT_MODE", "SET_ID", "SET_MARK", "SET_NUM", "SET_COLOR", "SET_FOREIGN"]),
            edit: function () {
                this.SET_ID(this.row_data.id)
                this.SET_MARK(this.row_data.mark)
                this.SET_NUM(this.row_data.num)
                this.SET_COLOR(this.row_data.color)
                this.SET_FOREIGN(this.row_data.foreign)
                this.SET_EDIT_MODE(true)
            },
            remove: function () {
                this.REQUEST.delete('/cars/' + this.row_data.id).then(response => {
                    this.ENTITIES.splice(this.$store.state.entities.indexOf(this.row_data), 1)
                }).catch(error => {
                    if (error.response.status === 403) {
                        window.alert(error.response.data.message)
                    }
                })
            }
        }
    }
</script>

<style scoped>
    .car-table-row {
        display: flex;
        justify-content: space-around;
    }
    .row {
        padding: 8px 8px;
        flex-basis: 16.6%;
        text-align: center;
        align-self: center;
    }
    .delete {
        padding: 8px 8px;
        max-width: 70px;
        align-self: center;
    }
</style>