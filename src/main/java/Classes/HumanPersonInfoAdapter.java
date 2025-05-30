package Classes;

import Enums.Gender;

public class HumanPersonInfoAdapter extends Human implements LambdaDemo.PersonInfo {
    public HumanPersonInfoAdapter(String surname, String firstname, String patronymic, int age, Gender gender) {
        super(surname, firstname, patronymic, age, gender);
    }
}

