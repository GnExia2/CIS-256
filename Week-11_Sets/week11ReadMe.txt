Java HashSet overview

The java.util package contains a HashSet class that implements a dynamic set. Functionality is described in online documentation.

Step 1: Inspect StaticSet.java

Inspect the StaticSet generic class declaration in the StaticSet.java file. Access StaticSet.java by clicking on the orange arrow next to LabProgram.java at the top of the coding window. StaticSet uses a HashSet to implement a static set. The HashSet's contents are assigned at construction time and must not change after.

Constructors and some additional methods are already implemented:

contains(T item) uses the HashSet's contains() method to determine if the set contains the item. If contains() returns true, the item is in the set. Otherwise the item is not in the set and contains() returns false.
getSize() uses the HashSet's size() method to determine the number of elements in the set. getSize() returns the set's size.
Step 2: Implement StaticSet's union(), intersection(), difference(), filter(), and map() methods

Implement the StaticSet class's union(), intersection(), difference(), filter(), and map() methods. Each must not change the StaticSet itself, but rather build and return a new StaticSet.

Step 3: Test in develop mode, then submit

File LabProgram.java contains test cases for each of the five operations. Running code in develop mode displays the test results, with 3 points possible for the union(), intersection(), and difference() operations, and 2 points for the filter() and map() operations. After each method is implemented and all tests pass in develop mode, submit the code. The unit tests run on submitted code are similar, but use different sets and generic types.