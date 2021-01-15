import java.net.MalformedURLException;
import java.net.URL;

public class ClassLoadingTest {

    myClassLoader1 mycl1;
    myClassLoader2 mycl2;

    public static void main(String[] args) {
        new ClassLoadingTest().test();
    }

    private void test() {
        try {
            mycl1 = new myClassLoader1(new URL[]{
                    new URL("file://C:/CL_Article/TestCL/A/")});
            mycl2 = new myClassLoader2(new URL[]{
                    new URL("file://C:/CL_Article/TestCL/B/")}, mycl1);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("mycl1 is about to load class PrintA");
            mycl1.loadClass("PrintString");
            System.out.println("mycl1 loaded PrintA");

            System.out.println("mycl2 is about to load class PrintB");
            mycl2.loadClass("PrintString");
            System.out.println("mycl2 loaded PrintB");

            Print obj = (Print) mycl2.loadClass("PrintString").newInstance();
            obj.print();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
