<template>
  <div>
    <a-menu v-model:selectedKeys="current"
            mode="vertical"
            :items="items"
            @click="handleMenuItemClick"
    />
  </div>
</template>

<script>
import { h, ref} from 'vue';
import { AppstoreOutlined } from '@ant-design/icons-vue';
import router from "@/router";

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: 'Index',
  props: {cur: {
      type: String,
      default:"add"
    },
  },
  setup(props) {
    const current = ref([props.cur]);
    const items = [
      {
        key: 'PicAdd',
        icon: () => h(AppstoreOutlined),
        label: '图片上传',
        title: '',
      },
      {
        key: 'PicInfo',
        icon: () => h(AppstoreOutlined),
        label: '图片属性',
        title: '图片属性',
      },
      {
        key: 'ExcelAdd',
        icon: () => h(AppstoreOutlined),
        label: 'Excel上传',
        title: '图片展示',
      },
      {
        key: 'PicSearch',
        icon: () => h(AppstoreOutlined),
        label: '查看图片',
        title: '查看图片',
      },
    ];
    const Router =router
    const handleMenuItemClick = ({key}) => {
      Router.push(key);
    };
    return {
      current,
      items,
      handleMenuItemClick,
    };
  },
};
</script>

<style scoped>
/* 样式 */
</style>