package pages;

import com.github.javafaker.Faker;

public class Util {

    protected Faker faker = new Faker();
    private final String fakeEmailForLogin = faker.name().firstName().toLowerCase() + "." + faker.name().lastName().toLowerCase() + "@testmail.com";
    private final String fakePassword = faker.name().username();
    private final String fakeFirstName = faker.name().firstName();
    private final String fakeLastName = faker.name().lastName();
    private final String fakeName = fakeFirstName + fakeLastName;
    private final String fakeEmailForSignup = fakeFirstName.toLowerCase() + "." + fakeLastName.toLowerCase() + "@itbootcamp.rs";
    private final String fakePhone = String.valueOf(faker.phoneNumber());
    private final String fakeCity = faker.address().city();
    private final String fakeCountry = faker.address().country();
    private final String fakeTwitter = "https://" + faker.internet().domainName();
    private final String fakeGitHub = "https://" + faker.name().firstName() + faker.internet().domainName();

    public Util() {
    }

    public String getFakeEmailForLogin() {
        return fakeEmailForLogin;
    }

    public String getFakePassword() {
        return fakePassword;
    }

    public String getFakeName() {
        return fakeName;
    }

    public String getFakeEmailForSignup() {
        return fakeEmailForSignup;
    }

    public String getFakePhone() {
        return fakePhone;
    }

    public String getFakeCity() {
        return fakeCity;
    }

    public String getFakeCountry() {
        return fakeCountry;
    }

    public String getFakeTwitter() {
        return fakeTwitter;
    }

    public String getFakeGitHub() {
        return fakeGitHub;
    }
}
