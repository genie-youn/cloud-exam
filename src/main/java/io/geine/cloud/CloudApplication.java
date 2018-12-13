package io.geine.cloud;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.time.LocalDateTime;

@SpringBootApplication
@Slf4j
public class CloudApplication {

  public static void main(String[] args) {
    SpringApplication.run(CloudApplication.class, args);
  }

  @PostConstruct
  public void publishLog() {

    final String containerName = "container-" + RandomStringUtils.randomAlphabetic(6);

    Flux.interval(Duration.ofSeconds(1))
        .subscribe(i -> log.info("[{}] now is : {}", containerName, LocalDateTime.now()));
  }
}

