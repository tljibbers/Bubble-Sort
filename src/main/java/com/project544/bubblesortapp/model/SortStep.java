package com.project544.bubblesortapp.model;

import java.util.List;

public class SortStep {
    private final List<Integer> state;
    private final Integer index1;
    private final Integer index2;
    private final int pass;
    private final String stepType;

    public SortStep(List<Integer> state, Integer index1, Integer index2, int pass, String stepType) {
        this.state = state;
        this.index1 = index1;
        this.index2 = index2;
        this.pass = pass;
        this.stepType = stepType;
    }

    public List<Integer> getState() {
        return state;
    }

    public Integer getIndex1() {
        return index1;
    }

    public Integer getIndex2() {
        return index2;
    }

    public int getPass() {
        return pass;
    }

    public String getStepType() {
        return stepType;
    }
}
