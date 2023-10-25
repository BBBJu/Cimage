<template>
  <MyLayout MyBrightness="1" current="PicInfo">
    <template v-slot:content>
      <div class="content-wrapper">
        <div class="rectangle" style="display: flex; flex-direction: column">
          <div style="flex: 2;display: flex;align-items: center;justify-content: start;">
            <p style="font-size: 30px;margin-left: 30px">基本信息</p>
          </div>
          <div style="flex: 1;display: flex;align-items: center;justify-content: start;flex-wrap: wrap;">
            <div class="input-container">
              <label style="flex: 1;">ID</label>
              <a-input id="input" style="flex: 1;"/>
            </div>
            <div class="input-container">
              <label style="flex: 1">实验人姓名</label>
              <a-input id="input" style="flex: 1"/>
            </div>
            <div class="input-container">
              <label style="flex: 1">实验日期</label>
              <a-input id="input" style="flex: 1"/>
            </div>
            <div class="input-container">
              <label style="flex: 1">实验设备名称</label>
              <a-input id="input" style="flex: 1"/>
            </div>
            <div class="input-container">
              <label style="flex: 1">实验类型</label>
              <a-input id="input" style="flex: 1"/>
            </div>
            <div class="input-container">
              <label style="flex: 1">是否原位</label>
              <a-input id="input" style="flex: 1"/>
            </div>
            <div class="input-container">
              <label style="flex: 1">实验温度</label>
              <a-input id="input" style="flex: 1"/>
            </div>
          </div>

          <div style="flex: 2;display: flex;align-items: center;justify-content: start;">
            <p style="font-size: 30px;margin-left: 30px">样品信息</p>
          </div >

          <div style="flex:2;display: flex;align-items: center;justify-content: space-around;">
            <div style="flex:1;display: flex;align-items: center;flex-wrap: wrap">
              <div class="input-container">
                <label style="flex: 1;">样品名称</label>
                <a-input id="input" style="flex: 1;"/>
              </div>
              <div class="input-container">
                <label style="flex: 1;">标距段尺寸（长）</label>
                <a-input id="input" style="flex: 1;"/>
              </div>
              <div class="input-container">
                <label style="flex: 1;">标距段尺寸（宽）</label>
                <a-input id="input" style="flex: 1;"/>
              </div>
              <div class="input-container">
                <label style="flex: 1;">标距段尺寸（高）</label>
                <a-input id="input" style="flex: 1;"/>
              </div>
              <div class="input-container">
                <label style="flex: 1;">样品尺寸图路径</label>
                <a-input id="input" style="flex: 1;"/>
              </div>
            </div>
            <div style="flex:1;display: flex;align-items: center;justify-content: space-around">
              <pic-add-component/>
            </div>
          </div>


          <div style="flex: 2;display: flex;align-items: center;justify-content: start;">
            <p style="font-size: 30px;margin-left: 30px">微观组成</p>
          </div>


          <div style="flex: 2;display: flex;align-items: center;justify-content: start;">
            <p style="font-size: 30px;margin-left: 30px">疲劳-力学性能</p>
          </div>
          <div style="flex: 1;display: flex;align-items: center;justify-content: start;flex-wrap: wrap;">
            <div class="input-container">
              <label style="flex: 1;">峰值应力</label>
              <a-input id="input" style="flex: 1;"/>
            </div>
            <div class="input-container">
              <label style="flex: 1">谷值应力</label>
              <a-input id="input" style="flex: 1"/>
            </div>
            <div class="input-container">
              <label style="flex: 1">应力比</label>
              <a-input id="input" style="flex: 1"/>
            </div>
            <div class="input-container">
              <label style="flex: 1">疲劳寿命</label>
              <a-input id="input" style="flex: 1"/>
            </div>
            <div class="input-container">
              <label style="flex: 1">疲劳极限</label>
              <a-input id="input" style="flex: 1"/>
            </div>
            <div class="input-container">
              <label style="flex: 1">频率</label>
              <a-input id="input" style="flex: 1"/>
            </div>
          </div>

          <div style="flex: 2;display: flex;align-items: center;justify-content: start;">
            <p style="font-size: 30px;margin-left: 30px">蠕变-力学性能</p>
          </div>

          <div style="flex: 1;display: flex;align-items: center;justify-content: start;flex-wrap: wrap;">
            <div class="input-container">
              <label style="flex: 1;">蠕变极限</label>
              <a-input id="input" style="flex: 1;"/>
            </div>
            <div class="input-container">
              <label style="flex: 1">持久强度极限</label>
              <a-input id="input" style="flex: 1"/>
            </div>
            <div class="input-container">
              <label style="flex: 1">应力</label>
              <a-input id="input" style="flex: 1"/>
            </div>
          </div>

          <div style="flex: 2;display: flex;align-items: center;justify-content: start;">
            <p style="font-size: 30px;margin-left: 30px">拉伸-力学性能</p>
          </div>

          <div style="flex: 1;display: flex;align-items: center;justify-content: start;flex-wrap: wrap;">
            <div class="input-container">
              <label style="flex: 1;">屈服强度</label>
              <a-input id="input" style="flex: 1;"/>
            </div>
            <div class="input-container">
              <label style="flex: 1">弹性模量</label>
              <a-input id="input" style="flex: 1"/>
            </div>
            <div class="input-container">
              <label style="flex: 1">抗拉强度</label>
              <a-input id="input" style="flex: 1"/>
            </div>
            <div class="input-container">
              <label style="flex: 1">断面收缩率</label>
              <a-input id="input" style="flex: 1"/>
            </div>
            <div class="input-container">
              <label style="flex: 1">延伸率</label>
              <a-input id="input" style="flex: 1"/>
            </div>
          </div>

          <div style="flex: 2;display: flex;align-items: center;justify-content: start;">
            <p style="font-size: 30px;margin-left: 30px">压缩-力学性能</p>
          </div>

          <div style="flex: 1;display: flex;align-items: center;justify-content: start;flex-wrap: wrap;">
            <div class="input-container">
              <label style="flex: 1;">屈服强度</label>
              <a-input id="input" style="flex: 1;"/>
            </div>
            <div class="input-container">
              <label style="flex: 1">抗压强度</label>
              <a-input id="input" style="flex: 1"/>
            </div>
            <div class="input-container">
              <label style="flex: 1">弹性模量</label>
              <a-input id="input" style="flex: 1"/>
            </div>
          </div>

          <div style="flex: 2;display: flex;align-items: center;justify-content: start;">
            <p style="font-size: 30px;margin-left: 30px">图像数据存储路径</p>
          </div>

          <div style="flex: 1;display: flex;align-items: center;justify-content: start;flex-wrap: wrap;">
            <div class="input-container">
              <label style="flex: 1;">力-位移</label>
              <a-input id="input" style="flex: 1;"/>
            </div>
            <div class="input-container">
              <label style="flex: 1">透射图像</label>
              <a-input id="input" style="flex: 1"/>
            </div>
            <div class="input-container">
              <label style="flex: 1">SEM图像</label>
              <a-input id="input" style="flex: 1"/>
            </div>
            <div class="input-container">
              <label style="flex: 1">DIC图像</label>
              <a-input id="input" style="flex: 1"/>
            </div>
            <div class="input-container">
              <label style="flex: 1">断口图像</label>
              <a-input id="input" style="flex: 1"/>
            </div>
            <div class="input-container">
              <label style="flex: 1">其他图谱等数据文件</label>
              <a-input id="input" style="flex: 1"/>
            </div>
            <div class="input-container">
              <label style="flex: 1">EBSD文件</label>
              <a-input id="input" style="flex: 1"/>
            </div>
          </div>

          <div style="flex: 2">
            <p>123</p>
          </div>
        </div>
      </div>
    </template>
  </MyLayout>
</template>

<script>
import router from "@/router";
import MyLayout from "@/views/MyLayout.vue";
import PicAddComponent from "@/views/PicAddComponent.vue";
export default {
  name: "PicInfo",
  components: {
    MyLayout,
    PicAddComponent
  },
  data() {
    return {
      Router:router,
    };
  },
  mounted() {
  },
  methods: {

  }
};
</script>
<style>
.rectangle {
  width: 100%;
  height: 3000px;
  background-color: #fa6262;
  display: flex;
}
.content-wrapper {
  position: relative;
  top: 50px;
  left: 20px;
  height: 80%;
  width: 95%;
  background-color: #ffffff;
  border-radius: 10px;
  overflow-y: auto;
}
.input-container{
  display: flex;
  align-items: center;
}
</style>