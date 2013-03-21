package com.expedia.jonas.serialisationtesting;

/**
 * Created with IntelliJ IDEA.
 * User: jolofsson
 * Date: 12/03/2013
 * Time: 19:18
 * To change this template use File | Settings | File Templates.
 */
public class NonSerializableSubObject extends AbstractSerializableSubObject implements ISubObject {

    public NonSerializableSubObject(String string) {
        super(string);
    }

}
