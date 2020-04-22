package com.jyotirmayadas.msscbeerservice.web.controller;

import com.jyotirmayadas.msscbeerservice.web.model.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
public class BeerController {

    @GetMapping("/{beerid}")
    public ResponseEntity<BeerDto> geetBeerById(@PathVariable("beerid") UUID beerid) {

        // todo impl
        return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewBeer(@RequestBody BeerDto beerDto) {

        // todo impl
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeer(@PathVariable("beerId") UUID beerId,
                                     @RequestBody BeerDto beerDto) {

        // todo impl
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
