package cosc426.program.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //initialize edit text variables
private EditText Entry1;
private EditText Entry2;
private TextView ResultOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Create Variables
        Entry1 = (EditText) findViewById(R.id.Entry1);
        Entry2 = (EditText) findViewById(R.id.Entry2);
        ResultOutput = (TextView) findViewById(R.id.ResultOutput);
    }

    public void add(View view) {
        float n1 = Float.parseFloat(Entry1.getText().toString());
        float n2 = Float.parseFloat(Entry2.getText().toString());
        float sum = n1 + n2;
        ResultOutput.setText(String.valueOf(sum));
    }

    public void subtract(View view) {
        float n1 = Float.parseFloat(Entry1.getText().toString());
        float n2 = Float.parseFloat(Entry2.getText().toString());
        float sum = n1 - n2;
        ResultOutput.setText(String.valueOf(sum));
    }

    public void multiply(View view) {
        float n1 = Float.parseFloat(Entry1.getText().toString());
        float n2 = Float.parseFloat(Entry2.getText().toString());
        float sum = n1 * n2;
        ResultOutput.setText(String.valueOf(sum));
    }

    public void divide(View view) {
        float n1 = Float.parseFloat(Entry1.getText().toString());
        float n2 = Float.parseFloat(Entry2.getText().toString());
        float sum = n1 / n2;
        ResultOutput.setText(String.valueOf(sum));
    }
}