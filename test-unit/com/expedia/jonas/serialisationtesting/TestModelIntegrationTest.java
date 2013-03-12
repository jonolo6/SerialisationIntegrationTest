package com.expedia.jonas.serialisationtesting;

import org.testng.annotations.Test;

import java.io.*;

import static org.testng.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: jolofsson
 * Date: 12/03/2013
 * Time: 19:31
 * To change this template use File | Settings | File Templates.
 */
public class TestModelIntegrationTest {

    @Test
    public void testSerializationFormatHasNotChanged() throws IOException, ClassNotFoundException {

        //deserialize
        InputStream in = new FileInputStream("test-data/testModelExample.dat");
        ObjectInputStream ois = new ObjectInputStream(in);
        Object o = ois.readObject();
        TestModel context = (TestModel) o;

        // test the result
        assertEquals("blah2", context.getVariableValue());
    }

}
