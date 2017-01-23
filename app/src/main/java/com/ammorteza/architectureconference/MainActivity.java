package com.ammorteza.architectureconference;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class MainActivity extends AppCompatActivity {
    private Toast endToast;
    private boolean doubleBackToExitPressedOnce = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.createActionBar();
        this.createPopUpMenu();
        this.endToast = new Toast(MainActivity.this);

        DesignDemoPagerAdapter adapter = new DesignDemoPagerAdapter(getSupportFragmentManager());
        ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            endToast.cancel();
            finish();
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        endToast.setDuration(Toast.LENGTH_SHORT);
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast,null);
        TextView textView=(TextView)layout.findViewById(R.id.toastText);
        textView.setText("لطفا برای خروج دو بار لمس کنید");
        endToast.setDuration(Toast.LENGTH_SHORT);
        endToast.setView(layout);
        endToast.show();
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

    public void conItems(View view)
    {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.con_item_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        Window window = dialog.getWindow();
        lp.copyFrom(window.getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);
        switch (view.getId())
        {
            case R.id.conItem1:
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this, (ImageView) dialog.findViewById(R.id.con_dialog_img), "malmir.jpg");
                ((TextView)dialog.findViewById(R.id.con_dialog_subject)).setText("سخنرانی");
                ((TextView)dialog.findViewById(R.id.con_dialog_name)).setText("مهندس علی مالمیر مدیرکل میراث فرهنگی, صنایع دستی و گردشگری استان همدان و رئیس کنگره");
                ((TextView)dialog.findViewById(R.id.con_dialog_desc)).setText("خوش آمدگویی");
                ((TextView)dialog.findViewById(R.id.con_dialog_time)).setText("۰۸:۵۰");
                break;
            case R.id.conItem2:
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this, (ImageView) dialog.findViewById(R.id.con_dialog_img), "hajmohamadi.jpg");
                ((TextView)dialog.findViewById(R.id.con_dialog_subject)).setText("سخنرانی");
                ((TextView)dialog.findViewById(R.id.con_dialog_name)).setText("حضرت آیت الله غیاث الدین طه محمدی نماينده محترم ولي فقيه و امام جمعه استان همدان");
                ((TextView)dialog.findViewById(R.id.con_dialog_desc)).setText("معماری اسلامی");
                ((TextView)dialog.findViewById(R.id.con_dialog_time)).setText("۰۹:۰۰");
                break;
            case R.id.conItem3:
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this, (ImageView) dialog.findViewById(R.id.con_dialog_img), "dr_motarjem.jpg");
                ((TextView)dialog.findViewById(R.id.con_dialog_subject)).setText("سخنرانی");
                ((TextView)dialog.findViewById(R.id.con_dialog_name)).setText("دکتر عباس مترجم, هیئت علمی و رئیس دانشکده هنر و معماری دانشگاه بوعلی سینا همدان و دبیر علمی کنگره");
                ((TextView)dialog.findViewById(R.id.con_dialog_desc)).setText("سخنرانی در خصوص مقالات ارائه شده");
                ((TextView)dialog.findViewById(R.id.con_dialog_time)).setText("۰۹:۵۰");
                break;
            case R.id.conItem4:
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this, (ImageView) dialog.findViewById(R.id.con_dialog_img), "con_part1_4.png");
                ((TextView)dialog.findViewById(R.id.con_dialog_subject)).setText("سخنرانی");
                ((TextView)dialog.findViewById(R.id.con_dialog_name)).setText("نماینده سازمان میراث فرهنگی, صنایع دستی و گردشگری");
                ((TextView)dialog.findViewById(R.id.con_dialog_desc)).setText("");
                ((TextView)dialog.findViewById(R.id.con_dialog_time)).setText("۰۹:۴۰");
                break;
            case R.id.conItem5:
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this, (ImageView) dialog.findViewById(R.id.con_dialog_img), "con_part1_4.png");
                ((TextView)dialog.findViewById(R.id.con_dialog_subject)).setText("سخنرانی");
                ((TextView)dialog.findViewById(R.id.con_dialog_name)).setText("مسئولین محترم شهر همدان");
                ((TextView)dialog.findViewById(R.id.con_dialog_desc)).setText("");
                ((TextView)dialog.findViewById(R.id.con_dialog_time)).setText("۰۹:۳۰");
                break;
            case R.id.conItem6:
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this, (ImageView) dialog.findViewById(R.id.con_dialog_img), "makarchian.jpg");
                ((TextView)dialog.findViewById(R.id.con_dialog_subject)).setText("سخنرانی تخصصی");
                ((TextView)dialog.findViewById(R.id.con_dialog_name)).setText("دکتر مسعود مکارچیان معاون مالی دانشکده فنی مهندسی و هیئت علمی دانشگاه بوعلی سینا همدان");
                ((TextView)dialog.findViewById(R.id.con_dialog_desc)).setText("پل های قوسی تاریخی استان همدان");
                ((TextView)dialog.findViewById(R.id.con_dialog_time)).setText("۱۱:۳۰");
                break;
            case R.id.conItem7:
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this, (ImageView) dialog.findViewById(R.id.con_dialog_img), "bahramzade.jpg");
                ((TextView)dialog.findViewById(R.id.con_dialog_subject)).setText("سخنرانی تخصصی");
                ((TextView)dialog.findViewById(R.id.con_dialog_name)).setText("دکتر محمد بهرام زاده معاون بنیاد ایرانشناسی  کشور");
                ((TextView)dialog.findViewById(R.id.con_dialog_desc)).setText("نقش باستان شناسي در مطالعات ايران شناسي");
                ((TextView)dialog.findViewById(R.id.con_dialog_time)).setText("۱۱:۰۰");
                break;
            case R.id.conItem8:
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this, (ImageView) dialog.findViewById(R.id.con_dialog_img), "mormoj.jpg");
                ((TextView)dialog.findViewById(R.id.con_dialog_subject)).setText("سخنرانی تخصصی");
                ((TextView)dialog.findViewById(R.id.con_dialog_name)).setText("دکتر علی اصغر مرادی و مهندس سید مهدی مجابی, هیئت علمی دانشگاه علم و صنعت ایران / دانشکده هنر ومعماری");
                ((TextView)dialog.findViewById(R.id.con_dialog_desc)).setText(" راهبرد، توصيه، منشور و ضوابط مربوط به حفاظت و احياي بافت هاي تاريخي كشور");
                ((TextView)dialog.findViewById(R.id.con_dialog_time)).setText("۱۰:۳۰");
                break;
            case R.id.conItem9:
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this, (ImageView) dialog.findViewById(R.id.con_dialog_img), "mohamadian.jpg");
                ((TextView)dialog.findViewById(R.id.con_dialog_subject)).setText("ارائه مقاله منتخب");
                ((TextView)dialog.findViewById(R.id.con_dialog_name)).setText("دکتر صاحب محمدیان منصور هیئت علمی دانشگاه بوعلی سینا همدان / گروه معماری");
                ((TextView)dialog.findViewById(R.id.con_dialog_desc)).setText("بررسی قابلیتهای هندسی و سازه ای پتکانه ");
                ((TextView)dialog.findViewById(R.id.con_dialog_time)).setText("۱۵:۱۰");
                break;
            case R.id.conItem10:
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this, (ImageView) dialog.findViewById(R.id.con_dialog_img), "nazariarshad.jpg");
                ((TextView)dialog.findViewById(R.id.con_dialog_subject)).setText("ارائه مقاله منتخب");
                ((TextView)dialog.findViewById(R.id.con_dialog_name)).setText("دکتر رضا نظری ارشد هئیت علمی دانشگاه آزاد اسلامی همدان / گروه باستان شناسی");
                ((TextView)dialog.findViewById(R.id.con_dialog_desc)).setText("بررسي ومطالعه باستان شناختي آرامگاه برجي باباحسين ملاير");
                ((TextView)dialog.findViewById(R.id.con_dialog_time)).setText("۱۴:۵۰");
                break;
            case R.id.conItem11:
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this, (ImageView) dialog.findViewById(R.id.con_dialog_img), "parsi.jpg");
                ((TextView)dialog.findViewById(R.id.con_dialog_subject)).setText("سخنرانی تخصصی");
                ((TextView)dialog.findViewById(R.id.con_dialog_name)).setText("مهندس فرامرز پارسی");
                ((TextView)dialog.findViewById(R.id.con_dialog_desc)).setText("بحران آسيب بناهاي تاريخي");
                ((TextView)dialog.findViewById(R.id.con_dialog_time)).setText("۱۰:۳۰");
                break;
            case R.id.conItem12:
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this, (ImageView) dialog.findViewById(R.id.con_dialog_img), "sajjadzade.jpg");
                ((TextView)dialog.findViewById(R.id.con_dialog_subject)).setText("ارائه مقاله منتخب");
                ((TextView)dialog.findViewById(R.id.con_dialog_name)).setText("دکتر حسن سجاد زاده هیئت علمی و مدیر گروه معماری دانشگاه بوعلی سینا همدان / دانشکده هنر و معماری");
                ((TextView)dialog.findViewById(R.id.con_dialog_desc)).setText("عوامل موثر بر تحولات ساختاري با تاكيد بر دروازه ها و راه ها");
                ((TextView)dialog.findViewById(R.id.con_dialog_time)).setText("۱۱:۰۰");
                break;
        }
        //TextView text = (TextView) dialog.findViewById(R.id.text_dialog);
        //text.setText(msg);

        dialog.show();

    }

    public void memItems(View view)
    {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.mem_item_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        Window window = dialog.getWindow();
        lp.copyFrom(window.getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);
        switch (view.getId())
        {
            case R.id.execAdmin:
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this, (ImageView) dialog.findViewById(R.id.con_dialog_img), "malmir.jpg");
                ((TextView)dialog.findViewById(R.id.mem_dialog_name)).setText("مهندس علی مالمیر");
                ((TextView)dialog.findViewById(R.id.mem_dialog_post)).setText("مدیرکل میراث فرهنگی, صنایع دستی و گردشگری استان همدان و رئیس کنگره");
                break;
            case R.id.exec1:
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this , (ImageView)dialog.findViewById(R.id.con_dialog_img) , "khorshidi.jpg");
                ((TextView)dialog.findViewById(R.id.mem_dialog_name)).setText("حسین خورشیدی");
                ((TextView)dialog.findViewById(R.id.mem_dialog_post)).setText("رئیس اداره حراست اداره کل میراث فرهنگی, صنایع دستی و گردشگری استان همدان و حراست کنگره");
                break;
            case R.id.exec2:
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this , (ImageView)dialog.findViewById(R.id.con_dialog_img) , "abasi.jpg");
                ((TextView)dialog.findViewById(R.id.mem_dialog_name)).setText("بهجت عباسی");
                ((TextView)dialog.findViewById(R.id.mem_dialog_post)).setText("مدیر روابط عمومی اداره کل میراث فرهنگی صنایع دستی و گردشگری استان همدان و مسئول سمعی بصری و روابط عمومی کنگره");
                break;
            case R.id.exec3:
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this , (ImageView)dialog.findViewById(R.id.con_dialog_img) , "valadi.jpg");
                ((TextView)dialog.findViewById(R.id.mem_dialog_name)).setText("مولود ولدی");
                ((TextView)dialog.findViewById(R.id.mem_dialog_post)).setText("کارشناس ارشد اداره کل میراث فرهنگی, صنایع دستی و گردشگری استان همدان و عضو دبیرخانه کنگره");
                break;
            case R.id.exec4:
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this, (ImageView) dialog.findViewById(R.id.con_dialog_img), "toosee.jpg");
                ((TextView)dialog.findViewById(R.id.mem_dialog_name)).setText("سید کمال الدین طوسی");
                ((TextView)dialog.findViewById(R.id.mem_dialog_post)).setText("معاون توسعه مدیریت و پشتیبانی اداره کل میراث فرهنگی, صنایع دستی و گردشگری استان همدان و مسئول پشتیبانی کنگره");
                break;
            case R.id.exec5:
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this , (ImageView)dialog.findViewById(R.id.con_dialog_img) , "tootoonchi.jpg");
                ((TextView)dialog.findViewById(R.id.mem_dialog_name)).setText("مهندس بهرام توتونچی");
                ((TextView)dialog.findViewById(R.id.mem_dialog_post)).setText("معاون میراث فرهنگی استان همدان");
                break;
            case R.id.exec6:
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this , (ImageView)dialog.findViewById(R.id.con_dialog_img) , "safari.jpg");
                ((TextView)dialog.findViewById(R.id.mem_dialog_name)).setText("اتابک صفری تورج");
                ((TextView)dialog.findViewById(R.id.mem_dialog_post)).setText("کارشناس اداره کل میراث فرهنگی, صنایع دستی و گردشگری استان همدان و عضو دبیرخانه کنگره");
                break;
            case R.id.exec7:
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this , (ImageView)dialog.findViewById(R.id.con_dialog_img) , "mirzaee.jpg");
                ((TextView)dialog.findViewById(R.id.mem_dialog_name)).setText("خدیجه ملامیرزایی");
                ((TextView)dialog.findViewById(R.id.mem_dialog_post)).setText("کارشناس ارشد باستان شناس اداره کل میراث فرهنگی, صنایع دستی و گردشگری استان همدان و عضو دبیرخانه کنگره");
                break;
            case R.id.exec8:
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this , (ImageView)dialog.findViewById(R.id.con_dialog_img) , "shabani.jpg");
                ((TextView)dialog.findViewById(R.id.mem_dialog_name)).setText("محمد شعبانی");
                ((TextView)dialog.findViewById(R.id.mem_dialog_post)).setText("کارشناس ارشد باستان شناس اداره کل میراث فرهنگی, صنایع دستی و گردشگری استان همدان و عضو دبیرخانه کنگره");
                break;
            case R.id.exec9:
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this , (ImageView)dialog.findViewById(R.id.con_dialog_img) , "farahpoor.jpg");
                ((TextView)dialog.findViewById(R.id.mem_dialog_name)).setText("محمد امین فرهپور");
                ((TextView)dialog.findViewById(R.id.mem_dialog_post)).setText("دبیر اجرایی کنگره");
                break;
            case R.id.exec10:
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this , (ImageView)dialog.findViewById(R.id.con_dialog_img) , "moosavi.jpg");
                ((TextView)dialog.findViewById(R.id.mem_dialog_name)).setText("مریم مختاری موسوی");
                ((TextView)dialog.findViewById(R.id.mem_dialog_post)).setText("کارشناس ارشد مرمت اداره کل میراث فرهنگی, صنایع دستی و گردشگری استان همدان و مسئول دبیرخانه - مدیر سایت کنگره");
                break;
            case R.id.exec11:
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this , (ImageView)dialog.findViewById(R.id.con_dialog_img) , "amzajerdi.jpg");
                ((TextView)dialog.findViewById(R.id.mem_dialog_name)).setText("مرتضی امزاجردی");
                ((TextView)dialog.findViewById(R.id.mem_dialog_post)).setText("کارشناس اداره کل میراث فرهنگی, صنایع دستی و گردشگری استان همدان و عضو دبیرخانه کنگره");
                break;
            case R.id.academicAdmin:
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this, (ImageView) dialog.findViewById(R.id.con_dialog_img), "dr_motarjem.jpg");
                ((TextView)dialog.findViewById(R.id.mem_dialog_name)).setText("دکتر عباس مترجم");
                ((TextView)dialog.findViewById(R.id.mem_dialog_post)).setText("هیئت علمی و رئیس دانشکده هنر و معماری دانشگاه بوعلی سینا همدان و دبیر علمی کنگره");
                break;
            case R.id.academic1:
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this, (ImageView) dialog.findViewById(R.id.con_dialog_img), "ezadi.jpg");
                ((TextView)dialog.findViewById(R.id.mem_dialog_name)).setText("دکتر سعید ایزدی");
                ((TextView)dialog.findViewById(R.id.mem_dialog_post)).setText("معاون وزیر راه و شهرسازی و مدیر عامل شرکت عمران و بهسازی شهری ایران");
                break;
            case R.id.academic2:
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this, (ImageView) dialog.findViewById(R.id.con_dialog_img), "sajjadzade.jpg");
                ((TextView)dialog.findViewById(R.id.mem_dialog_name)).setText("دکتر حسن سجادزاده");
                ((TextView)dialog.findViewById(R.id.mem_dialog_post)).setText("هیئت علمی و مدیر گروه معماری دانشگاه بوعلی سینا همدان / دانشکده هنر و معماری");
                break;
            case R.id.academic3:
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this, (ImageView) dialog.findViewById(R.id.con_dialog_img), "zaree.jpg");
                ((TextView)dialog.findViewById(R.id.mem_dialog_name)).setText("دکتر محمد ابراهیم زارعی");
                ((TextView)dialog.findViewById(R.id.mem_dialog_post)).setText("هیئت علمی دانشگاه بوعلی سینا همدان / گروه باستان شناسی");
                break;
            case R.id.academic4:
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this, (ImageView) dialog.findViewById(R.id.con_dialog_img), "mojabi.jpg");
                ((TextView)dialog.findViewById(R.id.mem_dialog_name)).setText("دکتر سید مهدی مجابی");
                ((TextView)dialog.findViewById(R.id.mem_dialog_post)).setText("هیئت علمی دانشگاه علم و صنعت ایران / دانشکده هنر و معماری");
                break;
            case R.id.academic5:
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this, (ImageView) dialog.findViewById(R.id.con_dialog_img), "mohamadifar.jpg");
                ((TextView)dialog.findViewById(R.id.mem_dialog_name)).setText("دکتر علی محمدی فر");
                ((TextView)dialog.findViewById(R.id.mem_dialog_post)).setText("معاون توسعه مدیریت و پشتیبانی و هیئت علمی دانشگاه بوعلی سینا / گروه باستان شناسی");
                break;
            case R.id.academic6:
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this, (ImageView) dialog.findViewById(R.id.con_dialog_img), "adib.jpg");
                ((TextView)dialog.findViewById(R.id.mem_dialog_name)).setText("دکتر مرتضی ادیب");
                ((TextView)dialog.findViewById(R.id.mem_dialog_post)).setText("هیئت علمی دانشگاه شهید بهشتی / گروه معماری منظر");
                break;
            case R.id.academic7:
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this, (ImageView) dialog.findViewById(R.id.con_dialog_img), "malekzade.jpg");
                ((TextView)dialog.findViewById(R.id.mem_dialog_name)).setText("دکتر مهرداد ملک زاده");
                ((TextView)dialog.findViewById(R.id.mem_dialog_post)).setText("هیئت علمی پژوهشکده باستان شناسی سازمان میراث فرهنگی, صنایع دستی و گردشگری");
                break;
            case R.id.academic8:
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this, (ImageView) dialog.findViewById(R.id.con_dialog_img), "dezhdar.jpg");
                ((TextView)dialog.findViewById(R.id.mem_dialog_name)).setText("دکتر امید دژدار");
                ((TextView)dialog.findViewById(R.id.mem_dialog_post)).setText("هیئت علمی و رئیس دانشکده هنر و معماری دانشگاه آزاد اسلامی همدان");
                break;
            case R.id.academic9:
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this, (ImageView) dialog.findViewById(R.id.con_dialog_img), "makarchian.jpg");
                ((TextView)dialog.findViewById(R.id.mem_dialog_name)).setText("دکتر مسعود مکارچیان");
                ((TextView)dialog.findViewById(R.id.mem_dialog_post)).setText("معاون مالی دانشکده فنی مهندسی و هیئت علمی دانشگاه بوعلی سینا همدان");
                break;
            case R.id.academic10:
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this, (ImageView) dialog.findViewById(R.id.con_dialog_img), "abasi_nader_poor.jpg");
                ((TextView)dialog.findViewById(R.id.mem_dialog_name)).setText("دکتر محمد رضا عباسی");
                ((TextView)dialog.findViewById(R.id.mem_dialog_post)).setText("هیئت علمی دانشگاه بوعلی سینا همدان / گروه شهرسازی");
                break;
            case R.id.academic11:
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this, (ImageView) dialog.findViewById(R.id.con_dialog_img), "forotan.jpg");
                ((TextView)dialog.findViewById(R.id.mem_dialog_name)).setText("دکتر منوچهر فروتن");
                ((TextView)dialog.findViewById(R.id.mem_dialog_post)).setText("هیئت علمی دانشگاه آزاد اسلامی همدان / گروه معماری");
                break;
            case R.id.academic12:
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this, (ImageView) dialog.findViewById(R.id.con_dialog_img), "molavi.jpg");
                ((TextView)dialog.findViewById(R.id.mem_dialog_name)).setText("دکتر ابراهیم مولوی");
                ((TextView)dialog.findViewById(R.id.mem_dialog_post)).setText("رئیس مرکز مطالعات و پژوهش های شورای اسلامی شهر همدان");
                break;
            case R.id.academic13:
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this, (ImageView) dialog.findViewById(R.id.con_dialog_img), "naghdi.jpg");
                ((TextView)dialog.findViewById(R.id.mem_dialog_name)).setText("دکتر علی نقدی");
                ((TextView)dialog.findViewById(R.id.mem_dialog_post)).setText("هیئت علمی دانشگاه بوعلی سینا همدان / گروه اقتصاد و علوم اجتماعی");
                break;
            case R.id.academic14:
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this, (ImageView) dialog.findViewById(R.id.con_dialog_img), "jalilmosavi.jpg");
                ((TextView)dialog.findViewById(R.id.mem_dialog_name)).setText("دکتر جلیل موسوی");
                ((TextView)dialog.findViewById(R.id.mem_dialog_post)).setText("هئیت علمی دانشگاه آزاد اسلامی همدان / گروه معماری");
                break;
            case R.id.academic15:
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this, (ImageView) dialog.findViewById(R.id.con_dialog_img), "godarzi.jpg");
                ((TextView)dialog.findViewById(R.id.mem_dialog_name)).setText("دکتر محمد مهدی گودرزی سروش");
                ((TextView)dialog.findViewById(R.id.mem_dialog_post)).setText("هئیت علمی دانشگاه آزاد اسلامی همدان / گروه معماری");
                break;
            case R.id.academic16:
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this, (ImageView) dialog.findViewById(R.id.con_dialog_img), "nazariarshad.jpg");
                ((TextView)dialog.findViewById(R.id.mem_dialog_name)).setText("دکتر رضا نظری ارشد");
                ((TextView)dialog.findViewById(R.id.mem_dialog_post)).setText("هئیت علمی دانشگاه آزاد اسلامی همدان / گروه باستان شناسی");
                break;
            case R.id.academic17:
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this, (ImageView) dialog.findViewById(R.id.con_dialog_img), "parastar.jpg");
                ((TextView)dialog.findViewById(R.id.mem_dialog_name)).setText("دکتر مهدی پرستار");
                ((TextView)dialog.findViewById(R.id.mem_dialog_post)).setText("هیئت علمی دانشگاه بوعلی سینا همدان / گروه تصویر سازی");
                break;
            case R.id.academic18:
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this, (ImageView) dialog.findViewById(R.id.con_dialog_img), "mohamadian.jpg");
                ((TextView)dialog.findViewById(R.id.mem_dialog_name)).setText("دکتر صاحب محمدیان منصور");
                ((TextView)dialog.findViewById(R.id.mem_dialog_post)).setText("هیئت علمی دانشگاه بوعلی سینا همدان / گروه معماری");
                break;
            case R.id.academic19:
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this, (ImageView) dialog.findViewById(R.id.con_dialog_img), "shayganfar.jpg");
                ((TextView)dialog.findViewById(R.id.mem_dialog_name)).setText("مهندس سحر شایگان فر");
                ((TextView)dialog.findViewById(R.id.mem_dialog_post)).setText("هیئت علمی و مدیر گروه مرمت دانشگاه آزاد اسلامی همدان");
                break;
            case R.id.academic20:
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this, (ImageView) dialog.findViewById(R.id.con_dialog_img), "bahramzade.jpg");
                ((TextView)dialog.findViewById(R.id.mem_dialog_name)).setText("دکتر محمد بهرام زاده");
                ((TextView)dialog.findViewById(R.id.mem_dialog_post)).setText("معاون بنیاد ایرانشناسی  کشور");
                break;
            case R.id.academic21:
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this, (ImageView) dialog.findViewById(R.id.con_dialog_img), "moradi.jpg");
                ((TextView)dialog.findViewById(R.id.mem_dialog_name)).setText("دکتر علی اصغر مرادی");
                ((TextView)dialog.findViewById(R.id.mem_dialog_post)).setText("هیئت علمی دانشگاه علم و صنعت ایران / دانشکده هنر و معماری");
                break;

        }
        //TextView text = (TextView) dialog.findViewById(R.id.text_dialog);
        //text.setText(msg);

        dialog.show();

    }

    private void createPopUpMenu()
    {
        findViewById(R.id.popUpMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, view);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId())
                        {
                            case  R.id.item_about:
                                Intent abountPage = new Intent(MainActivity.this, AboutActivity.class);
                                startActivity(abountPage);
                                overridePendingTransition(R.anim.page_pull_in_right, R.anim.page_push_out_left);
                                break;
                        }
                        return true;
                    }
                });
                popupMenu.inflate(R.menu.popup_menu);
                popupMenu.show();
            }
        });
    }

    private void createActionBar()
    {
        Typeface type;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimary)));
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayUseLogoEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);

        View mCustomView = mInflater.inflate(R.layout.custom_action_bar, null);
        actionBar.setDisplayShowCustomEnabled(true);
        ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT);
        actionBar.setCustomView(mCustomView, layoutParams);
        Toolbar parent = (Toolbar) mCustomView.getParent();
        parent.setContentInsetsAbsolute(0, 0);
    }

    public static class DesignDemoFragment extends Fragment {
        private static final String TAB_POSITION = "tab_position";
        private NotifiableViewFlipper adViewFlipper;
        private static final int[] AD_POINT_IDS = { R.id.radioButton_flipperPoint0,
                    R.id.radioButton_flipperPoint1, R.id.radioButton_flipperPoint2};
        private RadioGroup adPointRadioGroup;
        public DesignDemoFragment() {

        }

        private void loadImages(View view , int tabPos)
        {
            switch (tabPos)
            {
                case 0:
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.con_banner1) , "banner_1.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.con_banner2) , "banner_2.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.con_banner3) , "banner_3.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.con_part1_img1) , "malmir.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.con_part1_img2) , "hajmohamadi.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.con_part1_img3) , "dr_motarjem.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.con_part1_img4) , "con_part1_4.png");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.con_part1_img5) , "con_part1_4.png");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.con_part1_img6) , "makarchian.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.con_part1_img7) , "bahramzade.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.con_part1_img8) , "mormoj.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.con_part1_img9) , "mohamadian.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.con_part1_img10) , "nazariarshad.jpg");
                    //LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.con_part1_img11) , "con_part1_4.png");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.con_first_adib) , "adib.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.con_first_khorshidi) , "khorshidi.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.p1ـ1) , "sajjadzade.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.p1_2) , "naghdi.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.p1_3) , "abasi_nader_poor.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.p2_1) , "mohamadifar.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.p2_2) , "tajbakhsh.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.p2_3) , "malekzade.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.p2_4) , "shabani.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.p2_5) , "hemati.jpg");

                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.p3_1) , "ezadi.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.p3_2) , "jalilmosavi.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.p3_3) , "madadi.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.p3_4) , "mohamadian.jpg");

                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.con_lunch_time) , "lunch_time.png");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.con_part2_img1) , "parsi.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.con_part2_img2) , "sajjadzade.jpg");
                    //LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.con_part2_img3) , "con_part1_4.png");
                    //LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.con_part2_img4) , "con_part1_4.png");
                    //LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.con_part2_img5) , "con_part1_4.png");
                    //LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.con_part2_img6) , "con_part1_4.png");

                    break;
                case 2:
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.supportersMirasLogo) , "miras_logo.png");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.supportersostandariLogo) , "_iran_logo.png");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.shahrdariLogo) , "shahrdari_logo.png");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.nezamLogo) , "nezam_mohandesi_logo.png");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.elmikarbirdiLogo) , "hegmataneh_logo.png");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.elmoSanatLogo) , "elmo_sanat_logo.png");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.azadLogo) , "azad_university_logo.png");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.boaliLogo) , "boali_logo.png");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.barnameBojjeLogo) , "_iran_logo.png");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.bonyadMaskanLogo) , "bonyad_maskan_logo.png");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.abMantagheLogo) , "ab_mantaghee_logo.png");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.bonyadIranShenasiLogo) , "bonyad_iranshenasi_logo.png");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.asnadLogo) , "asnad_ketabkhane_logo.png");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.rahVaShahrsaziLogo) , "_iran_logo.png");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.shoraLogo) , "shoraye_eslami_logo.png");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.shabake5Logo) , "shabake_5_logo.png");
                    break;
                case 3:
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.history1) , "shirazi3.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.history2) , "shirazi2.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.history3) , "shirazi1.jpg");
                    break;
                case 4:
                    break;
                case 5:
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.execAdmin) , "malmir.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.exec1) , "khorshidi.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.exec2) , "abasi.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.exec3) , "valadi.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.exec4) , "toosee.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.exec5) , "tootoonchi.jpg");

                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.exec6) , "safari.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.exec7) , "mirzaee.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.exec8) , "shabani.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.exec9) , "farahpoor.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.exec10) , "moosavi.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.exec11) , "amzajerdi.jpg");

                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.academicAdmin) , "dr_motarjem.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.academic1) , "ezadi.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.academic2) , "sajjadzade.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.academic3) , "zaree.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.academic4) , "mojabi.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.academic5) , "mohamadifar.jpg");

                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.academic6) , "adib.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.academic7) , "malekzade.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.academic8) , "dezhdar.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.academic9) , "makarchian.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.academic10) , "abasi_nader_poor.jpg");

                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.academic11) , "forotan.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.academic12) , "molavi.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.academic13) , "naghdi.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.academic14) , "jalilmosavi.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.academic15) , "godarzi.jpg");

                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.academic16) , "nazariarshad.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.academic17) , "parastar.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.academic18) , "mohamadian.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.academic19) , "shayganfar.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.academic20) , "bahramzade.jpg");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.academic21) , "moradi.jpg");
                    break;
            }

        }

        public static DesignDemoFragment newInstance(int tabPosition) {
            DesignDemoFragment fragment = new DesignDemoFragment();
            Bundle args = new Bundle();
            args.putInt(TAB_POSITION, tabPosition);
            fragment.setArguments(args);
            return fragment;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            Bundle args = getArguments();
            DatabaseHandler db = new DatabaseHandler(getContext());
            int tabPosition = args.getInt(TAB_POSITION);
            DisplayMetrics displaymetrics = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
            int screenHeight = displaymetrics.heightPixels;

            int actionBarHeight = 0;
            TypedValue tv = new TypedValue();
            if (getActivity().getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
                actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data,getResources().getDisplayMetrics());
            }
            switch (tabPosition)
            {
                case 0:
                    View view = inflater.inflate(R.layout.fragment_condac_fragment_layout, container, false);
                    adViewFlipper = (NotifiableViewFlipper) view.findViewById(R.id.viewFlipper_AD);
                    adPointRadioGroup = (RadioGroup) view.findViewById(R.id.radioGroup_flipperPoints);
                    adViewFlipper.setOnFlipListener(new NotifiableViewFlipper.OnFlipListener() {
                        @Override
                        public void onShowPrevious(NotifiableViewFlipper flipper) {
                            adPointRadioGroup.check(AD_POINT_IDS[flipper.getDisplayedChild()]);
                        }

                        @Override
                        public void onShowNext(NotifiableViewFlipper flipper) {
                            adPointRadioGroup.check(AD_POINT_IDS[flipper.getDisplayedChild()]);
                        }
                    });
                    loadImages(view , tabPosition);

                    ((LinearLayout)view.findViewById(R.id.con_main_layout)).setMinimumHeight(screenHeight - actionBarHeight);

                    return view;
                case 1:
                    View viewTopics = inflater.inflate(R.layout.fragment_topics_fragment_layout, container, false);
                    return viewTopics;
                case 2:
                    View viewSupporters = inflater.inflate(R.layout.fragment_supporters_fragment_layout, container, false);
                    loadImages(viewSupporters , tabPosition);
                    return viewSupporters;
                case 3:
                    View viewHistory = inflater.inflate(R.layout.fragment_history_fragment_layout, container, false);
                    loadImages(viewHistory , tabPosition);
                    return viewHistory;
                case 4:
                    View viewArticles = inflater.inflate(R.layout.fragment_articles_fragment_layout, container, false);
                    ArrayList<HashMap<String , Object>> articles = db.getAllArticleContacts();
                    Log.d("text" , articles.get(0).get("text").toString());
                    RecyclerView recyclerView = (RecyclerView) viewArticles.findViewById(R.id.recycler_view);
                    recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
                    ArticleRecyclerAdapter recyclerAdapter = new ArticleRecyclerAdapter(getActivity(), articles);
                    recyclerView.setAdapter(recyclerAdapter);
                    loadImages(viewArticles , tabPosition);
                    return viewArticles;
                case 5:
                    View viewMembers = inflater.inflate(R.layout.fragment_members_fragment_layout, container, false);
                    loadImages(viewMembers , tabPosition);
                    ((LinearLayout)viewMembers.findViewById(R.id.member_main_layout)).setMinimumHeight(screenHeight - actionBarHeight);
                    return viewMembers;
            }
            return null;
        }
    }

    static class DesignDemoPagerAdapter extends FragmentStatePagerAdapter {

        public DesignDemoPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return DesignDemoFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return 6;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position)
            {
                case 0: return "کنداکتور";
                case 1: return "محورهای همایش";
                case 2: return "حامیان کنگره";
                case 3: return "تاریخچه کنگره";
                case 4: return "مقاله ها";
                case 5: return "اعضای کنگره";
            }
            return "";
        }
    }

}
