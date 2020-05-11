<template>
  <v-content class="ProposalsList">
    <v-card>
      <v-card-title id="card-title">
        Employees
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
        :items="biddings"
        :search="search"
        :loading="getLoadingBiddings"
        fixed-header
        disable-pagination
        disable-sort
        hide-default-footer
        loading-text="Loading... Please wait"
      >
      </v-data-table>
    </v-card>
  </v-content>
</template>

<script>
import { createNamespacedHelpers } from "vuex";
const { mapGetters, mapActions } = createNamespacedHelpers("Biddings");

export default {
  name: "BiddingsList",
  data() {
    return {
      dialog: false,
      search: "",
      biddings: [],
      headers: [
        {
          text: "Descrição",
          align: "start",
          sortable: false,
          value: "description"
        },
        { text: "Tipo Classificação", value: "type" },
      ],
      heightTable: "92vh"
    };
  },
  computed: {
    ...mapGetters(["getLoadingBiddings", "getBiddings"])
  },
  watch: {
    getBiddings(biddings) {
      this.filterBiddings(biddings);
    }
  },
  methods: {
    ...mapActions(["findAll"]),
    filterBiddings(biddings) {
      this.biddings = biddings || this.proposals;
      return (this.biddings = this.getBiddings.filter(
        bidding =>
          bidding.description.includes(this.search.toLowerCase()) ||
          bidding.type.includes(this.search.toLowerCase())
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
