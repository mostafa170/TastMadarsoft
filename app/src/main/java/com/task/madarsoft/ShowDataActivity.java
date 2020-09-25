package com.task.madarsoft;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.AsyncTask;
import android.os.Bundle;

import com.task.madarsoft.appRoomDataBase.AppDataBase;
import com.task.madarsoft.appRoomDataBase.InfoModel;
import com.task.madarsoft.databinding.ActivityShowDataBinding;

import java.util.List;

public class ShowDataActivity extends AppCompatActivity {

    ActivityShowDataBinding binding;
    List<InfoModel> mylist;
    ShowDataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_show_data);
        binding.setLifecycleOwner(this);
        initView();
        onClickListener();
    }
    private void initView(){
        adapter =  new ShowDataAdapter(null);
        binding.rvGetInfo.setLayoutManager(new LinearLayoutManager(this));
        binding.rvGetInfo.setAdapter(adapter);
    }

    private void onClickListener(){

        class GetData extends AsyncTask<Void,Void,List<InfoModel>> {

            @Override
            protected List<InfoModel> doInBackground(Void... voids) {
                mylist = AppDataBase.
                        getInstance()
                        .classDAO().
                                getAllSources();
                return mylist;

            }

            @Override
            protected void onPostExecute(List<InfoModel> myDataList) {

                adapter = new ShowDataAdapter(mylist);
                binding.rvGetInfo.setAdapter(adapter);
                super.onPostExecute(myDataList);
            }
        }
        GetData gd=new GetData();
        gd.execute();

    }

}