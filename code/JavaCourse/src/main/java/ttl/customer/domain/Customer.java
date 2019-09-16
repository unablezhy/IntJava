package ttl.customer.domain;

import ttl.larku.dao.inmemory.InMemoryStudentDAO;
import ttl.larku.domain.Student;
import ttl.larku.service.StudentService;

import java.util.List;
import java.util.Objects;

/**
 * @author whynot
 */
public class Customer {

    private int id;
    private String name;
    private List<String> phoneNumbers;
    private Status status;

    public enum Status
    {
        Privelaged,
        Normal,
        Restricted
    }

    public Customer(int id, String name, List<String> phoneNumbers, Status status) {
        this.id = id;
        this.name = name;
        this.phoneNumbers = phoneNumbers;
        this.status = status;
    }

    public Customer(String name, List<String> phoneNumbers, Status status) {
        this.name = name;
        this.phoneNumbers = phoneNumbers;
        this.status = status;
    }

    public Customer() {}

    public int getId() {
        return id;
    }

    /*
    public void setId(int id) {
        this.id = id;
    }
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public Status getStatus() {
        return status;
    }


    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumbers=" + phoneNumbers +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id &&
                Objects.equals(name, customer.name) &&
                Objects.equals(phoneNumbers, customer.phoneNumbers) &&
                status == customer.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phoneNumbers, status);
    }
}
