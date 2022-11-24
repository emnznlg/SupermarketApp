public class CustomerPojo {

    public String email;
    public String name;
    private String password;
    private String phoneNumber;

    public CustomerPojo(String email, String name, String password, String phoneNumber) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Name: " + email +
                ", Email: " + email +
                ", Password: " + password +
                ", Phone Number: " + phoneNumber;
    }
}
