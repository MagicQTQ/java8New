package file.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.Test;

public class UserTest {

	@Test
	public void test1() {
		User u = new User();
		u.setId(1);
		u.setName("zhangsan");
		System.out.println(u);
	}
	
	@Test
	public void test2() {
		String objstr ="reflect.User";
		try {
			Class clz =Class.forName(objstr);
			User user = (User) clz.newInstance();
			
			user.setId(3);
			user.setName("LiSi");
			System.out.println(user);
			
			//无参数的方法  user.show();
			String showMetnod = "show";
				Method method =clz.getMethod(showMetnod);
				method.invoke(user);
			
			//有参数的方法  user.say("shenmegui");
			String sayMethod ="say";
				Method method2 =clz.getMethod(sayMethod, String.class);
				method2.invoke(user, "shenmegui");
			
			//静态的有参数构造函数   类名clz.nihao("haha","world");
			String nihaoMethod ="nihao";
				Method method3 =  clz.getMethod(nihaoMethod, String.class,String.class);
				method3.invoke(clz, "haha","world");
				
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();	
			}catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
	
}
