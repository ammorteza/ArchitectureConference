package com.ammorteza.architectureconference;

import android.app.Dialog;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
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

import java.util.ArrayList;
import java.util.HashMap;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.createActionBar();
        this.createPopUpMenu();

        DesignDemoPagerAdapter adapter = new DesignDemoPagerAdapter(getSupportFragmentManager());
        ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
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
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this , (ImageView)dialog.findViewById(R.id.con_dialog_img) , "con_part1_4.png");
                ((TextView)dialog.findViewById(R.id.con_dialog_subject)).setText("معماری و شهرسازی مدرن");
                ((TextView)dialog.findViewById(R.id.con_dialog_name)).setText("دکتر مترجم");
                ((TextView)dialog.findViewById(R.id.con_dialog_desc)).setText("ساخت و ساز، بنا کردن آبادی ها و راهکارهای شکل گیری آن از دیرباز مورد توجه انسان بوده است. ");
                ((TextView)dialog.findViewById(R.id.con_dialog_time)).setText("08:00");
                Log.d("11111111", "111111111111111111");
                break;
            case R.id.conItem2:
                LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(MainActivity.this , (ImageView)dialog.findViewById(R.id.con_dialog_img) , "con_part1_4.png");
                Log.d("222222222", "22222222222222");
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
                        return false;
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
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.con_banner1) , "irancell_banner.png");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.con_banner2) , "irancell_banner1.png");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.con_banner3) , "irancell_banner2.png");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.con_part1_img1) , "con_part1_4.png");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.con_part1_img2) , "con_part1_4.png");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.con_part1_img3) , "con_part1_4.png");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.con_part1_img4) , "con_part1_4.png");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.con_part1_img5) , "con_part1_4.png");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.con_part1_img6) , "con_part1_4.png");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.con_lunch_time) , "lunch_time.png");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.con_part2_img1) , "con_part1_4.png");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.con_part2_img2) , "con_part1_4.png");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.con_part2_img3) , "con_part1_4.png");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.con_part2_img4) , "con_part1_4.png");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.con_part2_img5) , "con_part1_4.png");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.con_part2_img6) , "con_part1_4.png");
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
                    break;
                case 4:
                    break;
                case 5:
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.execAdmin) , "con_part1_4.png");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.exec1) , "member.png");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.exec2) , "member.png");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.exec3) , "member.png");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.exec4) , "member.png");
                    LoadBigImage.createResizedImageViewWithoutPlaceHolderFromAssets(getContext() , (ImageView)view.findViewById(R.id.exec5) , "member.png");
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
                    DisplayMetrics displaymetrics = new DisplayMetrics();
                    getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
                    int screenHeight = displaymetrics.heightPixels;

                    int actionBarHeight = 0;
                    TypedValue tv = new TypedValue();
                    if (getActivity().getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
                        actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data,getResources().getDisplayMetrics());
                    }

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
