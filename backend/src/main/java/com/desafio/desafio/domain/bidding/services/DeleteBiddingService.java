package com.desafio.desafio.domain.bidding.services;

import com.desafio.desafio.domain.bidding.BiddingRepository;

import org.springframework.stereotype.Service;

@Service
public class DeleteBiddingService implements IDeleteBiddingService {

  private BiddingRepository biddingRepository;

  DeleteBiddingService(BiddingRepository biddingRepository) {
    this.biddingRepository = biddingRepository;
  }

  @Override
	public void deleteById(Integer id) {
    this.biddingRepository.deleteById(id);
	}
  
}