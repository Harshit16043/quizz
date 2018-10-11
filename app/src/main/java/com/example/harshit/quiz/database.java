package com.example.harshit.quiz;

import android.provider.BaseColumns;

public final class database {

    public static class questiontable implements BaseColumns {

        public static final String TABLE_NAME="quiz_quiestions";
        public static final String COLUMN_QUESTION="question";
        public static final String OP1="option1";
        public static final String OP2="option2";
        public static final String COLUMN_ANSWER_NO ="answer_no";
        public static final String ANS_SUBMIT="Ans_Submit";

    }
}
