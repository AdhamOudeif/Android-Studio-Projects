package cosc426.program.userpassgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

//controller
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void genButton(View view) {
       //get edit texts
        EditText fname = (EditText) findViewById(R.id.FirstName);
        EditText lname = (EditText) findViewById(R.id.LastName);
        EditText dateOB = (EditText) findViewById(R.id.Date);
    //get strings
        String firstName = fname.getText().toString();
        String lastName = lname.getText().toString();
        String DateOfBirth = dateOB.getText().toString();
//create new gen user pass
        UserPassGen GenUserPass = new UserPassGen(firstName,lastName,DateOfBirth);
        //output user and pass
        TextView genUser = (TextView) findViewById(R.id.genUser);
        TextView genPass = (TextView) findViewById(R.id.genPass);
        genUser.setText(GenUserPass.getUsername());
        genPass.setText(GenUserPass.getPassword());
    }
}