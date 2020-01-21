package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class EnvController {
    String port;
    String memoryLimit;
    String cfInstanceIndex;
    String cfInstanceAddr;

    public EnvController(@Value("${PORT:80}") String port, @Value("${MEMORY_LIMIT:1G}") String memoryLimit, @Value("${CF_INSTANCE_INDEX:1}") String cfInstanceIndex, @Value("${CF_INSTANCE_ADDR:123.Winter.Street}") String cfInstanceAddr) {

        this.port = port;
        this.memoryLimit = memoryLimit;
        this.cfInstanceIndex = cfInstanceIndex;
        this.cfInstanceAddr = cfInstanceAddr;



    }


    @GetMapping("/env")
    public Map<String, String> getEnv() {

        Map<String, String> env = Map.of(
                "PORT", port,
                "MEMORY_LIMIT", memoryLimit,
                "CF_INSTANCE_INDEX", cfInstanceIndex,
                "CF_INSTANCE_ADDR", cfInstanceAddr

        );


        return env;
    }
}
