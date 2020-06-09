<template>
    <div class="car-table">
        <div class="car-form">
            <car-table-form></car-table-form>
        </div>
        <div class="car-table-header">
            <p class="row">Id</p>
            <p class="row">Mark</p>
            <p class="row">Num</p>
            <p class="row">Color</p>
            <p class="row">Is Foreign</p>
            <p class="row"></p>
        </div>
        <div class="car-table-body">
            <car-table-row v-for="row in cars_data" :key="row.id" :row_data="row"></car-table-row>
        </div>
    </div>
</template>

<script>
    import carTableRow from './car-table-row.vue'
    import carTableForm from './car-table-form.vue'

    export default {
        name: "car-table",
        props: {
            cars_data: {
                type: Array,
                default: () => {
                    return []
                }
            }
        },
        components: {
            carTableRow,
            carTableForm
        }
    }
</script>

<style scoped>
    .car-table {
        position: relative;
        max-width: 70%;
        margin-left: auto;
        margin-right: 90px;
        margin-top: 0;
    }
    .car-table-header {
        display: flex;
        justify-content: space-around;
        border-bottom: solid 1px #e7e7e7;
        text-align: center;

    }
    .row {
        padding: 8px 16px;
        flex-basis: 16.6%;
        text-align: center;
    }

</style>