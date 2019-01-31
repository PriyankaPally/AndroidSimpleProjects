package com.example.ppriyanka.myapplication.Retrofit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ppriyanka.myapplication.R;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PhotoAdatapter extends RecyclerView.Adapter<PhotoAdatapter.PhotoViewHolder>  {


    Context context;
    List<RetroPhoto> photoList;

    public PhotoAdatapter(Context context, List<RetroPhoto> photoList) {

        this.context=context;
        this.photoList=photoList;
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater =LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.photo_list_items,viewGroup,false);
        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder photoViewHolder, int i) {

        photoViewHolder.photo_text.setText(photoList.get(i).getTitle());


        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(photoList.get(i).getThumbnailUrl())
                /*.placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)*/
                .into(photoViewHolder.photo_image);
    }

    @Override
    public int getItemCount() {
        return photoList.size();
    }

    public class PhotoViewHolder extends RecyclerView.ViewHolder {

        TextView photo_text;
        ImageView photo_image;
        public PhotoViewHolder(@NonNull View itemView) {
            super(itemView);
            photo_text=(TextView)itemView.findViewById(R.id.photo_textView);
            photo_image=(ImageView)itemView.findViewById(R.id.photo_imageView);

        }
    }
}
