public class TestGenerics {
    public static void main(String[] args) throws Exception{
        GenericsClass<String> myvar;
        myvar = new GenericsClass<String>("Hello");
        System.out.println(myvar.getAttr());
        GenericsClass<Integer> othervar; //using a wrapper class for primitive int
        othervar = new GenericsClass<Integer>(Integer.valueOf(5)); //no NEW when creating a new instance of integer
    }
}
