package com.desafio.desafio.domain.bidding.classifiers.enums;

public enum ClassifierType {
  MENOR_PRECO("Menor Preço") , NOTA_PRECO("Nota Preço");

  private String description;

  ClassifierType(String description) {
    this.description = description;
  }

  public String getDescription() {
    return this.description;
  }
}