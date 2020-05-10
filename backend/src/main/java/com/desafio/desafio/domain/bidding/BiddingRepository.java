package com.desafio.desafio.domain.bidding;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.desafio.desafio.domain.bidding.models.Bidding;

@Repository
public interface BiddingRepository extends CrudRepository<Bidding, Integer> {
}
