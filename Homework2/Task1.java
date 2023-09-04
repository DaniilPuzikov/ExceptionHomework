import java.util.Scanner;

public class Task1 {

    // Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), 
    // и возвращает введенное значение. 
    // Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, 
    // необходимо повторно запросить у пользователя ввод данных.
    public static void main(String[] args) {
        System.out.println(returnFloat());
    }

    public static float returnFloat(){
        System.out.println("Введите число");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        try{
            return Float.parseFloat(s);
        }
        catch(NumberFormatException e){
            System.out.println(e.getMessage()+" введено не число");
        }
        return returnFloat();
    }


}
