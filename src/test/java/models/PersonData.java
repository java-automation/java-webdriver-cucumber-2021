package models;

public class PersonData {
    private String firstName;
    private String middleName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private String confirmPassword;
    private String phone;
    private String countryOfOrigin;
    private String gender;
    private String address;
    private String carMake;
    private String dateOfBirth;

    public PersonData(String firstName, String middleName, String lastName,
                      String username, String email, String password, String confirmPassword, String phone, String countryOfOrigin, String gender, String address, String carMake, String dateOfBirth) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.phone = phone;
        this.countryOfOrigin = countryOfOrigin;
        this.gender = gender;
        this.address = address;
        this.carMake = carMake;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public PersonData withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getMiddleName() {
        return middleName;
    }

    public PersonData withMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public PersonData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public PersonData withUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PersonData withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public PersonData withPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public PersonData withConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public PersonData withPhone(String middleName) {
        this.phone = phone;
        return this;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public PersonData withCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public PersonData withGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public PersonData withAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCarMake() {
        return carMake;
    }

    public PersonData withCarMake(String carMake) {
        this.carMake = carMake;
        return this;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public PersonData withDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }
}
