package com.example.myapplication;

import android.content.Context;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.util.AttributeSet;

public class CustomKeyboardView extends android.inputmethodservice.KeyboardView {
    public CustomKeyboardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setKeyboard(Keyboard keyboard) {
        super.setKeyboard(keyboard);
    }


}
