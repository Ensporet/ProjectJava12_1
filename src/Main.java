import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static final String CANCEL = "x";




    public static String help(ArrayList<Lock> arr){

        String s = "";
        for(Lock l : arr)
            s += String.format("%-5s%s%s%n",l.getKey(),":",l.getDescription());



    return s;
    }

    public static int    getId(String s, ArrayList<Lock> l){

    if(s == null || s.length() == 0 || l == null)
        return -1;

    for(Lock lock : l)
        if(lock.Trues(s))
            return lock.getId();

    return -1;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Создать персонажа
        Human h = Human.buldHuman();


        ArrayList<Lock> lock = new ArrayList<>();
            lock.add(new Lock("1" , 1 , " Добавить" ));
            lock.add(new Lock("2" , 2 , " Удалить ")) ;
            lock.add(new Lock("3" , 3 , " Изменить "));
            lock.add(new Lock("4" , 4 , " Удалить все "));
            lock.add(new Lock("5" , 5 , " Показать список всех обьектов "));
            lock.add(new Lock("6" , 6 , " Выбрать обект "));
            lock.add(new Lock("7" , 7 , " ВЫХОД "));
            lock.add(new Lock(CANCEL ,  8 , " Отмена "));
            lock.add(new Lock("help",9 , " Инфо"));






        while(true){

        String symbol = scan.nextLine();

        switch (getId(symbol,lock)){


            case 1:
                h.addHumanObject();
                break;
            case 2:
                h.deleteHumanObject();
                break;
            case 3:
                h.setHumanObjects();
                break;
            case 4 :
                h.deleteAllHumanObject();
            case 5 :
                h.getAllObjectString();
                break;
            case 6:
                h.SelectHumanObject();
                break;
            case 7:
                System.out.println("Спасибо за тест програмы , хорошего дня ) \n " +
                "...............................................................");
                System.exit(0);
                break;
            case 8:
                break;
            case 9:
                System.out.println( help(lock) + h.toString());

                break;

            default:
                System.out.println(" Нет такой команды , введите help");
                break;



        }






        }







    }







}
