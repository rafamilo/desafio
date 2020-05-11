<template>
  <div class="Header">
    <v-app-bar id="header-system" app clipped-left>
      <v-app-bar-nav-icon @click.stop="openSidebar = !openSidebar"></v-app-bar-nav-icon>
      <v-toolbar-title>AZ Propostas</v-toolbar-title>
    </v-app-bar>
    <SideBar :openSidebar="openSidebar" />
  </div>
</template>

<script>
import SideBar from "./SideBar";

export default {
  name: "Header",
  components: { SideBar },
  data: () => ({
    openSidebar: false
  })
};
</script>
