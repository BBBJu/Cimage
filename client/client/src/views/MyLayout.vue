<template>
  <a-layout class="layout" >
    <a-layout-header :style="headerStyle">
      <a-row>
        <a-col :span="5">
          <div style="text-align: left;font-size: 25px">电镜图片提交平台</div>
        </a-col>
        <a-col :span="12">
          <div style="text-align: right;font-size: 20px">
            {{currentDate}}
          </div>
        </a-col>
        <a-col :span="3">
          <span style="display:flex;align-items:center;justify-content: right;height: 64px">
             <a-badge :count="authorizationCount">
            <SoundOutlined :style="{ fontSize: '40px'}" @click="handleClickAuthorization"/>
             </a-badge>
          </span>
        </a-col>
        <a-col :span="4">
          <a-button type="primary" size="large" @click="handleClickLogout" style="position:absolute;left: 30px;top:12px">
            <LogoutOutlined/>
            退出
          </a-button>
        </a-col>
      </a-row>
    </a-layout-header>
    <a-layout>
      <a-layout-sider :style="siderStyle">
        <a-avatar :size="100" class="userAvatar">
          <template #icon><UserOutlined /></template>
        </a-avatar>
        <div style="margin-bottom:20px ">{{username}}</div>
        <index :cur="current"/>
      </a-layout-sider>
      <a-layout-content :style="contentStyle">
        <slot name="content"></slot>
      </a-layout-content>
    </a-layout>
  </a-layout>
</template>

<script>
import index from "./index.vue";
import {LogoutOutlined, SoundOutlined, UserOutlined} from '@ant-design/icons-vue';
import router from "@/router";

export default {
  name: "MyLayout",
  props:['MyBrightness','current'],
  components: {
    index,
    UserOutlined,
    SoundOutlined,
    LogoutOutlined
  },
  data() {
    return {
      authorizationCount:1,
      username:"abc",
      currentDate: null,
      Router:router,
      headerStyle: {
        textAlign: 'center',
        color: '#fff',
        height: '64px',
        paddingInline: '0px',
        backgroundColor: '#7dbcea',
        filter: `brightness(${this.MyBrightness})`
      },
      contentStyle: {
        textAlign: 'center',
        minHeight: '400px',
        lineHeight: '120px',
        color: '#fff',
        backgroundColor: '#7ed1fc',

      },
      siderStyle: {
        height: '100%',
        backgroundColor: '#f0f2f5',
        filter: `brightness(${this.MyBrightness})`
      },
    }
  },
  computed:{
  },
  mounted() {
    this.getCurrentDate();
  },
  methods: {
    getCurrentDate() {
      const today = new Date();
      const options = { year: 'numeric', month: 'long', day: 'numeric' };
      this.currentDate = today.toLocaleDateString(undefined, options);
    },
    handleClickAuthorization(){
      this.Router.push("/Authorize");
    },
    handleClickLogout()
    {
      this.Router.push("/");
    }
  }
};
</script>
<style>
.layout{
  display: flex;
  height: 100vh;
}
.userAvatar{
  margin-top: 10px;
  margin-bottom:10px;
}

</style>