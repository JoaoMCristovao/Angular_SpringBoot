package com.fibonacci.fibonacci.fibonacci;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/api/fibonacci")	
public class FibonacciController {

    private final FibonacciRepository fibonacciRepository;

    public FibonacciController(FibonacciRepository fibonacciRepository) {
        this.fibonacciRepository = fibonacciRepository;
    }

    @GetMapping("")
    List<Fibonacci> findAll() {
        System.out.println("find all");
        return fibonacciRepository.findAll();
    }


    @GetMapping("/{input}")
    Optional<Fibonacci> findResult(@PathVariable int input) {
        if (input != (int)input) {
            System.err.println("Invalid index");
            return null;
        }

        Optional<Fibonacci> fibonacciOptional = fibonacciRepository.findByInput(input);
        
        if(fibonacciOptional.isPresent()){
            return fibonacciOptional;
        }

        int calculatedValue = FibonacciCalculator.Calculate(input);

        Optional<Fibonacci> fibonacci = Optional.ofNullable(new Fibonacci(input, calculatedValue));

        fibonacciRepository.create(fibonacci);

        return fibonacci;
    }



}
