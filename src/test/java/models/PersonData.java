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

    public void withFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void withMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void withLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void withUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void withEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void withPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void withConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getPhone() {
        return phone;
    }

    public void withPhone(String middleName) {
        this.phone = phone;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void withCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getGender() {
        return gender;
    }

    public void withGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void withAddress(String address) {
        this.address = address;
    }

    public String getCarMake() {
        return carMake;
    }

    public void withCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void withDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
