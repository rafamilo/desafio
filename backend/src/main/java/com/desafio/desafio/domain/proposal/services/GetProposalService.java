package com.desafio.desafio.domain.proposal.services;

import java.util.List;
import java.util.Optional;

import com.desafio.desafio.domain.proposal.ProposalRepository;
import com.desafio.desafio.domain.proposal.models.Proposal;

import org.springframework.stereotype.Service;

@Service
public class GetProposalService implements IGetProposalService {

  private ProposalRepository proposalRepository;

  public GetProposalService(ProposalRepository proposalRepository) {
    this.proposalRepository = proposalRepository;
  }

  @Override
  public List<Proposal> findAll() {
    return (List<Proposal>) this.proposalRepository.findAll();
  }

  @Override
  public Optional<Proposal> findById(Integer id) {
    return this.proposalRepository.findById(id);
	}
  
}