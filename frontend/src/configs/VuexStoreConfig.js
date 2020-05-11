import Vuex from "vuex";
import Proposals from "@/domain/proposal/store";
import Biddings from "@/domain/bidding/store";

let instance = false;

export default class VueStoreConfig {
  constructor() {
    if (!instance) {
      const configs = {
        state: {},
        mutations: {},
        actions: {},
        modules: {
          Proposals,
          Biddings
        }
      };

      instance = new Vuex.Store(configs);
    }

    return instance;
  }
}
