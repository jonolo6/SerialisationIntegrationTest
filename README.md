SerialisationIntegrationTest
============================

Testing out how to expliclity make a test fail if the SerialVersionUID hasn't been updated in the class but the contents of the class has.

Current Status of project
=========================
I have both unit tests and integration tests that test serialisation well apart from being able to test...
* Given a class (TestModel) with a given SerialVersionUID and set to Serializable when I pull it from disk and compare to the same class that now has some changes in it I want the test to fail.

Next Steps/Ideas:
=================
1) Try recursively call all methods/objects: (example here: http://www.java2s.com/Tutorial/Java/0125__Reflection/Recursivelygetallfieldsforahierarchicalclasstree.htm for instance)
