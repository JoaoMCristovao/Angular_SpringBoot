package com.fibonacci.fibonacci.fibonacci;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class ResultRepository {

    private List<Result> results = new ArrayList<>();

    List<Result> findAll(){
        return results;
    }

    int findByIndex(int index){
        int toReturn = results.stream()
        .filter(result -> result.input() == index)
        .findFirst()
        .map(Result::output)
        .orElse(-1);
        
        if(toReturn == -1){
            toReturn = ResultCalculator.Calculate(index);
            results.add(new Result(index, toReturn));
        }

        return toReturn; 
    }

    @PostConstruct
    private void init(){
        for(int i = 0; i < 3; i++){
            results.add(new Result(i, ResultCalculator.Calculate(i)));
        }
    }
}
