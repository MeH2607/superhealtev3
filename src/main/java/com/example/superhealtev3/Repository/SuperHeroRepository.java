package com.example.superhealtev3.Repository;

import com.example.superhealtev3.Models.SuperHero;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class SuperHeroRepository {

    ArrayList<SuperHero> heroDatabase;
    ArrayList<String> nameList;

    public SuperHeroRepository() {
        nameList = new ArrayList<>();
        this.heroDatabase = new ArrayList<>(List.of(
                //Opretter og tilføjer helte til databasen så det ikke skal gøres i hver test metode
                new SuperHero("Spider-man",
                        "Spider stuff", 1962),
                new SuperHero("Superman",
                        "Super strength, flight, lasers, shit what doesn't he have", 1938),
                new SuperHero("Johnny",
                        "Being cool", 2000),
                new SuperHero("Batman",
                        "Money", 1939),
                new SuperHero("Spider-man", "Spider stuff", 1999)
                //indsætter til databasen
        ));
    }

    private ArrayList<SuperHero> findSuperheroList = new ArrayList<>();


    public ArrayList<SuperHero> getHeroDatabase() {
        return heroDatabase;
    }

    public void setHeroDatabase(ArrayList<SuperHero> heroDatabase) {
        this.heroDatabase = heroDatabase;
    }

    public ArrayList<SuperHero> getFindSuperheroList() {
        return findSuperheroList;
    }


    public SuperHero addToDatabase(String superheroName, String superheroPower, int creationYear) {
        SuperHero newHero = new SuperHero(superheroName, superheroPower, creationYear);
        heroDatabase.add(newHero);
        return newHero;
    }

    public SuperHero addToDatabase(SuperHero hero) {
        heroDatabase.add(hero);
        return hero;
    }


    //Samler en gruppe af helte, når man skal gemme resultater. Bruges til når der skal redigeres.
    public ArrayList<SuperHero> searchForHeroList(String searchName) {
        SuperHero hero;
        findSuperheroList.clear(); //Clear for at når man søger flere gange så gemmes de gamle svar ikke

        for (int n = 0; n < heroDatabase.size(); n++) {
            hero = heroDatabase.get(n);
            if (hero.getSuperheroName().toLowerCase().contains(searchName.toLowerCase()))
                findSuperheroList.add(hero);
        }
        return findSuperheroList;
    }

    public void deleteHero(int heroToDelete) {

        //Fjerner 1 fra bruger input for at matche arraylist index
        int deleteOnIndex = heroToDelete - 1;

        //Printer ud før der slettes så man stadig kan hente den slettede helts navn.
        System.out.println(heroDatabase.get(deleteOnIndex).getSuperheroName() + " has been deleted");

        heroDatabase.remove(deleteOnIndex);
    }

    public void deleteHero(String heroName) {

        for (SuperHero s : heroDatabase) {
            if (s.getSuperheroName().equals(heroName)) {
                heroDatabase.remove(s);
                break;
            }
        }
    }

    public void editHeroName(SuperHero newHero) {
        for (SuperHero s : heroDatabase) {
            if (s.getSuperheroName().equals(newHero.getSuperheroName())){
               int index =  heroDatabase.indexOf(s);
               heroDatabase.set(index, newHero);
            }
        }
    }

}