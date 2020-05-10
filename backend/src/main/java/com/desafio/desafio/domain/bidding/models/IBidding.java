package com.desafio.desafio.domain.bidding.models;

import com.desafio.desafio.domain.bidding.classifiers.enums.ClassifierType;

public interface IBidding {
  public Integer getId();
  public void setId(Integer id);
  public String getDescription();
  public void setDescription(String description);
  public ClassifierType getType();
  public void setType(ClassifierType type);
}
