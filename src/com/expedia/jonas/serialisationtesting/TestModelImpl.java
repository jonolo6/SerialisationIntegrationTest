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

    public TestModelImpl() {
    }

    public TestModelImpl(ISubObject object) {
        this.objects = object;
    }

    public ISubObject getSubObject() {
        return objects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestModelImpl testModel = (TestModelImpl) o;

        if (objects != null ? !objects.equals(testModel.objects) : testModel.objects != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return objects != null ? objects.hashCode() : 0;
    }

    private synchronized void writeObject(java.io.ObjectOutputStream stream) throws java.io.IOException {
        stream.defaultWriteObject(  );
        stream.writeInt(elementData.length);
        for (int i=0; i<size; i++)
            stream.writeObject(elementData[i]);
    }
}
