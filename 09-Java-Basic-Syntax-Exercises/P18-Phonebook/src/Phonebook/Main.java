package Phonebook;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] command = scanner
                .nextLine()
                .split(" ");

        LinkedHashMap<String, String> phonebook = new LinkedHashMap<>();

        while (!command[0].equals("END")) {

            String name = command[1];

            if (command[0].equals("A")) {

                String number = command[2];
                phonebook.put(name, number);

            } else if (command[0].equals("S")) {

                if (phonebook.containsKey(name)) {

                    for (String key : phonebook.keySet()) {

                        if (key.equals(name)) {

                            System.out.println(key + " -> " + phonebook.get(key));
                            break;
                        }
                    }
                } else {

                    System.out.println("Contact " + name + " does not exist.");
                }
            }

            command = scanner
                    .nextLine()
                    .split(" ");
        }
    }
}