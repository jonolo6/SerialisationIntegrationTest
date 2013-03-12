package com.expedia.jonas.serialisationtesting;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * Created with IntelliJ IDEA.
 * User: jolofsson
 * Date: 12/03/2013
 * Time: 19:26
 * To change this template use File | Settings | File Templates.
 */
public class SerialisationTestHelper {

    public static void main(String[] args) throws IOException {

        // Uncomment and run the below when you need an instance of the TestModel serialized to disk
        // writeATestModelToFile("test-data/testModelExample.dat");

    }

    private static void writeATestModelToFile(String fileName) throws IOException {
        OutputStream fout = new FileOutputStream(fileName);
        ObjectOutputStream out = new ObjectOutputStream(fout);

        TestModel context = new TestModel("variableObject");
        context.setVariableValue("blah2");

        out.writeObject(context);
        out.flush();
        out.close();
    }

}
