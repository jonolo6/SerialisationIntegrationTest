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

    private DiskSerializer diskSerializer;

    //This test will fail if the TestModel contains a sub-object that is not Serialisable (like a java.net.Socket object for instance).
    @Test
    public void testSerializationFormatHasNotChanged() throws IOException, ClassNotFoundException {
        String fileName = "test-data/testModel-WithSerializableSubObject.dat";

        ISubObject serializableObject = new SerializableSubObject("serialisedObjName");
        ITestModel testModelToDisk = new TestModelImpl(serializableObject);

        assertRoundTripSerialisationToDisk(fileName, testModelToDisk, "serialisedObjName");
    }

    //This test will fail if the TestModel contains an objects that is Serialisable (like a java.net.Socket object for instance).
    @Test
    public void testSerializationOfNonSerializableSubObjectFails() throws ClassNotFoundException {
        String fileName = "test-data/testModel-WithNonSerializableSubObject.dat";

        ISubObject nonSerializableSubObject = new NonSerializableSubObject("serialisedObjName");
        ITestModel testModelToDisk = new TestModelImpl(nonSerializableSubObject);

        try {
            assertRoundTripSerialisationToDisk(fileName, testModelToDisk, "serialisedObjName");
        } catch (IOException e) {
            assertTrue(true, "We do expect an IO exception when de-serialising");
        }
    }

    @Test
    public void testThatCallingAllMethodsOnAnObjectThatDeserialisesFineButIsIncompatibleFails() throws IOException, ClassNotFoundException {
        Object objectFromFile = diskSerializer.readObjectFromFile("test-data/testModel-oldVersion.dat");
        ITestModel testModel = (ITestModel) objectFromFile;
        ISubObject result = testModel.getSubObjectAsANewMethod();
        System.out.println("old: " + result);
        //TODO: the problem here is that the old model doesn't have the getSubObjectAsANewMethod method, but it returns null - it doesn't throw an exception.

        objectFromFile = diskSerializer.readObjectFromFile("test-data/testModel-newVersion.dat");
        testModel = (ITestModel) objectFromFile;
        result = testModel.getSubObjectAsANewMethod();
        System.out.println("new: " + result);
    }


    private void assertRoundTripSerialisationToDisk(String fileName, ITestModel modelToDisk, String expectedStringValueOfSubObject) throws IOException, ClassNotFoundException {
        diskSerializer = new DiskSerializer();
        Object objectFromDisk = diskSerializer.roundTripSerialiseToDisk(fileName, modelToDisk);

        ITestModel modelFromDisk = (ITestModel) objectFromDisk;

        assertEquals(modelFromDisk.getSubObjectAsANewMethod().getStringValue(), expectedStringValueOfSubObject);
    }

}
