package com.project544.bubblesortapp.controller;

import com.project544.bubblesortapp.model.NumbersRequest;
import com.project544.bubblesortapp.service.BubbleSortService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * API Endpoint class to access
 */

@RestController
@RequestMapping("/api/bubblesort")
public class BubbleSortController {
    private final BubbleSortService bubbleSortService;

    public BubbleSortController(BubbleSortService bubbleSortService) {
        this.bubbleSortService = bubbleSortService;
    }

    @PostMapping("/sort")
    public ResponseEntity<?> sortArray(@Valid @RequestBody NumbersRequest request){
        return ResponseEntity.ok(bubbleSortService.sort(request.getNumbers()));
    }

}
