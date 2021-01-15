import java.net.URL;
import java.net.URLClassLoader;

public class myClassLoader1 extends URLClassLoader {

    public myClassLoader1(URL[] urls) {
        super(urls);
    }
}
