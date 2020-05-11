import ProposalsRest from "../ProposalsRest";

export default {
  namespaced: true,
  state: {
    proposals: [],
    loading: {
      proposals: false,
    },
  },
  getters: {
    getProposals: (state) => state.proposals,
    getLoadingProposals: (state) => state.loading.proposals,
  },
  mutations: {
    SET_PROPOSALS: (state, proposals) => (state.proposals = proposals),
    SET_LOADING_PROPOSALS: (state, loading) =>
      (state.loading.proposals = loading),
  },
  actions: {
    findAll: async ({ commit }) => {
      try {
        commit("SET_LOADING_PROPOSALS", true);
        const { data } = await new ProposalsRest().findAll();
        commit("SET_PROPOSALS", data);
      } catch (error) {
        alert(error.data.message);
      } finally {
        commit("SET_LOADING_PROPOSALS", false);
      }
    },
  },
};
