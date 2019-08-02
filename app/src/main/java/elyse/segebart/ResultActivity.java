package elyse.segebart;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Locale;

public class ResultActivity extends AppCompatActivity {

    public static final String EXTRA_TOTAL_BILL = "totalBill";
    public static final String EXTRA_TIP_AMOUNT = "tipAmount";

    private TextView mTipAmount;
    private TextView mTotalBill;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_result);

        mTotalBill = findViewById(R.id.totalBill);
        mTipAmount = findViewById(R.id.tipAmount);

        Intent intent = getIntent();

        double totalTip = intent.getDoubleExtra(EXTRA_TIP_AMOUNT, 0);
        double totalBill = intent.getDoubleExtra(EXTRA_TOTAL_BILL, 0);

        mTipAmount.setText( String.format(Locale.getDefault(), "Tip amount: %.2f", totalTip));
        mTotalBill.setText( String.format(Locale.getDefault(), "Total bill: %.2f", totalBill));
    }
}
