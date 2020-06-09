import Vue from 'vue'
import Vuex from 'vuex'
import authorization from './authorization'
import car from './car'
import work from './work'
import service from "./service"

Vue.use(Vuex)


const store = new Vuex.Store({
    modules: {
        work: work,
        car: car,
        service: service,
        authorization: authorization
    },
    state: {
        entities: [],
        isCars: false,
        isWorks: true,
        isMasters: false,
        isServices: false,
        isEditMode: false
    },
    actions: {
        GET_CARS({commit}) {
            return authorization.state.apiRequest.get( "/cars")
                .then((response) => {
                    if (response.status === 200) {
                        commit('SET_CARS', response.data)
                    }
                }).catch(error => {
                    if (error.response.status === 401) {
                        sessionStorage.jwtToken = ''
                        this.state.authorization.isAuthorized = false
                    }
                })
        },
        GET_WORKS({commit}) {
            return authorization.state.apiRequest.get( "/works")
                .then((response) => {
                    if (response.status === 200) {
                        commit('SET_WORKS', response.data)
                    }
                }).catch(error => {
                    if (error.response.status === 401) {
                        window.alert(error.response.data.message)
                        sessionStorage.jwtToken = ''
                        this.state.authorization.isAuthorized = false
                    }
                })
        },
        GET_SERVICES({commit}) {
            return authorization.state.apiRequest.get( "/services")
                .then((response) => {
                    if (response.status === 200) {
                        commit('SET_SERVICES', response.data)
                    }
                }).catch(error => {
                    if (error.response.status === 401) {
                        window.alert(error.response.data.message)
                        sessionStorage.jwtToken = ''
                        this.state.authorization.isAuthorized = false
                    }
                })
        },
        GET_MASTERS({commit}) {
            return authorization.state.apiRequest.get( "/masters")
                .then((response) => {
                    if (response.status === 200) {
                        commit('SET_MASTERS', response.data)
                    }
                }).catch(error => {
                    if (error.response.status === 401) {
                        window.alert(error.response.data.message)
                        sessionStorage.jwtToken = ''
                        this.state.authorization.isAuthorized = false
                    }
                })
        }
    },
    mutations: {
        SET_CARS: (state, cars) => {
            state.entities = cars
            state.isWorks = false
            state.isServices = false
            state.isMasters = false
            state.isCars = true
        },
        SET_WORKS: (state, works) => {
            state.entities = works
            state.isServices = false
            state.isMasters = false
            state.isCars = false
            state.isWorks = true
        },
        SET_SERVICES: (state, services) => {
            state.entities = services
            state.isMasters = false
            state.isCars = false
            state.isWorks = false
            state.isServices = true
        },
        SET_MASTERS: (state, masters) => {
            state.entities = masters
            state.isCars = false
            state.isWorks = false
            state.isServices = false
            state.isMasters = true
        },
        SET_EDIT_MODE: (state, isEditMode) => {
            state.isEditMode = isEditMode
        }

    },
    getters: {
        ENTITIES(state) {
            return state.entities
        },
        CARS(state) {
            return state.isCars
        },
        WORKS(state) {
            return state.isWorks
        },
        MASTERS(state) {
            return state.isMasters
        },
        SERVICES(state) {
            return state.isServices
        },
        IS_EDIT_MODE(state) {
            return state.isEditMode
        },
        INDEX: state => id => {
            for(let i = 0; i < state.entities.length; ++i) {
                if (id === state.entities[i].id) {
                    return i
                }
            }
            return -1
        }
    },
})

export default store