package com.desafio.desafio.domain.bidding.services;

import com.desafio.desafio.domain.bidding.BiddingRepository;
import com.desafio.desafio.domain.bidding.models.Bidding;
import com.desafio.desafio.domain.bidding.models.IBidding;

import org.springframework.stereotype.Service;

@Service
public class UpdateBiddingService implements IUpdateBiddingService {

  private BiddingRepository biddingRepository;

  UpdateBiddingService(BiddingRepository biddingRepository) {
    this.biddingRepository = biddingRepository;
  }

  @Override
  public IBidding update(IBidding bidding) {
    return this.biddingRepository.save((Bidding) bidding);
  }
}