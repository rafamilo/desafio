package com.desafio.desafio.domain.bidding.services;

import java.util.List;
import java.util.Optional;

import com.desafio.desafio.domain.bidding.models.Bidding;

public interface IGetBiddingService {
  public List<Bidding> findAll();
  public Optional<Bidding> findById(Integer id);
}