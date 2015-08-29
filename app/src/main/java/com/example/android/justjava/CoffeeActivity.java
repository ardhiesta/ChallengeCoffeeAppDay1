package com.example.android.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CoffeeActivity extends AppCompatActivity {
    EditText etPrice;
    Button bMinus;
    Button bPlus;
    TextView tvQty;
    EditText etTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);

        etPrice = (EditText) findViewById(R.id.etPrice);
        bMinus = (Button) findViewById(R.id.bMinus);
        bPlus = (Button) findViewById(R.id.bPlus);
        tvQty = (TextView) findViewById(R.id.tvQty);
        etTotal = (EditText) findViewById(R.id.etTotal);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_coffee, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //kurangi jumlah kopi, sekaligus menghitung total harga
    public void decrementQty(View view){
        int coffeeQty = Integer.parseInt(tvQty.getText().toString());
        if(coffeeQty > 0){
            coffeeQty--;
        }

        tvQty.setText(String.valueOf(coffeeQty));

        if(!etPrice.getText().toString().equals("")){
            int hargaSatuan = Integer.parseInt(etPrice.getText().toString());
            int total = coffeeQty * hargaSatuan;
            etTotal.setText(String.valueOf(total));
        }
    }

    //tambah jumlah kopi, sekaligus menghitung total harga
    public void incrementQty(View view){
        int coffeeQty = Integer.parseInt(tvQty.getText().toString());
//        if(coffeeQty >= 0){
//            coffeeQty--;
//        }
        coffeeQty++;

        tvQty.setText(String.valueOf(coffeeQty));

        if(!etPrice.getText().toString().equals("")){
            int hargaSatuan = Integer.parseInt(etPrice.getText().toString());
            int total = coffeeQty * hargaSatuan;
            etTotal.setText(String.valueOf(total));
        }

    }
}
