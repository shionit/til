package com.shionit.tddbc;

/**
 * Created by @shionit on 2021/02/22.
 */
public class FizzBuzz {

    public String convert(int num) {
        if (num % 15 == 0) {
            return "FizzBuzz";
        } else if (num % 3 == 0) {
            return "Fizz";
        } else if (num % 5 == 0) {
            return "Buzz";
        }
        return String.valueOf(num);
    }
}
