package kr.pe.jonghak.demo.hello.api;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class HelloController {

    @GetMapping("/hello")
    public ResponseEntity<String> hello(@RequestParam("name") String name) {
        return ResponseEntity.ok(String.format("Hello, %s", name));
    }

}
