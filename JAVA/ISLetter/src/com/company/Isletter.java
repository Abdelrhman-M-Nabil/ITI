package com.company;

public class Isletter {


    public static boolean isLetter(String letter) {
        if(letter == null || letter == ""){
            return false;
        }
        else{
            return letter.chars().allMatch(Character::isLetter);
            }

        }
    }

