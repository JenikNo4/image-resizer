package cz.simek.codelib.imageresizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ImageResizer {

    public static void main(String[] args) {
        SpringApplication.run(ImageResizer.class, args);
    }
}
