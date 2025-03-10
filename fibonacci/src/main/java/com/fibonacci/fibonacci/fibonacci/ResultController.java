package com.fibonacci.fibonacci.fibonacci;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        return resultRepository.findByIndex(index);
        //return ResultCalculator.Calculate(index);
    }


}
