package com.ravish.universities.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.ravish.universities.R;
import com.ravish.universities.model.University;

import java.util.ArrayList;
import java.util.List;

public class UniversityAdapter extends RecyclerView.Adapter<UniversityAdapter.UniversityViewHolder>{

    private Context mContext;
    private List<University> universities = new ArrayList<>();

    public UniversityAdapter(Context mContext, List<University> universities) {
        this.mContext = mContext;
        this.universities = universities;
    }

    @NonNull
    @Override
    public UniversityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.single_university_view, parent, false);
        return new UniversityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UniversityViewHolder holder, int position) {
        University university = universities.get(position);

        holder.name.setText(university.getName());
        holder.state.setText(university.getState_province());
        holder.country.setText(university.getCountry());

    }

    @Override
    public int getItemCount() {
        return universities.size();
    }

    public class UniversityViewHolder extends RecyclerView.ViewHolder {

        private ConstraintLayout singleItem;
        private TextView name;
        private TextView state;
        private TextView country;

        public UniversityViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tv_name);
            state = itemView.findViewById(R.id.tv_state);
            country = itemView.findViewById(R.id.tv_country);
            singleItem = itemView.findViewById(R.id.single_item_view);
        }
    }
}
