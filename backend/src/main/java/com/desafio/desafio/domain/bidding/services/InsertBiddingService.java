package com.desafio.desafio.domain.bidding.services;

import com.desafio.desafio.domain.bidding.BiddingRepository;
import com.desafio.desafio.domain.bidding.models.Bidding;
import com.desafio.desafio.domain.bidding.models.IBidding;

import org.springframework.stereotype.Service;

@Service
public class InsertBiddingService implements IInsertBiddingService {

  private BiddingRepository biddingRepository;

  InsertBiddingService(BiddingRepository biddingRepository) {
    this.biddingRepository = biddingRepository;
  }

  @Override
  public IBidding create(IBidding bidding) {
    return this.biddingRepository.save((Bidding) bidding);
  }
}