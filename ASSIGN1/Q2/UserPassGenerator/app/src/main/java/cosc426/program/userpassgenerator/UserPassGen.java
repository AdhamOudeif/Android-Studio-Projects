//model
package cosc426.program.userpassgenerator;

public class UserPassGen {
    private String username;
    private String password;

    //Constructor
    public UserPassGen(String fname, String lname, String dob){
        //Make the Username
        username = fname.charAt(0) + lname + dob.substring(3,5);
        username = username.toLowerCase();

        //Make the Password
        password = fname.substring(0,1) + fname.substring(fname.length()-1)
                + dob.substring(0,2) + dob.substring(8,10) + lname.substring(0,3)
                + fname.length() + lname.length();
        password = password.toLowerCase();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
