package com.example.superhealtev3.Controllers;

import com.example.superhealtev3.Models.SuperHero;
import com.example.superhealtev3.Services.SuperHeroService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "superhero")
public class SuperHeroController {

    private SuperHeroService superHeroService;

    public SuperHeroController(SuperHeroService superHeroService) {
        this.superHeroService = superHeroService;
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<SuperHero>> showAllHeroes() {
        ArrayList<SuperHero> heroList = superHeroService.getSuperheroes();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type", "text");
        return new ResponseEntity<List<SuperHero>>(heroList, HttpStatus.OK);
    }

    @PostMapping(path = "create")
    public ResponseEntity<SuperHero> createHero(@RequestBody SuperHero hero){
        superHeroService.createHero(hero);
        return new ResponseEntity<>(hero, HttpStatus.OK);
    }

    @DeleteMapping(path="delete")
    public ResponseEntity<SuperHero>deleteHero(@RequestBody SuperHero hero){
        superHeroService.deleteHero(hero.getSuperheroName());
        return new ResponseEntity<>(hero, HttpStatus.OK);
    }

    @PutMapping(path="edit")
    public ResponseEntity<SuperHero>updateHero(@RequestBody SuperHero hero){
        superHeroService.editHeroName(hero);
        return new ResponseEntity<>(hero, HttpStatus.OK);
    }
}
