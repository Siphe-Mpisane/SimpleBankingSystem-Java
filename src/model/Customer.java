package model;

public class Customer {
    private String name;
    private String surname;
    private String idNumber;
    private String phone;
    private String email;

    public Customer(String name, String surname, String idNumber, String phone, String email) {
        this.name = name;
        this.idNumber = idNumber;
        this.email = email;
        this.surname = surname;
        this.phone = phone;
    }

    public String getSurname() {
        return surname;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
