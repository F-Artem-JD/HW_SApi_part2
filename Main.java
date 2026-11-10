import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        //ЗАДАЧА 1

        List<Integer> inList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);

        Stream<Integer> stream = inList.stream()
                .filter(x -> x > 0)
                .filter(x -> x % 2 == 0)
                .sorted(Comparator.naturalOrder());

        stream.forEach(System.out::println);


        //ЗАДАЧА 2

        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    SEX.values()[new Random().nextInt(SEX.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        while (true) {

            System.out.println("Выберите необходимую аналитику: ");
            System.out.println("1. Узнать количество несовершенолетних в Лондоне");
            System.out.println("2. Получить список граждан призывного возраста в Лондоне");
            System.out.println("3. Получить список работоспособных граждан в Лондоне");
            System.out.println("4. Выход");
            String input = scanner.nextLine();

            int operations = Integer.parseInt(input);


            switch (operations) {

                case 1:

                    long adult = persons.stream()
                            .filter(person -> person.getAge() < 18)
                            .count();

                    System.out.println("Общее количество несовершенолетних: " + adult + " человек.");
                    break;

                case 2:

                    List<String> conscripts = persons.stream()
                            .filter(person -> person.getAge() >= 18 && person.getAge() <= 27)
                            .filter(person -> person.getSex().equals(SEX.MAN))
                            .map(Person::getFamily)
                            .collect(Collectors.toList());

                    System.out.println(conscripts);

                    break;

                case 3:

                    List<Person> efficientPeople = persons.stream()
                            .filter(person -> person.getAge() >= 18 && person.getAge() <= 65)
                            .filter(person -> person.getEducation().equals(Education.HIGHER))
                            .sorted(Comparator.comparing(Person::getFamily))
                            .collect(Collectors.toList());

                    System.out.println(efficientPeople);
                    break;
            }

            if (operations == 4) {
                System.out.println("Пока, спасибо за дз");
                break;
            }

        }
    }
}