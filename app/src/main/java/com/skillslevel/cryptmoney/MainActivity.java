package com.skillslevel.cryptmoney;

import android.app.DownloadManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements CryptoRecyclerViewAdapter.OnItemClickListener {
    public static final String cryptName = "CryptoCurrency";
    public static final String priceUsd = "priceUsd";
    public static final String priceBtc = "priceBtc";
    public static final String marketCap = "marketCap";
    public static final String percentChange = "percentChange";
    public static final String lastUpdated = "lastUpdated";

    private RecyclerView recyclerView;
    private CryptoRecyclerViewAdapter cryptoRecyclerViewAdapter;
    private ArrayList<CryptoCurrency> cryptoCurrencyArrayList;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        cryptoCurrencyArrayList = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(this);

        parseJSonAPI();
    }

    private void parseJSonAPI() {
        String URL = "https://api.coinmarketcap.com/v1/ticker/?limit=50";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject jsonObject = response.getJSONObject(i);
                        String name = jsonObject.getString("name");
                        String id = jsonObject.getString("id");
                        String symbol = jsonObject.getString("symbol");
                        String rank = jsonObject.getString("rank");
                        String price_usd = "$ "+ jsonObject.getString("price_usd");
                        String price_btc = jsonObject.getString("price_btc");
                        String _24h_volume_usd = "$ "+ jsonObject.getString("24h_volume_usd");
                        String market_cap_usd = jsonObject.getString("market_cap_usd");
                        String available_supply = jsonObject.getString("available_supply");
                        String total_supply = jsonObject.getString("total_supply");
                        String percent_change_1h = jsonObject.getString("percent_change_1h") + "%";
                        String percent_change_24h = jsonObject.getString("percent_change_24h") + "%";
                        String percent_change_7d = jsonObject.getString("percent_change_7d") + "%";
                        String last_updated = jsonObject.getString("last_updated");

                        Time time = new Time(Long.parseLong(last_updated));

                       String time_updated = time.toString();

                        cryptoCurrencyArrayList.add(new CryptoCurrency(id,symbol,name,rank,price_usd,price_btc, _24h_volume_usd,
                                market_cap_usd, available_supply,total_supply,percent_change_1h,percent_change_24h,
                                percent_change_7d, time_updated  ));

                    }
                    CryptoRecyclerViewAdapter cryptoRecyclerViewAdapter =
                            new CryptoRecyclerViewAdapter(cryptoCurrencyArrayList, MainActivity.this);
                    recyclerView.setAdapter(cryptoRecyclerViewAdapter);
                    cryptoRecyclerViewAdapter.setOnItemClickListener(MainActivity.this);
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, CryptActivity.class);
        CryptoCurrency cryptoCurrency = cryptoCurrencyArrayList.get(position);

        intent.putExtra(cryptName, cryptoCurrency.get_name());
        intent.putExtra(priceUsd, cryptoCurrency.get_price_usd());
        intent.putExtra(priceBtc, cryptoCurrency.get_price_btc());
        intent.putExtra(marketCap, cryptoCurrency.get_market_cap_usd());
        intent.putExtra(percentChange, cryptoCurrency.get_percent_change_1h());
        intent.putExtra(lastUpdated, cryptoCurrency.get_last_updated());

        startActivity(intent);
    }
}
