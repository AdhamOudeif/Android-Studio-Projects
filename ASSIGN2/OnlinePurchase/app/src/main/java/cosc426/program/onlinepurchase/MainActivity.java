package cosc426.program.onlinepurchase;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Button
        Button button = (Button)findViewById(R.id.enter);
        ButtonHandler temp = new ButtonHandler();
        button.setOnClickListener(temp);
    }

    private class ButtonHandler implements View.OnClickListener {
        public void onClick(View v) {
            //Toast
            Context context = getApplicationContext();
            int toastD = Toast.LENGTH_SHORT;

            //Get the price input
            EditText priceText = (EditText) findViewById(R.id.price);
            String priceString = priceText.getText().toString();
            int price;

            //Catch Errors
            try {
                price = Integer.parseInt(priceString);
            } catch (NumberFormatException e) {
                Toast toast = Toast.makeText(context, "No Price Entered", toastD);
                toast.show();
                return;
            }
            if (price < 0) {
                Toast toast = Toast.makeText(context, "Invalid Price", toastD);
                toast.show();
                return;
            }


            //Toggle Button
            ToggleButton warrantyButton = (ToggleButton)findViewById(R.id.warranty);
            boolean warranty = warrantyButton.isChecked();

            //Switch handeler
            Switch insuranceSwitch = (Switch) findViewById(R.id.insurance);
            boolean insurance = insuranceSwitch.isChecked();

            //Spinner
            Spinner deliverySpinner = (Spinner) findViewById(R.id.delivery);
            String delivery = (String)deliverySpinner.getSelectedItem();

            //Calculate and output Cost
            Cost calculateCost = new Cost(price, warranty, insurance, delivery);
            TextView costOutput = (TextView) findViewById(R.id.cost);
            costOutput.setText("$"+calculateCost.getCost());
        }
    }
}