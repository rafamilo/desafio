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
        <template v-slot:item.type="{ item }">
          {{ getTypeName(item) }}
        </template>
        <template v-slot:item.actions="{ item }">
          <button class="mr-2" @click="openEditBiddingModal(item)">Editar</button>
          <button class="ml-5" @click="deleteBidding(item)">Deletar</button>
        </template>
      </v-data-table>
    </v-card>
    <v-dialog v-model="dialog">
      <UpdateBiddingForm ref="updateBiddingForm" :bidding="bidding" v-on:finished="dialog = false" />
    </v-dialog>
    <NewBiddingModal />
  </v-content>
</template>

<script>
import { createNamespacedHelpers } from "vuex";
import NewBiddingModal from "@/domain/bidding/components/NewBiddingModal";
import UpdateBiddingForm from "@/domain/bidding/components/UpdateBiddingForm";
import BiddingsRest from "@/domain/bidding/BiddingsRest";
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
        { text: "Ações", value: "actions" }
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
    ...mapActions(["findAllBiddings"]),
    getTypeName(bidding) {
      return (bidding.type === "NOTA_PRECO" && "Nota Preço") || "Menor Preço";
    },
    openEditBiddingModal(bidding) {
      this.dialog = !this.dialog;
      this.bidding = bidding;
    },
    async deleteBidding(bidding) {
      try {
        await new BiddingsRest().deleteBidding(bidding.id);
        alert("Licitação deletada com sucesso!");
        this.findAllBiddings();
      } catch (error) {
        alert("Não foi possível deletar essa licitação");
      }
    },
    filterBiddings(biddings) {
      this.biddings = biddings || this.biddings;

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
