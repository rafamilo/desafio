package com.desafio.desafio.domain.proposal.services;

import com.desafio.desafio.domain.proposal.ProposalRepository;

import org.springframework.stereotype.Service;

@Service
public class DeleteProposalService implements IDeleteProposalService {

  private ProposalRepository proposalRepository;

  DeleteProposalService(ProposalRepository proposalRepository) {
    this.proposalRepository = proposalRepository;
  }

  @Override
	public void deleteById(Integer id) {
    this.proposalRepository.deleteById(id);
	}
  
}