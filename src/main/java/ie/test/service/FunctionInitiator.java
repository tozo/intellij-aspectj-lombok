package ie.test.service;

import ie.test.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FunctionInitiator implements Runnable, CustomInterface {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private User user;

    public FunctionInitiator(User user) {
        this.user = user;
    }

    @Override
    public void run() {
        logger.info("We are in the run function");
        logger.info("user: " + user);
    }
}
