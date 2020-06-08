<template>
    <div class="master-table-form">
        <input class="button" v-if="this.IS_EDIT_MODE" type="button" value="Edit" v-on:click="edit">
        <input class="button" v-else type="button" value="Add" v-on:click="add">
        <input type="text" placeholder="name" v-model="name">
    </div>
</template>


<script>
    import {mapGetters, mapMutations} from "vuex";

    export default {
        name: "master-table-form",
        computed: {
            ...mapGetters(["REQUEST", "INDEX", "ID" , "NAME", "IS_EDIT_MODE", "ENTITIES"]),
            name: {
                get: function () {
                    return this.NAME
                },
                set: function (name) {
                    this.SET_NAME(name)
                }
            }
        },
        methods: {
            ...mapMutations(["SET_EDIT_MODE" ,"SET_ID", "SET_NAME"]),
            add: function () {
                this.REQUEST.post('/masters', {
                    "name": this.NAME
                }).then((result) => {
                    this.ENTITIES.push(result.data)
                }).catch(error => {
                    if (error.response.status === 403) {
                        window.alert(error.response.data.message)
                    }
                })
                this.SET_NAME('')
            },
            edit: function () {
                this.REQUEST.post('/masters', {
                    "id": this.ID,
                    "name": this.NAME
                }).then((result) => {
                    this.ENTITIES.splice(this.INDEX(result.data.id), 1, result.data)
                }).catch(error => {
                    if (error.response.status === 403) {
                        window.alert(error.message)
                    }
                })
                this.SET_ID('')
                this.SET_NAME('')
                this.SET_EDIT_MODE(false)
            }
        }
    }
</script>

<style scoped>
    .master-table-form {
        display: flex;
        justify-content: left;
        margin-top: 0px;
    }

    input {
        padding: 8px 16px;
        flex-basis: 25%;
        align-items: center;
    }

    .button {
        max-width: 70px;
    }
</style>