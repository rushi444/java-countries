package com.project.countries;

public class Country {
    private static int maxID = 0;
    private int id;
    private String name;
    private int population;
    private int landMassSize;
    private int medianAge;

    public Country(String name, int population, int landMassSize, int medianAge) {
        maxID++;
        this.id = maxID;
        this.name = name;
        this.population = population;
        this.landMassSize = landMassSize;
        this.medianAge = medianAge;
    }

    public Country(Country toClone) {
        this.id = getId();
        this.name = toClone.getName();
        this.population = toClone.getPopulation();
        this.landMassSize = toClone.getLandMassSize();
        this.medianAge = toClone.getMedianAge();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getLandMassSize() {
        return landMassSize;
    }

    public void setLandMassSize(int landMassSize) {
        this.landMassSize = landMassSize;
    }

    public int getMedianAge() {
        return medianAge;
    }

    public void setMedianAge(int medianAge) {
        this.medianAge = medianAge;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", population=" + population +
                ", landMassSize=" + landMassSize +
                ", medianAge=" + medianAge +
                '}';
    }
}
