
// "Type" is a *generic* type that can later be
//   instantiated with different concrete types

public class GenericsClass<Type> {
    private Type attr;

    public GenericsClass(Type t) {
        attr = t;
    }

    public Type getAttr() {
        return attr;
    }
}
