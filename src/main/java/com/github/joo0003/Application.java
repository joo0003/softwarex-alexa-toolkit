package com.github.joo0003;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
    // change the name of the package to reflect your project's folder tree structure
    scanBasePackages = "com.github.joo0003"
)
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
