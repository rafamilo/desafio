package com.desafio.desafio.domain.proposal.dtos;

import java.math.BigDecimal;

import com.desafio.desafio.domain.bidding.dtos.IBiddingDTO;
import com.desafio.desafio.domain.proposal.models.IProposal;
import com.desafio.desafio.domain.proposal.models.Proposal;

public interface IProposalDTO {
  public Integer getId();

  public void setId(Integer id);

  public String getProvider();

  public void setProvider(String provider);

  public BigDecimal getNote();

  public void setNote(BigDecimal note);

  public BigDecimal getPrice();

  public void setPrice(BigDecimal price);

  public String getCreatedDate();

  public void setCreatedDate(String createdDate);

  public IBiddingDTO getBidding();
  
  public void setBidding(IBiddingDTO bidding);

  public static IProposal toModel(IProposalDTO proposalDTO) {
    IProposal proposal = new Proposal();
    proposal.setId(proposalDTO.getId());
    proposal.setId(proposalDTO.getId());
    proposal.setProvider(proposalDTO.getProvider());
    proposal.setNote(proposalDTO.getNote());
    proposal.setPrice(proposalDTO.getPrice());
    proposal.setCreatedDate(proposalDTO.getCreatedDate());
    try {
      proposal.setBidding(IBiddingDTO.toModel(proposalDTO.getBidding())); 
    } catch (Exception e) {
      e.printStackTrace();
    }

    return proposal;
  }

  public static IProposalDTO toDto(IProposal proposal) {
    IProposalDTO proposalDTO = new ProposalDTO();
    proposalDTO.setId(proposal.getId());
    proposalDTO.setId(proposal.getId());
    proposalDTO.setProvider(proposal.getProvider());
    proposalDTO.setNote(proposal.getNote());
    proposalDTO.setPrice(proposal.getPrice());
    proposalDTO.setCreatedDate(proposal.getCreatedDate());
    try {
      proposalDTO.setBidding(IBiddingDTO.toDto(proposal.getBidding()));
    } catch (Exception e) {
      e.printStackTrace();
    }

    return proposalDTO;
  }
}