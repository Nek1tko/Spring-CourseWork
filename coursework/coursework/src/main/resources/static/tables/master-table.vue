<template>
    <div class="master-table">
        <div class="master-form">
            <master-table-form />
        </div>
        <div class="master-table-header">
            <p>Id</p>
            <p>Name</p>
            <p></p>
        </div>
        <div class="master-table-body">
            <master-table-row v-for="row in masters_data" :key="row.id" :row_data="row" />
        </div>
    </div>
</template>

<script>
    import MasterTableRow from "./master-table-row.vue";
    import MasterTableForm from "./master-table-form.vue";

    export default {
        name: "master-table",
        props: {
            masters_data: {
                type: Array,
                default: () => {
                    return []
                }
            }
        },
        components: {
            MasterTableForm,
            MasterTableRow
        }
    }
</script>

<style scoped>
    .master-table {
        max-width: 70%;
        margin-left: auto;
        margin-right: 90px;
        margin-top: 0;
    }
    .master-table-header {
        display: flex;
        justify-content: space-around;
        border-bottom: solid 1px #e7e7e7;

    }
    p {
        padding: 8px 16px;
        flex-basis: 33%;
        text-align: center;
    }

</style>