package main.lesson_54_MapAdv.classwork.optional.person;

import main.lesson_54_MapAdv.classwork.optional.person.model.Person;
import main.lesson_54_MapAdv.classwork.optional.person.model.PersonNotFoundException;

import java.util.Optional;

public class PersonOptionalAppl {
    public static void main(String[] args) {
        Person[] people = {new Person("John", 28), new Person("Mary", 19), new Person("Peter", 25)};
//        Person person = findPersonByAge(people, 28);
//        if (person != null) {
//            System.out.println(person.getName());
//        }

        Optional<Person> optional = findPersonByAge(people, 23);


//        if (optional.isPresent()) {
//            Person person = optional.get();
//            System.out.println(person.getName());
//        }

//        optional.ifPresent(person -> System.out.println(person.getName()));

//        Person person = optional.orElse(new Person("Anonymous", -1));

//        Person person = optional.orElseGet(() -> new Person("Anonymous", -1));

//        Person person = optional.orElseThrow(() -> new PersonNotFoundException());
        Person person = optional.orElseThrow(PersonNotFoundException::new);

        System.out.println(person.getName());
    }

    public static Optional<Person> findPersonByAge(Person[] people, int age) {
        Person person = null;
        for (int i = 0; i < people.length; i++) {
            if (people[i].getAge() == age) {
                person = people[i];
                break;
            }
        }
        return Optional.ofNullable(person);
    }

}
