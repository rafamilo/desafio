package com.desafio.desafio.domain.bidding.controllers;

import com.desafio.desafio.domain.bidding.controllers.exceptions.ResourceNotFoundException;
import com.desafio.desafio.domain.bidding.dtos.BiddingDTO;
import com.desafio.desafio.domain.bidding.dtos.IBiddingDTO;
import com.desafio.desafio.domain.bidding.services.IDeleteBiddingService;
import com.desafio.desafio.domain.bidding.services.IGetBiddingService;
import com.desafio.desafio.domain.bidding.services.IInsertBiddingService;
import com.desafio.desafio.domain.bidding.services.IUpdateBiddingService;
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
@RequestMapping("/biddings")
public class BiddingController {

  private final IGetBiddingService getBiddingService;
  private final IInsertBiddingService insertBiddingService;
  private final IUpdateBiddingService updateBiddingService;
  private final IDeleteBiddingService deleteBiddingService;

  public BiddingController(final IGetBiddingService getBiddingService, final IInsertBiddingService insertBiddingService,
      final IUpdateBiddingService updateBiddingService, final IDeleteBiddingService deleteBiddingService) {
    this.getBiddingService = getBiddingService;
    this.insertBiddingService = insertBiddingService;
    this.updateBiddingService = updateBiddingService;
    this.deleteBiddingService = deleteBiddingService;
  }

  @GetMapping()
  public List<IBiddingDTO> findAll() {
    return this.getBiddingService.findAll().stream().map(IBiddingDTO::toDto).collect(Collectors.toList());
  }

  @PostMapping()
  public IBiddingDTO post(@RequestBody final BiddingDTO biddingDTO) {
    return IBiddingDTO.toDto(this.insertBiddingService.create(IBiddingDTO.toModel(biddingDTO)));
  }

  @PutMapping()
  public IBiddingDTO put(@RequestBody BiddingDTO biddingDTO) throws ResourceNotFoundException {
    this.getBiddingService.findById(biddingDTO.getId())
    .orElseThrow(() -> new ResourceNotFoundException("Doesn't exist any bidding with this id"));

    return IBiddingDTO.toDto(this.updateBiddingService.update(IBiddingDTO.toModel(biddingDTO)));
  }

  @DeleteMapping()
  public void delete(@RequestParam final Integer id) {
    this.deleteBiddingService.deleteById(id);
  }
}
