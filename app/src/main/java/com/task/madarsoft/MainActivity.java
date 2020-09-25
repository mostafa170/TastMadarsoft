package com.task.madarsoft;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.task.madarsoft.appRoomDataBase.AppDataBase;
import com.task.madarsoft.appRoomDataBase.InfoModel;
import com.task.madarsoft.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.setLifecycleOwner(this);
        onClickListener();
    }

    private void onClickListener (){
        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.etInfoName.getText().toString().isEmpty()){
                    binding.etInfoName.setError("please insert");
                }else if (binding.etInfoAge.getText().toString().isEmpty()){
                    binding.etInfoAge.setError("please insert");
                }else if (binding.etInfoJob.getText().toString().isEmpty()){
                    binding.etInfoJob.setError("please insert");
                }else if (binding.etInfoGender.getText().toString().isEmpty()){
                    binding.etInfoGender.setError("please insert");
                }else {
                    Toast.makeText(getApplication(), "Done", Toast.LENGTH_SHORT).show();
                    InfoModel infoModel =  new InfoModel();
                    infoModel.setName(binding.etInfoName.getText().toString());
                    infoModel.setAge(Integer.parseInt(binding.etInfoAge.getText().toString()));
                    infoModel.setGender(binding.etInfoGender.getText().toString());
                    infoModel.setJob(binding.etInfoJob.getText().toString());
                    InsertToDataBase th =new InsertToDataBase(infoModel);
                    th.start();
                    startActivity(new Intent(MainActivity.this,ShowDataActivity.class));
                }
            }
        });
    }


    class InsertToDataBase extends Thread{
        InfoModel itemsToInsert;

        public InsertToDataBase(InfoModel items){
            itemsToInsert = items;
        }

        public void run(){
            AppDataBase.
                    getInstance()
                    .classDAO().
                    insertSource(itemsToInsert);
        }
    }

}