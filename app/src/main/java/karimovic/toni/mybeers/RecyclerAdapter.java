package karimovic.toni.mybeers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.NameViewHolder>  {
    private List<String> list;
    private RemoveClickListener removeListener;


    public class NameViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tvItem;
        private ImageButton btRemove;
        private RemoveClickListener removeListener;

        public NameViewHolder(@NonNull View itemView, RemoveClickListener listener) {
            super(itemView);
            //removeListener=listener;
            tvItem=itemView.findViewById(R.id.text_beer);
            //btRemove.setOnClickListener(this);
        }

        public TextView getText(){ return tvItem; }

        public void setName(String name){ tvItem.setText(name);}

        @Override
        public void onClick(View v) { removeListener.onRemoveClick(getAdapterPosition()); }
    }


    public RecyclerAdapter(RemoveClickListener listener, List<String> list){
        removeListener=listener;
        this.list=list;
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItem= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_view_all_beers, parent, false);
        return new NameViewHolder(listItem, removeListener);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {
        holder.setName(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addNewCell(String name, int position){
        if(list.size()>=position) {
            list.add(position, name);
            notifyItemInserted(position);
        }
    }

    public void removeCell(int position){
        if (list.size()>position){
            list.remove(position);
            notifyItemRemoved(position);
        }
    }

}
