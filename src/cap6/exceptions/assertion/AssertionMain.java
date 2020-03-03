package cap6.exceptions.assertion;

public class AssertionMain {


    //assertions must be enabled: in intellij go to Edit Configuration and add to VM Options = -ea
    public static void main(String[] args) {

//        assert 1==2;

        System.out.println("GELL");

        assert 1==3: "Ceva nu este in regula";

    }

}
