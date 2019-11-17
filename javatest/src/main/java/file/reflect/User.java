package file.reflect;

public class User {

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + "]";
    }

    public User() {
    }

    public User(Integer id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    //无参数方法
    public void show() {
        System.out.println("无参数的方法。ID号：" + id + "姓名：" + name);
    }

    //有参数方法
    public void say(String aa) {
        System.out.println("大家好，我是有参数方法:" + aa);
    }

    public static void nihao(String a, String b) {

        System.out.println("静态有参数的方法。你的参数1是  ：" + a + "，你的参数2是：" + b);
    }
}
