package com.project544.bubblesortapp.model;

import java.util.List;

public class SortStep {
    private List<Integer> state;
    private Integer index1;
    private Integer index2;
    private int pass;
    private String stepType;

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

    public void setState(List<Integer> state) {
        this.state = state;
    }

    public void setIndex1(Integer index1) {
        this.index1 = index1;
    }

    public void setIndex2(Integer index2) {
        this.index2 = index2;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    public void setStepType(String stepType) {
        this.stepType = stepType;
    }
}
