<template>
  <div class="NewBiddingModal">
    <v-btn bottom color="pink" dark fixed right @click="dialog = !dialog">
      Nova Licitação
    </v-btn>
    <v-dialog v-model="dialog">
      <v-card>
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
    </v-dialog>
  </div>
</template>

<script>
import { createNamespacedHelpers } from "vuex";
import BiddingRest from "@/domain/bidding/BiddingsRest";
const { mapActions } = createNamespacedHelpers("Biddings");

export default {
  name: "NewBiddingModal",
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
    ...mapActions(["findAll"]),
    async validate() {
      return await this.$refs.form.validate();
    },
    async saveBidding() {
      if (await this.validate()) {
        try {
          await new BiddingRest().newBidding(this.bidding);
          alert("Licitação salva com sucesso!");
          this.bidding = { description: "", type: "" };
          this.dialog = false;
          this.findAll();
        } catch (error) {
          alert("Licitação não pode ser salva!");
        }
      }
    }
  }
};
</script>
