package com.expedia.jonas.serialisationtesting;

/**
 * Created with IntelliJ IDEA.
 * User: jolofsson
 * Date: 12/03/2013
 * Time: 19:18
 * To change this template use File | Settings | File Templates.
 */
public class NonSerializableObject implements SubObject{

    private Object object;


    public NonSerializableObject(Object object) {
        this.object = object;
    }

    @Override
    public String getStringValue() {
        return object.toString();
    }
}
