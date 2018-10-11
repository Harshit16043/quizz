package com.example.harshit.quiz;

import android.os.Parcel;


public class Question {
    private String question;
    private int ans;
    private String op1;
    private String op2;
    private String ans_submit;

    public String getAns_submit() {
        return ans_submit;
    }

    public void setAns_submit(String ans_submit) {
        this.ans_submit = ans_submit;
    }

    public Question() {
    }

    public Question(String question, int ans, String op1, String op2) {
        this.question = question;
        this.ans = ans;
        this.op1 = op1;
        this.op2 = op2;

    }


    protected Question(Parcel in) {
        question = in.readString();
        ans = in.readInt();
        op1 = in.readString();
        op2 = in.readString();
    }


    public String getOp1() {
        return op1;
    }

    public void setOp1(String op1) {
        this.op1 = op1;
    }

    public String getOp2() {
        return op2;
    }

    public void setOp2(String op2) {
        this.op2 = op2;
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getAns() {
        return ans;
    }

    public void setAns(int ans) {
        this.ans = ans;
    }
}
