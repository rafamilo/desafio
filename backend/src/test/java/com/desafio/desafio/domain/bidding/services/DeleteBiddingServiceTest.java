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
public class DeleteBiddingServiceTest {

  @InjectMocks
  private DeleteBiddingService deleteBiddingService;

  @Mock
  private BiddingRepository biddingRepository;

  @Test
  public void shouldBeImplementIDeleteBiddingService() {
    Class[] ifaces = DeleteBiddingService.class.getInterfaces();
    assertTrue(ifaces.length == 1);

    for (Class iface : ifaces) {
      assertTrue(iface.getName().contains("IDeleteBiddingService"));
    }
  }

  @Test
  public void shouldToCallRepositoryFindAll() {
    Integer biddingId = Integer.MAX_VALUE;
    deleteBiddingService.deleteById(biddingId);
    verify(biddingRepository, times(1)).deleteById(biddingId);
  }
}