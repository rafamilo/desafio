package com.desafio.desafio.domain.proposal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ProposalRepository extends CrudRepository<Bidding, Integer> {
}
