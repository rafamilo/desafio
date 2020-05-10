package com.desafio.desafio.domain.bidding.dtos;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.desafio.desafio.domain.bidding.classifiers.enums.ClassifierType;
import com.desafio.desafio.domain.bidding.models.Bidding;
import com.desafio.desafio.domain.bidding.models.IBidding;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class IBiddingDTOTest {

  @Test
  public void shouldReturnBidding() {
    IBiddingDTO biddingDTO = new BiddingDTO();
    biddingDTO.setType("MENOR_PRECO");

    assertTrue(IBiddingDTO.toModel(biddingDTO).getClass() == Bidding.class);
  }

  @Test
  public void shouldReturnBiddingDTO() {
    IBidding bidding = new Bidding();
    bidding.setType(ClassifierType.valueOf("MENOR_PRECO"));

    assertTrue(IBiddingDTO.toDto(bidding).getClass() == BiddingDTO.class);
  }
}