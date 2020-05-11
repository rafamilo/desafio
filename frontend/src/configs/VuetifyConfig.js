import Vuetify from "vuetify/lib";
import "@fortawesome/fontawesome-free/css/all.css";

let instance = false;

export default class VuetifyConfig {
  constructor() {
    if (!instance) {
      const configs = {
        icons: {
          iconfont: "fa"
        }
      };
      instance = new Vuetify(configs);
    }
    return instance;
  }
}
