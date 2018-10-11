package com.example.harshit.quiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Button;


import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import static com.example.harshit.quiz.SimpleRVAdapter.xx;

public class database2 extends SQLiteOpenHelper {
    private static final String DB_NAME="quiz.db";
    private static final int DB_VERSION=6;
    private SQLiteDatabase db;
String a=database.questiontable.TABLE_NAME;

    public database2(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        }

    @Override
    public void onCreate(SQLiteDatabase db) {
            this.db=db;

            final String QUESTIONS_TABLE = "CREATE TABLE "+
                    database.questiontable.TABLE_NAME + " ( " +
                    database.questiontable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    database.questiontable.COLUMN_QUESTION + " TEXT, "+
                    database.questiontable.OP1 + " TEXT, " +
                    database.questiontable.OP2 + " TEXT, " +
                    database.questiontable.ANS_SUBMIT + " TEXT, "+
                    database.questiontable.COLUMN_ANSWER_NO + " INTEGER"+

                    ")";
            db.execSQL(QUESTIONS_TABLE);
            questions_list();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + database.questiontable.TABLE_NAME);
        onCreate(db);

    }
    public  void  abc (String x, int sn)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String a= "update "+database.questiontable.TABLE_NAME+" SET "+ database.questiontable.ANS_SUBMIT +" = '"+x+"' where "+database.questiontable._ID+" = "+ sn;
        db.execSQL(a);
    }

    private void questions_list(){

        Question q1 = new Question("The Language that the computer can understand is called Machine Language." ,1, "TRUE","FALSE");
        addquestion(q1);
        Question q2 = new Question("Magnetic Tape used random access method." ,2, "TRUE","FALSE");
        addquestion(q2);
        Question q3 = new Question("Twitter is an online social networking and blogging service.",2, "TRUE","FALSE");
        addquestion(q3);
        Question q4 = new Question("Worms and trojan horses are easily detected and eliminated by antivirus software." ,1, "TRUE","FALSE");
        addquestion(q4);
        Question q5 = new Question("Dot matrix Deskjet Inkjet and Laser are all types of Printers." ,1, "TRUE","FALSE");
        addquestion(q5);
        Question q6 = new Question("GNU / Linux is a open source operating system." ,1, "TRUE","FALSE");
        addquestion(q6);
        Question q7 = new Question("Whaling / Whaling attack is a kind of phishing attacks that target senior executives and other high profile to access valuable information." ,1, "TRUE","FALSE");
        addquestion(q7);
        Question q8 = new Question("Freeware is software that is available for use at no monetary cost." ,1, "TRUE","FALSE");
        addquestion(q8);
        Question q9 = new Question("IPv6 Internet Protocol address is represented as eight groups of four Octal digits." ,2, "TRUE","FALSE");
        addquestion(q9);
        Question q10 = new Question("The hexadecimal number system contains digits from 1 - 15" ,2, "TRUE","FALSE");
        addquestion(q10);
        Question q11 = new Question("Octal number system contains digits from 0 - 7." ,1, "TRUE","FALSE");
        addquestion(q11);
        Question q12 = new Question("MS Word is a hardware." ,2, "TRUE","FALSE");
        addquestion(q12);
        Question q13 = new Question("CPU controls only input data of computer." ,2, "TRUE","FALSE");
        addquestion(q13);
        Question q14 = new Question("CPU stands for Central Performance Unit." ,2, "TRUE","FALSE");
        addquestion(q14);
        Question q15 = new Question("If you want to respond to the sender of a message click the Respond button." ,2, "TRUE","FALSE");
        addquestion(q15);
        Question q16 = new Question(" You can store Web-based e-mail messages in online folders. " ,1, "TRUE","FALSE");
        addquestion(q16);
        Question q17 = new Question("You can delete e-mails from a Web-based e-mail account" ,1, "TRUE","FALSE");
        addquestion(q17);
        Question q18 = new Question("You can only store messages in a new folder if they are received after you create the folder." ,2, "TRUE","FALSE");
        addquestion(q18);
        Question q19 = new Question(" New folders must all be at the same level." ,2, "TRUE","FALSE");
        addquestion(q19);
        Question q20 = new Question("There is only one way to create a new folder." ,2, "TRUE","FALSE");
        addquestion(q20);
        Question q21 = new Question("Your password should be something others will be able to figured out such as your birthday or wedding anniversary. " ,2, "TRUE","FALSE");
        addquestion(q21);
        Question q22 = new Question("You cannot send a file from a Web-based e-mail account." ,2, "TRUE","FALSE");
        addquestion(q22);
        Question q23 = new Question("Your e-mail address must be unique. " ,1, "TRUE","FALSE");
        addquestion(q23);
        Question q24 = new Question("All attachment are safe." ,2, "TRUE","FALSE");
        addquestion(q24);
        Question q25 = new Question("It is impossible to send a worm or virus over the Internet using in attachment." ,2, "TRUE","FALSE");
        addquestion(q25);
        Question q26 = new Question(" You can only send one attachment per e-mail message." ,2, "TRUE","FALSE");
        addquestion(q26);
        Question q27 = new Question("There is only one way to delete a message." ,2, "TRUE","FALSE");
        addquestion(q27);
        Question q28 = new Question("The Delete key is for deleting text it will not delete messages from your Inbox." ,2, "TRUE","FALSE");
        addquestion(q28);
        Question q29 = new Question("Pressing the Delete key and clicking the Delete button produce the same result." ,1, "TRUE","FALSE");
        addquestion(q29);
        Question q30 = new Question(" In Outlook you must store all of your messages in the Inbox." ,2, "TRUE","FALSE");
        addquestion(q30);










    }

    private void addquestion(Question ques){

        ContentValues cv = new ContentValues();
        cv.put(database.questiontable.COLUMN_QUESTION, ques.getQuestion());
        cv.put(database.questiontable.OP1, ques.getOp1());
        cv.put(database.questiontable.OP2,ques.getOp2());
        cv.put(database.questiontable.COLUMN_ANSWER_NO,ques.getAns());

        db.insert(database.questiontable.TABLE_NAME, null,cv);


    }



    public List<Question> getallquestions(){


        List<Question> list = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + database.questiontable.TABLE_NAME,null);

        if(c.moveToFirst())
        {

            do{
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(database.questiontable.COLUMN_QUESTION)));
                question.setOp1(c.getString(c.getColumnIndex(database.questiontable.OP1)));
                question.setOp2(c.getString(c.getColumnIndex(database.questiontable.OP2)));
                question.setAns(c.getInt(c.getColumnIndex(database.questiontable.COLUMN_ANSWER_NO)));
                list.add(question);

            }while (c.moveToNext());
        }

        c.close();
        return list;
    }

  /* public void convert (FileOutputStream out)

    {
        SQLiteDatabase db=this.getWritableDatabase();
        String Filename="data.csv";

        Cursor cursor=db.query(a,null,null,null,null,null,null);
        for(int i=1;i<31;i++){
            String enter;
            String qu;
            String op1;
            String op2;
            String ans_submit;
            String ans_no;

            cursor.moveToPosition(i-1);
             qu=cursor.getString(cursor.getColumnIndex("question"));
            op1=cursor.getString(cursor.getColumnIndex("option1"));
             op2=cursor.getString(cursor.getColumnIndex("option2"));
             ans_submit=cursor.getString(cursor.getColumnIndex("Ans_Submit"));
             ans_no = cursor.getString(cursor.getColumnIndex("answer_no"));
            enter =qu+","+op1+","+op2+","+ans_submit+","+ans_no+","+"\n";
            try{
                out.write(enter.getBytes());
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }*/




}



