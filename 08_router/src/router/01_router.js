import { createRouter, createWebHashHistory, createWebHistory } from 'vue-router';
import HomeView from '@/views/01_router/HomeView.vue';
import PathVariable from '@/views/01_router/PathVariable.vue';

const router = createRouter({
    // history: createWebHashHistory(),
    history: createWebHistory(),
    routes: [
        {   
            path: '/',
            component: HomeView
        },
        {
            path: '/pathVariable',
            component: PathVariable
        }
    ]
})

/* router 객체를 export 함(main.js에서 import 할 용도) */
export default router;