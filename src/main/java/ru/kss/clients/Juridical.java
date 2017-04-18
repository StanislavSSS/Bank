package ru.kss.clients;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Pony on 05/04/2017.
 */
public class Juridical extends Client {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private String typeOfBusiness;

    public Juridical(String name, boolean resident, String typeOfBusiness) {
        super(name, resident);
        this.typeOfBusiness = typeOfBusiness;
        logger.info("Juridical client " + name + "was added!");
    }



}
