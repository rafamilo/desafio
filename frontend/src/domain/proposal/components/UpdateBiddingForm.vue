<template>
  <v-card class="NewBiddingModal">
    <v-card-title class="grey darken-2">Nova Licitação</v-card-title>
    <v-container>
      <v-form ref="form" v-model="valid" :lazy-validation="true">
        <v-row class="mx-2">
          <v-col class="align-center justify-space-between" cols="12" md="12">
            <v-text-field
              v-model="bidding.description"
              placeholder="Descrição"
              :rules="descriptionRules"
              required
              prepend-icon="mdi-account"
            />
          </v-col>
          <v-col cols="12" md="6">
            <v-select
              v-model="bidding.type"
              :items="types"
              :rules="typeRules"
              :item-value="'id'"
              :item-text="'name'"
              label="Tipo Classificação"
              prepend-icon="mdi-domain"
            />
          </v-col>
        </v-row>
      </v-form>
    </v-container>
    <v-card-actions>
      <v-spacer />
      <v-btn text color="primary" @click="dialog = false">Cancelar</v-btn>
      <v-btn text @click="saveBidding">Salvar</v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
import BiddingRest from "@/domain/bidding/BiddingsRest";

export default {
  name: "NewBiddingModal",
  props: {
    bidding: { type: Object, required: true },
  },
  data: () => ({
    types: [
      { name: "Menor Preço", id: "MENOR_PRECO" },
      { name: "Nota Preço", id: "NOTA_PRECO" }
    ],
    dialog: false,
    valid: true,
    descriptionRules: [
      v => !!v || "Descrição é obrigatório",
      v =>
        (v && v.length > 1 && v.length <= 255) ||
        "Descrição precisa ter no mínimo 1 caracter e no máximo 255 caracteres"
    ],
    typeRules: [v => !!v || "Tipo é obrigatório"],
    bidding: {
      description: "",
      type: ""
    }
  }),
  methods: {
    async validate() {
      return await this.$refs.form.validate();
    },
    async saveBidding() {
      if (await this.validate()) {
        try {
          await new BiddingRest().updateBidding(this.bidding);
          alert("Licitação atualizada com sucesso!");
          this.$emit("finished");
        } catch (error) {
          alert("Licitação não pode ser atualizada!");
        }
      }
    }
  }
};
</script>
