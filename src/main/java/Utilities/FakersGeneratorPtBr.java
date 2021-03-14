package Utilities;

import com.github.javafaker.Faker;

import java.util.Locale;

public class FakersGeneratorPtBr {

    private Faker faker;

    public FakersGeneratorPtBr() {
        faker = new Faker(new Locale("pt-BR"));
    }

    public String getFirstName() {
        return faker.name().firstName();
    }

    public String getLastName() {
        return faker.name().lastName();
    }

    public String getPostalCode() {
        return faker.address().zipCode();
    }

    public String getRandomEmail() {
        String email = faker.bothify("????##@gmail.com");
        return email;
    }

    public String getCompanyName() {
        String companyName = faker.company().name();
        return companyName;
    }

    public String getAddress() {
        return faker.address().fullAddress();
    }

    public String getCity() {
        return faker.address().city();
    }

    public String getMobilePhone() {
        return faker.phoneNumber().cellPhone();
    }

    public String getPhone() {
        return faker.phoneNumber().phoneNumber();
    }

    public String getStreetAddress(){
        return faker.address().streetAddress();
    }

    public String getStreetName(){
        return faker.address().streetName();
    }

    public String getState(){
        return faker.address().state();
    }

    public String getBirthday(){

        Integer age = faker.date().birthday().getYear();

        return age.toString();
    }
}
