package main.lesson_26.homework.task2;

public class IpAddress {
    public static void main(String[] args) {
        String ipAddress = "192.168.23.1";

        short[] ipArray = parseIdAddress(ipAddress);
        printIpAddressSeparate(ipArray);
        if (checkIpAddress(ipArray)) {
            System.out.println("Correct IP address");
        } else {
            System.out.println("Wrong IP address");
        }

    }

    private static short[] parseIdAddress(String ip) {
        String[] numbers = ip.split("\\.");

        short[] ipArray = new short[4];
        for (int i = 0; i < numbers.length; i++) {
            ipArray[i] = Short.parseShort(numbers[i]);
        }
        return ipArray;
    }

    public static boolean checkIpAddress(short[] ip) {
        for (int i = 0; i < ip.length; i++) {
            if (!(ip[i] >= 0 && ip[i] <= 255)) {
                return false;
            }
        }
        return true;
    }

    public static void printIpAddressSeparate(short[] ipAddress) {
        for (int i = 0; i < ipAddress.length; i++) {
            System.out.println("Number " + (i + 1 + ": ") + ipAddress[i]);
        }
    }
}
