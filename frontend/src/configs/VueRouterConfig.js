import VueRouter from "vue-router";
import RouterView from "../views/RouterView.vue";
import ProposalsList from "@/domain/proposal/views/ProposalsList";
import BiddingsList from "@/domain/bidding/views/BiddingsList";

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
        {
          path: "/biddings",
          name: "biddings",
          redirect: { name: "biddings.list" },
          component: RouterView,
          children: [
            {
              path: "biddings-list",
              name: "biddings.list",
              component: BiddingsList
            }
          ]
        }
      ]
    },
  ]
}
