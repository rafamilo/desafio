package com.desafio.desafio.domain.proposal.services;

import com.desafio.desafio.domain.proposal.ProposalRepository;
import com.desafio.desafio.domain.proposal.models.IProposal;
import com.desafio.desafio.domain.proposal.models.Proposal;

import org.springframework.stereotype.Service;

@Service
public class InsertProposalService implements IInsertProposalService {

  private ProposalRepository proposalRepository;

  InsertProposalService(ProposalRepository proposalRepository) {
    this.proposalRepository = proposalRepository;
  }

  @Override
  public IProposal create(IProposal proposal) {
    return this.proposalRepository.save((Proposal) proposal);
  }
}