package com.desafio.desafio.domain.proposal;

import com.desafio.desafio.domain.proposal.models.Proposal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProposalRepository extends CrudRepository<Proposal, Integer> {
}
