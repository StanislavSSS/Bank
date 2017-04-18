package ru.kss.clients;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Pony on 05/04/2017.
 */
public class Phisical extends Client {
    private String name1, name2;
    private String liveCountry, liveCity;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public Phisical(String name, String name1, String name2, boolean resident, String liveCountry, String liveCity) {
        super(name, resident);
        this.name1 = name1;
        this.name2 = name2;
        this.liveCountry = liveCountry;
        this.liveCity = liveCity;
        logger.info("Phisical client " + name + " " + name1 + " " + name2 + "was added!");
    }



    public String getName1() {
        return name1;
    }

    public String getName2() {
        return name2;
    }

    public String getLiveCountry() {
        return liveCountry;
    }

    public String getLiveCity() {
        return liveCity;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public void setLiveCountry(String liveCountry, String liveCity) {
        this.liveCountry = liveCountry;
        this.liveCity = liveCity;
    }

    public void setLiveCity(String liveCity) {
        this.liveCity = liveCity;
    }
}