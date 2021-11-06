package com.switchfully.til.api;

import com.switchfully.til.api.dto.TilCreateDTO;
import com.switchfully.til.api.dto.TilDTO;
import com.switchfully.til.api.mappers.TilMapper;
import com.switchfully.til.domain.entities.Til;
import com.switchfully.til.service.TilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin // (origins = "http://localhost:63342/")
@RestController
@RequestMapping("/tils")
public class TilController {

    private final TilService tilService;
    private final TilMapper tilMapper;

    @Autowired
    public TilController(TilService tilService, TilMapper tilMapper) {
        this.tilService = tilService;
        this.tilMapper = tilMapper;
    }


    @GetMapping
    public List<TilDTO> getAllTils() {
        return tilMapper.toDTO(tilService.getTils());
    }

    @PostMapping(consumes = {"application/json"})
    public Til addTilWithPostman(@RequestBody Til newKnowledge) {
        return tilService.addTil(newKnowledge);
    }

    @PostMapping(consumes = {"application/x-www-form-urlencoded"})
    // @RequestBody does not like application/x-www-form-urlencoded information
    // Resolved [org.springframework.web.HttpMediaTypeNotSupportedException: Content type 'application/x-www-form-urlencoded;charset=UTF-8' not supported]
    public String addTilWithUI(TilCreateDTO newKnowledge) {
        Til newKnowledgeTil = tilService.addTil(tilMapper.toEntity(newKnowledge));
        return "Thank you " + newKnowledgeTil.getOwner() + ", your #TIL has been added";
    }

    @DeleteMapping("/{id}")
    public String deleteTil(@PathVariable String id) {
        tilService.removeTil(id);
        return "Be gone " + id;
    }

    @PatchMapping("/{id}/like")
    // @RequestBody does not like application/x-www-form-urlencoded information
    // Resolved [org.springframework.web.HttpMediaTypeNotSupportedException: Content type 'application/x-www-form-urlencoded;charset=UTF-8' not supported]
    public String addLikeWithUI(Til newLike) {
        System.out.println(newLike.getOwner());
        return "OK";
    }
}
