package ie.test;

import ie.test.domain.User;
import ie.test.service.FunctionInitiator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        User user = new User();
        user.setName("name");
        user.setPassword("passs");

        FunctionInitiator functionInitiator = new FunctionInitiator(user);
        functionInitiator.run();
        return "index";
    }
}
