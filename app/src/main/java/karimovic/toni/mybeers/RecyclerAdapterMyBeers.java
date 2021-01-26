package karimovic.toni.mybeers;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapterMyBeers extends RecyclerView.Adapter<RecyclerAdapterMyBeers.NameViewHolder>  {
    private List<Beer> list;

    public class NameViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tvName;
        private ImageView imageViewBeer;



        private TextView tvCountry;
        private TextView tvSince;
        private TextView tvBeerAlcohol;
        private ImageButton buttonRemove;

        public NameViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvName=itemView.findViewById(R.id.beer_name);
            this.imageViewBeer = itemView.findViewById(R.id.image_view_my_beer);
            this.tvCountry = itemView.findViewById(R.id.beer_state);
            this.tvSince = itemView.findViewById(R.id.beer_since);
            this.tvBeerAlcohol = itemView.findViewById(R.id.beer_alcohol);
            this.buttonRemove = itemView.findViewById(R.id.btn_remove_beer);
            itemView.setOnClickListener(this);

        }


        public void setName(Beer beer){ tvName.setText(beer.getName());}
        public void setPic(Beer beer){ imageViewBeer.setImageResource(beer.getImage()); }

        public void setTvCountry(Beer beer) {
          tvCountry.setText(beer.getCountry());
        }

        public void setTvSince(Beer beer) {
           tvSince.setText(beer.getSince());
        }

        public void setTvBeerAlcohol(Beer beer) {
           tvBeerAlcohol.setText(beer.getPercentage());
        }


        @Override
        public void onClick(View v) {  }
    }


    public RecyclerAdapterMyBeers(List<Beer> list){
        this.list=list;
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItem= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_view_my_beers, parent, false);
        return new NameViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {
        holder.setName(list.get(position));
        holder.setPic(list.get(position));
        holder.setTvCountry(list.get(position));
        holder.setTvSince(list.get(position));
        holder.setTvBeerAlcohol(list.get(position));
        holder.buttonRemove.setOnClickListener(v -> {
            Log.d("TAG", "size" + list.size() + "position: " + position);
            list.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, getItemCount());
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
