package exception;

public class MyCheckedException extends Exception{
    public MyCheckedException(){
        super("Проверено исключение: не хватает места, чтобы положить еще одну вещь");
    }
}
