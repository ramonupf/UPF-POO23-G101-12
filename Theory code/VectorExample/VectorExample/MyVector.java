
// MyVector: class for storing elements of *any type*

public class MyVector {
    
	// any instance can be stored in a variable of type Object
    private int size;
    private Object[] elems;

    public MyVector(int capacity) {
        size = 0;
        elems = new Object[capacity];
    }

    public int getSize() {
        return size;
    }

	// method for adding an element
    public void addElem(Object o) {
        elems[size] = o;
        size++;
    }

	// method for checking if the vector contains an object
    public boolean contains(Object o) {
        for (int i = 0; i < size; ++i) {
        	// polymorphism calls equals in the class of instance "elems[i]"
            if (elems[i].equals(o))
                return true;
        }
        return false;
    }
}
