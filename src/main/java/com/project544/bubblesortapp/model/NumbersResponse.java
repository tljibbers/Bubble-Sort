package com.project544.bubblesortapp.model;

import java.util.List;

public class NumbersResponse {
    private List<SortStep> steps;

    public NumbersResponse(List<SortStep> steps) {
        this.steps = steps;
    }

    public List<SortStep> getSteps() {
        return steps;
    }

    public void setSteps(List<SortStep> steps) {
        this.steps = steps;
    }
}
