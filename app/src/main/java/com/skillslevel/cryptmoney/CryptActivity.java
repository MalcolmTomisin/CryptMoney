package com.skillslevel.cryptmoney;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import static com.skillslevel.cryptmoney.MainActivity.cryptName;

public class CryptActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crypt);

        Intent intent = getIntent();
        String name = intent.getStringExtra(cryptName);
        String priceUsd = intent.getStringExtra(MainActivity.priceUsd);
        String priceBtc = intent.getStringExtra(MainActivity.priceBtc);
        String marketCap = intent.getStringExtra(MainActivity.marketCap);
        String percentChange = intent.getStringExtra(MainActivity.percentChange);
        String lastUpdated = intent.getStringExtra(MainActivity.lastUpdated);

        TextView tv1 = findViewById(R.id.text_name);
        TextView tv2 = findViewById(R.id.text_price_usd);
        TextView tv3 = findViewById(R.id.text_price_btc);
        TextView tv4 = findViewById(R.id.market_cap);
        TextView tv5 = findViewById(R.id.percent_change);
        TextView tv6 = findViewById(R.id.last_update);
        ImageView imageView = findViewById(R.id.imageView2);

        tv1.setText(name);
        tv2.setText(priceUsd);
        tv3.setText(priceBtc);
        tv4.setText(marketCap);
        tv5.setText(percentChange);
        tv6.setText(lastUpdated);

    }
}
