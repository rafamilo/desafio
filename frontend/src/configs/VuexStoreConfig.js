import Vuex from "vuex";
import Proposals from "@/domain/proposal/store";

let instance = false;

export default class VueStoreConfig {
  constructor() {
    if (!instance) {
      const configs = {
        state: {},
        mutations: {},
        actions: {},
        modules: {
          Proposals
        }
      };

      instance = new Vuex.Store(configs);
    }

    return instance;
  }
}
