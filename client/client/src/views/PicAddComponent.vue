<script>

import {addPoi} from "@/api/api";

export default {
  name: "PicAddComponent",
  data() {
    return {
      selectedFile: null,
      previewImageUrl: ''
    };
  },
methods: {
  handleFileUpload(event) {
    this.selectedFile = event.target.files[0];
    const formData = new FormData();
    formData.append('image', this.selectedFile);
    console.log('FormData内容:');
    for (const entry of formData.entries()) {
      console.log(entry);
    }
    this.previewImage();
  },
  uploadImage() {
    const formData = new FormData();
    formData.append('image', this.selectedFile);
    // 发送图片数据到后端API
    addPoi(formData)
        .then(response => {
          // 处理上传成功的响应
          console.log(response.data);
        })
        .catch(error => {
          // 处理上传失败的错误
          console.error(error);
        });
  },
  previewImage() {
    const reader = new FileReader();
    reader.onload = () => {
      this.previewImageUrl = reader.result;
    };
    if (this.selectedFile) {
      reader.readAsDataURL(this.selectedFile);
    }
  }
}
}
</script>

<template>
  <div class="addPicRectangle">
    <img v-if="!previewImageUrl" src="../pictures/picture.png" alt="占位图片">
    <div v-if="previewImageUrl">
      <img :src="previewImageUrl" alt="预览图片" width="200" height="150">
    </div>
    <label for="file-input" class="custom-button">
      点击上传样品文件
    </label>
    <input id="file-input" type="file" class="hidden-input" @change="handleFileUpload">
  </div>
</template>

<style>
.addPicRectangle {
  width: 70%;
  height: 70%;
  background-color: white;
  border: 1px solid black;
  border-radius: 10px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
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