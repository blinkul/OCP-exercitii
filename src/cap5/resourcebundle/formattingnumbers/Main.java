package cap5.resourcebundle.formattingnumbers;

import java.text.NumberFormat;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        // *** Number formatting ***
        System.out.println("*** Number Formatting ***");

        int attendeesPerYear = 3_200_000;
        int attendeesPerMonth = attendeesPerYear / 12;

        //266,666 (2 sute de mii!!!)
        NumberFormat us = NumberFormat.getNumberInstance(Locale.US);
        System.out.println(us.format(attendeesPerMonth));

        //266.666
        NumberFormat de = NumberFormat.getNumberInstance(Locale.GERMANY);
        System.out.println(de.format(attendeesPerMonth));

        //266 666
        NumberFormat ca = NumberFormat.getNumberInstance(Locale.CANADA_FRENCH);
        System.out.println(ca.format(attendeesPerMonth));

        // *** Currency formatting ***
        System.out.println("*** Currency Formatting ***");

        double price = 48;

        // $48.00
        NumberFormat us_cur = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println(us_cur.format(price));

        // 48,00 €
        NumberFormat de_cur = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        System.out.println(de_cur.format(price));

        // 48,00 $
        NumberFormat ca_cur = NumberFormat.getCurrencyInstance(Locale.CANADA_FRENCH);
        System.out.println(ca_cur.format(price));

    }
}
