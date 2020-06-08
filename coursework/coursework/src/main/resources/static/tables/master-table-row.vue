<template>
    <div class="master-table-row" v-on:dblclick="edit">
        <div class="row id"> {{row_data.id}}</div>
        <div class="row name"> {{row_data.name}}</div>
        <div class="row">
            <input class="delete" type="button" value="Delete" v-on:click="remove">
        </div>
    </div>
</template>

<script>
    import {mapGetters, mapMutations} from "vuex";

    export default {
        name: "master-table-row",
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
            ...mapMutations(["SET_EDIT_MODE", "SET_ID", "SET_NAME"]),
            edit: function () {
                this.SET_ID(this.row_data.id)
                this.SET_NAME(this.row_data.name)
                this.SET_EDIT_MODE(true)
            },
            remove: function () {
                this.REQUEST.delete('/masters/' + this.row_data.id).then(response => {
                    if (response.status === 200) {
                        this.ENTITIES.splice(this.ENTITIES.indexOf(this.row_data), 1)
                    }
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
    .master-table-row {
        display: flex;
        justify-content: space-around;
    }

    .row {
        padding: 8px 8px;
        flex-basis: 33%;
        text-align: center;

    }
    .delete {
        padding: 8px 8px;
        max-width: 70px;
        align-self: center;
    }
</style>