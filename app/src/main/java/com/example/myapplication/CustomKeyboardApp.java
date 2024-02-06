package com.example.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.os.Bundle;
import android.os.IBinder;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;



public class CustomKeyboardApp extends InputMethodService implements KeyboardView.OnKeyboardActionListener {

    private Context context;
    private boolean caps = false;
    private boolean custom = false;
    private KeyboardView keyboardView;
    private Keyboard keyboard;

    Calendar calendar = Calendar.getInstance();
    Date currentDate = calendar.getTime();

    int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
    boolean isDateEven = (dayOfMonth % 2 == 0);



    @Override
    public View onCreateInputView() {

        keyboardView = (KeyboardView) getLayoutInflater().inflate(R.layout.custom_layout, null);
        keyboard = new Keyboard(this, R.xml.custom_keypad);
        keyboardView.setKeyboard(keyboard);
        keyboardView.setOnKeyboardActionListener(this);
        return keyboardView;
        }

    @Override
    public void onRelease(int i) {

    }

    public void encrypt(int primaryCode){
        InputConnection inputConnection = getCurrentInputConnection();
        int num = primaryCode;
        num = num+2;
        char dis = (char) num;
        inputConnection.commitText(String.valueOf(dis), 1);
    }
    public void encryptw(int primaryCode){
        InputConnection inputConnection = getCurrentInputConnection();
        int num = primaryCode;
        num = num+3;
        char dis = (char) num;
        inputConnection.commitText(String.valueOf(dis), 1);
    }


    @Override
    public void onKey(int primaryCode, int[] keyCodes) {
        InputConnection inputConnection = getCurrentInputConnection();
        if (inputConnection != null) {
            switch(primaryCode) {
                case Keyboard.KEYCODE_DELETE :
                    CharSequence selectedText = inputConnection.getSelectedText(0);

                    if (TextUtils.isEmpty(selectedText)) {
                        inputConnection.deleteSurroundingText(1, 0);
                    } else {
                        inputConnection.commitText("", 1);
                    }
                case Keyboard.KEYCODE_SHIFT:
                    caps = !caps;
                    keyboard.setShifted(caps);
                    keyboardView.invalidateAllKeys();
                    break;

                    ///**************************//

                case Keyboard.KEYCODE_DONE:
                    inputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                    break;

               
                default :
                    char code = (char) primaryCode;

                    if(Character.isLetter(code) && caps){
                        code = Character.toUpperCase(code);

                        if (isDateEven) {
                            encryptw(primaryCode);
                        } else {
                            encrypt(primaryCode);
                        }


                    }
                    else{
                        inputConnection.commitText(String.valueOf(code), 1);
                    }
//

            }
        }


    }


    @Override
    public void onPress(int i) {

    }

    @Override
    public void onText(CharSequence charSequence) {

    }

    @Override
    public void swipeLeft() {

    }

    @Override
    public void swipeRight() {

    }

    @Override
    public void swipeDown() {

    }

    @Override
    public void swipeUp() {

    }

}

