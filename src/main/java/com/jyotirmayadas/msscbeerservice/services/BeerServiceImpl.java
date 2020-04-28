package com.jyotirmayadas.msscbeerservice.services;

import com.jyotirmayadas.msscbeerservice.domain.Beer;
import com.jyotirmayadas.msscbeerservice.mappers.BeerMapper;
import com.jyotirmayadas.msscbeerservice.repositories.BeerRepository;
import com.jyotirmayadas.msscbeerservice.web.controller.NotFoundException;
import com.jyotirmayadas.msscbeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public BeerDto getBeerById(UUID beerId) {

        return beerMapper.beerToBeerDto(
                beerRepository.findById(beerId).orElseThrow(NotFoundException::new)
        );

    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {

        return beerMapper.beerToBeerDto(
                beerRepository.save(
                        beerMapper.beerDtoToBeer(beerDto)
                )
        );
    }

    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {

        Beer beer = beerRepository.findById(beerId).orElseThrow(NotFoundException::new);

        beer.setBeerName(beerDto.getBeerName());
        beer.setBeerStyle(beerDto.getBeerStyle().name());
        beer.setPrice(beerDto.getPrice());
        beer.setUpc(beerDto.getUpc());

        return beerMapper.beerToBeerDto(beer);
    }
}
