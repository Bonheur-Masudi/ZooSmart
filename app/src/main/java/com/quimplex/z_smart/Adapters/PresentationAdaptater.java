package com.quimplex.q_shopdrc.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.quimplex.q_shopdrc.Models.PresentationModel;
import com.quimplex.q_shopdrc.R;

import java.util.List;
import java.util.zip.Inflater;

public class PresentationAdaptater extends RecyclerView.Adapter<PresentationAdaptater.PresentationViewHolder> {

        private List<PresentationModel> presentationModels; //
        private Context context;

    public PresentationAdaptater(List<PresentationModel> presentationModels, Context context) {
        this.presentationModels = presentationModels;
        this.context = context;
    }

    @NonNull
        @Override
        public PresentationAdaptater.PresentationViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
            View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_presentation_starting,viewGroup,false);

        return new PresentationViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull PresentationAdaptater.PresentationViewHolder holder, int position) {
            PresentationModel model=presentationModels.get(position);

            Glide.with(context).load(model.getPresentation_img()).into(holder.presentationImage);
        }

        @Override
        public int getItemCount() {
            return presentationModels.size();
        }

        public class PresentationViewHolder extends RecyclerView.ViewHolder {
            //
            private ImageView presentationImage;
            //
            public PresentationViewHolder(@NonNull View itemView) {
                super(itemView);
                presentationImage=(ImageView)itemView.findViewById(R.id.imageView2);

            }
        }
    }

