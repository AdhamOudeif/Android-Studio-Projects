package com.cosc426.encryption;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

//Pass key and input string to Model class
public class Model
{
    private int key;

    //Persistent data constructor
    public Model(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        key = preferences.getInt("KEY", 0); //initial value 0
    }

    public int getKey() {
        return key;
    }

    public void set(int key)
    {
        this.key = key;
    }

    //Method to save persistent data
    public void savePreferences(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("KEY", key);
        editor.apply();
    }
    //encryption
    public String encrypt(String input)
    {
        String output = "";

        for (int i = 0; i < input.length(); i++) {
            if (Character.isLetter(input.charAt(i)))
                output = output + encrypt(input.charAt(i));
            else
                output = output + input.charAt(i);
        }

        return output;
    }
    //decryption
    public String decrypt(String input)
    {
        String output = "";

        for (int i = 0; i < input.length(); i++) {
            if (Character.isLetter(input.charAt(i)))
                output = output + decrypt(input.charAt(i));
            else
                output = output + input.charAt(i);
        }

        return output;
    }
    //circle of 52 rotations
    private char encrypt(char letter)
    {
        int code = code(letter);

        code = (code + key%52)%52;

        return character(code);
    }

    private char decrypt(char letter)
    {
        int code = code(letter);

        code = (code - key%52 + 52)%52;

        return character(code);
    }
    //A-Z
    private int code(char letter)
    {
        if (Character.isLowerCase(letter))
            return (int)letter - (int)'a';
        else
            return (int)letter - (int)'A' + 26;
    }
    //a-z
    private char character(int code)
    {
        if (code < 26)
            return (char)((int)'a' + code);
        else
            return (char)((int)'A' + code - 26);
    }
}