import axios from 'axios'

const authorization = {
    state: {
        isAuthorized: false,
        username: '',
        password: '',
        jwtToken: '',
        apiRequest: '',
        apiURL: 'http://localhost:8080/carservice'
    },
    getters: {
        IS_AUTHORIZED(state) {
            return state.isAuthorized
        },
        USERNAME(state) {
            return state.username
        },
        PASSWORD(state) {
            return state.password
        },
        REQUEST(state) {
            return state.apiRequest
        }
    },
    actions: {
        SEND_AUTH_REQUEST({state, commit}) {
            axios.post(state.apiURL + '/auth/signin', {
                userName: state.username,
                password: state.password
            }).then(result => {
                state.jwtToken = result.data.token
                state.apiRequest = axios.create({
                    baseURL: state.apiURL,
                    headers: {
                        Authorization: 'Bearer ' + result.data.token
                    }
                })
                state.isAuthorized = true
                commit('UPDATE_SESSION_STORAGE')
            })

        }
    },
    mutations: {
        UPDATE_SESSION_STORAGE(state) {
            sessionStorage.isAuthorized = state.isAuthorized
            sessionStorage.jwtToken = state.jwtToken
        },
        SET_JWT_TOKEN(state, jwtToken) {
            state.jwtToken = jwtToken
            state.apiRequest = axios.create({
                baseURL: state.apiURL,
                headers: {
                    Authorization: 'Bearer ' + jwtToken
                }
            })
        },
        SET_AUTHORIZED(state, isAuthorized) {
            state.isAuthorized = isAuthorized
        },
        SET_USERNAME(state, username) {
            state.username = username
        },
        SET_PASSWORD(state, password) {
            state.password = password
        }
    }
}

export default authorization