import HttpConfig from "@/configs/HttpConfig";

export default class ProposalsRest extends HttpConfig {
  findAll = async () => await this.get("proposals");
  newProposal = async (proposal) => {
    proposal.note = proposal.note.replace(",", ".");
    proposal.price = proposal.price.replace(",", ".");
    await this.post("proposals", { ...proposal });
  };
  updateProposal = async (proposal) => {
    proposal.note = proposal.note.replace(",", ".");
    proposal.price = proposal.price.replace(",", ".");
    await this.put("proposals", { ...proposal });
  }
}
