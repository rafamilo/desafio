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
public class DeleteProposalServiceTest {

  @InjectMocks
  private DeleteProposalService proposalService;

  @Mock
  private ProposalRepository proposalRepository;

  @Test
  public void shouldBeImplementIDeleteProposalService() {
    Class[] ifaces = DeleteProposalService.class.getInterfaces();
    assertTrue(ifaces.length == 1);

    for (Class iface : ifaces) {
      assertTrue(iface.getName().contains("IDeleteProposalService"));
    }
  }

  @Test
  public void shouldToCallRepositoryFindAll() {
    Integer biddingId = Integer.MAX_VALUE;
    proposalService.deleteById(biddingId);
    verify(proposalRepository, times(1)).deleteById(biddingId);
  }
}