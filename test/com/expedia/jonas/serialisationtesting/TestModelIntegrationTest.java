package com.expedia.jonas.serialisationtesting;

import org.testng.annotations.Test;

import java.io.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: jolofsson
 * Date: 12/03/2013
 * Time: 19:31
 * To change this template use File | Settings | File Templates.
 */
public class TestModelIntegrationTest {

    //This test will fail if the TestModel contains a sub-object that is not Serialisable (like a java.net.Socket object for instance).
    @Test
    public void testSerializationFormatHasNotChanged() throws IOException, ClassNotFoundException {
        String fileName = "test-data/testModel-WithSerializableSubObject.dat";

        SubObject serializableObject = new SerializableObject("serialisedObjName");
        TestModel testModelToDisk = new TestModelImpl(serializableObject);

        assertRoundTripSerialisationToDisk(fileName, testModelToDisk, "serialisedObjName");
    }

    //This test will fail if the TestModel contains an objects that is Serialisable (like a java.net.Socket object for instance).
    @Test
    public void testSerializationOfNonSerializableSubObjectFails() throws ClassNotFoundException {
        String fileName = "test-data/testModel-WithNonSerializableSubObject.dat";

        SubObject nonSerializableSubObject = new NonSerializableObject("serialisedObjName");
        TestModel testModelToDisk = new TestModelImpl(nonSerializableSubObject);

        try {
            assertRoundTripSerialisationToDisk(fileName, testModelToDisk, "serialisedObjName");
        } catch (IOException e) {
            assertTrue(true, "We do expect an IO exception when de-serialising");
        }
    }

    private void assertRoundTripSerialisationToDisk(String fileName, TestModel modelToDisk, String expectedStringValueOfSubObject) throws IOException, ClassNotFoundException {
        DiskSerializer diskSerializer = new DiskSerializer();
        Object objectFromDisk = diskSerializer.roundTripSerialiseToDisk(fileName, modelToDisk);

        TestModel modelFromDisk = (TestModel) objectFromDisk;

        assertEquals(modelFromDisk.getSubObject().getStringValue(), expectedStringValueOfSubObject);
    }

}
