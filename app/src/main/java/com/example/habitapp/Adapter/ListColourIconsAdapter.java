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

public class ListColourIconsAdapter extends RecyclerView.Adapter<ListColourIconsAdapter.ListColourIconsViewHolder> {
    private Context context;
    private TypedArray colourIcons;
    private int checkedPosition;
    private ColourIconSelected colourIconSelected;

    public ListColourIconsAdapter(Context context, ColourIconSelected colourIconSelected) {
        this.context = context;
        this.colourIconSelected = colourIconSelected;
        this.checkedPosition = 0;
    }

    public void setColourIcons(TypedArray colourIcons) {
        this.colourIcons = colourIcons;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ListColourIconsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_colour_icons_item, parent, false);
        return new ListColourIconsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListColourIconsViewHolder holder, int position) {
        holder.bind(colourIcons, position);
    }

    @Override
    public int getItemCount() {
        if(colourIcons == null){
            return 0;
        }else{
            return colourIcons.length();
        }
    }

    public int getSelected(){
        if(checkedPosition != -1){
            return colourIcons.getResourceId(checkedPosition, 0);
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
        private ImageView list_colour_icon;

        public ListColourIconsViewHolder(@NonNull View itemView) {
            super(itemView);
            list_colour_icon = itemView.findViewById(R.id.list_colour_icon);
        }

        public void bind(TypedArray icon, int position){
            if(checkedPosition == -1){
                list_colour_icon.setBackgroundResource(R.drawable.unselected_icon_background);
            }
            else{
                if(checkedPosition == getAdapterPosition()){
                    list_colour_icon.setBackgroundResource(R.drawable.selected_icon_background);
                }
                else{
                    list_colour_icon.setBackgroundResource(R.drawable.unselected_icon_background);
                }
            }
            list_colour_icon.setImageResource(icon.getResourceId(position, 0));
            list_colour_icon.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            list_colour_icon.setBackgroundResource(R.drawable.selected_icon_background);
            if(checkedPosition != getAdapterPosition()){
                notifyItemChanged(checkedPosition);
                checkedPosition = getAdapterPosition();
            }
            colourIconSelected.onColourItemClicked(checkedPosition);
        }
    }

    public interface ColourIconSelected {
        void onColourItemClicked(int position);
    }
}
