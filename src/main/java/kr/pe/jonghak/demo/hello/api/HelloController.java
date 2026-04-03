package kr.pe.jonghak.demo.hello.api;

import org.springframework.web.bind.annotation.RestController;

import kr.pe.jonghak.demo.hello.api.exception.DesignedException;
import kr.pe.jonghak.demo.hello.api.service.AwsomeService;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.stream.Stream;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@Slf4j
public class HelloController {
    private AwsomeService awsomeService;

    public HelloController(AwsomeService awsomeService) {
        this.awsomeService = awsomeService;
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello(@RequestParam("name") String name) {
        return ResponseEntity.ok(String.format("Hello, %s", name));
    }

    @GetMapping("/ex/checked")
    public ResponseEntity<String> checkedException() {
        log.info("Throw checked exception!");
        try {
            awsomeService.notAwsome();
        } catch (DesignedException e) {
            log.info(e.getMessage());
            // log.info(Arrays.toString(e.getStackTrace()));
            log.info(Arrays.toString(e.getStackTrace()).replaceAll(",", "\n"));
            log.info("Fixed!!");
        }
        return ResponseEntity.ok("Can you see this!");
    }

    @GetMapping("/ex/runtime")
    public ResponseEntity<String> runtimeException() {
        String awsomeThing = awsomeService.reallyBad();
        return ResponseEntity.ok(String.format("You'll never see this %s", awsomeThing));
    }
}
