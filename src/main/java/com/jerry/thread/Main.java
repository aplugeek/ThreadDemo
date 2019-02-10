package com.jerry.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Date: 17/9/4 14:43
 *
 * @author jerry.R
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputString = scanner.nextLine();
        String[] input = inputString.split(" ");
        int a = Integer.parseInt(input[0], 7);
        int b = Integer.parseInt(input[1], 7);
        int sum = a + b;
        System.out.println(a+"|"+b);
        String result = transferToResult(sum, 7);
        System.out.println(result);
    }

    private static String transferToResult(int sum, int i) {
        List<Integer> result = new ArrayList<>();
        if(sum ==0){
            return  "0";
        }
        while (sum != 0) {
            result.add(sum % i);
            sum = sum / i;
        }

        Collections.reverse(result);
        StringBuffer resultString = new StringBuffer();
        result.forEach((r) -> resultString.append(r.toString()));
        return  resultString.toString();
    }

}
