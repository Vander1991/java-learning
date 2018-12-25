package szu.vander.generic.question;

//: generics/NeedCasting.java
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;


public class NeedCasting {
  @SuppressWarnings("unchecked")
  public void f(String[] args) throws Exception {
    ObjectInputStream in = new ObjectInputStream(new FileInputStream(args[0]));
    // 这里你会被强制要求转型，但是编译的时候又被告知不应该转型
    List<Widget> shapes = (List<Widget>)in.readObject();
  }
}

class Widget {
	
}

