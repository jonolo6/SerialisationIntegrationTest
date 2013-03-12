package com.expedia.jonas.serialisationtesting;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: jolofsson
 * Date: 12/03/2013
 * Time: 18:45
 * To change this template use File | Settings | File Templates.
 */
public class TestModel implements Serializable {

    private static final long serialVersionUID = 2765884437957874564L;

    private Object object;
    private Object object2;

// If you uncomment the line below the TestModelTest's unit test that checks that the roundtrip serialisation works as the object below doesn't implement the Serialisable interface.
//    private NonSerialisableObject nonSerialisableObject = new NonSerialisableObject();


    public TestModel(Object object) {
        this.object = object;
    }


    public void setVariableValue(Object newObject) {
        object = newObject;
    }

    public Object getVariableValue() {
        return object;
    }
}
