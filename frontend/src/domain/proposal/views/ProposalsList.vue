<template>
  <v-content class="ProposalsList">
    <v-card>
      <v-card-title id="card-title">
        Propostas
        <v-spacer></v-spacer>
        <v-text-field
          @input="filterProposals()"
          v-model="search"
          append-icon="mdi-magnify"
          label="Search"
          single-line
          hide-details
        ></v-text-field>
      </v-card-title>
      <v-data-table
        :headers="headers"
        :height="heightTable"
        :items="proposals"
        :search="search"
        :loading="getLoadingProposals"
        fixed-header
        disable-pagination
        disable-sort
        hide-default-footer
        loading-text="Loading... Please wait"
      ></v-data-table>
    </v-card>
    <NewProposalModal />
  </v-content>
</template>

<script>
import { createNamespacedHelpers, mapActions } from "vuex";
const { mapGetters } = createNamespacedHelpers("Proposals");
import NewProposalModal from "../components/NewProposalModal";

export default {
  name: "ProposalsList",
  components: { NewProposalModal },
  data() {
    return {
      dialog: false,
      search: "",
      proposals: [],
      headers: [
        {
          text: "Fornecedor",
          align: "start",
          sortable: false,
          value: "provider"
        },
        { text: "Nota", value: "note" },
        { text: "Preço", value: "price" },
        { text: "Data Cadastro", value: "createdDate" },
        { text: "Classificador", value: "classificator" }
      ],
      heightTable: "92vh"
    };
  },
  computed: {
    ...mapGetters(["getLoadingProposals", "getProposals"]),
  },
  watch: {
    getProposals(proposals) {
      this.filterProposals(proposals);
    }
  },
  methods: {
    ...mapActions("Proposals", ["findAll"]),
    ...mapActions("Biddings", ["findAllBiddings"]),
    filterProposals(proposals) {
      this.proposals = proposals || this.proposals;
      return (this.proposals = this.getProposals.filter(
        proposal =>
          proposal.provider.includes(this.search.toLowerCase()) ||
          proposal.note.includes(this.search.toLowerCase()) ||
          proposal.price.includes(this.search.toLowerCase()) ||
          proposal.createdDate.includes(this.search.toLowerCase()) ||
          proposal.classificator.includes(this.search.toLowerCase()) ||
          proposal.bidding.includes(this.search.toLowerCase())
      ));
    },
    onResize() {
      const heightHeaders =
        window.document.getElementById("card-title").clientHeight +
        window.document.getElementById("header-system").clientHeight;
      this.heightTable = window.innerHeight - heightHeaders;
    }
  },
  created() {
    this.findAll();
    this.findAllBiddings();
  },
  mounted() {
    window.addEventListener("resize", this.onResize);
    this.onResize();
  },
  beforeDestroy() {
    window.removeEventListener("resize", this.onResize);
  }
};
</script>
