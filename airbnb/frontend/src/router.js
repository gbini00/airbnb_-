
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import PaymentManager from "./components/PaymentManager"

import RoomManager from "./components/RoomManager"
import ReviewManager from "./components/ReviewManager"

import ReservationManager from "./components/ReservationManager"

import MessageManager from "./components/MessageManager"


import Roomview from "./components/Roomview"
import MemberManager from "./components/memberManager"

import AffiliateproductManager from "./components/AffiliateproductManager"

import OrderManager from "./components/OrderManager"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/Payment',
                name: 'PaymentManager',
                component: PaymentManager
            },

            {
                path: '/Room',
                name: 'RoomManager',
                component: RoomManager
            },
            {
                path: '/Review',
                name: 'ReviewManager',
                component: ReviewManager
            },

            {
                path: '/Reservation',
                name: 'ReservationManager',
                component: ReservationManager
            },

            {
                path: '/Message',
                name: 'MessageManager',
                component: MessageManager
            },


            {
                path: '/Roomview',
                name: 'Roomview',
                component: Roomview
            },
            {
                path: '/member',
                name: 'memberManager',
                component: memberManager
            },

            {
                path: '/Affiliateproduct',
                name: 'AffiliateproductManager',
                component: AffiliateproductManager
            },

            {
                path: '/Order',
                name: 'OrderManager',
                component: OrderManager
            },



    ]
})
