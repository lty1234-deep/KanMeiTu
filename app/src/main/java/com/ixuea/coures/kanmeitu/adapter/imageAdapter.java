package com.ixuea.coures.kanmeitu.adapter;

import android.app.Activity;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ixuea.coures.kanmeitu.R;
import com.ixuea.coures.kanmeitu.domain.Image;
import com.ixuea.coures.kanmeitu.util.ImageUtil;

import java.util.ArrayList;
import java.util.List;

import static android.view.LayoutInflater.from;

public class imageAdapter extends RecyclerView.Adapter <imageAdapter.ViewHolder>{

    private final Context context;
    private final LayoutInflater inflater;
    private List<Image> datas = new ArrayList<Image>();
    ImageView iv;
    private OnItemClickListener onItemClickListener;

    public imageAdapter(Context context){
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_image,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(datas.get(position));

        if (onItemClickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(position);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void setDatas(List<Image> datas){
        this.datas.clear();
        this.datas.addAll(datas);

        notifyItemRangeInserted(0,this.datas.size());
    }

    public Image getData(int position) {
        return datas.get(position);
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv =itemView.findViewById(R.id.iv);
        }

        public void bindData(Image image){
            ImageUtil.show((Activity)context,iv,image.getUri());

        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{

        void onItemClick(int position);
    }
}
