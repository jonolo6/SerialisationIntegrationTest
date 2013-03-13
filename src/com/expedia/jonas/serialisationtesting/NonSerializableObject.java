package com.expedia.jonas.serialisationtesting;

/**
 * Created with IntelliJ IDEA.
 * User: jolofsson
 * Date: 12/03/2013
 * Time: 19:18
 * To change this template use File | Settings | File Templates.
 */
public class NonSerializableObject extends AbstractSerializbleObject implements ISubObject {

    public NonSerializableObject(String string) {
        super(string);
    }

}
