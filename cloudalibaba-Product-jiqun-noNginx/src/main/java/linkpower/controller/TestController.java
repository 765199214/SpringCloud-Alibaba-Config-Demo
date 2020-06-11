package linkpower.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${server.port}")
    private String port;

    @RequestMapping("/product/getProduct/{id}")
    public String getOrder(@PathVariable("id") String id) {
        return "this is product services,port:"+port+"\t id="+id;
    }
}
