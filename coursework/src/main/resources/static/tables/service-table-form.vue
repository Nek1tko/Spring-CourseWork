<template>
    <div class="service-table-form">
        <input type="button" value="add" v-on:click="buttonClicked">
        <input type="text" placeholder="name" v-model="name">
        <input type="number" placeholder="cost_our" v-model="costOur">
        <input type="number" placeholder="cost_foreign" v-model="costForeign">
    </div>
</template>


<script>
    import axios from 'axios'

    export default {
        name: "service-table-form",
        data: function() {
            return {
                name: '',
                costOur: '',
                costForeign: ''
            }
        },
        props: {
        },
        methods: {
            buttonClicked: function () {
                axios.post('http://localhost:8080/carservice/services', {
                    "name": this.name,
                    "costOur": this.costOur,
                    "costForeign": this.costForeign
                }).then((result) => {
                    this.$store.state.entities.push(result.data)
                })
                this.name = ''
                this.costOur = ''
                this.costForeign = ''
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