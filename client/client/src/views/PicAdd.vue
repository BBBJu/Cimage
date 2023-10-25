<template>
  <MyLayout MyBrightness="0.6" current="PicAdd">
    <template v-slot:content>
      <div class="rectangle">
        <span class="close-button" @click="handleClickClose">&times;</span>
        <img v-if="!previewImageUrl" src="../pictures/picture.png" alt="占位图片">
        <div v-if="previewImageUrl">
          <img :src="previewImageUrl" alt="预览图片" width="200" height="150">
        </div>
        <label for="file-input" class="custom-button">
          选择文件
        </label>
        <input id="file-input" type="file" class="hidden-input" @change="handleFileUpload">
        <a-button style="margin-top: 20px;background-color:rebeccapurple;color: white">点击上传图片</a-button>
      </div>
    </template>
  </MyLayout>
</template>

<script>
import router from "@/router";
import MyLayout from "@/views/MyLayout.vue";
export default {
  name: "PicList",
  components: {
    MyLayout,
  },
  data() {
    return {
      authorizationCount:1,
      username:"abc",
      currentDate: null,
      Router:router,
      selectedFile: null,
      previewImageUrl: ''
    };
  },
  mounted() {
  },
  methods: {
    handleFileUpload(event) {
      this.selectedFile = event.target.files[0];
      this.previewImage();
    },
    previewImage() {
  const reader = new FileReader();
  reader.onload = () => {
    this.previewImageUrl = reader.result;
  };
  if (this.selectedFile) {
    reader.readAsDataURL(this.selectedFile);
  }
},
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
.custom-button {
  /* 自定义按钮样式 */
  display: inline-block;
  padding: 6px 12px;
  margin-top: 10px;
  height: 40px;
  line-height: 25px;
  background-color: #ddd;
  color: #333;
  border: 1px solid #ccc;
  border-radius: 4px;
  cursor: pointer;
}

.hidden-input {
  /* 隐藏原生文件选择输入框 */
  display: none;
}
</style>