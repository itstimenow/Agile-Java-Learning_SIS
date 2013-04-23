package languageTest;

import junit.framework.TestCase;

public class SuperClassTest extends TestCase {
    public void testConstructorCalls() {
        SuperClass.constructorWasCalled = false;
        SubClass subClass = new SubClass("param");
        assertTrue(SuperClass.constructorWasCalled);
    }
}

class SuperClass {
    static boolean constructorWasCalled = false;
    
    SuperClass(String param) {
        constructorWasCalled = true;
    }
}

class SubClass extends SuperClass {
    SubClass(String param) {
        super(param);
    }
}
