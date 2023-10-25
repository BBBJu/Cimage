<template>
  <MyLayout MyBrightness="1" current="PicSearch">
    <template v-slot:content>
      <div style="display: flex;justify-content: space-around;align-items:center;height: 100px ">
        <span style="display: flex; justify-content: center;align-items: center;">
          <span style="flex: 1">图片名称</span>
          <a-input style="flex: 2" v-model:value="SelectedPicName" />
        </span>
        <span style="display: flex; justify-content: center;align-items: center;">
          <span style="flex: 1">图片拥有者</span>
          <a-input style="flex: 2" v-model:value="SelectedPicHolder" />
        </span>
        <span style="display: flex; justify-content: center;align-items: center;">
          <span style="flex: 1">图片类型</span>
          <a-select
              ref="select"
              v-model:value="SelectedPicType"
              style="width: 120px"
              :options="options"
              @focus="focus"
              @change="handleChange"
          ></a-select>
        </span>
        <a-button>查询</a-button>
      </div>
      <a-table :columns="columns" :data-source="data" :pagination="pagination">
        <template #headerCell="{ column }">
          <template v-if="column.key === 'key'">
            <span>
              序号
            </span>
          </template>
          <template v-if="column.key === 'name'">
            <span>
              用户名
            </span>
          </template>
        </template>
        <template
            #customFilterDropdown="{ setSelectedKeys, selectedKeys, confirm, clearFilters, column }"
        >
          <div style="padding: 8px">
            <a-input
                ref="searchInput"
                :placeholder="`Search ${column.dataIndex}`"
                :value="selectedKeys[0]"
                style="width: 188px; margin-bottom: 8px; display: block"
                @change="e => setSelectedKeys(e.target.value ? [e.target.value] : [])"
                @pressEnter="handleSearch(selectedKeys, confirm, column.dataIndex)"
            />
            <a-button
                type="primary"
                size="small"
                style="width: 90px; margin-right: 8px"
                @click="handleSearch(selectedKeys, confirm, column.dataIndex)"
            >
              <template #icon><SearchOutlined/></template>
              Search
            </a-button>
            <a-button size="small" style="width: 90px" @click="handleReset(clearFilters)">
              Reset
            </a-button>
          </div>
        </template>
        <template #customFilterIcon>
          <SearchOutlined :style="{ fontSize: '20px'}"/>
        </template>
        <template #bodyCell="{ text, column ,record}">
      <span v-if="state.searchText && state.searchedColumn === column.dataIndex">
        <template
            v-for="(fragment, i) in text
            .toString()
            .split(new RegExp(`(?<=${state.searchText})|(?=${state.searchText})`, 'i'))"
        >
          <mark
              v-if="fragment.toLowerCase() === state.searchText.toLowerCase()"
              :key="i"
              class="highlight"
          >
            {{ fragment }}
          </mark>
          <template v-else>{{ fragment }}</template>
        </template>
      </span>
          <template v-if="column.key === 'state'">
              <span v-if="record.state===true" style="color: #42b983">已授权</span>
              <span v-else style="color:#f52c2c;">未授权</span>
          </template>
          <template v-if="column.key === 'action'">
            <span v-if="record.state===true" style="color: #42b983">
              <a-button>预览</a-button>
              <a-button>下载</a-button>
            </span>
            <span v-else style="color:#f52c2c;">
              <span>发送请求</span>
              <a-switch></a-switch>
            </span>
          </template>
        </template>
      </a-table>
    </template>
  </MyLayout>
</template>

<script>
import router from "@/router";
import MyLayout from "@/views/MyLayout.vue";
import {SearchOutlined} from "@ant-design/icons-vue"
export default {
  name: "PicSearch",
  components: {
    MyLayout,
    SearchOutlined,
  },
  computed: {
    pagination() {
      return {
        current: this.PageNum,
        pageSize: this.PageSize,
        total: this.total,
        showTotal: total => `共 ${total} 条`,
        onChange: this.handlePageChange
      }
    }
  },
  data() {
    return {
      SelectedPicName:"John Brown",
      SelectedPicHolder:"20080101",
      SelectedPicType:"A",
      Router:router,
      PageNum:1,
      PageSize:2,
      total:0,
      searchInput:"",
      state :{
        searchText: '',
        searchedColumn: '',
      },
      columns : [
        {
          name: '序号',
          dataIndex: 'key',
          key: 'key',
        },
        {
          name: '图片名',
          dataIndex: 'name',
          key: 'name',
          customFilterDropdown: true,
          onFilter: (value, record) => record.name.toString().toLowerCase().includes(value.toLowerCase()),
        },
        {
          title: '图片拥有者',
          dataIndex: 'id',
          key: 'id',
          customFilterDropdown: true,
          onFilter: (value, record) => record.id.toString().toLowerCase().includes(value.toLowerCase()),
        },
        {
          title: '图片类别',
          dataIndex: 'type',
          key: 'type',
          customFilterDropdown: true,
          onFilter: (value, record) => record.type.toString().toLowerCase().includes(value.toLowerCase()),
        },
        {
          title: '状态',
          dataIndex: 'state',
          key: 'state',
        },
        {
          title: '操作',
          key: 'action',
        },
      ],
      data : [
        {
          key: '1',
          id:"20080101",
          name: 'John Brown一二三',
          type:"A",
          state:true,
        },
        {
          key: '2',
          id:"20080102",
          name: 'Jim Green',
          type:"A",
          state:true,
        },
        {
          key: '3',
          id:"20080102",
          name: 'Joe Black',
          type:"B",
          state:false,
        },
      ],
      options:[
        {
          value: 'jack',
          label: '123',
        },
        {
          value: 'lucy',
          label: 'Lucy',
        },
        {
          value: 'disabled',
          label: 'Disabled',
          disabled: true,
        },
        {
          value: 'yiminghe',
          label: 'Yiminghe',
        }],

    };
  },
  mounted() {
  },
  methods: {
    handlePageChange(page){
      this.PageNum=page
    },
    handleSearch(selectedKeys, confirm, dataIndex){
      confirm();
      this.state.searchText = selectedKeys[0];
      this.state.searchedColumn = dataIndex;
    },
    handleReset(clearFilters){
      clearFilters({
        confirm: true,
      });
      this.state.searchText = '';
    },
  }
};
</script>
<style>

</style>