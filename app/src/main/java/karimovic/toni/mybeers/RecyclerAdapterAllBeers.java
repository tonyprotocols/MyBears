package karimovic.toni.mybeers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapterAllBeers extends RecyclerView.Adapter<RecyclerAdapterAllBeers.NameViewHolder>   {
    private List<Beer> list;
    private OnCardClickListener onCardListener;

    public RecyclerAdapterAllBeers(OnCardClickListener listener, List<Beer> list){
        this.list = list;
        this.onCardListener = listener;
    }

    public class NameViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tvName;
        private ImageView imageViewBeer;
        private CardView itemCardBeer;

        public NameViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvName=itemView.findViewById(R.id.text_beer);
            this.imageViewBeer = itemView.findViewById(R.id.image_view_beer);
            this.itemCardBeer = itemView.findViewById(R.id.item_card_beer);
            itemView.setOnClickListener(this);

        }

        public TextView getText(){ return tvName; }

        public void setName(Beer beer){ tvName.setText(beer.getName());}
        public void setPic(Beer beer){ imageViewBeer.setImageResource(beer.getImage()); }




        @Override
        public void onClick(View v) {

        }
    }



    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItem= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_view_all_beers, parent, false);
        return new NameViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {
        holder.setName(list.get(position));
        holder.setPic(list.get(position));
        holder.itemCardBeer.setOnClickListener(v -> {
            onCardListener.onCardClick(position);
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
