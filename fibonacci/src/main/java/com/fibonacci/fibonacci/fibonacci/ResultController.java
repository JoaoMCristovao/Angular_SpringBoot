package com.fibonacci.fibonacci.fibonacci;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/api/fibonacci")	
public class ResultController {

    private final ResultRepository resultRepository;

    public ResultController(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @GetMapping("")
    List<Result> findAll() {
        return resultRepository.findAll();
    }

    @GetMapping("/{index}")
    int findResult(@PathVariable int index) {
        if (index != (int)index) {
            System.err.println("Invalid index");
            return -1;
        }

        Optional<Integer> result = resultRepository.findByIndex(index);
        
        if(result.isPresent()){
            return result.get();
        }

        int calculatedValue = ResultCalculator.Calculate(index);

        resultRepository.add(index, calculatedValue);

        return calculatedValue;
    }



}
