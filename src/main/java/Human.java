import java.util.Objects;

public class Human {
    private String surname;
    private String firstname;
    private String patronymic;
    private int age;
    private String gender;

    public Human(String surname, String firstname, String patronymic, int age, String gender) {
        this.surname = surname;
        this.firstname = firstname;
        this.patronymic = patronymic;
        this.age = age;
        this.gender = gender;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age && Objects.equals(surname, human.surname) && Objects.equals(firstname, human.firstname) && Objects.equals(patronymic, human.patronymic) && Objects.equals(gender, human.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, firstname, patronymic, age, gender);
    }
}
