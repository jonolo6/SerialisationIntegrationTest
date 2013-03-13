package com.expedia.jonas.serialisationtesting;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: jolofsson
 * Date: 13/03/2013
 * Time: 17:14
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractSerializbleObject implements Serializable, ISubObject {
    protected String object;

    public AbstractSerializbleObject(String object) {
        this.object = object;
    }

    @Override
    public String getStringValue() {
        return object;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SerializableObject)) return false;

        SerializableObject that = (SerializableObject) o;

        if (object != null ? !object.equals(that.object) : that.object != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return object != null ? object.hashCode() : 0;
    }
}
