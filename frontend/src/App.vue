<template>
  <v-app id="inspire">
    <Header />

    <router-view/>

    <v-footer app>
      <span>&copy; 2020</span>
    </v-footer>
  </v-app>
</template>

<script>
import Header from "@/components/Header";
export default {
  components: { Header },
  props: {
    source: String
  },
  data: () => ({
    drawer: null
  }),
  created() {
    this.$vuetify.theme.dark = true;
  }
};
</script>