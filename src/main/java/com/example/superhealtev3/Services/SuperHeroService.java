package com.example.superhealtev3.Services;

import com.example.superhealtev3.Models.SuperHero;
import com.example.superhealtev3.Repository.SuperHeroRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SuperHeroService {

    private SuperHeroRepository superHeroRepository;

    public SuperHeroService() {
        this.superHeroRepository = new SuperHeroRepository();
    }

    public ArrayList<SuperHero> searchForHeroList(String searchName){

        return superHeroRepository.searchForHeroList(searchName);
    }

    public SuperHero createHero(String heroName, String heroPower, int year) {
        return superHeroRepository.addToDatabase(heroName, heroPower, year);
    }
    public SuperHero createHero(SuperHero hero) {
        return superHeroRepository.addToDatabase(hero);
    }

    public void deleteHero(int heroToDelete){
        superHeroRepository.deleteHero(heroToDelete);
    }

    public void deleteHero(String heroName){
        superHeroRepository.deleteHero(heroName);
    }

    public ArrayList getSuperheroes(){
        return superHeroRepository.getHeroDatabase();
    }

    public void editHeroName(SuperHero hero){
        superHeroRepository.editHeroName(hero);
    }
}
