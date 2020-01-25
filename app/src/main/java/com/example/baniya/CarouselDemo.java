package com.example.baniya;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class CarouselDemo extends AppCompatActivity {

    private int images[] = new int[] {R.drawable.headphone_sale, R.drawable.laptop_sale, R.drawable.mobile_sale, R.drawable.watch_sale};


    CarouselView carouselView;
//    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carousel_demo);


        carouselView = (CarouselView) findViewById(R.id.carousel_view);
        carouselView.setPageCount(images.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {

                imageView.setImageResource(images[position]);
            }
        });



//        viewFlipper = (ViewFlipper) findViewById(R.id.v_flipper);
//
//
//        for (int image : images){
//            flipperImages(image);
//        }
//    }
//
//    public void flipperImages(int image){
//        ImageView imageView = new ImageView(this);
//        imageView.setBackgroundResource(image);
//
//        viewFlipper.addView(imageView);
//        viewFlipper.setFlipInterval(3000);
//        viewFlipper.setAutoStart(true);
//
//        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
//        viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);
//    }
    }
}
