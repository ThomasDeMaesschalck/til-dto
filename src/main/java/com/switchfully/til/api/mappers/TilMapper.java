package com.switchfully.til.api.mappers;

import com.switchfully.til.api.dto.TilCreateDTO;
import com.switchfully.til.api.dto.TilDTO;
import com.switchfully.til.domain.entities.Til;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class TilMapper {

    public Til toEntity(TilCreateDTO tilCreateDTO) {
        return new Til(tilCreateDTO.getOwnerName(), tilCreateDTO.getTil(), UUID.randomUUID());
    }

    public TilDTO toDTO(Til til) {
        return new TilDTO(til.getUuid().toString(), til.getOwner(), til.getKnowledgeOfTheDay());
    }

    public List<TilDTO> toDTO(List<Til> tils) {
        return tils.stream().map(this::toDTO).collect(Collectors.toList());
    }

}
