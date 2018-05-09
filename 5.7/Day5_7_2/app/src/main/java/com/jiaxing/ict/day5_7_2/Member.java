package com.jiaxing.ict.day5_7_2;

public class Member {
    /**
     *  "member_id": 35,
     "uname": "zhusheng",
     "password": "MKqb7tLur1KQL+XxhUYO2A==",
     "email": "zhu.sheng@huatec.com",
     "sex": 0,
     "mobile": "",
     "regtime": 1524791291000,
     "lastlogin": 1525653636000,
     "image": "",
     "memberAddresses": null
     */
    private int member_id;
    private String uname;
    private String password;
    private String email;
    private int sex; //0表示男，1表示女
    private String mobile;
    private String regtime;
    private String lastlogin;
    private String image;
    private String memberAddresses;

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRegtime() {
        return regtime;
    }

    public void setRegtime(String regtime) {
        this.regtime = regtime;
    }

    public String getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(String lastlogin) {
        this.lastlogin = lastlogin;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMemberAddresses() {
        return memberAddresses;
    }

    public void setMemberAddresses(String memberAddresses) {
        this.memberAddresses = memberAddresses;
    }

    @Override
    public String toString() {
        return "Member{" +
                "member_id=" + member_id +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", sex=" + sex +
                ", mobile='" + mobile + '\'' +
                ", regtime='" + regtime + '\'' +
                ", lastlogin='" + lastlogin + '\'' +
                ", image='" + image + '\'' +
                ", memberAddresses='" + memberAddresses + '\'' +
                '}';
    }
}
