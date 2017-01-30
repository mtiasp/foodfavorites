package se.mtiasp.foodfavorites.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import se.mtiasp.foodfavorites.model.FoodItem;
import se.mtiasp.foodfavorites.R;


public class SelectedFoodAdapter extends RecyclerView.Adapter<SelectedFoodAdapter.ViewHolder> {

    private final ArrayList<FoodItem> foodList;
    private final OnFoodClickListener listener;

    public interface OnFoodClickListener {
        void onClick(FoodItem food);
    }

    public SelectedFoodAdapter(ArrayList<FoodItem> foodList, OnFoodClickListener listener) {
        this.foodList = foodList;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.selected_food_item, parent, false);
        return new SelectedFoodAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int position) {
        FoodItem food = foodList.get(position);
        viewHolder.click(food, position, listener);
        viewHolder.title.setText(food.getTitle());
        viewHolder.text.setText(food.getCaloriesDescription());
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView text;

        public ViewHolder(View view) {
            super(view);

            title = (TextView)view.findViewById(R.id.selected_food_item_title);
            text = (TextView)view.findViewById(R.id.selected_food_item_text);
        }

        public void click(final FoodItem food, int position, final OnFoodClickListener listener) {
            itemView.setOnClickListener(v -> {
                foodList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, getItemCount());
                listener.onClick(food);
            });
        }
    }
}
