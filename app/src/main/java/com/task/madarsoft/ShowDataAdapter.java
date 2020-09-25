package com.task.madarsoft;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.task.madarsoft.appRoomDataBase.InfoModel;
import com.task.madarsoft.databinding.SaveDataItemBinding;

import java.util.List;

public class ShowDataAdapter extends RecyclerView.Adapter<ShowDataAdapter.ViewHolder> {

    List<InfoModel> infoModelList;

    public ShowDataAdapter(List<InfoModel> infoModelList) {
        this.infoModelList = infoModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.save_data_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.saveDataItemBinding.tvNameSave.setText(infoModelList.get(position).getName());
        viewHolder.saveDataItemBinding.tvAgeSave.setText(String.valueOf(infoModelList.get(position).getAge()));
        viewHolder.saveDataItemBinding.tvJobSave.setText(infoModelList.get(position).getJob());
        viewHolder.saveDataItemBinding.tvGenderSave.setText(infoModelList.get(position).getGender());

    }

    @Override
    public int getItemCount() {
        if (infoModelList == null)
            return 0;
        return infoModelList.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder {

        SaveDataItemBinding saveDataItemBinding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bind();
        }


        void bind() {
            if (saveDataItemBinding == null) {
                saveDataItemBinding = DataBindingUtil.bind(itemView);

            }
        }

    }


}
