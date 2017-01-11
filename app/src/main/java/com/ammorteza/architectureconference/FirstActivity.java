package com.ammorteza.architectureconference;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.cepheuen.progresspageindicator.ProgressPageIndicator;

public class FirstActivity extends AppCompatActivity {

    //int[] imageArray = { R.drawable.first_pic1 , R.drawable.first_pic2 , R.drawable.first_pic3 , R.drawable.first_pic4};
    DatabaseHandler db = new DatabaseHandler(FirstActivity.this);
    Handler handler = new Handler();
    Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        int temp = db.getArticleCount();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isFirstRun()) {
                    initWizardDialog();
                    loadImages();
                    backImage();
                    RelativeLayout first_logo = (RelativeLayout) findViewById(R.id.first_logo);
                    RelativeLayout first_review = (RelativeLayout) findViewById(R.id.first_review);
                    first_logo.setVisibility(LinearLayout.GONE);
                    first_review.setVisibility(RelativeLayout.VISIBLE);
                }
                else
                {
                    Intent mainIntent = new Intent(FirstActivity.this, MainActivity.class);
                    startActivity(mainIntent);
                    finish();
                    overridePendingTransition(R.anim.page_pull_in_right, R.anim.page_push_out_left);
                }
            }
        }, 5000);


    }

    public boolean isFirstRun() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(FirstActivity.this);
        SharedPreferences.Editor preferencesEditor = preferences.edit();
        if (preferences.getBoolean("architetureConferenceFirstRun", true)) {
            preferencesEditor.putBoolean("architetureConferenceFirstRun", false).commit();
            return true;
        } else {
            return false;
        }
    }

    private void backImage()
    {
        final ViewFlipper backImg = (ViewFlipper)findViewById(R.id.first_back_img);
        runnable = new Runnable() {
            int i = 1;

            public void run() {
                backImg.setInAnimation(FirstActivity.this, R.anim.fade_in);
                backImg.setOutAnimation(FirstActivity.this, R.anim.fade_out);
                backImg.setDisplayedChild(i);
                i++;
                if (i > 3) {
                    i = 0;
                }
                handler.postDelayed(this, 5000);
            }
        };
        handler.postDelayed(runnable, 5000);
    }

    protected void onStop() {
        super.onStop();
        handler.removeCallbacks(runnable);
    }

    private void loadImages()
    {
        LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(FirstActivity.this, (ImageView) findViewById(R.id.winzard_img1), "first_pic1.png");
        LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(FirstActivity.this, (ImageView) findViewById(R.id.winzard_img2), "first_pic2.png");
        LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(FirstActivity.this, (ImageView) findViewById(R.id.winzard_img3), "first_pic3.png");
        LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(FirstActivity.this, (ImageView) findViewById(R.id.winzard_img4), "first_pic4.png");
    }

    private void initWizardDialog()
    {
        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        CustomPagerAdapter customPagerAddapter = new CustomPagerAdapter(this);
        viewPager.setAdapter(customPagerAddapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                ImageView firstIcons = (ImageView)findViewById(R.id.first_icons);
                switch (position)
                {
                    case 0:
                        firstIcons.setImageResource(R.drawable.wizard_icon1);
                        break;
                    case 1:
                        firstIcons.setImageResource(R.drawable.wizard_icon2);
                        break;
                    case 2:
                        firstIcons.setImageResource(R.drawable.wizard_icon3);
                        break;
                    case 3:
                        firstIcons.setImageResource(R.drawable.wizard_icon4);
                        break;
                    case 4:
                        firstIcons.setImageResource(R.drawable.wizard_icon5);
                        break;
                    case 5:
                        firstIcons.setImageResource(R.drawable.wizard_icon6);
                        break;
                    case 6:
                        firstIcons.setImageResource(R.drawable.wizard_icon7);
                        break;
                    case 7:
                        firstIcons.setImageResource(R.drawable.wizard_icon8);
                        break;
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        ProgressPageIndicator pagerIndicator = (ProgressPageIndicator)findViewById(R.id.pageIndicator);
        pagerIndicator.setViewPager(viewPager);
    }

    private class CustomPagerAdapter extends PagerAdapter {

        private Context mContext;

        public CustomPagerAdapter(Context context) {
            mContext = context;
        }

        @Override
        public Object instantiateItem(ViewGroup collection, int position) {
            //CustomPagerEnum customPagerEnum = CustomPagerEnum.values()[position];
            LayoutInflater inflater = LayoutInflater.from(mContext);
            ViewGroup layout = null;
            layout = (ViewGroup) inflater.inflate(R.layout.wizard_page, collection, false);
            final Button condac = (Button)layout.findViewById(R.id.first_start);
            condac.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent mainIntent = new Intent(FirstActivity.this, MainActivity.class);
                    startActivity(mainIntent);
                    finish();
                    overridePendingTransition(R.anim.page_pull_in_right, R.anim.page_push_out_left);
                }
            });
            if (position == 7) {
                condac.setVisibility(Button.VISIBLE);
            } else {
                condac.setVisibility(Button.GONE);
            }
            switch (position)
            {
                case 0:
                    ((TextView)layout.findViewById(R.id.wizardSubject)).setText("حوزه های فرهنگی - طبیعی شهر و روستاهای تاریخی");
                    break;
                case 1:
                    ((TextView)layout.findViewById(R.id.wizardSubject)).setText("منظر فرهنگی و منظر شهری تاریخی");
                    break;
                case 2:
                    ((TextView)layout.findViewById(R.id.wizardSubject)).setText("سازه در تاریخ معماری و شهرسازی");
                    break;
                case 3:
                    ((TextView)layout.findViewById(R.id.wizardSubject)).setText("باستان شناسی، معماری و شهرسازی");
                    break;
                case 4:
                    ((TextView)layout.findViewById(R.id.wizardSubject)).setText("میراث معماری و شهرسازی مدرن");
                    break;
                case 5:
                    ((TextView)layout.findViewById(R.id.wizardSubject)).setText("میراث آب و كشاورزی");
                    break;
                case 6:
                    ((TextView)layout.findViewById(R.id.wizardSubject)).setText("میراث فرهنگی ناملموس");
                    break;
                case 7:
                    ((TextView)layout.findViewById(R.id.wizardSubject)).setText("راه های فرهنگی و عناصر وابسته");
                    break;
            }
            collection.addView(layout);
            return layout;
        }

        @Override
        public void destroyItem(ViewGroup collection, int position, Object view) {
            collection.removeView((View) view);
        }

        @Override
        public int getCount() {
            return 8;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }


    }

}
