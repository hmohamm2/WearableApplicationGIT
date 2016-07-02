package com.example.wearableapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public final static String mssg = "1", mssg2 = "2", mssg3 = "3", mssg4 = "4", mssg5 = "5",
            mssg6 = "6", mssg7 = "7";
    private Button btnTotal, btnNextpg;
    private TextView tvResult;
    private EditText etFirstNumber, etSecondNumber, etThirdNumber, etFourthNumber, etFifthNumber,
            etSixthNumber, etSeventhNumber;
    private InputData2 db;
    public Date dateOne, dateTwo, dateThree, dateFour, dateFive, dateSix, dateSeven;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
//
//        InputData2 inputData2 = new InputData2(this);
//       if (!inputData2.isOpen()) {
//        inputData2.open();
//       } else {
//
//       }


        init();
        setDayOne();
        setDayTwo();
        setDayThree();
        setDayFour();
        setDayFive();
        setDaySix();
        setDaySeven();
        etFirstNumber = (EditText) findViewById(R.id.etFirstNumber);
        etSecondNumber = (EditText) findViewById(R.id.etSecondNumber);
        etThirdNumber = (EditText) findViewById(R.id.etThirdNumber);
        etFourthNumber = (EditText) findViewById(R.id.etFourthNumber);
        etFifthNumber = (EditText) findViewById(R.id.etFifthNumber);
        etSixthNumber = (EditText) findViewById(R.id.etSixthNumber);
        etSeventhNumber = (EditText) findViewById(R.id.etSeventhNumber);

    }

    public void addListenerOnButton() {
        final Context context = this;
        btnNextpg = (Button) findViewById(R.id.btnNextPg);
        btnNextpg.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DisplayMore.class);

                EditText editText = (EditText) findViewById(R.id.etFirstNumber);
                String message1 = editText.getText().toString();
                intent.putExtra(mssg, message1);

                EditText editText2 = (EditText) findViewById(R.id.etSecondNumber);
                String message2 = editText2.getText().toString();
                intent.putExtra(mssg2, message2);

                EditText editText3 = (EditText) findViewById(R.id.etThirdNumber);
                String message3 = editText3.getText().toString();
                intent.putExtra(mssg3, message3);

                EditText editText4 = (EditText) findViewById(R.id.etFourthNumber);
                String message4 = editText4.getText().toString();
                intent.putExtra(mssg4, message4);

                EditText editText5 = (EditText) findViewById(R.id.etFifthNumber);
                String message5 = editText5.getText().toString();
                intent.putExtra(mssg5, message5);

                EditText editText6 = (EditText) findViewById(R.id.etSixthNumber);
                String message6 = editText6.getText().toString();
                intent.putExtra(mssg6, message6);

                EditText editText7 = (EditText) findViewById(R.id.etSeventhNumber);
                String message7 = editText7.getText().toString();
                intent.putExtra(mssg7, message7);

                startActivity(intent);

            }
        });
    }

    //setting up calendar view for each day
    private void setDayOne() {
        TextView dayOne = (TextView) findViewById(R.id.tvDay1);
        Calendar td = Calendar.getInstance();
        dateOne = new java.sql.Date(td.getTimeInMillis());
        Date today = dateOne;
        dayOne.setText(String.valueOf(today));
    }

    private void setDayTwo() {
        TextView dayTwo = (TextView) findViewById(R.id.tvDay2);
        Calendar td = Calendar.getInstance();
        td.add(Calendar.DATE, -1);
        dateTwo = new java.sql.Date(td.getTimeInMillis());
        Date yesterday = dateTwo;
        dayTwo.setText(String.valueOf(yesterday));
    }

    private void setDayThree() {
        TextView dayThree = (TextView) findViewById(R.id.tvDay3);
        Calendar td = Calendar.getInstance();
        td.add(Calendar.DATE, -2);
        dateThree = new java.sql.Date(td.getTimeInMillis());
        Date yesterday = dateThree;
        dayThree.setText(String.valueOf(yesterday));

    }

    private void setDayFour() {
        TextView dayFour = (TextView) findViewById(R.id.tvDay4);
        Calendar td = Calendar.getInstance();
        td.add(Calendar.DATE, -3);
        dateFour = new java.sql.Date(td.getTimeInMillis());
        Date yesterday = dateFour;
        dayFour.setText(String.valueOf(yesterday));
    }

    private void setDayFive() {
        TextView dayFive = (TextView) findViewById(R.id.tvDay5);
        Calendar td = Calendar.getInstance();
        td.add(Calendar.DATE, -4);
        dateFive = new java.sql.Date(td.getTimeInMillis());
        Date yesterday = dateFive;
        dayFive.setText(String.valueOf(yesterday));
    }

    private void setDaySix() {
        TextView daySix = (TextView) findViewById(R.id.tvDay6);
        Calendar td = Calendar.getInstance();
        td.add(Calendar.DATE, -5);
        dateSix = new java.sql.Date(td.getTimeInMillis());
        Date yesterday = dateSix;
        daySix.setText(String.valueOf(yesterday));
    }

    private void setDaySeven() {
        TextView daySeven = (TextView) findViewById(R.id.tvDay7);
        Calendar td = Calendar.getInstance();
        td.add(Calendar.DATE, -6);
        dateSeven = new java.sql.Date(td.getTimeInMillis());
        Date yesterday = dateSeven;
        daySeven.setText(String.valueOf(yesterday));
    }


    private void init() {
        btnTotal = (Button) findViewById(R.id.btnTotal);
        btnNextpg = (Button) findViewById(R.id.btnNextPg);

        etFirstNumber = (EditText) findViewById(R.id.etFirstNumber);
        etSecondNumber = (EditText) findViewById(R.id.etSecondNumber);
        etThirdNumber = (EditText) findViewById(R.id.etThirdNumber);
        etFourthNumber = (EditText) findViewById(R.id.etFourthNumber);
        etFifthNumber = (EditText) findViewById(R.id.etFifthNumber);
        etSixthNumber = (EditText) findViewById(R.id.etSixthNumber);
        etSeventhNumber = (EditText) findViewById(R.id.etSeventhNumber);

        tvResult = (TextView) findViewById(R.id.tvResult);

        btnTotal.setOnClickListener(this);
    }


    public void onClick(View view) {

        InputData2 inputData2 = new InputData2(this);
        inputData2.open();


        String num1 = etFirstNumber.getText().toString();
        String num2 = etSecondNumber.getText().toString();
        String num3 = etThirdNumber.getText().toString();
        String num4 = etFourthNumber.getText().toString();
        String num5 = etFifthNumber.getText().toString();
        String num6 = etSixthNumber.getText().toString();
        String num7 = etSeventhNumber.getText().toString();

        if (!num1.equals(null)) {
            inputData2.insertValue(Integer.parseInt(num1));
        }
        if (!num2.equals(null)) {inputData2.insertValue(Integer.parseInt(num2));}
        if (!num3.equals(null)) {inputData2.insertValue(Integer.parseInt(num3));}
        if (!num4.equals(null)) {inputData2.insertValue(Integer.parseInt(num4));}
        if (!num5.equals(null)) {inputData2.insertValue(Integer.parseInt(num5));}
        if (!num6.equals(null)) {inputData2.insertValue(Integer.parseInt(num6));}
        if (!num7.equals(null)) {inputData2.insertValue(Integer.parseInt(num7));}

        inputData2.close();

//        db.setNumMovements(dateOne, Integer.getInteger(num1));
//        db.setNumMovements(dateTwo, Integer.getInteger(num2));
//        db.setNumMovements(dateThree, Integer.getInteger(num3));
//        db.setNumMovements(dateFour, Integer.getInteger(num4));
//        db.setNumMovements(dateFive, Integer.getInteger(num5));
//        db.setNumMovements(dateSix, Integer.getInteger(num6));
//        db.setNumMovements(dateSeven, Integer.getInteger(num7));


        switch (view.getId()) {

            case R.id.btnTotal:
                int total = Integer.parseInt(num1) + Integer.parseInt(num2) +
                        Integer.parseInt(num3) + Integer.parseInt(num4) + Integer.parseInt(num5)
                        + Integer.parseInt(num6) + Integer.parseInt(num7);
                tvResult.setText(String.valueOf(total));
                break;

            //int average = (total / 7);
            //tvAverage.setText(String.valueOf(average));
            //break;


        }
    }


}
