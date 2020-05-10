package com.desafio.desafio.domain.proposal.services;

import com.desafio.desafio.domain.proposal.ProposalRepository;
import com.desafio.desafio.domain.proposal.models.Proposal;
import com.desafio.desafio.domain.proposal.models.IProposal;

import org.springframework.stereotype.Service;

@Service
public class UpdateProposalService implements IUpdateProposalService {

  private ProposalRepository proposalRepository;

  UpdateProposalService(ProposalRepository proposalRepository) {
    this.proposalRepository = proposalRepository;
  }

  @Override
  public IProposal update(IProposal bidding) {
    return this.proposalRepository.save((Proposal) bidding);
  }
}