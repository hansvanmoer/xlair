/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.xlair.music.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;
import be.xlair.music.facet.Facet;

/**
 *
 * @author hans
 */
public class User implements Serializable, Identifiable{
    
    public static Facet<User> FIRST_NAME_FACET = new Facet<User>(User.class,"firstName");
    public static Facet<User> LAST_NAME_FACET = new Facet<User>(User.class,"lastName");
    public static Facet<User> EMAIL_ADDRESS_FACET = new Facet<User>(User.class,"emailAddress");
    public static Facet<User> TELEPHONE_FACET = new Facet<User>(User.class,"telephone");
    public static Facet<User> BIRTH_DATE_FACET = new Facet<User>(User.class,"birthDate");
    public static Facet<User> ANSWER_FACET = new Facet<User>(User.class,"answer");
    public static Facet<User> SCORE_FACET = new Facet<User>(User.class,"score");
    
    private Long userId;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String telephone;
    private Date birthDate;
    private Integer answer;
    private Integer score;
    private UserState state;
    private Timestamp createdTime;

    public User(){
        this.createdTime = new Timestamp(System.currentTimeMillis());
        this.score=0;
    }
    
    public User(String firstName, String lastName, String emailAddress, String telephone, Date birthDate, Integer answer){
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.state = UserState.ACCEPTED;
        this.createdTime = new Timestamp(System.currentTimeMillis());
        this.telephone = telephone;
        this.birthDate = birthDate;
        this.answer = answer;
        this.score=0;
    }
    
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public UserState getState() {
        return state;
    }

    public void setState(UserState state) {
        this.state = state;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.userId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.userId, other.userId)) {
            return false;
        }
        return true;
    }
    
    public Object getUniqueId(){
        return userId;
    }
    
}
