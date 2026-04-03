package kr.pe.jonghak.demo.hello.api.service;

import org.springframework.stereotype.Service;

import kr.pe.jonghak.demo.hello.api.exception.DesignedException;

@Service
public class AwsomeService {
    public String notAwsome() throws DesignedException {
        throw new DesignedException("This is desiged!");
    }

    public String reallyBad() {
        throw new RuntimeException("This is unpredictable!");
    }
}
