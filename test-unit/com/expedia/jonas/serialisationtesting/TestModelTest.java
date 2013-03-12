package com.expedia.jonas.serialisationtesting;

import org.testng.annotations.Test;

import java.io.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: jolofsson
 * Date: 12/03/2013
 * Time: 19:02
 * To change this template use File | Settings | File Templates.
 */
public class TestModelTest {

    @Test
    public void testCanSerialise() throws IOException {
        TestModel testModel = new TestModel("blah");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(out);

        oos.writeObject(testModel);
        oos.close();

        assertTrue(out.toByteArray().length > 0);
    }

    //This test will fail if the TestModel hasn't implemented the Serializable interface.
    //This test will fail if the TestModel contains an object that is not Serialisable (like a java.net.Socket object for instance).
    @Test
    public void testRoundTripSerialization() throws IOException, ClassNotFoundException {

        // construct test object
        TestModel testModel = new TestModel("blah");
        testModel.setVariableValue("s");

        // serialize
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(out);

        oos.writeObject(testModel);
        oos.close();

        //deserialize
        byte[] pickled = out.toByteArray();
        InputStream in = new ByteArrayInputStream(pickled);
        ObjectInputStream ois = new ObjectInputStream(in);
        Object o = ois.readObject();
        TestModel copy = (TestModel) o;

        // test the result
        assertEquals("s", copy.getVariableValue());

    }
}
