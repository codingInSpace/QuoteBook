package com.example.quotebook;

/**
 * Created by Jonathan on 2/10/2015.
 */
public class Quote {
    private int _id;
    private String _quotetext;
    private String _author;

    public Quote() {
    }

    public Quote(String quotetext, String author){
        this._quotetext = quotetext;
        this._author = author;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_quotetext(String _quotetext) {
        this._quotetext = _quotetext;
    }

    public void set_author(String _author) {
        this._author = _author;
    }

    public int get_id() {
        return _id;
    }

    public String get_quotetext() {
        return _quotetext;
    }

    public String get_author() {
        return _author;
    }
}
