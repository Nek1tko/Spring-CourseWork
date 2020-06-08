const service = {
    state: {
        name: '',
        costOur: '',
        costForeign: '',
    },
    getters: {
        NAME(state) {
            return state.name
        },
        COST_OUR(state) {
            return state.costOur
        },
        COST_FOREIGN(state) {
            return state.costForeign
        }
    },
    mutations: {
        SET_NAME(state, name) {
            state.name = name
        },
        SET_COST_OUR(state, costOur) {
            state.costOur = costOur
        },
        SET_COST_FOREIGN(state, costForeign) {
            state.costForeign = costForeign
        }
    }
}

export default service