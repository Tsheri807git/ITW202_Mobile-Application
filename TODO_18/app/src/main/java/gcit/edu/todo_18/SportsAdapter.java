package gcit.edu.todo_18;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class SportsAdapter extends RecyclerView.Adapter<SportsAdapter.ViewHolder> {
    private ArrayList<Sport> mSportData;
    private Context mContext;
    private ImageView mSportsImage;

    SportsAdapter(Context context, ArrayList<Sport> SportsData) {
        this.mSportData = SportsData;
        this.mContext = context;
    }
    @NonNull
    @Override
    public SportsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext)
                .inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SportsAdapter.ViewHolder holder, int position) {
        Sport currentSport = mSportData.get(position);
        holder.bindTo(currentSport);

    }

    @Override
    public int getItemCount() {
        return mSportData.size();
    }

        class ViewHolder extends RecyclerView.ViewHolder {
            private TextView mTitleText, mInfoText;

            ViewHolder(View itemView) {
                super(itemView);

                mTitleText = itemView.findViewById(R.id.title);
                mInfoText = itemView.findViewById(R.id.subtitle);
                mSportsImage = itemView.findViewById(R.id.sportimages);
            }

            void bindTo(Sport currentSport) {
                mTitleText.setText(currentSport.getTitle());
                mInfoText.setText(currentSport.getInfo());
                Glide.with(mContext).load(currentSport.getImageResources()).into(mSportsImage);
            }
        }
    }
