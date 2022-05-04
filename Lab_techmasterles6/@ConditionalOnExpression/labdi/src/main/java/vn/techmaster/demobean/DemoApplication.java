package vn.techmaster.demobean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    @Autowired
    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String[] beans = applicationContext.getBeanDefinitionNames();
        Arrays.sort(beans);
        boolean contains = Arrays.stream(beans).anyMatch("module"::equalsIgnoreCase);
        if (contains) {
            System.out.println("Module loaded");
        } else {
            System.out.println("Module not loaded");
        }
    }
}
