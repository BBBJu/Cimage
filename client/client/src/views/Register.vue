<template>
  <a-button id="back" @click="handleClickBack">返回</a-button>
  <div class="input">
    <a-row :gutter="30">
      <a-col :span="12" class="form-col">
        <a-form
            :model="formState"
            name="basic"
            labelAlign="right"
            :label-col="{ span: 8 }"
            :wrapper-col="{ span: 16 }"
            autocomplete="off"
            @finish="onFinish"
            @finishFailed="onFinishFailed"
        >
          <a-form-item
              label="手机号"
              name="phone"
              :rules="[{ required: true, message: '请输入手机号！' }]"
          >
            <a-input v-model:value="formState.phoneNumber" />
          </a-form-item>

          <a-form-item
              label="验证码"
              name="verifyNumber"
              :rules="[{ required: true, message: '请输入验证码！' }]"
          >
            <a-input v-model:value="formState.verifyNumber" />
          </a-form-item>
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

          <a-form-item
              label="再次输入密码"
              name="confirmPassword"
              :rules="[{ required: true, message: 'Please confirm your password!' }]"
          >
            <a-input-password v-model:value="formState.confirmPassword" />
          </a-form-item>
          <a-form-item :wrapper-col="{ offset: 8, span: 16 }">
            <a-button type="primary" html-type="submit" @click="handleClickSubmit">确认</a-button>
          </a-form-item>
        </a-form>
      </a-col>
      <a-col :span="12" class="button-col">
        <a-button class="btn-spacing" @click="handleGetVerificationCode">获取验证码</a-button>
      </a-col>
    </a-row>
  </div>
</template>

<script>
import router from "@/router";

export default {
  name: "UserRegister",
  data() {
    return {
      Router: router,
      formState: {
        phoneNumber: '',
        verifyNumber: '',
        username: '',
        password: '',
        confirmPassword: '',
        remember: true,
      },
    }
  },
  methods: {
    onFinish(values) {
      console.log('Success:', values)
    },
    onFinishFailed(errorInfo) {
      console.log('Failed:', errorInfo)
    },
    handleClickSubmit() {
      if (this.formState.password && this.formState.password === this.formState.confirmPassword) {
        alert("注册成功")
        this.Router.push("/");
      }
    },
    handleClickBack()
    {
      this.Router.go(-1);
    }
  }
}
</script>

<style scoped>
.input {
  width: 60%;
  padding: 20px;
  margin: 0 auto;
  border: 1px solid #ccc;
  border-radius: 10px;
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
}

.form-col {
  padding: 20px;
}

.button-col {
  display: flex;
  padding: 20px;
}

.btn-spacing {
  margin-left: 30px;
}

.input .a-form-item {
  margin-bottom: 16px;
}
#back{
  position: absolute;
  top: 10px;
  left: 10px;
}
</style>
