# ClassLoaderTest

해당 레포지토리는 java classloader를 테스트한 것


classloader 1
     |
classloader 2

와 같이 상속관계이고 cl1와 cl2에 같은 패키지명과 같은 클래스이름을 가진 클래스 PrintString을 로딩한다
그런데 PrintString 클래스는 패키지명과 클래스 이름만 동일하지 다른 내용물을 가짐
이렇게 클래스로딩이 이루어지면 클래스로딩은 부모를 먼저 찾아서 클래스로딩하기 때문에 cl1의 클래스를 로딩하게 되고 그 결과를 


file://C:/CL_Article/TestCL/A/ 에 위치한 PrintString
~~~
public class PrintString implements Print{

    @Override
    public void print() {
        System.out.println("AAAAAAAAA");
    }
}
~~~

file://C:/CL_Article/TestCL/B/ 에 위치한 PrintString
~~~
public class PrintString implements Print{

    @Override
    public void print() {
        System.out.println("BBBBBBBBBB");
    }
}
~~~

최종결과는 아래와 같이 cl1의 클래스로딩 결과를 보여줌
~~~
mycl1 is about to load class PrintA
mycl1 loaded PrintA
mycl2 is about to load class PrintB
mycl2 loaded PrintB

결과 : AAAAAAAAAAAAAA
~~~
