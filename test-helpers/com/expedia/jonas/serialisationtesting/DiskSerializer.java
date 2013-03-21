package com.expedia.jonas.serialisationtesting;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: jolofsson
 * Date: 12/03/2013
 * Time: 19:26
 * To change this template use File | Settings | File Templates.
 */
public class DiskSerializer {

    public static void main(String[] args) throws IOException {
        SerializableSubObject serializableObject = new SerializableSubObject("serialisedObjName");
        TestModelImpl testModel = new TestModelImpl();

        // run the below when you need an instance of the TestModel serialized to disk
        DiskSerializer serialisationTestHelper = new DiskSerializer();
        serialisationTestHelper.writeObjectToFile("test-data/testModel.dat", testModel);
    }

    public Object roundTripSerialiseToDisk(String fileName, Object testModel) throws IOException, ClassNotFoundException {
        writeObjectToFile(fileName, testModel);
        return readObjectFromFile(fileName);
    }

    public void writeObjectToFile(String fileName, Object object) throws IOException {
        OutputStream fout = new FileOutputStream(fileName);
        ObjectOutputStream out = new ObjectOutputStream(fout);
        out.writeObject(object);
        out.flush();
        out.close();
    }

    public Object readObjectFromFile(String fileName) throws IOException, ClassNotFoundException {
        InputStream in = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(in);
        return ois.readObject();
    }
}
