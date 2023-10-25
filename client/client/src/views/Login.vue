
<script>
import {message} from "ant-design-vue";
import router from "@/router";

export default {
  name: "UserLogin",
  data() {
    return {
      Router:router,
      testName:"123",
      testPassword:"123456",
      formState: {
        username: '',
        password: '',
        remember: true,
      },
    }
  },
  methods:{
    onFinish(values)
    {
      console.log('Success:', values)
    },
    onFinishFailed(errorInfo)
    {
      console.log('Failed:',errorInfo)
    },
    handleClickSubmit()
    {
      if(this.formState.username===this.testName){
        if(this.formState.password===this.testPassword){
          // eslint-disable-next-line no-undef
          this.Router.push("add");
        }
        else{
          message.info('用户名或密码错误！');
        }
      }
      else{
        message.info('用户名或密码错误！');
      }
    },
    handleClickRegister(){
      this.Router.push("register");
    }
  }

}

</script>

<template>
  <div class="input">
  <a-form
      :model="formState"
      name="basic"
      labelAlign="right"
      :label-col="{ span: 8 }"
      :wrapper-col="{ span: 12 }"
      autocomplete="off"
      @finish="onFinish"
      @finishFailed="onFinishFailed"
  >
    <a-form-item
        label="用户名"
        name="username"
        :rules="[{ required: true, message: 'Please input your username!' }]"
    >
      <a-input v-model:value="formState.username" />
    </a-form-item>

    <a-form-item
        label="密码"
        name="password"
        :rules="[{ required: true, message: 'Please input your password!' }]"
    >
      <a-input-password v-model:value="formState.password" />
    </a-form-item>

    <a-form-item :wrapper-col="{ offset: 8, span: 8 }">
      <a-button type="primary" html-type="submit" @click="handleClickSubmit">提交</a-button>
      <a-button type="primary" html-type="submit" @click="handleClickRegister" class="btn-spacing">注册</a-button>
    </a-form-item>
  </a-form>
    </div>
</template>

<style scoped>
.input {
  width: 100%; /* 设置矩形的宽度 */
  height: 200px; /* 设置矩形的高度 */
  border: 1px solid #000; /* 设置边框样式，这里使用2px的黑色实线边框 */
  border-radius: 10px; /* 设置圆角的半径，这里使用10px */
  padding: 10px; /* 可选，设置内边距 */
  margin-left: auto;
  margin-right: auto;
}
.btn-spacing {
  margin-left: 30px; /* 设置左侧间距 */
}
</style>