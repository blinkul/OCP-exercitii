package cap5.resourcebundle.usingclass;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main {

    public static void main(String[] args) {
        //class name specifies the language and the country
        ResourceBundle rb = ResourceBundle.getBundle("cap5.resourcebundle.usingclass.Tax", Locale.US);
        System.out.println(rb.getObject("tax"));
    }


}
