package com.example.eka.study_0326;

import android.text.Editable;

/**
 * Created by eka on 2017. 3. 26..
 */

public class ItemList {
    private String text_memo, text_date;

    public ItemList(String text_memo, String text_date) {
        this.text_memo = text_memo;
        this.text_date = text_date;
    }

    public String getText_memo() {
        return text_memo;
    }

    public void setText_memo(String text_memo) {
        this.text_memo = text_memo;
    }

    public String getText_date() {
        return text_date;
    }

    public void setText_date(String text_date) {
        this.text_date = text_date;
    }
}
