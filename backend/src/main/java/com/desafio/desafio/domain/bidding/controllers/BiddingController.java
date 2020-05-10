package com.desafio.desafio.domain.bidding.controllers;

import com.desafio.desafio.domain.bidding.classifiers.enums.ClassifierType;
import com.desafio.desafio.domain.bidding.controllers.exceptions.ResourceNotFoundException;
import com.desafio.desafio.domain.bidding.dtos.BiddingDTO;
import com.desafio.desafio.domain.bidding.dtos.IBiddingDTO;
import com.desafio.desafio.domain.bidding.models.IBidding;
import com.desafio.desafio.domain.bidding.services.IDeleteBiddingService;
import com.desafio.desafio.domain.bidding.services.IGetBiddingService;
import com.desafio.desafio.domain.bidding.services.IInsertBiddingService;
import com.desafio.desafio.domain.bidding.services.IUpdateBiddingService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

  private IGetBiddingService getBiddingService;
  private IInsertBiddingService insertBiddingService;
  private IUpdateBiddingService updateBiddingService;
  private IDeleteBiddingService deleteBiddingService;

  public BiddingController(IGetBiddingService getBiddingService, IInsertBiddingService insertBiddingService,
      IUpdateBiddingService updateBiddingService, IDeleteBiddingService deleteBiddingService) {
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
  public IBiddingDTO post(@RequestBody BiddingDTO biddingDTO) {
    return IBiddingDTO.toDto(this.insertBiddingService.create(IBiddingDTO.toModel(biddingDTO)));
  }

  @PutMapping()
  public IBiddingDTO put(@RequestBody BiddingDTO biddingDTO) throws ResourceNotFoundException {
    IBidding bidding = this.getBiddingService.findById(biddingDTO.getId())
        .orElseThrow(() -> new ResourceNotFoundException("Doesn't exist any user with id " + biddingDTO.getId()));

    bidding.setDescription(biddingDTO.getDescription());
    bidding.setType(ClassifierType.valueOf(biddingDTO.getType()));

    return IBiddingDTO.toDto(this.updateBiddingService.update(bidding));
  }

  @DeleteMapping()
  public void delete(@RequestParam Integer id) {
    this.deleteBiddingService.deleteById(id);
  }
}
