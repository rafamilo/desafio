import BiddingsRest from "../BiddingsRest";

export default {
  namespaced: true,
  state: {
    biddings: [],
    loading: {
      biddings: false,
    },
  },
  getters: {
    getBiddings: (state) => state.biddings,
    getLoadingBidding: (state) => state.loading.biddings,
  },
  mutations: {
    SET_BIDDINGS: (state, biddings) => (state.biddings = biddings),
    SET_LOADING_BIDDINGS: (state, loading) =>
      (state.loading.biddings = loading),
  },
  actions: {
    findAll: async ({ commit }) => {
      try {
        commit("SET_LOADING_BIDDINGS", true);
        const { data } = await new BiddingsRest().findAll();
        commit("SET_BIDDINGS", data);
      } catch (error) {
        alert(error.data.message);
      } finally {
        commit("SET_LOADING_BIDDINGS", false);
      }
    },
  },
};
