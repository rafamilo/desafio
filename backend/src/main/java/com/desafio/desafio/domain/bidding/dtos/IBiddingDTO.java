package com.desafio.desafio.domain.bidding.dtos;

import com.desafio.desafio.domain.bidding.classifiers.enums.ClassifierType;
import com.desafio.desafio.domain.bidding.models.Bidding;
import com.desafio.desafio.domain.bidding.models.IBidding;

public interface IBiddingDTO {
  public Integer getId();
  public void setId(Integer id);
  public String getDescription();
  public void setDescription(String description);
  public String getType();
  public void setType(String type);

  public static IBidding toModel(IBiddingDTO biddingDTO) {
    IBidding bidding = new Bidding();
    bidding.setId(biddingDTO.getId());
    bidding.setDescription(biddingDTO.getDescription());
    bidding.setType(ClassifierType.valueOf(biddingDTO.getType()));

    return bidding;
  }

  public static IBiddingDTO toDto(IBidding bidding) {
    IBiddingDTO biddingDTO = new BiddingDTO();
    biddingDTO.setId(bidding.getId());
    biddingDTO.setDescription(bidding.getDescription());
    biddingDTO.setType(bidding.getType().getDescription());

    return biddingDTO;
  }
}