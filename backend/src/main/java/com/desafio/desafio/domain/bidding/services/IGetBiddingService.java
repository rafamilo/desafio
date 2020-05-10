package com.desafio.desafio.domain.bidding.services;

import java.util.List;

import com.desafio.desafio.domain.bidding.models.Bidding;

public interface IGetBiddingService {
  public List<Bidding> findAll();
}