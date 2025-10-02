package com.project544.bubblesortapp.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

/**
 * request model to represent user input data
 */
public class NumbersRequest {
    @NotEmpty(message = "Numbers cannot be null or empty")
    @Size(min = 3,max = 8, message = "Array size must be between 3 and 8")
    private List<
            @Min(value = 0, message = "Numbers must be >=0")
            @Max(value = 9, message = "Numbers must be <=9") Integer> numbers;
    private String command;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

}
