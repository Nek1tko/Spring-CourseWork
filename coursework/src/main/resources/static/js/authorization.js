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
        AUTHORIZED(state) {
            return state.isAuthorized
        },
        USERNAME(state) {
            return state.username
        },
        PASSWORD(state) {
            return  state.password
        },
        REQUEST(state) {
            return state.apiRequest
        }
    },
    actions: {
        SEND_AUTH_REQUEST({state, commit}) {
            axios.post(state.apiURL + '/auth/signin', {
                userName: state.username === '' ? null : state.username,
                password: state.password === '' ? null : state.password
            }).then(result => {
                if (result.status === 200) {
                    state.jwtToken = result.data.token
                    state.apiRequest = axios.create({
                        baseURL: state.apiURL,
                        headers: {
                            Authorization: 'Bearer ' + result.data.token
                        }
                    })
                    state.isAuthorized = true
                    sessionStorage.jwtToken = state.jwtToken
                }
                }).catch(error => {
                if (error.response.status === 401) {
                    window.alert(error.response.data.message)
                }
            })
            state.username = ''
            state.password = ''
        },
        SEND_REGISTRATION_REQUEST({state}) {
            axios.post(state.apiURL + '/register', {
                userName: state.username === '' ? null : state.username,
                password: state.password === '' ? null : state.password
            }).then(response => {
                if (response.status === 200) {
                    window.alert("User added")
                }
            }).catch(error => {
                if (error.response.status === 403 || error.response.status === 401) {
                    window.alert(error.response.data.message)
                }
            })
            state.username = ''
            state.password = ''
        }
    },
    mutations: {
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