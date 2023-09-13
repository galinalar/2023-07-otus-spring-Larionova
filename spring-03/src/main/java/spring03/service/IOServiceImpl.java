package spring03.service;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class IOServiceImpl implements IOService {

    private final Scanner input;

    public IOServiceImpl() {
        input = new Scanner(System.in);
    }

    @Override
    public String readString() {
        return input.nextLine();
    }
}
