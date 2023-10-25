import {createRouter, createWebHashHistory} from "vue-router";

const routes=[
    {
        path:'/index',
        component:()=>import("@/views/index.vue")
    },
    {
        path:'/home',
        component:()=>import("@/views/home.vue")
    },
    {
        path:'/PicAdd',
        component:()=>import("@/views/PicAdd.vue")
    },
    {
        path:"/",
        component:()=>import("@/views/Login.vue")
    },
    {
        path:"/register",
        component:()=>import("@/views/Register.vue")
    },
    {
        path:"/PicSearch",
        component:()=>import("@/views/PicSearch.vue")
    },
    {
        path:"/PicInfo",
        component:()=>import("@/views/PicInfo.vue")
    },
    {
        path:"/ExcelAdd",
        component:()=>import("@/views/ExcelAdd.vue")
    },
    {
        path:"/Authorize",
        component:()=>import("@/views/Authorize.vue")
    },
]

const router = createRouter({
    history:createWebHashHistory(),
    routes
})
export default router