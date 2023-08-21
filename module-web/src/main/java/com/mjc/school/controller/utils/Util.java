package com.mjc.school.controller.utils;

import com.mjc.school.service.exeptions.ErrorCodes;
import com.mjc.school.service.exeptions.InvaliDataException;

import java.util.Scanner;

public class Util {
    private Util() {
    }

    public static long getUserInput(Scanner scanner) throws InvaliDataException {
        try {
            long number = scanner.nextLong();
            scanner.nextLine();
            return number;
        } catch (Exception e) {
            scanner.nextLine();
            throw new InvaliDataException(String.format(ErrorCodes.VALIDATE_INT_VALUE.getMessage(), "args"));
        }
    }
}


