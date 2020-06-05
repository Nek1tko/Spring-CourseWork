<template>
    <div class="master-table-row" v-on:dblclick="edit">
        <div class="row id"> {{row_data.id}}</div>
        <div class="row name"> {{row_data.name}}</div>
        <input class="row delete" type="button" value="delete" v-on:click="remove">
    </div>
</template>

<script>
    import axios from 'axios'

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
        methods: {
            edit: function () {

            },
            remove: function () {
                axios.delete('http://localhost:8080/carservice/masters/' + this.row_data.id).then(response => {
                    if (response.ok) {
                        this.$store.state.entities.splice(this.$store.state.entities.indexOf(this.row_data), 1)
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