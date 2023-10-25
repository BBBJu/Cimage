<template>
 <MyLayout MyBrightness="1">
 </MyLayout>
</template>

<script>
import router from "@/router";
import MyLayout from "@/views/MyLayout.vue";
export default {
  name: "HomePage",
  components: {
    MyLayout,
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
</style>