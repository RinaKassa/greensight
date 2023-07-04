@SuppressWarnings("all")
class MyObject {
}



@SuppressWarnings("all")
class Wow {

    MyObject myOb = new MyObject(); // Noncompliant
    Class c = myOb.getClass();

    Class d = MyObject.class; // compliant
}


