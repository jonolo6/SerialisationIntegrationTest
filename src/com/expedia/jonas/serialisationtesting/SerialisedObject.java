package com.expedia.jonas.serialisationtesting;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: jolofsson
 * Date: 13/03/2013
 * Time: 09:57
 * To change this template use File | Settings | File Templates.
 */
public class SerialisedObject implements Serializable {

    private Object object;


    public SerialisedObject(Object object) {
        this.object = object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }
}

