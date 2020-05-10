package com.desafio.desafio.domain.proposal.services;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.desafio.desafio.domain.proposal.ProposalRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GetProposalServiceTest {

  @InjectMocks
  private GetProposalService getBiddingService;

  @Mock
  private ProposalRepository proposalRepository;

  @Test
  public void shouldBeImplementIGetProposalService() {
    Class[] ifaces = GetProposalService.class.getInterfaces();
    assertTrue(ifaces.length == 1);

    for (Class iface : ifaces) {
      assertTrue(iface.getName().contains("IGetProposalService"));
    }
  }

  @Test
  public void shouldToCallRepositoryFindAll() {
    getBiddingService.findAll();
    verify(proposalRepository, times(1)).findAll();
  }

  @Test
  public void shouldToCallRepositoryFindById() {
    Integer biddingId = Integer.MAX_VALUE;
    getBiddingService.findById(biddingId);
    verify(proposalRepository, times(1)).findById(biddingId);
  }
}