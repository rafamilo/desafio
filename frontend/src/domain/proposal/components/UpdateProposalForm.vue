<template>
  <v-card class="UpdateProposalForm">
    <v-card-title class="grey darken-2">Editar Proposta</v-card-title>
    <v-container>
      <v-form ref="form" v-model="valid" :lazy-validation="true">
        <v-row class="mx-2">
          <v-col cols="12" md="12">
            <v-select
              v-model="proposal.provider"
              :items="providers"
              :item-value="'name'"
              :item-text="'name'"
              label="Fornecedor"
              prepend-icon="mdi-domain"
            />
          </v-col>
          <v-col cols="12" md="6">
            <v-select
              v-model="proposal.bidding"
              :items="getBiddings"
              :item-text="'description'"
              label="Licitação"
              prepend-icon="mdi-domain"
              return-object
            />
          </v-col>
          <v-col class="align-center justify-space-between" cols="12" md="6" v-if="proposal.bidding && proposal.bidding.type === 'NOTA_PRECO'">
            <v-text-field v-model="proposal.note" placeholder="Nota" prepend-icon="mdi-account" />
          </v-col>
          <v-col class="align-center justify-space-between" cols="12" md="6">
            <v-text-field v-model="proposal.price" placeholder="Preço" prepend-icon="mdi-account" />
          </v-col>
          <v-col class="align-center justify-space-between" cols="12" md="6">
            <v-text-field
              v-model="proposal.createdDate"
              placeholder="Data Cadastro"
              prepend-icon="mdi-account"
            />
          </v-col>
        </v-row>
      </v-form>
    </v-container>
    <v-card-actions>
      <v-spacer />
      <v-btn text color="primary" @click="$emit('finished')">Cancelar</v-btn>
      <v-btn text @click="saveProposal">Salvar</v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
import { mapGetters, mapActions } from "vuex";
import ProposalsRest from "@/domain/proposal/ProposalsRest";

export default {
  name: "UpdateProposalForm",
  props: {
    proposal: { type: Object, required: true },
  },
  data: () => ({
    dialog: false,
    valid: true,
    providers: [
      { name: "Fornecedor A" },
      { name: "Fornecedor B" },
      { name: "Fornecedor C" },
      { name: "Fornecedor D" }
    ],
  }),
  computed: {
    ...mapGetters("Biddings", ["getBiddings"])
  },
  methods: {
    ...mapActions("Proposals", ["findAll"]),
    ...mapActions("Biddings", ["findAllBiddings"]),
    async validate() {
      return await this.$refs.form.validate();
    },
    async saveProposal() {
      if (await this.validate()) {
        try {
          await new ProposalsRest().updateProposal(this.proposal);
          alert("Proposta atualizada com sucesso!");
          this.$emit("finished");
        } catch (error) {
          alert("Proposta não pode ser atualizada!");
        }
      }
    }
  }
};
</script>
