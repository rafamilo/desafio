import Vue from "vue";
import App from "./App.vue";
import "./registerServiceWorker";
import "./assets/scss/Index.scss";
import Vuex from "vuex";
import VueRouter from "vue-router";
import VuetifyConfig from "./configs/VuetifyConfig";
import Vuetify from "vuetify";
import VuexStoreConfig from "./configs/VuexStoreConfig";
import VueRouterConfig from "./configs/VueRouterConfig";

Vue.use(Vuetify);
Vue.use(Vuex);
Vue.use(VueRouter);
Vue.use(Vuetify);

Vue.config.productionTip = false;

const store = new VuexStoreConfig();
const router = new VueRouterConfig();
const vuetify = new VuetifyConfig();

new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount("#app");
