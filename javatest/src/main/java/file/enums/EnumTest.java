package file.enums;

/**
 * @Author qtq
 * @Created on 2019-11-17 15:50.
 */
public enum EnumTest {

    LEFT(0, "左"), RIGHT(1, "右"), UP(2, "上"), DOWN(3, "下");

    private String name;
    private int code;

    private EnumTest(int code, String name) {
        this.name = name;
        this.code = code;
    }


    public String getName() {
        return name;
    }


    public int getCode() {
        return code;
    }

}
