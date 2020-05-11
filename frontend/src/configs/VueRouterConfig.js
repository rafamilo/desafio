import VueRouter from "vue-router";
import RouterView from "../views/RouterView.vue";
import ProposalsList from "@/domain/proposal/views/ProposalsList";

let instance = false;

export default class VueRouterConfig {
  constructor() {
    if (!instance) {
      const configs = {
        mode: "history",
        base: `${process.env.BASE_URL}`,
        routes: this.routes
      };

      instance = new VueRouter(configs);
    }
    return instance;
  }

  routes = [
    {
      path: "/",
      name: "base",
      component: RouterView,
      children: [
        {
          path: "/proposals",
          name: "proposals",
          redirect: { name: "proposals.list" },
          component: RouterView,
          children: [
            {
              path: "proposals-list",
              name: "proposals.list",
              component: ProposalsList
            }
          ]
        },
      ]
    }
  ];
}
