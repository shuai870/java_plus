<!--主页面布局样式代码-->
<template>
  <el-container style="min-height: 100vh">
    <el-container>
      <!--     页面主体       -->
      <el-main>
        <!--        搜索部分        -->
        <div style="margin: 10px 0">
          <el-input style="width: 200px" placeholder="请输入名称" suffix-icon="el-icon-search" v-model="username"></el-input>
          <el-input style="width: 200px" placeholder="请输入邮箱" suffix-icon="el-icon-message"
                    class="ml-5"></el-input>
          <el-input style="width: 200px" placeholder="请输入地址" suffix-icon="el-icon-position"
                    class="ml-5"></el-input>
          <el-button class="ml-5" type="primary" @click="load">搜索</el-button>
        </div>

        <!--      表格外部操作部分          -->
        <div style="margin: 10px 0">
          <el-button type="primary">新增 <i class="el-icon-circle-plus-outline"></i></el-button>
          <el-button type="danger">批量删除 <i class="el-icon-remove-outline"></i></el-button>
          <el-button type="primary">导入 <i class="el-icon-bottom"></i></el-button>
          <el-button type="primary">导出 <i class="el-icon-top"></i></el-button>
        </div>

        <!--        表格内部操作部分        -->
        <el-table :data="tableData" border stripe :header-cell-class-name="headerBg">
          <el-table-column prop="id" label="ID" width="80"></el-table-column>
          <el-table-column prop="username" label="用户名" width="140"></el-table-column>
          <el-table-column prop="nickname" label="昵称" width="120"></el-table-column>
          <el-table-column prop="email" label="邮箱" width="120"></el-table-column>
          <el-table-column prop="phone" label="电话" width="120"></el-table-column>
          <el-table-column prop="address" label="地址"></el-table-column>
          <el-table-column label="操作" width="200" align="center">
            <template slot-scope="scope">
              <el-button type="success">编辑 <i class="el-icon-edit"></i></el-button>
              <el-button type="danger">删除 <i class="el-icon-remove-outline"></i></el-button>
            </template>
          </el-table-column>
        </el-table>

        <!--       翻页与页码部分         -->
        <div style="padding: 10px 0">
          <el-pagination
              @size-change="handleSizeChange"
              @current-change="handleCurrentChange"
              :current-page="pageNum"
              :page-sizes="[5, 10, 15, 20]"
              :page-size="pageSize"
              layout="total, sizes, prev, pager, next, jumper"
              :total="total">
          </el-pagination>
        </div>

      </el-main>

    </el-container>

  </el-container>
</template>

<!--页面数据与动作Js代码-->
<script>
export default {
  name: 'Home',
  //请求分页查询数据
  created(){
     this.load()
  },
  data() {
    return {
      tableData:[],
      total: 0,
      pageNum: 1,
      pageSize:5,
      username:"",
      msg: "admin",
      collapseBtnClass: 'el-icon-s-fold',
      isCollapse: false, //默认侧边栏打开
      sideWidth: 200,
      logoTextShow: true, //在默认侧边栏打开的情况下，侧边栏图标显示
      headerBg: 'headerBg'
    }
  },
  methods: {
    collapse() {  //点击收缩侧边栏按钮触发
      this.isCollapse = !this.isCollapse
      if (this.isCollapse) {  //收缩侧边栏
        this.sideWidth = 64
        this.collapseBtnClass = 'el-icon-s-unfold'
        this.logoTextShow = false
      } else {   //展开侧边栏
        this.sideWidth = 200
        this.collapseBtnClass = 'el-icon-s-fold'
        this.logoTextShow = true
      }
    },
    handleSizeChange(pageSize){
      console.log(pageSize)
      this.pageSize =pageSize
      this.load()
    },
    handleCurrentChange(pageNum){
      console.log(pageNum)
      this.pageNum = pageNum
      this.load()
    },
    load(){
      fetch("http://localhost:9090/user/page?pageNum=" + this.pageNum + "&pageSize=" + this.pageSize+"&username="+this.username)
          .then(res => res.json())
          .then(res => {
            console.log(res);
            // 在这里处理获取的后端数据，例如将其存储到组件的数据中
            this.tableData = res.data
            this.total = res.total
          })
          .catch(error => {
            console.error('Error fetching data:', error);
          });
    }
  },

}
</script>

<!--表格头部样式-->
<style>
.headerBg {
  background: #eee !important;
}
</style>
