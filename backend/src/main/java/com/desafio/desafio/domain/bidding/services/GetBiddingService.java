package com.desafio.desafio.domain.bidding.services;

import java.util.List;

import com.desafio.desafio.domain.bidding.BiddingRepository;
import com.desafio.desafio.domain.bidding.models.Bidding;

import org.springframework.stereotype.Service;

@Service
public class GetBiddingService implements IGetBiddingService {

  private BiddingRepository biddingRepository;

  public GetBiddingService(BiddingRepository biddingRepository) {
    this.biddingRepository = biddingRepository;
  }

	public List<Bidding> findAll() {
    return (List<Bidding>) this.biddingRepository.findAll();
	}
  
}