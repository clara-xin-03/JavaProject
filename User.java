abstract class User {
    private String userName;
    private String userPassword;

    public User(String userName, String userPassword){
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;

    }

    public String getUserPassword() {
        return this.userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;

    }

    public void userLogin() {
        boolean checkName = true;
        boolean checkPassword = true;
        while(checkName){
            String inputName = Keyboard.readString("Enter Login Name> ");
            if(inputName.equals(userName)) {
                checkName = false;
                while(checkPassword) {
                    String inputPassword = Keyboard.readString("Enter Password> ");
                    if( inputPassword.equals(userPassword)) {
                        checkPassword = false;
                        System.out.println("Login Successful!");
                    }else {
                        System.out.println("Incorrect Password. Enter again: ");
    
                    }
                }
                
                
            }else {
                System.out.println("Incorrect Name. Enter again: ");
            }

       
        }

    }
    
    
    
}
