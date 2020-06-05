const service = {
    state: {
        costOur: '',
        costForeign: '',
    },
    getters: {
        COST_OUR(state) {
            return state.costOur
        },
        COST_FOREIGN(state) {
            return state.costForeign
        }
    },
    mutations: {
        SET_COST_OUR(state, costOur) {
            state.costOur = costOur
        },
        SET_COST_FOREIGN(state, costForeign) {
            state.costForeign = costForeign
        }
    }
}

export default service