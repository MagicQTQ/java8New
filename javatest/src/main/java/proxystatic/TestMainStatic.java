package proxystatic;

/**
 * @Author qtq
 * @Created on 2019-09-01 12:57.
 */
public class TestMainStatic {

    public static void main(String[] args) {

        AaFactory aa = new AaFactory();
        Lison lison = new Lison(aa);
        lison.saleManTools(4);
    }
}
