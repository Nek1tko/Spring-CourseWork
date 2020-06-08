<template>
    <div class="master-table-row" v-on:dblclick="edit">
        <div class="row id"> {{row_data.id}}</div>
        <div class="row name"> {{row_data.name}}</div>
        <input class="row delete" type="button" value="delete" v-on:click="remove">
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
                    if (response.ok) {
                        this.ENTITIES.splice(this.ENTITIES.indexOf(this.row_data), 1)
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
        text-align: left;
        align-self: center;
    }
</style>