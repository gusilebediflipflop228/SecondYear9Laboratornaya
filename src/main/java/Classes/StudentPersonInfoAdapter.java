package Classes;

import Enums.Gender;

public class StudentPersonInfoAdapter extends Student implements LambdaDemo.PersonInfo {
    public StudentPersonInfoAdapter(String surname, String firstname, String patronymic, int age, Gender gender) {
        super(surname, firstname, patronymic, age, gender);
    }

}
