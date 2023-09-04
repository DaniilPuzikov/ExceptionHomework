import java.util.Scanner;

public class Task4 {
    // Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. 
    // Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
    public static void main(String[] args) {
        enterString();
    }

    public static void enterString(){
        System.out.println("Введите строку: ");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if(s.isEmpty()){
            throw new RuntimeException("Пустые строки вводить нельзя");
        }
    }
}
