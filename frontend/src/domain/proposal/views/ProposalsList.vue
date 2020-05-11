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
      >
      <template v-slot:item.note="{ item }">
        {{ itemNote(item) }}
      </template>
        <template v-slot:item.actions="{ item }">
          <button class="mr-2" @click="openEditProposalModal(item)">Editar</button>
          <button class="ml-5" @click="deleteProposal(item)">Deletar</button>
        </template>
      </v-data-table>
    </v-card>
    <v-dialog v-model="dialog">
      <UpdateProposalForm
        ref="updateProposalForm"
        :proposal="proposal"
        v-on:finished="dialog = false"
      />
    </v-dialog>
    <NewProposalModal />
  </v-content>
</template>

<script>
import { createNamespacedHelpers, mapActions } from "vuex";
const { mapGetters } = createNamespacedHelpers("Proposals");
import NewProposalModal from "../components/NewProposalModal";
import UpdateProposalForm from "../components/UpdateProposalForm";
import ProposalsRest from "../ProposalsRest";
import _ from "lodash";

export default {
  name: "ProposalsList",
  components: { NewProposalModal, UpdateProposalForm },
  data() {
    return {
      dialog: false,
      search: "",
      proposal: {},
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
        { text: "Ações", value: "actions" }
      ],
      heightTable: "92vh"
    };
  },
  computed: {
    ...mapGetters(["getLoadingProposals", "getProposals"])
  },
  watch: {
    getProposals(proposals) {
      this.filterProposals(proposals);
    }
  },
  methods: {
    ...mapActions("Proposals", ["findAll"]),
    ...mapActions("Biddings", ["findAllBiddings"]),
    openEditProposalModal(proposal) {
      this.dialog = !this.dialog;
      this.proposal = proposal;
    },
    itemNote(item) {
      return item.bidding.type === "NOTA_PRECO" && item.note || ""
    },
    async deleteProposal(proposal) {
      try {
        await new ProposalsRest().deleteProposal(proposal.id);
        alert("Proposta deletada com sucesso!");
        this.findAll();
        this.findAllBiddings();
      } catch (error) {
        alert("Não foi possível deletar essa Proposta");
      }
    },
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
      ), this.proposals = _.orderBy(this.proposals, ['bidding.type', 'note', 'price', 'createdDate'], ['desc', 'asc', 'asc', 'asc']));
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
