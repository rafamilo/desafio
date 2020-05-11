<template>
  <v-content class="ProposalsList">
    <v-card>
      <v-card-title id="card-title">
        Licitações
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
        <template v-slot:item.actions="{ item }">
          <v-icon small class="mr-2" @click="openEditBiddingModal(item)">Editar</v-icon>
        </template>
      </v-data-table>
    </v-card>
    <v-dialog v-model="dialog">
      <UpdateBiddingForm
        ref="updateBiddingForm"
        :bidding="bidding"
        v-on:finished="dialog = false"
      />
    </v-dialog>
    <NewBiddingModal />
  </v-content>
</template>

<script>
import { createNamespacedHelpers } from "vuex";
import NewBiddingModal from "@/domain/bidding/components/NewBiddingModal";
import UpdateBiddingForm from "@/domain/bidding/components/UpdateBiddingForm";
const { mapGetters, mapActions } = createNamespacedHelpers("Biddings");

export default {
  name: "BiddingsList",
  components: { NewBiddingModal, UpdateBiddingForm },
  data() {
    return {
      dialog: false,
      search: "",
      bidding: {},
      biddings: [],
      headers: [
        {
          text: "Descrição",
          align: "start",
          sortable: false,
          value: "description"
        },
        { text: "Tipo Classificação", value: "type" },
        { text: "", value: "actions" }
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
    openEditBiddingModal(bidding) {
      this.dialog = !this.dialog;
      this.bidding = bidding;
    },
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
