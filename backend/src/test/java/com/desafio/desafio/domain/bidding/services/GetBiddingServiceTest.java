package com.desafio.desafio.domain.bidding.services;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.desafio.desafio.domain.bidding.BiddingRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GetBiddingServiceTest {

  @InjectMocks
  private GetBiddingService getBiddingService;

  @Mock
  private BiddingRepository biddingRepository;

  @Test
  public void shouldBeImplementIGetBiddingService() {
    Class[] ifaces = GetBiddingService.class.getInterfaces();
    assertTrue(ifaces.length == 1);

    for (Class iface : ifaces) {
      assertTrue(iface.getName().contains("IGetBiddingService"));
    }
  }

  @Test
  public void shouldToCallRepositoryFindAll() {
    getBiddingService.findAll();
    verify(biddingRepository, times(1)).findAll();
  }

  @Test
  public void shouldToCallRepositoryFindById() {
    Integer biddingId = Integer.MAX_VALUE;
    getBiddingService.findById(biddingId);
    verify(biddingRepository, times(1)).findById(biddingId);
  }
}