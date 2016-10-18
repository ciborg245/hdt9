/**
 * Created by user on 10/17/2016.
 */

public class HashMap<T> implements Map<T> {
    public boolean valor;
    public boolean insert (T element) {
        Map.put(objeto.getT(),objeto.getType());

    }

    public T find(T element) {
        Map.containsValue(element.getT());
        valor=Map.containsKey(element.getT());
        if(valor==true){
            T palabra=new T();
            palabra.setT(element.getT());
            palabra.setType(Map.get(element.getT()));
            return palabra;
        }else{
            return null;
        }
    }
}
