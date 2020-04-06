package chapter5.propertyfile;

import java.text.MessageFormat;
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

    private static void printWithResourceBundle(Locale locale) {
        ResourceBundle rb = ResourceBundle.getBundle("chapter5/propertyfile/Zoo", locale);
        String name = "Ciprian";
        System.out.println(MessageFormat.format(rb.getString("hello"), name));
        System.out.println(rb.getString("open"));
    }

    public static void printWithProperties(Locale locale) {
        String name = "Ciprian";
        ResourceBundle rb = ResourceBundle.getBundle("chapter5/propertyfile/Zoo", locale);

        //load properties to Properties
        Properties properties = new Properties();
        rb.keySet().stream().forEach(k -> properties.put(k, rb.getString(k)));

        //output translations
        System.out.println(MessageFormat.format(properties.getProperty("hello"), name));
        System.out.println(properties.getProperty("open"));
        //method to call with a default value
        //ResourceBundle does not have a default value for missing keys.
        System.out.println(properties.getProperty("notOpen", "Value is not defined!"));
    }
}
