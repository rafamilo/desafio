package com.desafio.desafio.domain.proposal.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.desafio.desafio.domain.bidding.models.IBidding;

import org.springframework.stereotype.Service;

@Entity
@Service
@Table(name = "proposals")
public class Proposal implements IProposal {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column
  private String provider;

  @Column
  private BigDecimal note;

  @Column
  private BigDecimal price;

  @Column
  private String createdDate;

  @Column
  private IBidding bidding;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getProvider() {
    return provider;
  }

  public void setProvider(String provider) {
    this.provider = provider;
  }

  public BigDecimal getNote() {
    return note;
  }

  public void setNote(BigDecimal note) {
    this.note = note;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public String getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(String createdDate) {
    this.createdDate = createdDate;
  }

  public IBidding getBidding() {
    return bidding;
  }

  public void setBidding(IBidding bidding) {
    this.bidding = bidding;
  }
}