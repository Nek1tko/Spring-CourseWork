const work = {
    state: {
        dateWork: '',
        carId: '',
        masterId: '',
        serviceId: ''
    },
    getters: {
        DATE_WORK(state) {
            return state.dateWork
        },
        CAR_ID(state) {
            return state.carId
        },
        MASTER_ID(state) {
            return state.masterId
        },
        SERVICE_ID(state) {
            return state.serviceId
        }
    },
    mutations: {
        SET_DATE_WORK(state, dateWork) {
            state.dateWork = dateWork
        },
        SET_CAR_ID(state, carId) {
            state.carId = carId
        },
        SET_MASTER_ID(state, masterId) {
            state.masterId = masterId
        },
        SET_SERVICE_ID(state, serviceId) {
            state.serviceId = serviceId
        }
    }
}

export default work