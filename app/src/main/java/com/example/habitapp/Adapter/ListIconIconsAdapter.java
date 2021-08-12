package com.example.habitapp.Adapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.habitapp.R;

public class ListIconIconsAdapter extends RecyclerView.Adapter<ListIconIconsAdapter.ListColourIconsViewHolder> {
    private Context context;
    private TypedArray iconIcons;
    private int checkedPosition;
    private IconIconSelected iconIconSelected;

    public ListIconIconsAdapter(Context context, IconIconSelected iconIconSelected) {
        this.context = context;
        this.iconIconSelected = iconIconSelected;
        this.checkedPosition = 0;
    }

    public void setIconIcons(TypedArray iconIcons) {
        this.iconIcons = iconIcons;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ListColourIconsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_icon_icons_item, parent, false);
        return new ListColourIconsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListColourIconsViewHolder holder, int position) {
        holder.bind(iconIcons, position);
    }

    @Override
    public int getItemCount() {
        if(iconIcons == null){
            return 0;
        }else{
            return iconIcons.length();
        }
    }

    public int getSelected(){
        if(checkedPosition != -1){
            return iconIcons.getResourceId(checkedPosition, 0);
        }
        return -1;
    }

    public void setSelected(int checkedPosition){
        this.checkedPosition = checkedPosition;
    }

    public int getCheckedPosition(){
        return checkedPosition;
    }

    class ListColourIconsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView list_icon_icon;

        public ListColourIconsViewHolder(@NonNull View itemView) {
            super(itemView);
            list_icon_icon = itemView.findViewById(R.id.list_icon_icon);
        }

        public void bind(TypedArray icon, int position){
            if(checkedPosition == -1){
                list_icon_icon.setBackgroundResource(R.drawable.unselected_icon_background);
            }
            else{
                if(checkedPosition == getAdapterPosition()){
                    list_icon_icon.setBackgroundResource(R.drawable.selected_icon_background);
                }
                else{
                    list_icon_icon.setBackgroundResource(R.drawable.unselected_icon_background);
                }
            }
            list_icon_icon.setImageResource(icon.getResourceId(position, 0));
            list_icon_icon.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            list_icon_icon.setBackgroundResource(R.drawable.selected_icon_background);
            if(checkedPosition != getAdapterPosition()){
                notifyItemChanged(checkedPosition);
                checkedPosition = getAdapterPosition();
            }
            iconIconSelected.onIconItemClicked(checkedPosition);
        }
    }

    public interface IconIconSelected {
        void onIconItemClicked(int position);
    }
}
