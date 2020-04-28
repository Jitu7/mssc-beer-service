package com.jyotirmayadas.msscbeerservice.web.controller;

import com.jyotirmayadas.msscbeerservice.services.BeerService;
import com.jyotirmayadas.msscbeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;

    @GetMapping("/{beerid}")
    public ResponseEntity<BeerDto> geetBeerById(@PathVariable("beerid") UUID beerid) {
        return new ResponseEntity<>(beerService.getBeerById(beerid), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewBeer(@Valid @RequestBody BeerDto beerDto) {
        return new ResponseEntity(beerService.saveNewBeer(beerDto), HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeer(@PathVariable("beerId") UUID beerId,
                                     @Valid @RequestBody BeerDto beerDto) {
        return new ResponseEntity(beerService.updateBeer(beerId, beerDto), HttpStatus.NO_CONTENT);
    }
}
