package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText billTotal;
    private EditText tipPercent;
    private EditText partySize;
    private EditText totalNum;
    private EditText indivAmt;
    private RadioButton splitBill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        billTotal = findViewById(R.id.billTotal);
        tipPercent = findViewById(R.id.tipPercent);
        partySize = findViewById(R.id.partySize);
        totalNum = findViewById(R.id.totalNum);
        indivAmt = findViewById(R.id.indivAmt);
        splitBill = findViewById(R.id.splitBill);
    }

    public void makeMoney(View v){
        String amt = billTotal.getText().toString();
        String perc = tipPercent.getText().toString();
        String ps = partySize.getText().toString();
        if(splitBill.isChecked()){
            if(amt.length()>0){
                if(perc.length()>0){
                    if(ps.length()>0) {
                        double billValue = Double.parseDouble(amt);
                        double tipValue = Double.parseDouble(perc);
                        double pS = Double.parseDouble(ps);
                        double totalValue = billValue + ((tipValue / 100.0) * billValue);
                        double indivValue = totalValue / pS;
                        totalNum.setText(String.format("%.2f", totalValue));
                        indivAmt.setText(String.format("%.2f", indivValue));
                    }else{
                        Toast.makeText(this, "No Party Size value entered.", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(this, "No Tip Percent value entered.", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(this, "No Bill Amount value entered.", Toast.LENGTH_SHORT).show();
            }
        }else{
            if(amt.length()>0){
                if(perc.length()>0){
                    double billValue = Double.parseDouble(amt);
                    double tipValue = Double.parseDouble(perc);
                    double totalValue = billValue + ((tipValue / 100.0) * billValue);
                    totalNum.setText(String.format("%.2f", totalValue));
                    indivAmt.setText(String.format("%.2f", totalValue));
                }else{
                    Toast.makeText(this, "No Tip Percent value entered.", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(this, "No Bill Amount value entered.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
