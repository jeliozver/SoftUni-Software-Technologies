package URLParser;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String url = scanner.nextLine();

        String protocol = "";
        String server = "";
        String resource = "";

        int protocolIndex = url.indexOf("://");

        if (protocolIndex != -1) {
            protocol = url.substring(0, protocolIndex);
            String toRemove = url.substring(0, protocolIndex + 3);
            url = url.replaceAll(toRemove, "");
        }

        int resourceIndex = url.indexOf('/');
        if (resourceIndex == -1) {
            server = url;
        } else {
            server = url.substring(0, resourceIndex);
            resource = url.substring(resourceIndex + 1, url.length());
        }

        System.out.println("[protocol] = " + "\"" + protocol + "\"");
        System.out.println("[server] = " + "\"" + server + "\"");
        System.out.println("[resource] = " + "\"" + resource + "\"");
    }
}