package kg.geektech.taskapp.ui.onboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import kg.geektech.taskapp.R;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.ViewHolder> {

    private OpenHome openHome;



    private String[] titles = new String[]{"Hello! my friends", "Салам достор!","Ассаламу алайкум баурым!"};
    private int[] images = new int[]{R.drawable.handshake,R.drawable.sharing,R.drawable.onboarding};


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

    public void setOpenHome(OpenHome openHome) {
        this.openHome = openHome;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textTitle;
        private ImageView img;
        private Button btnStart;

        public ViewHolder(@NotNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);
            img = itemView.findViewById(R.id.img);
            btnStart = itemView.findViewById(R.id.btn_start);

            btnStart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openHome.openHomeClick();
                }
            });
        }

        public void bind(int position) {
            textTitle.setText(titles[position]);
            img.setImageResource(images[position]);
            if (position == 2 ){
                btnStart.setVisibility(View.VISIBLE);
            }
        }
    }
}

interface OpenHome {
    void openHomeClick();
}



