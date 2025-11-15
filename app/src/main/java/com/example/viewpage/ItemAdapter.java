package com.example.viewpage;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private final List<ItemData> itemList;

    public ItemAdapter(List<ItemData> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        ItemData item = itemList.get(position);
        holder.title.setText(item.getTitle());

        // Giả lập nội dung dài hơn cho Staggered Layout
        String description = item.getDescription();
        if (position % 3 == 0) {
            description += "\nThêm một dòng nữa để xem Staggered Layout hoạt động.";
        }
        holder.description.setText(description);

        // Giả lập đặt hình ảnh
        // holder.image.setImageResource(item.getImageResId());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView description;
        public ImageView image;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_title);
            description = itemView.findViewById(R.id.item_description);
            image = itemView.findViewById(R.id.item_image);
        }
    }
}