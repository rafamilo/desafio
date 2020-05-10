package com.desafio.desafio.domain.bidding.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.desafio.desafio.domain.bidding.classifiers.enums.ClassifierType;

import org.springframework.stereotype.Service;

@Entity
@Service
@Table(name = "biddings")
public class Bidding implements IBidding {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column
  private String description;

  @Column
  @Enumerated(EnumType.STRING)
  private ClassifierType type;

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
  public ClassifierType getType() {
    return type;
  }

  @Override
  public void setType(ClassifierType type) {
    this.type = type;
  }
}