package com.project544.bubblesortapp;

import com.project544.bubblesortapp.model.NumbersResponse;
import com.project544.bubblesortapp.service.BubbleSortService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BubbleSortServiceTest {
    private final BubbleSortService service=new BubbleSortService();
    @Test
    void testSort() {
        List<Integer> input = List.of(9, 8, 3, 2);
        NumbersResponse response = service.sort(input);

        List<Integer> finalState = response.getSteps()
                .getLast()
                .getState();
        assertEquals(List.of(2,3,8,9), finalState);
    }

}
