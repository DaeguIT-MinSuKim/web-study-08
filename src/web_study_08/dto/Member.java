package web_study_08.dto;

public class Member {
    private String name;
    private String userId;
    private String pwd;
    private String email;
    private String phone;
    private int admin;

    public Member() {
        // TODO Auto-generated constructor stub
    }

    public Member(String userId) {
        this.userId = userId;
    }

    public Member(String name, String userId, String pwd, String email, String phone, int admin) {
        this.name = name;
        this.userId = userId;
        this.pwd = pwd;
        this.email = email;
        this.phone = phone;
        this.admin = admin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return String.format("Member [name=%s, userId=%s, pwd=%s, email=%s, phone=%s, admin=%s]", name, userId, pwd,
                email, phone, admin);
    }

}
