package PhonebookUpgrade;

import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] command = scanner
                .nextLine()
                .split(" ");

        TreeMap<String, String> phonebook = new TreeMap<>();

        while (!command[0].equals("END")) {

            if (command[0].equals("A")) {

                String name = command[1];
                String number = command[2];
                phonebook.put(name, number);

            } else if (command[0].equals("S")) {

                String name = command[1];

                if (phonebook.containsKey(name)) {

                    for (String key : phonebook.keySet()) {

                        if (key.equals(name)) {

                            System.out.println(key + " -> " + phonebook.get(key));
                            break;
                        }
                    }
                }
                else {

                    System.out.println("Contact " + name + " does not exist.");
                }
            } else if (command[0].equals("ListAll")) {

                for (String key : phonebook.keySet()) {

                    System.out.println(key + " -> " + phonebook.get(key));
                }
            }

            command = scanner
                    .nextLine()
                    .split(" ");
        }
    }
}