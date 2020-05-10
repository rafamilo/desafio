package com.desafio.desafio.domain.proposal.services;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.desafio.desafio.domain.proposal.ProposalRepository;
import com.desafio.desafio.domain.proposal.models.IProposal;
import com.desafio.desafio.domain.proposal.models.Proposal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class InsertProposalServiceTest {

  @InjectMocks
  private InsertProposalService insertProposalService;

  @Mock
  private ProposalRepository proposalRepository;

  @Test
  public void shouldBeImplementIInsertProposalService() {
    Class[] ifaces = InsertProposalService.class.getInterfaces();
    assertTrue(ifaces.length == 1);

    for (Class iface : ifaces) {
      assertTrue(iface.getName().contains("IInsertProposalService"));
    }
  }

  @Test
  public void shouldToCallRepositoryFindAll() {
    IProposal proposal = new Proposal();
    insertProposalService.create(proposal);
    verify(proposalRepository, times(1)).save((Proposal) proposal);
  }
}