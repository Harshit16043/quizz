package com.example.harshit.quiz;


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.harshit.quiz.MainActivity.list;
import static com.example.harshit.quiz.SimpleRVAdapter.xx;


/**
 * A simple {@link Fragment} subclass.
 */
public class questiondetail extends Fragment {

    private database2 db;
    int x;

    public questiondetail() {
        // Required empty public constructor
    }
    String ans = null;
    int c;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_questiondetail, container, false);
        TextView textView2 = (TextView) view.findViewById(R.id.textView2);
        Button b2 = (Button) view.findViewById(R.id.button2);
        db=new database2(getContext());
        Bundle bundle = getArguments();
        if(bundle!= null){

           if( bundle.getString("selecteddata")!=null){
               String text = null;
               x=Integer.parseInt(bundle.getString("selecteddata"));
               text= list.get(x).getQuestion();

               textView2.setText(text);
           }
        }




        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // find which radio button is selected
                if(checkedId == R.id.radioButton) {
                  //  Toast.makeText(getActivity().getApplicationContext(), Integer.toString(checkedId),
                          //  Toast.LENGTH_SHORT).show();
                    c=checkedId;
                } else if(checkedId == R.id.radioButton2) {
                   // Toast.makeText(getActivity().getApplicationContext(), Integer.toString(checkedId),
                          //  Toast.LENGTH_SHORT).show();
                    c=checkedId;

                }
         }

        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(),"Text!",Toast.LENGTH_SHORT).show();

                if(c==2131165289)
                {
                    ans="True";
                }
                else if (c==2131165290)
                {
                    ans = "False";

                }
                System.out.println(ans);
                db.abc(ans,x);


               String table = "quiz_quiestions";





              /* Question q= new Question();
               q.setAns_submit(ans);
                ContentValues cv = new ContentValues();
                cv.put(database.questiontable.ANS_SUBMIT, q.getAns_submit());
             //   db.insert(database.questiontable.TABLE_NAME, null,cv);
                String a= database.questiontable._ID;




                 db.update(table , cv ,"_id="+a, null);*/

               // Toast.makeText(getActivity(),ans,Toast.LENGTH_SHORT).show();


                }
                });








        return view;
    }

}
