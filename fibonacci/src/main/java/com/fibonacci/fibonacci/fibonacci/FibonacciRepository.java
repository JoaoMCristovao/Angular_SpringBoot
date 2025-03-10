package com.fibonacci.fibonacci.fibonacci;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import ch.qos.logback.classic.Logger;
import jakarta.annotation.PostConstruct;

@Repository
public class FibonacciRepository {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(FibonacciRepository.class);
    private final JdbcClient jdbcClient;

    public FibonacciRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Fibonacci> findAll() {
        return jdbcClient.sql("select * from fibonaccis")
                .query(Fibonacci.class)
                .list();

    }

    public Optional<Fibonacci> findByInput(int input) {
        return jdbcClient.sql("SELECT input, output FROM Fibonaccis WHERE input = :input")
                .param("input", input)
                .query(Fibonacci.class)
                .optional();
    }

    public void create(Optional<Fibonacci> fibonacci) {
        if (fibonacci.isPresent()) {
            jdbcClient.sql("INSERT INTO Fibonaccis (input, output) VALUES (:input, :output)")
                    .param("input", fibonacci.get().input())
                    .param("output", fibonacci.get().output())
                    .update();
        }
    }

}
