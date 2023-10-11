public class GenericsClass<Type>{ //this variable type could later be any class
       private Type attr;
       public GenericsClass(Type t){
              attr = t;
       }
       public Type getAttr(){
              return attr;
       }
}
