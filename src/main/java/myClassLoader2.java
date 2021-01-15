import java.net.URL;
import java.net.URLClassLoader;

public class myClassLoader2 extends URLClassLoader {
    public myClassLoader2(URL[] urls, ClassLoader parent) {
        super(urls, parent);

    }
}
