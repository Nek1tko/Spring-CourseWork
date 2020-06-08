const car = {
    state: {
        id: '',
        mark: '',
        num: '',
        color: '',
        isForeign: false
    },
    getters: {
        MARK(state) {
            return state.mark
        },
        NUM(state) {
            return state.num
        },
        COLOR(state) {
            return state.color
        },
        FOREIGN(state) {
            return state.isForeign
        },
        ID(state) {
            return state.id
        }
    },
    mutations: {
        SET_ID(state, id) {
            state.id = id
        },
        SET_MARK(state, mark) {
            state.mark = mark
        },
        SET_NUM(state, num) {
            state.num = num
        },
        SET_COLOR(state, color) {
            state.color = color
        },
        SET_FOREIGN(state, isForeign) {
            state.isForeign = isForeign
        }
    }
}

export default car