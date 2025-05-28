package config;

public class Session {
    
    private static Session instance;
    private int uid;
    private String fname;
    private String lname;
    private String bdate;
    private String email;
    private String pass;
    private String type;
    private String phone;
    private String status;
    private String imagePath;
    private int staff_id;
    
    private Session(){
        //private cons.
    }

    public static synchronized Session getInstance() {
        if(instance==null){
            instance = new Session();
        }
        return instance;
    }
    
    public void setStaffId(int uid) {
        this.uid = uid;
    }
    
    public int getStaffId() {
        return staff_id;
    }


    public static boolean isInstanceEmpty() {
        return instance == null;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getBdate() {
        return bdate;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getImagePath() {
    return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    
    
}
