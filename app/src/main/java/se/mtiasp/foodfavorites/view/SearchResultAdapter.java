package se.mtiasp.foodfavorites.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import se.mtiasp.foodfavorites.model.FoodItem;
import se.mtiasp.foodfavorites.R;


public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.ViewHolder> {

    private final ArrayList<FoodItem> foodList;
    private final OnFoodClickListener listener;

    public interface OnFoodClickListener {
        void onClick(FoodItem food, boolean isSelected);
    }

    public SearchResultAdapter(ArrayList<FoodItem> foodList, OnFoodClickListener listener) {
        this.foodList = foodList;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_result_item, parent, false);
        return new SearchResultAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int position) {
        FoodItem food = foodList.get(position);

        viewHolder.click(food, position, listener);

        viewHolder.title.setText(food.getTitle());
        viewHolder.text.setText(food.getCaloriesDescription());

        if (food.isSelected()) {
            viewHolder.favorite_outline.setVisibility(View.GONE);
            viewHolder.favorite.setVisibility(View.VISIBLE);
        } else {
            viewHolder.favorite.setVisibility(View.GONE);
            viewHolder.favorite_outline.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView text;

        private View favorite;
        private View favorite_outline;

        public ViewHolder(View view) {
            super(view);

            title = (TextView)view.findViewById(R.id.search_result_item_title);
            text = (TextView)view.findViewById(R.id.search_result_item_text);
            favorite = view.findViewById(R.id.search_result_item_favorite);
            favorite_outline = view.findViewById(R.id.search_result_item_favorite_outline);
        }

        public void click(final FoodItem food, int position, final OnFoodClickListener listener) {
            itemView.setOnClickListener(v -> {
                boolean selected = !food.isSelected();
                foodList.get(position).setSelected(selected);
                notifyItemChanged(position);
                listener.onClick(food, selected);
            });
        }
    }
}
