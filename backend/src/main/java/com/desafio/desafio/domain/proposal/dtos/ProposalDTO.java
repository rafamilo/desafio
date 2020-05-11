package com.desafio.desafio.domain.proposal.dtos;

import java.math.BigDecimal;

import com.desafio.desafio.domain.bidding.dtos.BiddingDTO;

import org.springframework.stereotype.Service;

@Service
public class ProposalDTO implements IProposalDTO {
  private Integer id;
  private String provider;
  private BigDecimal note;
  private BigDecimal price;
  private String createdDate;
  private BiddingDTO bidding;

  public Integer getId() {
    return id;
  }

  public void setId(final Integer id) {
    this.id = id;
  }

  public String getProvider() {
    return provider;
  }

  public void setProvider(final String provider) {
    this.provider = provider;
  }

  public BigDecimal getNote() {
    return note;
  }

  public void setNote(final BigDecimal note) {
    this.note = note;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(final BigDecimal price) {
    this.price = price;
  }

  public String getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(final String createdDate) {
    this.createdDate = createdDate;
  }

  public BiddingDTO getBidding() {
    return bidding;
  }

  public void setBidding(BiddingDTO bidding) {
    this.bidding = bidding;
  }
}