<template>
    <div class="car-table-form">
        <input v-if="this.IS_EDIT_MODE" type="button" value="edit" v-on:click="edit">
        <input v-else type="button" value="add" v-on:click="add">
        <input type="text" placeholder="mark" v-model="mark">
        <input type="text" placeholder="num" v-model="num">
        <input type="text" placeholder="color" v-model="color">
        <input type="checkbox" class="checkbox" v-model="isForeign">
    </div>
</template>

<script>
    import {mapGetters, mapMutations} from "vuex"

    export default {
        name: "car-form",
        computed: {
            ...mapGetters(["REQUEST","INDEX", "ID" ,"MARK", "NUM", "COLOR", "FOREIGN", "IS_EDIT_MODE", "ENTITIES"]),
            mark: {
                get() {
                    return this.MARK
                },
                set(mark) {
                    this.SET_MARK(mark)
                }
            },
            num: {
                get() {
                    return this.NUM
                },
                set(num) {
                    this.SET_NUM(num)
                }
            },
            color: {
                get() {
                    return this.COLOR
                },
                set(color) {
                    this.SET_COLOR(color)
                }
            },
            isForeign: {
                get() {
                    return this.FOREIGN
                },
                set(isForeign) {
                    this.SET_FOREIGN(isForeign)
                }
            },
        },
        methods: {
            ...mapMutations(["SET_EDIT_MODE" ,"SET_ID", "SET_MARK", "SET_NUM", "SET_COLOR", "SET_FOREIGN"]),
            add: function () {
                this.REQUEST.post('/cars', {
                    "num": this.NUM,
                    "color": this.COLOR,
                    "mark": this.MARK,
                    "foreign": this.FOREIGN
                }).then((result) => {
                    this.ENTITIES.push(result.data)
                })
                this.SET_NUM('')
                this.SET_MARK('')
                this.SET_COLOR('')
                this.SET_FOREIGN(false)
            },
            edit: function () {
                this.REQUEST.post('/cars', {
                    "id": this.ID,
                    "num": this.NUM,
                    "color": this.COLOR,
                    "mark": this.MARK,
                    "foreign": this.FOREIGN
                }).then((result) => {
                    this.ENTITIES.splice(this.INDEX(result.data.id), 1, result.data)
                })
                this.SET_EDIT_MODE(false)
                this.SET_ID('')
                this.SET_NUM('')
                this.SET_MARK('')
                this.SET_COLOR('')
                this.SET_FOREIGN(false)
            }
        }
    }
</script>

<style scoped>
    .car-table-form {
        display: flex;
        justify-content: space-around;
        margin-top: 0px;
    }

    .checkbox {
        align-self: center;
    }

    .car-form input {
        padding: 8px 16px;
        flex-basis: 20%;
        align-items: center;
    }
</style>