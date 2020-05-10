package com.desafio.desafio.domain.proposal.models;

import java.math.BigDecimal;

import com.desafio.desafio.domain.bidding.models.IBidding;

public interface IProposal {
  public Integer getId();
  public void setId(Integer id);
  public String getProvider();
  public void setProvider(String provider);
  public BigDecimal getNote();
  public void setNote(BigDecimal note);
  public BigDecimal getPrice();
  public void setPrice(BigDecimal price);
  public String getCreatedDate();
  public void setCreatedDate(String createdDate);
  public IBidding getBidding();
  public void setBidding(IBidding bidding);
}
