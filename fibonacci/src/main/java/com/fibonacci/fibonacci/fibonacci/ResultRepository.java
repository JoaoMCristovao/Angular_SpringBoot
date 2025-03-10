package com.fibonacci.fibonacci.fibonacci;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class ResultRepository {

    private List<Result> results = new ArrayList<>();

    List<Result> findAll(){
        return results;
    }

    Optional<Integer> findByIndex(int index){
        return results.stream()
        .filter(result -> result.input() == index)
        .findFirst()
        .map(Result::output);
    }

    void add(int index, int output){
        if(index < 0 || output < 0){
            return;
        }

        if(results.stream().anyMatch(result -> result.input() == index)){
            return;
        }

        results.add(new Result(index, output));
    }

    @PostConstruct
    private void init(){
        for(int i = 0; i < 3; i++){
            results.add(new Result(i, ResultCalculator.Calculate(i)));
        }
    }
}
