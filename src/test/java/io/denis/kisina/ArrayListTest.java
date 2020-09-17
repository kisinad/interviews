package io.denis.kisina;

import junit.framework.TestCase;
import org.junit.Assert;

public class ArrayListTest extends TestCase {

    ArrayList list;
    public void setUp() throws Exception {
        super.setUp();
        list = new ArrayList();



    }

    public void tearDown() throws Exception {
        list = null;
    }

    public void testAppend() {
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(3);
        list.append(4);
        assertTrue(4 == list.get(4));
        assertTrue(2 == list.get(1));
        assertTrue(3 == list.get(2));
    }

    public void testGet() {
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(3);
        list.append(4);
        assertTrue(4 == list.get(4));
        assertTrue(2 == list.get(1));
        assertTrue(3 == list.get(2));
    }

    public void testSet() {
        list.set(0, 3);
        assertTrue(3 == list.get(0));
    }

    public void testDelete() {
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(3);
        list.append(4);

        assertTrue(5 == list.size());

        list.delete(1);

        assertTrue(4 == list.size());
    }
}