import Vue from 'vue'
import store from './store/store'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import './assets/gloable.css'
Vue.config.productionTip = false
Vue.use(ElementUI,  { size:"mini" });
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
