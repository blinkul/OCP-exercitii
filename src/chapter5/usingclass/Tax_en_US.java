package chapter5.usingclass;

import java.util.ListResourceBundle;

public class Tax_en_US extends ListResourceBundle {

    /**
     * the advantages of using a class:
     * 1. You can use a value type that is not string
     * 2. You can change the value at runtime
     */

    @Override
    protected Object[][] getContents() {
        return new Object[][]{
                {"tax", new UsTaxCode()}
        };
    }
}

class UsTaxCode {

    @Override
    public String toString() {
        return "This is US tax!";
    }
}