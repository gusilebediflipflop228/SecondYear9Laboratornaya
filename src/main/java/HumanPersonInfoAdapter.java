public class HumanPersonInfoAdapter extends Human implements LambdaDemo.PersonInfo {
    public HumanPersonInfoAdapter(String surname, String firstname, String patronymic, int age, String gender) {
        super(surname, firstname, patronymic, age, gender);
    }
}

class StudentPersonInfoAdapter extends Student implements LambdaDemo.PersonInfo {
    public StudentPersonInfoAdapter(String surname, String firstname, String patronymic, int age, String gender, String university, String faculty, String specialty) {
        super(surname, firstname, patronymic, age, gender, university, faculty, specialty);
    }
}
