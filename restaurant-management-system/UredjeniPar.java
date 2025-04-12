package oop_sep1_22_Polic_Visnja_mp22435;

public class UredjeniPar<T1, T2> {

    private T1 prvi;
    private T2 drugi;

    public UredjeniPar(T1 prvi, T2 drugi){
        this.prvi = prvi;
        this.drugi = drugi;
    }

    public T1 getPrvi() {
        return prvi;
    }

    public T2 getDrugi() {
        return drugi;
    }
}
