package com.expedia.jonas.serialisationtesting;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: jolofsson
 * Date: 12/03/2013
 * Time: 18:45
 * To change this template use File | Settings | File Templates.
 */
public class TestModelImpl implements Serializable, ITestModel {

    private static final long serialVersionUID = 2765884437957874564L;

    private ISubObject objects;

    public TestModelImpl(ISubObject object) {
        this.objects = object;
    }

    public void setObjects(ISubObject newObject) {
        this.objects = newObject;
    }

    public ISubObject getSubObjectAsANewMethod() {
        return objects;
    }
}
