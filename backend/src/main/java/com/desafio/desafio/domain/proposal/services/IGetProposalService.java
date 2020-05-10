package com.desafio.desafio.domain.proposal.services;

import java.util.List;
import java.util.Optional;

import com.desafio.desafio.domain.proposal.models.Proposal;

public interface IGetProposalService {
  public List<Proposal> findAll();
  public Optional<Proposal> findById(Integer id);
}