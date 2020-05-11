import HttpConfig from "@/configs/HttpConfig";

export default class BiddingsRest extends HttpConfig {
  findAllBiddings = async () => await this.get("biddings");
  newBidding = async bidding => await this.post("biddings", { ...bidding });
  updateBidding = async bidding => await this.put("biddings", { ...bidding });
}
