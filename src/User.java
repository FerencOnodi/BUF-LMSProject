public abstract class User {
    private String name;
    private String email;
    private String role;



    public User(String name, String email, String role){
        this.name = name;
        this.email = email;
        this.role = role;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getRole() {
        return role;
    }


    public void setRole(String role) {
        this.role = role;
    }


    public String getEmail() {
        return email;
    }

    public String toString(){
        return getName() + " " + getEmail() + " " + getRole();
    }


}
