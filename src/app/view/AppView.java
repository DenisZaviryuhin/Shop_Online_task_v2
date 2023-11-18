package app.view;

import app.utility.Constants;

import java.util.Scanner;
import java.util.Locale;


public class AppView {
    private final Scanner scanner = new Scanner(System.in);

    public String[] getData() {
        scanner.useLocale(Locale.ENGLISH);
        System.out.print("Enter client's name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter client's phone number: ");
        String phone = scanner.nextLine().trim();
        System.out.print("Enter quantity , pcs.: ");
        String quantity = scanner.nextLine().trim();
        System.out.print("Enter product price , " + Constants.CURRENCY + ": ");
        String price = scanner.nextLine().trim();
        return new String[]{name, phone, quantity, price};
    }

    public String getDeliveryAddress() {
        System.out.print("Enter delivery address: ");
        return scanner.nextLine().trim();
    }

    public void getOutput(String output) {
        System.out.println(output);
    }

}
