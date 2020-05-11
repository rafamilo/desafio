import HttpConfig from "@/configs/HttpConfig";

export default class ProposalsRest extends HttpConfig {
  findAll = async () => await this.get("proposals");
}
