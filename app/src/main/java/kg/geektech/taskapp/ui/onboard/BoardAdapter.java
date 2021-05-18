package kg.geektech.taskapp.ui.onboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import kg.geektech.taskapp.R;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.ViewHolder> {
    private String[] titles = new String[]{"Hello", "Salam","Privet"};
 //   private String [] images = new String[]{}


    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pager_board, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NotNull ViewHolder holder, int position) {
        holder.bind(position);

    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textTitle;
        private ImageView img;

        public ViewHolder(@NotNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);
            img = itemView.findViewById(R.id.img);
        }

        public void bind(int position) {
            textTitle.setText(titles[position]);

        }
    }
}
