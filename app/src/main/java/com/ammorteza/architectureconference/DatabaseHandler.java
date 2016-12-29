package com.ammorteza.architectureconference;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

////////////////written by key team/////////////////////////
public class DatabaseHandler extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "ADataBase";
 
    // Contacts table name
    private static final String TABLE_ARTICLES = "tbl_articles";

    /////////////////////////// public field ////////////////////////////////////////////////////
    private static final String ID = "id";
    ///////////////////////////daily subscriptions offers fields ////////////////////////////////
    private static final String ATC_SUBJECT = "atcSubject";
    private static final String ATC_OWNER = "atcOwner";
    private static final String ATC_AXE = "atcAxe";
    private static final String ATC_TEXT = "atcText";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ARTICLES_TABLE = "CREATE TABLE " + TABLE_ARTICLES + "("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL , "
                + ATC_SUBJECT + " TEXT , "
                + ATC_OWNER + " TEXT , "
                + ATC_AXE + " TEXT , "
                + ATC_TEXT + " TEXT" + ")";
        db.execSQL(CREATE_ARTICLES_TABLE);
        addArticleContacts(db, "بررسی تاثیر الوند بر منظر فرهنگی شهر همدان", "محمد شعبانی", "باستان شناسی منظر فرهنگی ", "      کوهستان الوند واقع در جنوب شهر همدان مهمترین عنصر طبیعی این شهر محسوب میشود. این کوهستان در طول تاریخ همواره به عنوان منظر طبیعی، ارتباط ذهنی مردم شهر و خاطره جمعی آنان را شکل داده و به عنوان عنصری تاثیر گذار بخش مهمی از منظر فرهنگی شهروندان را به وجود آورده است. در عین حال الوند در شکل گیری بافت منظرین شهر همدان نقشی یگانه داشته و از ابتدای شکلگیری آن تا به امروز به عنوان نماد طبیعی آن محسوب میشود. در ذهن شهروندان شهر همدان، کوهستان الوند به عنوان مادری است که آنان را در آغوش گرفته و مهر و محبت خود را به آنها میبخشد و زندگی آنان را در سایه ویژگیهای طبیعی خود ممکن میسازد. تاثیر الوند در منظر شهری نیز که به عنوان یکی از عناصر شکل دهنده به فضای شهری و جزیی از ادارک کالبدی، تاثیر بسزایی در مطلوبیت یا عدم مطلوبیت فضای شهری دارد، تاثیر عمیقی داشته و باعث ارتباط بین مردم و محیط ساختگاه و در نتیجه نقش بسزایی در هویت بخشی و احساس آرامش شهروندان دارد. با وجود جایگاه کوهستان الوند در منظر فرهنگی شهر همدان، این مقوله هیچگاه از این زاویه مورد بررسی قرار نگرفته است و مطالعات موجود عموما در حول خود شهر همدان و سبقه تاریخی آن قرار دارد. از این رو در این تحقیق سعی شده است با پرداختن به منظر فرهنگی الوند، تاثیر آن بر مردم و شهر همدان مورد مطالعه قرار گیرد.");
        addArticleContacts(db , "زلزله و نقش آن بر تغییر و تحولات الگوی معماری و شهرسازی شهر همدان در ادوار مختلف تاریخی" , "خلیل الله بیک محمدی" , "منظر فرهنگی و منظر شهری تاریخی" , "بلایای طبیعی ممکن است در هر جا و در هر زمانی روی دهد که «زلزله» یکی از آنهاست؛ زلزله یا زمینلرزه از آزاد شدن ناگهاني انرژي انباشته شده در لایههاي پوسته زمين بهوجود ميآيد و با رها شدن انرژي بهصورت امواج، باعث لرزش سطح زمين شده و در صورت عدم رعایت استانداردها و استحکامات لازم در ساخت سازههای معماری، اين لرزش منجر به ویرانیهای جبرانناپذیر ميشود. یکی از شهرهایی که در طول تاریخ از آسیب و تخریبهای زلزله مصون نمانده، شهر «همدان» است که بهدلیل آسیبهای ناشی از این عامل طبیعی، خسارات و تخریبهای سنگینی را متحمل شده و به ناچار الگوهای معماری شهرسازی و بناهای مختلف آن تغییر یافته و از نوع ساخته شده است. با توجه به قرار داشتن همدان در کمربند گسل زلزلهخیز بزرگ زاگرس، این شهر در ادوار مختلف تاریخی (345، 480، 586، 833 هـ.ق. و...) بارها بهواسطهی زلزله ویران شده است، بهطوریکه بنابه گزارش مورخین در زلزلهی 345 هـ.ق. اماکن مسکونی و در زلزلهی 480 هـ.ق. دو برج از دژ همدان و دو منطقه در حومهی آن تخریب شده و تعداد زیادی از اهالی آن جان باختهاند. حال پرسش این است: زلزله و تخریبهای ناشی از آن، چه نقشی بر تحولات و تغییرات الگوی معماری و شهرسازی همدان در طول تاریخ داشته است؟ هدف اصلی پژوهش پیشِرو واکاوی زلزلههای مهیب تاریخی شهر همدان و پرداختن به این عامل تأثیرگذار در تحولات الگوی معماری و شهرسازی در طول حیات تاریخی است. روش پژوهش با بهرهمندی از منابع تاریخی، به روشهای کتابخانهای و تحلیلی از توصیفات یاد شده توسط مورخان از زلزلههای تاریخی و همچنین نقشهها و الگوهای تغییر یافته معماری و شهرسازی همدان خواهد بود. برآیند پژوهش، نشانگر آن است که شهر همدان در طول تاریخ بهواسطهی زلزلههای متعدد، بخشی از برج و بارو و همچنین بناهای مختلف شهر تخریب و از نو ساخته و الگوی معماری و شهرسازی آن تغییر شکل داده؛ بهگونهای که در این رهیافت، جمعیت همدان نیز بعد از هر زلزله، دچار نوسان بوده و کاهش یافته است.\n" + "کلیدواژگان: زلزله، معماری، شهرسازی، همدان، تخریب.");
    }
 
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (oldVersion)
        {
            case 1:
                break;
        }
    }
 
    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */
    ///////////////////////////////////////////// offers method /////////////////////////////////////////
    public void addArticleContacts(SQLiteDatabase db , String subject , String owner , String axe , String text) {

        ContentValues values = new ContentValues();
        values.put(ATC_SUBJECT, subject);
        values.put(ATC_OWNER, owner);
        values.put(ATC_AXE, axe);
        values.put(ATC_TEXT, text);
        db.insert(TABLE_ARTICLES, null, values);
    }

    //Getting count
    public int getArticleCount()
    {
        String selectQuery = "SELECT  * FROM " + TABLE_ARTICLES;
        Log.d("sql", selectQuery);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        return cursor.getCount();
    }

     
    // Getting All Contacts
    public ArrayList<HashMap<String, Object>> getAllArticleContacts() {
        ArrayList<HashMap<String, Object>> contactList = new ArrayList<HashMap<String,Object>>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ARTICLES;
 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, Object> temp = new HashMap<String, Object>();
                temp.put("subject", cursor.getString(cursor.getColumnIndex(ATC_SUBJECT)));
                temp.put("owner", cursor.getString(cursor.getColumnIndex(ATC_OWNER)));
                temp.put("axe", cursor.getString(cursor.getColumnIndex(ATC_AXE)));
                temp.put("text",cursor.getString(cursor.getColumnIndex(ATC_TEXT)));
                contactList.add(temp);
            } while (cursor.moveToNext());
        }

        return contactList;
    }
    
    public void deleteAllOffersContacts()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ARTICLES,null,null);
        //db.close();
    }
}
