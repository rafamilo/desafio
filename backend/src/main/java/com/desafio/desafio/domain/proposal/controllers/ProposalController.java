package com.desafio.desafio.domain.proposal.controllers;

import com.desafio.desafio.domain.proposal.controllers.exceptions.ResourceNotFoundException;
import com.desafio.desafio.domain.proposal.dtos.ProposalDTO;
import com.desafio.desafio.domain.proposal.dtos.IProposalDTO;
import com.desafio.desafio.domain.proposal.services.IDeleteProposalService;
import com.desafio.desafio.domain.proposal.services.IGetProposalService;
import com.desafio.desafio.domain.proposal.services.IInsertProposalService;
import com.desafio.desafio.domain.proposal.services.IUpdateProposalService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/proposals")
public class ProposalController {

  private final IGetProposalService getProposalService;
  private final IInsertProposalService insertProposalService;
  private final IUpdateProposalService updateProposalService;
  private final IDeleteProposalService deleteProposalService;

  public ProposalController(final IGetProposalService getProposalService,
      final IInsertProposalService insertProposalService, final IUpdateProposalService updateProposalService,
      final IDeleteProposalService deleteProposalService) {
    this.getProposalService = getProposalService;
    this.insertProposalService = insertProposalService;
    this.updateProposalService = updateProposalService;
    this.deleteProposalService = deleteProposalService;
  }

  @GetMapping()
  public List<IProposalDTO> findAll() {
    return this.getProposalService.findAll().stream().map(IProposalDTO::toDto).collect(Collectors.toList());
  }

  @PostMapping()
  public IProposalDTO post(@RequestBody final ProposalDTO proposalDTO) {
    return IProposalDTO.toDto(this.insertProposalService.create(IProposalDTO.toModel(proposalDTO)));
  }

  @PutMapping()
  public IProposalDTO put(@RequestBody ProposalDTO proposalDTO) throws ResourceNotFoundException {
    this.getProposalService.findById(proposalDTO.getId())
        .orElseThrow(() -> new ResourceNotFoundException("Doesn't exist any proposal with this id"));

    return IProposalDTO.toDto(this.updateProposalService.update(IProposalDTO.toModel(proposalDTO)));
  }

  @DeleteMapping()
  public void delete(@RequestParam final Integer id) {
    this.deleteProposalService.deleteById(id);
  }
}
