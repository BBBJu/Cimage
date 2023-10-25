<script>
import MyLayout from "@/views/MyLayout.vue";
export default {
  name: "PicAuthorize",
  components:{
    MyLayout
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
  data(){
    return{
      PageNum:1,
      PageSize:2,
      total:0,
      columns : [
        {
          name: '序号',
          dataIndex: 'serial',
          key: 'serial',
        },
        {
          name: '用户名',
          dataIndex: 'name',
          key: 'name',
        },
        {
          title: 'ID',
          dataIndex: 'id',
          key: 'id',
        },
        {
          title: '图片属性',
          dataIndex: 'picAttribute',
          key: 'picAttribute',
        },
        {
          title: '授权',
          key: 'action',
        },
      ],
      data : [
        {
          key: '1',
          id:"20080101",
          serial:"1",
          picAttribute:"description",
          name: 'John Brown',
          check:true,
        },
        {
          key: '2',
          name: 'Jim Green',
          check:true,
        },
        {
          key: '3',
          name: 'Joe Black',
          check:false,
        },
      ],
    }
  },
  methods:{
    handlePageChange(page){
      this.PageNum=page
    }
  },

}
</script>

<template>
  <my-layout MyBrightness="1">
    <template v-slot:content>
      <div class="AuthorizeRectangular">
      <p style="text-align: left;font-size: 30px;height: 100px;color:cadetblue;margin-left: 30px">授权请求</p>
      <a-table :columns="columns" :data-source="data" :pagination="pagination">
        <template #headerCell="{ column }">
          <template v-if="column.key === 'serial'">
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
        <template #bodyCell="{ column, record }">
          <template v-if="column.key === 'name'">
            <p>
              {{ record.name }}
            </p>
          </template>
          <template v-else-if="column.key === 'action'">
            <span>
              <span v-if="record.check===true" style="color: #42b983">已授权</span>
              <a-switch v-model:checked="record.check" />
            </span>
          </template>
        </template>
      </a-table>
      </div>
    </template>
  </my-layout>
</template>
<style scoped>
.AuthorizeRectangular{
  position: relative;
  top:20px;
  left: 20px;
  width: 95%;
  height: 90%;
  background-color: white;
  border: 1px solid black;
  border-radius: 10px;
}
</style>