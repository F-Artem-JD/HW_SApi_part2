public class Person {

    private String name;
    private String family;
    private Integer age;
    private SEX sex;
    private Education education;

    public Person(String name, String family,Integer age, SEX sex, Education education ){

        this.name = name;
        this.family = family;
        this.age = age;
        this.sex = sex;
        this.education = education;

    }

    public String getName() {
        return name;
    }

    public Education getEducation() {
        return education;
    }

    public Integer getAge() {
        return age;
    }

    public SEX getSex() {
        return sex;
    }

    public String getFamily() {
        return family;
    }

    @Override
    public String toString(){
        return "Person{" +
                "name = '" + name + '\'' +
                ", family='" + family + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", education=" + education +
                '}';
    }
}
