package com.example.photobomb1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.photobomb1.R;

public class ViewPagerAdapter extends PagerAdapter {

Context context;

LayoutInflater layoutInflater;

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==(LinearLayout)object;
    }

    int [] image={R.drawable.teddy,R.drawable.teddy,R.drawable.teddy};
    String[]  title= {"Welcome","Welcome","Welcome"};
    String[] description={"Photobombing is the act of purposely putting oneself into the view of a photograph",
            "Photobombing is the act of purposely putting oneself into the view of a photograph",
            "Photobombing is the act of purposely putting oneself into the view of a photograph"};


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view= layoutInflater.inflate(R.layout.viewpage_item,container,false);
        ImageView imageView=view.findViewById(R.id.imageView1);
        TextView textView=view.findViewById(R.id.title);
        TextView textView1=view.findViewById(R.id.description);

        imageView.setImageResource(image[position]);
        textView.setText(title[position]);
        textView1.setText(description[position]);
        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
