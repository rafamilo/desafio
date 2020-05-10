package com.desafio.desafio.domain.bidding.dtos;

import com.desafio.desafio.domain.bidding.classifiers.enums.ClassifierType;
import com.desafio.desafio.domain.bidding.models.Bidding;
import com.desafio.desafio.domain.bidding.models.IBidding;

import org.springframework.stereotype.Service;

@Service
public class BiddingDTO implements IBiddingDTO {
  private Integer id;
  private String description;
  private String type;

  @Override
  public Integer getId() {
    return id;
  }

  @Override
  public void setId(Integer id) {
    this.id = id;
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String getType() {
    return type;
  }

  @Override
  public void setType(String type) {
    this.type = type;
  }
}