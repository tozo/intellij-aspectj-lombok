package ie.test;

import ie.test.domain.User;
import ie.test.service.FunctionInitiator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @Autowired
    private TaskScheduler taskScheduler;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @ResponseBody
    @GetMapping("/init")
    public String initiateThread() {
        User user = new User();
        user.setName("name");
        user.setPassword("passs");

        FunctionInitiator functionInitiator = new FunctionInitiator(user);

        taskScheduler.schedule(functionInitiator, new CronTrigger("*/10 * * * * *"));
        return "OK";
    }
}
