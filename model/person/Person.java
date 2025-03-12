package model.person;

import java.time.LocalDate;
import java.time.Period;

public abstract class Person {
    private final int id;
    private final String fullName;
    private String address;
    private String phone;
    private String email;
    private final LocalDate dateOfBirth;

    protected Person(int id, String fullName, String address, String phone, String email, LocalDate dateOfBirth) {
        this.id = validateId(id); //checking for neg val
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    protected Person(int id, String fullName, LocalDate dateOfBirth) {
        this.id = validateId(id);
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
    }

    private static int validateId(int id) { //try catch block
        try {
            if (id < 0) {
                throw new IllegalArgumentException("Student ID can't be negative.");
            }
            return id;
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return 0; // return 0 if invalid id
        }
    }
    public int getId() { return id; }
    public String getFullName() { return fullName; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public int getAge() {
        LocalDate today = LocalDate.now();
        Period period = Period.between(this.dateOfBirth, today);
        return period.getYears();
    }
    public void setAddress(String address) { this.address = address; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Person{");
        sb.append("id=").append(id);
        sb.append(", fullName='").append(fullName).append("'");
        sb.append(", address='").append(address).append("'");
        sb.append(", phone='").append(phone).append("'");
        sb.append(", email='").append(email).append("'");
        sb.append(", dateOfBirth=").append(dateOfBirth);
        sb.append("}");
        return sb.toString();
    }
}
