package com.skillslevel.cryptmoney;

public class CryptoCurrency {
    private String _id;

    public CryptoCurrency(String _id, String _symbol, String _name, String _rank, String _price_usd,
                          String _price_btc, String _24h_volume_usd, String _market_cap_usd,
                          String _available_supply, String _total_supply, String _percent_change_1h,
                          String _percent_change_24h, String _percent_change_7d, String _last_updated) {
        this._id = _id;
        this._symbol = _symbol;
        this._name = _name;
        this._rank = _rank;
        this._price_usd = _price_usd;
        this._price_btc = _price_btc;
        this._24h_volume_usd = _24h_volume_usd;
        this._market_cap_usd = _market_cap_usd;
        this._available_supply = _available_supply;
        this._total_supply = _total_supply;
        this._percent_change_1h = _percent_change_1h;
        this._percent_change_24h = _percent_change_24h;
        this._percent_change_7d = _percent_change_7d;
        this._last_updated = _last_updated;
    }

    private String _symbol;
    private String _name;
    private String _rank;
    private String _price_usd;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_symbol() {
        return _symbol;
    }

    public void set_symbol(String _symbol) {
        this._symbol = _symbol;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_rank() {
        return _rank;
    }

    public void set_rank(String _rank) {
        this._rank = _rank;
    }

    public String get_price_usd() {
        return _price_usd;
    }

    public void set_price_usd(String _price_usd) {
        this._price_usd = _price_usd;
    }

    public String get_price_btc() {
        return _price_btc;
    }

    public void set_price_btc(String _price_btc) {
        this._price_btc = _price_btc;
    }

    public String get_24h_volume_usd() {
        return _24h_volume_usd;
    }

    public void set_24h_volume_usd(String _24h_volume_usd) {
        this._24h_volume_usd = _24h_volume_usd;
    }

    public String get_market_cap_usd() {
        return _market_cap_usd;
    }

    public void set_market_cap_usd(String _market_cap_usd) {
        this._market_cap_usd = _market_cap_usd;
    }

    public String get_available_supply() {
        return _available_supply;
    }

    public void set_available_supply(String _available_supply) {
        this._available_supply = _available_supply;
    }

    public String get_total_supply() {
        return _total_supply;
    }

    public void set_total_supply(String _total_supply) {
        this._total_supply = _total_supply;
    }

    public String get_percent_change_1h() {
        return _percent_change_1h;
    }

    public void set_percent_change_1h(String _percent_change_1h) {
        this._percent_change_1h = _percent_change_1h;
    }

    public String get_percent_change_24h() {
        return _percent_change_24h;
    }

    public void set_percent_change_24h(String _percent_change_24h) {
        this._percent_change_24h = _percent_change_24h;
    }

    public String get_percent_change_7d() {
        return _percent_change_7d;
    }

    public void set_percent_change_7d(String _percent_change_7d) {
        this._percent_change_7d = _percent_change_7d;
    }

    public String get_last_updated() {
        return _last_updated;
    }

    public void set_last_updated(String _last_updated) {
        this._last_updated = _last_updated;
    }

    private String _price_btc;
    private String _24h_volume_usd;
    private String _market_cap_usd;
    private String _available_supply;
    private String _total_supply;
    // private double _max_supply;
    private String _percent_change_1h;
    private String _percent_change_24h;
    private String _percent_change_7d;
    private String _last_updated;

    public CryptoCurrency() {
    }
}
