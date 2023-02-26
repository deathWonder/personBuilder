import java.util.OptionalInt;

public class PersonBuilder {

    private String name;
    private String surname;
    private OptionalInt age;
    private String address;


    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) throw new IllegalArgumentException("Неподходящие данные");
        this.age = OptionalInt.of(age);
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null) throw new IllegalArgumentException("Не указанно имя");
        if (surname == null) throw new IllegalArgumentException("Не указанна фамилия");
        if (age.isPresent() && address != null) return new Person(name, surname, age.getAsInt(), address);
        if (age.isPresent()) return new Person(name, surname, age.getAsInt());
        if (address != null) return new Person(name, surname, address);
        return new Person(name, surname);
    }
}