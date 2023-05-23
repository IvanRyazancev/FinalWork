import java.util.*;

public class FinalWork {
    public static void main(String[] args) {
        /*
        Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
        Создать множество ноутбуков.
        Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет
        ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например: Введите цифру,
        соответствующую необходимому критерию:
        1 - ОЗУ
        2 - Объем ЖД
        3 - Операционная система
        4 - Цвет
        Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно
        также в Map.
        Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.
        Работу сдать как обычно ссылкой на гит репозиторий
        P.S. Частые ошибки смотри в конце семинара
         */
        laptop lap1 = new laptop("A5", 1236, "Xiaomi");
        lap1.setColor("black");
        lap1.setHDD(700);
        lap1.setOS("Windows");
        lap1.setRAM(8);

        laptop lap2 = new laptop("ABC30", 6467, "Acer");
        lap2.setColor("white");
        lap2.setHDD(1000);
        lap2.setOS("Windows");
        lap2.setRAM(8);

        laptop lap3 = new laptop("AB97", 67201, "Acer");
        lap3.setColor("rose");
        lap3.setHDD(900);
        lap3.setOS("Windows");
        lap3.setRAM(16);

        laptop lap4 = new laptop("OMAN11", 1111, "hp");
        lap4.setColor("black");
        lap4.setHDD(700);
        lap4.setOS("Linux");
        lap4.setRAM(8);

        laptop lap5 = new laptop("MAC101", 8438483, "Apple");
        lap5.setColor("silver");
        lap5.setHDD(1000);
        lap5.setOS("macOS");
        lap5.setRAM(8);

        HashSet<laptop> laptops = new HashSet<>(Arrays.asList(lap1, lap2, lap3, lap4, lap5));
        HashSet<laptop> res = new HashSet<>();

        System.out.println("Здравствуйте");
        System.out.print("""
                Введите цифру, соответствующую необходимому критерию:
                 1 - ОЗУ\s
                 2 - Объем HDD\s
                 3 - Операционная система\s
                 4 - цвет\s
                 или 5, чтобы осуществить поиск
                """);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        HashMap<String, Object> filters = new HashMap<>();
        while (n != 5) {
            if (n == 1) {
                System.out.println("Введите минимальную оперативную память");
                Integer temp = sc.nextInt();
                sc.nextLine();
                filters.put("RAM", temp);
            }
            if (n == 2) {
                System.out.println("Введите минимальный объем ЖД");
                Integer temp = sc.nextInt();
                sc.nextLine();
                filters.put("HDD", temp);
            }
            if (n == 3) {
                System.out.println("Введите ОС");
                String temp = sc.nextLine();
                filters.put("OS", temp);
            }
            if (n == 4) {
                System.out.println("Введите цвет");
                String temp = sc.nextLine();
                filters.put("color", temp);
            }
            System.out.print("""
                    Введите цифру, соответствующую необходимому критерию:
                     1 - ОЗУ\s
                     2 - Объем HDD\s
                     3 - Операционная система\s
                     4 - цвет\s
                     или 5, чтобы осуществить поиск
                    """);
            n = sc.nextInt();
            sc.nextLine();
        }
        for (Map.Entry<String, Object> entry : filters.entrySet()) {
            if (entry.getKey().equals("RAM")) {
                for (laptop lap : laptops) {
                    if (lap.getRAM() >= (Integer) entry.getValue()) {
                        res.add(lap);
                    }
                }
            }
            if (entry.getKey().equals("HDD")) {
                for (laptop lap : laptops) {
                    if (lap.getHDD() >= (Integer) entry.getValue()) {
                        res.add(lap);
                    }
                }
            }
            if (entry.getKey().equals("OS")) {
                for (laptop lap : laptops) {
                    if (lap.getOS().equals(entry.getValue())) {
                        res.add(lap);
                    }
                }
            }
            if (entry.getKey().equals("color")) {
                for (laptop lap : laptops) {
                    if (lap.getColor().equals(entry.getValue())) {
                        res.add(lap);
                    }
                }
            }
        }

        for (laptop lap : res) {
            System.out.println(lap.toString());
            System.out.println();
        }


    }
}