package dto;

import constraint.Name;
import enums.Sex;
import constraint.Password;
import constraint.RegistrationDay;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author Laci
 */
@RegistrationDay
@Name
public class UserDTO {

    @NotNull
    @Size(min = 6)
    private String userName;

    @NotNull
    @Password
    private String password;

    private String firstName;
    private String lastName;

    @Pattern(regexp = "^\\d{4}.*")
    private String address;

    @Pattern(regexp = "^((06)|(\\+36))\\d{9}$")
    private String phone;

    @NotNull
    @Pattern(regexp = "^.*@.*\\.[a-z]{2,3}")
    private String email;

    private Sex sex;
    @NotNull
    private Date registrationDate;

    private Date dateOfBirth;
    private boolean admin;

    public UserDTO() {
        //Do nothing because JSON
    }

    public UserDTO(String userName, String password, String email, Date registrationDate) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.registrationDate = registrationDate;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Sex getSex() {
        return sex;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}