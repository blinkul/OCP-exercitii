package cap5.localization;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class Zoo {

    public static void main(String[] args) {
        Locale us = new Locale("en", "US");
        Locale france = new Locale("fr", "FR");

//        printWithResourceBundle(us);
//        System.out.println();
//        printWithResourceBundle(france);

        printWithProperties(us);
        System.out.println();
        printWithProperties(france);

    }

    public static void printWithResourceBundle(Locale locale) {
        ResourceBundle rb = ResourceBundle.getBundle("Zoo", locale);
        System.out.println(rb.getString("hello"));
        System.out.println(rb.getString("open"));
    }

    public static void printWithProperties(Locale locale) {
        ResourceBundle rb = ResourceBundle.getBundle("cap5/localization/Zoo", locale);

        //load properties to Properties
        Properties properties = new Properties();
        rb.keySet().stream().forEach(k -> properties.put(k, rb.getString(k)));

        //output translations
        System.out.println(properties.getProperty("hello"));
        System.out.println(properties.getProperty("open"));
        //method to call with a default value
        //ResourceBundle does not have a default value for missing keys.
        System.out.println(properties.getProperty("notOpen", "Value is not defined!"));

    }
}
