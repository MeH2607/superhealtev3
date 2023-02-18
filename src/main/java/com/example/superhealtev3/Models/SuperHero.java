package com.example.superhealtev3.Models;

public class SuperHero{


    private String superheroName;
    private String superheroPower;
    private int creationYear;


    public SuperHero(String superheroName, String superheroPower, int creationYear) {

        this.superheroName = superheroName;
        this.superheroPower = superheroPower;

        this.creationYear = creationYear;
    }



    public String getSuperheroName() {
        return superheroName;
    }

    public void setSuperheroName(String superheroName) {
        this.superheroName = superheroName;
    }

    public String getSuperheroPower() {
        return superheroPower;
    }

    public void setSuperheroPower(String superheroPower) {
        this.superheroPower = superheroPower;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }




    public String PrintSuperHeroName() {
        String s;
        if (superheroName == null) {
            return "* Har ikke superheltenavn *";
        } else {
            return superheroName;
        }
    }


    @Override
    public String toString() {
        return String.format("│ %-15s │ %-20s │ %-13d ┃", superheroName, superheroPower, creationYear);
        // "[" + "Civil navn: " +  name  + ", " + "Superheltenavn: " + superheroName + ", " + "Superheltekraft: " + superheroPower + ", " + "Er menneske: " + human + ", " + "Oprindelses år: " + creationYear + "] ";
    }

}
