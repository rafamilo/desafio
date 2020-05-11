import HttpConfig from "@/configs/HttpConfig";

export default class BiddingsRest extends HttpConfig {
  findAll = async () => await this.get("biddings");
}
