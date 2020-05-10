package com.desafio.desafio.domain.bidding.services;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.desafio.desafio.domain.bidding.BiddingRepository;
import com.desafio.desafio.domain.bidding.models.Bidding;
import com.desafio.desafio.domain.bidding.models.IBidding;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class InsertBiddingServiceTest {

  @InjectMocks
  private InsertBiddingService insertBiddingService;

  @Mock
  private BiddingRepository biddingRepository;

  @Test
  public void shouldBeImplementIInsertBiddingService() {
    Class[] ifaces = InsertBiddingService.class.getInterfaces();
    assertTrue(ifaces.length == 1);

    for (Class iface : ifaces) {
      assertTrue(iface.getName().contains("IInsertBiddingService"));
    }
  }

  @Test
  public void shouldToCallRepositoryFindAll() {
    IBidding bidding = new Bidding();
    insertBiddingService.create(bidding);
    verify(biddingRepository, times(1)).save((Bidding) bidding);
  }
}