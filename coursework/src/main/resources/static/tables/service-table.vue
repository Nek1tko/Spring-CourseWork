<template>
    <div class="service-table">
        <div class="service-form">
            <service-table-form />
        </div>
        <div class="service-table-header">
            <p>Id</p>
            <p>Name</p>
            <p>Cost Our</p>
            <p>Cost Foreign</p>
            <p></p>
        </div>
        <div class="service-table-body">
            <service-table-row v-for="row in services_data" :key="row.id" :row_data="row" />
        </div>
    </div>
</template>

<script>
    import ServiceTableRow from "./service-table-row.vue";
    import ServiceTableForm from "./service-table-form.vue";

    export default {
        name: "service-table",
        props: {
            services_data: {
                type: Array,
                default: () => {
                    return []
                }
            }
        },
        components: {
            ServiceTableForm,
            ServiceTableRow,
        }
    }
</script>

<style scoped>
    .service-table {
        max-width: 70%;
        margin-left: auto;
        margin-right: 0;
        margin-top: 0;
    }
    .service-table-header {
        display: flex;
        justify-content: space-around;
        border-bottom: solid 1px #e7e7e7;

    }
    p {
        padding: 8px 16px;
        flex-basis: 20%;
        text-align: left;
    }

</style>