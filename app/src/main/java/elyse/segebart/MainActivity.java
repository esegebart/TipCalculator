package elyse.segebart;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

import java.util.Locale;
import java.util.Scanner;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {

    //Declaring the variables using the id from layout
    EditText billAmount;
    EditText tipPercentage;
    Button calculate;
    FloatingActionButton newBill;
    FloatingActionButton newBill2;
    TextView tipAmount;
    TextView mTotalBill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //retrieving the variables from resource id and casting their type
        billAmount = findViewById(R.id.billAmount);
        tipPercentage = (EditText) findViewById(R.id.tipPercentage);
        calculate = (Button) findViewById(R.id.calculate);
        newBill = (FloatingActionButton) findViewById(R.id.newBill);
        newBill2 = (FloatingActionButton) findViewById(R.id.newBill2);
        tipAmount = (TextView) findViewById(R.id.tipAmount);
        mTotalBill = (TextView) findViewById(R.id.totalBill);

        //adding functionality to the button using onclicklistener
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //converting values to string and assigning to a new variable
                String billText = billAmount.getText().toString();
                String percentageText = tipPercentage.getText().toString();

                //converting string to double
                double billAmount = Double.parseDouble(billText);
                int tipPercentage = Integer.parseInt(percentageText);

                //calling the method to calculate tip total and final bill
                double tipTotal = calculateTipTotal(billAmount, tipPercentage);

                double finalBill = calculateFinalBill(billAmount, tipTotal);

                //setting finalBill value in format with two places after decimal
                String finalBillText = String.format(Locale.getDefault(), "%.2f", finalBill);

                //mTotalBill.setText(finalBillText);


                //Intent provides runtime binding between separate components, like two Activities
                //Represents applications "intent to do something"
                //Added extra_tip_amount and extra_total_bill to add calculations to be displayed in activity_result
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra(ResultActivity.EXTRA_TIP_AMOUNT, tipTotal);
                intent.putExtra(ResultActivity.EXTRA_TOTAL_BILL, finalBill);

                startActivity(intent);
            }
        });


    }

    //method to calculate tipTotal
    private double calculateTipTotal(double billAmount, int tipPercentage) {
        return billAmount * ((double) tipPercentage / 100);
    }

    //method to calculate final bill
    public double calculateFinalBill(double billAmount, double tipTotal) {
        return billAmount + tipTotal;
    }


    //taken from simpleCalculator to try and see if text box is empty
    public void buttononClick(View v) {
        double bill = 0;
        double tipPercent = 0;
        double totalTip = 0;
        double totalBill = 0;

        if (TextUtils.isEmpty(billAmount.getText().toString())
                || TextUtils.isEmpty(tipPercentage.getText().toString())) {
            return;
        }

        //read values and fill variables with numbers in string notation
        bill = Double.parseDouble(billAmount.getText().toString());
        tipPercent = Integer.parseInt(tipPercentage.getText().toString());
    }

    //methods to return the id using findViewByID
    private Object findViewById(TextView tipAmount) {

        return tipAmount;
    }



}
