package com.tudresden.jasonsample;
import jason.environment.Environment;
import jason.asSyntax.*;

import java.util.logging.Logger;

public class TestEnvironment extends Environment{
    private Logger logger = Logger.getLogger("testenv.mas2j"+TestEnvironment.class.getName());

    @Override
    public void init(String[] args) {

    }

    @Override
    public boolean executeAction(String agName, Structure action) {
        if(action.getFunctor().equals("burn")) {
            addPercept(Literal.parseLiteral("fire"));
            return true;
        }
        else {
            logger.info("executing: " + action);
            return false;
        }
    }

    @Override
    public void stop(){
        super.stop();
    }
}
