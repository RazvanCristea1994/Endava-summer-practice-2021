package org.fantasticcoffee.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        //              Web App
        SpringApplication.run(App.class, args);

        /*              Console App
        ApplicationContext appConfig = new AnnotationConfigApplicationContext("org.fantasticcoffee.shop");
        ConsoleController consoleController = appConfig.getBean(ConsoleController.class);

        consoleController.runApp();
        */
    }
}