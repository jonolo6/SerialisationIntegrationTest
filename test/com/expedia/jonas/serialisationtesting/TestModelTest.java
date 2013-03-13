package com.expedia.jonas.serialisationtesting;

import org.testng.annotations.Test;

import java.io.*;

import static org.testng.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: jolofsson
 * Date: 12/03/2013
 * Time: 19:02
 * To change this template use File | Settings | File Templates.
 */
public class TestModelTest {


    //This test will fail if the TestModel hasn't implemented the Serializable interface.
    @Test
    public void testCanSerialise() throws IOException {
        ITestModel testModel = new TestModelImpl(new SerializableObject("testSerializableObject"));

        ByteArrayOutputStream out = serialise(testModel);
        assertTrue(out.toByteArray().length > 0);
    }

    private ByteArrayOutputStream serialise(ITestModel testModel) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(testModel);
        oos.close();
        return out;
    }


}
