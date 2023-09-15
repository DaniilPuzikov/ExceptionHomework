package Homework3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

// Напишите приложение, которое будет запрашивать у пользователя следующие данные, разделенные пробелом:
// Фамилия Имя Отчество датарождения номертелефона пол

// Форматы данных(можно везде использовать тип String):
// фамилия, имя, отчество - строки
// датарождения - строка формата dd.mm.yyyy
// номертелефона - целое беззнаковое число без форматирования
// пол - символ латиницей f или m.

// Приложение должно проверить введенные данные по количеству. 
// Если количество не совпадает с требуемым, вернуть код ошибки, 
// обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.

// Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. 
// Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. 
// Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано, 
// пользователю выведено сообщение с информацией, что именно неверно.

// Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии,
// в него в одну строку должны записаться полученные данные, вида

// <Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>

// Однофамильцы должны записаться в один и тот же файл, в отдельные строки.

// Не забудьте закрыть соединение с файлом.

// При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано,
// пользователь должен увидеть стектрейс ошибки.

// Данная промежуточная аттестация оценивается по системе "зачет" / "не зачет"

// "Зачет" ставится, если слушатель успешно выполнил
// "Незачет"" ставится, если слушатель успешно выполнил

// Критерии оценивания:
// Слушатель напишите приложение, 
//которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробело

public class Task {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите Фамилию, Имя, Отчество, Дату рождения, Номер телефона и пол(одной буквой m или f)");
        String str = sc.nextLine();
        String[] data = str.split(" ");
        if(data.length==6){
            String surname = data[0];
            String name = data[1];
            String patronymic = data[2];
            String dateOfBirthString = data[3];
            File file = new File(surname);
            String[] dateOfBirthStringArr = dateOfBirthString.split("\\.");
            try(FileWriter fw = new FileWriter(file,true);BufferedWriter bw = new BufferedWriter(fw)) {
                int day = Integer.parseInt(dateOfBirthStringArr[0]);
                int month = Integer.parseInt(dateOfBirthStringArr[1]);
                int year = Integer.parseInt(dateOfBirthStringArr[2]);
                if(day>31||day<1){
                    throw new RuntimeException("Некорректно введён день");
                }
                if(month>12||month<1){
                    throw new RuntimeException("Некорректно введён месяц");
                }
                long phoneNumber = Long.parseLong(data[4]);
                if(data[5].length()!=1){
                    throw new RuntimeException("Некорректно длина значения пола");
                }
                char gender = data[5].charAt(0);
                if(gender!='m'&&gender!='f'){
                    throw new RuntimeException("Некорректное значение пола");
                }
                bw.write(str);
                bw.newLine();
            }
            catch(NumberFormatException e){
                e.printStackTrace();
                System.err.println("В числовых значениях имеются буквы или другие сторонние символы");
            } 
            catch(RuntimeException e) {
                System.err.println(e.getMessage());
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
        else{  
            data = new String[]{"0"};
            System.out.println("Некорректное количество данных\n"+Arrays.toString(data));
        }
    }
}
