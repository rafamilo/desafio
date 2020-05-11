package com.desafio.desafio.domain.proposal.dtos;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.desafio.desafio.domain.bidding.dtos.BiddingDTO;
import com.desafio.desafio.domain.bidding.models.Bidding;
import com.desafio.desafio.domain.proposal.models.IProposal;
import com.desafio.desafio.domain.proposal.models.Proposal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class IProposalDTOTest {

  @Test
  public void shouldReturnProposal() {
    IProposalDTO proposalDTO = new ProposalDTO();
    proposalDTO.setBidding(new BiddingDTO());

    assertTrue(IProposalDTO.toModel(proposalDTO).getClass() == Proposal.class);
  }

  @Test
  public void shouldReturnProposalDTO() {
    IProposal proposal = new Proposal();
    proposal.setBidding(new Bidding());

    assertTrue(IProposalDTO.toDto(proposal).getClass() == ProposalDTO.class);
  }
}