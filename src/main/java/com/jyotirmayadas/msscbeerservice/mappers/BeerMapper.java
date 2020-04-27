package com.jyotirmayadas.msscbeerservice.mappers;

import com.jyotirmayadas.msscbeerservice.domain.Beer;
import com.jyotirmayadas.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDto beerDto);

}
