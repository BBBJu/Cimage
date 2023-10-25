<template>
  <MyLayout MyBrightness="0.6" current="ExcelAdd">
    <template v-slot:content>
      <div class="rectangle">
        <span class="close-button" @click="handleClickClose">&times;</span>
        <img src="../pictures/excel.png" alt="Your Image">
        <a-button style="margin-top: 20px;background-color:rebeccapurple;color: white">点击上传图片</a-button>
      </div>
    </template>
  </MyLayout>
</template>

<script>
import router from "@/router";
import MyLayout from "@/views/MyLayout.vue";
export default {
  name: "ExcelAdd",
  components: {
    MyLayout,
  },
  data() {
    return {
      authorizationCount:1,
      username:"abc",
      currentDate: null,
      Router:router,
    };
  },
  mounted() {
  },
  methods: {
    handleClickClose()
    {
      this.Router.push("home")
    }
  }
};
</script>
<style>
.rectangle {
  width: 800px;
  height: 500px;
  background-color: white;
  border: 1px solid black;
  border-radius: 10px;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}
.close-button {
  position: absolute;
  top: 0px;
  right: 0px;
  line-height: 60px;
  font-size: 50px;
  cursor: pointer;
  color: black;
}

.close-button:hover {
  color: red;
}
</style>