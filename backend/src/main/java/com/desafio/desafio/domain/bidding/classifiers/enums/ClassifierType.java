package com.desafio.desafio.domain.bidding.classifiers.enums;

public enum ClassifierType {
  MENOR_PRECO("MENOR_PRECO") , NOTA_PRECO("NOTA_PRECO");

  private String description;

  ClassifierType(String description) {
    this.description = description;
  }

  public String getDescription() {
    return this.description;
  }
}