package com.example.harshit.quiz;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.security.AccessController;
import java.util.ArrayList;
import java.util.List;



import static com.example.harshit.quiz.MainActivity.list;
import static com.example.harshit.quiz.MainActivity.myDataset;


/**
 * A simple {@link Fragment} subclass.
 */
public class Recycler extends Fragment {


    public Recycler() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

       // View view = inflater.inflate(R.layout.fragment_recycler, container,false);
       // ArrayList<String> myData =  new ArrayList<>();
       String[] myData =  new String[34];
        myData=myDataset;

        RecyclerView rv = new RecyclerView(getContext());
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(new SimpleRVAdapter(myData,getActivity(),rv));

        return rv;


        //ArrayAdapter<String> adapter =new ArrayAdapter<String >(getContext(),android.R.layout.simple_list_item_1,myData);

       /* ListView listre = (ListView) view.findViewById(R.id.listre);
        listre.setAdapter(adapter);*/

      /* listre.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                questiondetail detailfragment = new questiondetail();
                Bundle bundle = new Bundle();
                String text = null;
               text= list.get(position).getQuestion();


                bundle.putString("selecteddata",text );
                detailfragment.setArguments(bundle);
                FragmentManager manager= getFragmentManager();
                manager.beginTransaction().replace(R.id.detaillayout, detailfragment).commit();
            }
        });*/

      // return view;

    }
}


class SimpleRVAdapter extends RecyclerView.Adapter<SimpleViewHolder> {

    static int  xx;
    private String[] dataSource;
    View rv;

    Context context;
    public SimpleRVAdapter(String[] dataArgs, Context context,View r){
        dataSource = dataArgs;
        this.context=context;
        rv=r;


    }






    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = new TextView(parent.getContext());
        SimpleViewHolder viewHolder = new SimpleViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, int position) {
        holder.textView.setText(dataSource[position]);

        holder.textView.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                //Toast.makeText( context,"Text!",Toast.LENGTH_SHORT).show();

                questiondetail detailfragment = new questiondetail();
                Bundle bundle = new Bundle();
                String text = null;
                text= list.get(position).getQuestion();


                bundle.putString("selecteddata",String.valueOf(position) );
                detailfragment.setArguments(bundle);
                android.support.v4.app.FragmentTransaction tx = ((MainActivity)context).getSupportFragmentManager().beginTransaction();
                tx.replace(R.id.detaillayout, detailfragment);
                tx.commit();

                xx=position;




            }


        });


    }

    @Override
    public int getItemCount() {
        return dataSource.length;
    }






}



class SimpleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView textView;
    public SimpleViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView;
        textView.setTextSize(25);


    }

    @Override
    public void onClick(View v) {

        Context context = null;
        Toast.makeText(context,"Text!",Toast.LENGTH_SHORT).show();

    }
}







