import HttpConfig from "@/configs/HttpConfig";

export default class ProposalsRest extends HttpConfig {
  findAll = async () => await this.get("proposals");
  newProposal = async proposal => await this.post("proposals", { ...proposal });
  updateProposal = async proposal => await this.put("proposals", { ...proposal });
}
