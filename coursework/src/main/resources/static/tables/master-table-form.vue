<template>
    <div class="master-table-form">
        <input type="button" value="add" v-on:click="buttonClicked">
        <input type="text" placeholder="name" v-model="name">
    </div>
</template>


<script>
    import axios from 'axios'

    export default {
        name: "master-table-form",
        data: function() {
            return {
                name: ''
            }
        },
        props: {
        },
        methods: {
            buttonClicked: function () {
                axios.post('http://localhost:8080/carservice/masters', {
                    "name": this.name
                }).then((result) => {
                    this.$store.state.entities.push(result.data)
                })
                this.name = ''
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
</style>