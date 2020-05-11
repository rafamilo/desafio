import axios from "axios";
import VueRouterConfig from "./VueRouterConfig";

let instance = false;

export default class HttpConfig {
  constructor() {
    if (!instance) {
      instance = axios.create({
        baseURL: process.env.VUE_APP_SERVER_URL,
        timeout: 15000,
        headers: {
          "Content-Type": "application/json",
        },
      });

      instance.interceptors.response.use(
        (res) => res,
        (err) => Promise.reject(err && err.response ? err.response : err)
      );
    }

    return instance;
  }
}
