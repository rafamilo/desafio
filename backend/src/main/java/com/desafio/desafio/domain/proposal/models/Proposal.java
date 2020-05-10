package com.desafio.desafio.domain.proposal.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Service;

@Entity
@Service
@Table(name = "proposals")
public class Proposal implements IProposal {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
}