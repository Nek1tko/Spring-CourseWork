<template>
    <div class="work-table">
        <div class="work-form">
            <work-table-form></work-table-form>
        </div>
        <div class="work-table-header">
            <p>Id</p>
            <p>Date Work</p>
            <p>Car Id</p>
            <p>Master Id</p>
            <p>Service Id</p>
            <p></p>
        </div>
        <div class="car-table-body">
            <work-table-row v-for="row in works_data" :key="row.id" :row_data="row"></work-table-row>
        </div>
    </div>
</template>

<script>
    import workTableRow from "./work-table-row.vue";
    import workTableForm from "./work-table-form.vue";
    import {mapActions} from "vuex";

    export default {
        name: "work-table",
        props: {
            works_data: {
                type: Array,
                default: () => {
                    return []
                }
            }
        },
        mounted() {
            this.GET_WORKS()
        },
        components: {
            workTableRow,
            workTableForm
        },
        methods: {
            ...mapActions(["GET_WORKS"])
        }
    }
</script>

<style scoped>
    .work-table {
        max-width: 70%;
        margin-left: auto;
        margin-right: 0;
        margin-top: 0;
    }
    .work-table-header {
        display: flex;
        justify-content: space-around;
        border-bottom: solid 1px #e7e7e7;

    }
    p {
        padding: 8px 16px;
        flex-basis: 16.6%;
        text-align: left;
    }

</style>