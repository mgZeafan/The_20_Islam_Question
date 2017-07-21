package com.app.mohamedgomaa.the_20_islam_question;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.yalantis.contextmenu.lib.ContextMenuDialogFragment;
import com.yalantis.contextmenu.lib.MenuParams;
import com.yalantis.contextmenu.lib.interfaces.OnMenuItemClickListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class Main_Question extends AppCompatActivity implements OnMenuItemClickListener {
    private AdView mAdView;
    InterstitialAd mInterstitialAd;
    adpterList_Language adpterList_lang;
    List<items_MainQuestions> myList = new ArrayList<>();
    AlertDialog.Builder  About_author;
    AlertDialog.Builder  selectLanuage;
    ListView listView;
    ListView Language_list;
    final int lenght = 20;
    menu_items my_items;
    int lang_id;
    private ContextMenuDialogFragment mMenuDialogFragmen;
    private FragmentManager fragmentManager;
    String[] lang = new String[]{"en", "ru", "hi", "de", "fr", "nl", "hy", "uk", "ro", "sq", "no", "hu", "el"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences lang = getSharedPreferences("lang", MODE_PRIVATE);
        lang_id = lang.getInt("key", 0);
        switch (lang_id) {
            case 0:
                setLocale("en");
                break;
            case 1:
                setLocale("ru");
                break;
            case 2:
                setLocale("hi");
                break;
            case 3:
                setLocale("de");
                break;
            case 4:
                setLocale("fr");
                break;
            case 5:
                setLocale("nl");
                break;
            case 6:
                setLocale("hy");
                break;
            case 7:
                setLocale("uk");
                break;
            case 8:
                setLocale("ro");
                break;
            case 9:
                setLocale("sq");
                break;
            case 10:
                setLocale("no");
                break;
            case 11:
                setLocale("hu");
                break;
            case 12:
                setLocale("el");
                break;
        }
        setContentView(R.layout.activity_main__question);
        //initilize_SelectLanguage();
        MobileAds.initialize(getApplicationContext(),
                "ca-app-pub-2377269014702707~1992291077");
        AdRequest adRequest_inter = new AdRequest.Builder().build();
        mInterstitialAd = new InterstitialAd(Main_Question.this);
        mInterstitialAd.setAdUnitId("ca-app-pub-2377269014702707/9096755477");
        mInterstitialAd.loadAd(adRequest_inter);
        mInterstitialAd.setAdListener(new AdListener(){
    @Override
    public void onAdClosed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
});

        mAdView = (AdView) findViewById(R.id.adView);
        if (new CheckConnnection(this).IsConnection()) {
            mAdView.setVisibility(View.VISIBLE);
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);
        }

        listView = (ListView) findViewById(R.id.listiew);
        my_items = new menu_items(getResources());
        fragmentManager = (FragmentManager) getSupportFragmentManager();
        initMenuFragment();
        mMenuDialogFragmen.setItemClickListener(this);

        for (int i = 0; i <= lenght; i++) {
            myList.add(new items_MainQuestions(i, getResources().getString(getResources()
                    .getIdentifier("title" + String.valueOf(i), "string", getPackageName())), getResources().getString(getResources()
                    .getIdentifier("question" + String.valueOf(i), "string", getPackageName()))));
        }
        adpterMainList my_adapter = new adpterMainList(myList);
        listView.setAdapter(my_adapter);

    }
    void initilize_SelectLanguage()
    {
        selectLanuage = new AlertDialog.Builder(this);
        selectLanuage.setTitle(getResources().getString(R.string.lang));
        Language_list = new ListView(this);
        adpterList_lang = new adpterList_Language(getApplicationContext(), getLayoutInflater(), getResources());
        Language_list.setAdapter(adpterList_lang);
        selectLanuage.setView(Language_list);
        selectLanuage.setNegativeButton("close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        Language_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SharedPreferences lang = getSharedPreferences("lang", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = lang.edit();
                editor.putInt("key", position);
                editor.apply();
                selectLanuage.setCancelable(true);
                finish();
                startActivity(new Intent(Main_Question.this, Main_Question.class));
            }

        });
    }

    @SuppressWarnings("deprecation")
    public void setLocale(String lang) {
        Locale myLocale = new Locale(lang);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        Configuration conf = getResources().getConfiguration();
        conf.locale = myLocale;
        getResources().updateConfiguration(conf, dm);
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }


    void initMenuFragment() {
        MenuParams menuParams = new MenuParams();
        menuParams.setActionBarSize((int) getResources().getDimension(R.dimen.menu_Size));
        menuParams.setMenuObjects(my_items.getMenuObj());
        menuParams.setClosableOutside(true);
        // set other settings to meet your needs
        mMenuDialogFragmen = ContextMenuDialogFragment.newInstance(menuParams);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.context_menu:
                if (fragmentManager.findFragmentByTag(ContextMenuDialogFragment.TAG) == null) {

                    mMenuDialogFragmen.show(fragmentManager, "ContextMenuDialogFragment");
                }
                break;
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder ExitsDialog = new AlertDialog.Builder(this);
        ExitsDialog.setMessage(getResources().getString(R.string.exist));
        ExitsDialog.setNegativeButton(getResources().getString(R.string.exis), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    }
                else {
                    Main_Question.super.onBackPressed();
                }
            }
        });

        ExitsDialog.setPositiveButton(getResources().getString(R.string.like), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent evaluate = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/details?id=com.app.mohamedgomaa.the_20_islam_question"));
                startActivity(evaluate);
            }
        });

        ExitsDialog.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (new CheckConnnection(this).IsConnection()) {
            mAdView.setVisibility(View.VISIBLE);
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);
        }
    }

    @Override
    public void onMenuItemClick(View clickedView, int position) {
        switch (position) {
            case 0:
                initilize_SelectLanguage();
                selectLanuage.show();
                break;
            case 1:
                About_author = new AlertDialog.Builder(this);
                 About_author.setTitle(getResources().getString(R.string.athor_name));
                View view = getLayoutInflater().inflate(R.layout.author_layout, null);
                About_author.setView(view);
                 About_author.setNegativeButton("close", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                       dialog.dismiss();
                  }
                });
                About_author.show();
                break;
            case 2:
                Intent i = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("https://www.facebook.com/zakirnaik/"));
                startActivity(i);
                break;
            case 3:
                Intent i2 = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("https://www.youtube.com/channel/UC3YmP7nqf514I1zh1eVbzrA"));
                startActivity(i2);
                break;
            case 4:
                String[] Email = new String[]{"zeafanm@gmail.com"};
                Intent gmail = new Intent(Intent.ACTION_SEND);
                gmail.setType("text/plain");
                gmail.putExtra(Intent.EXTRA_EMAIL, Email);
                gmail.putExtra(Intent.EXTRA_SUBJECT, "about application common questions about islam");

                startActivity(Intent.createChooser(gmail, "Send mail..."));

                break;
            case 5:
                Intent evaluate = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/details?id=com.app.mohamedgomaa.the_20_islam_question"));
                startActivity(evaluate);
                break;
            case 6:
                String uri_app = "https://play.google.com/store/apps/details?id=com.app.mohamedgomaa.the_20_islam_question";
                Intent sendIntent = new Intent(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, uri_app);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                break;
        }

    }

    class adpterMainList extends BaseAdapter {
        List<items_MainQuestions> _myList = new ArrayList<>();

        public adpterMainList(List<items_MainQuestions> myList) {

            this._myList = myList;
        }

        @Override
        public int getCount() {
            return _myList.size();
        }

        @Override
        public Object getItem(int position) {
            return _myList;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.raw_main_list, null);
            LinearLayout layout = (LinearLayout) view.findViewById(R.id.LinearL);
            TextView title = (TextView) view.findViewById(R.id.title);
            TextView question = (TextView) view.findViewById(R.id.question);
            TextView num = (TextView) view.findViewById(R.id.num);
            if (_myList.get(position).numquestion != 0) {
                title.setText(_myList.get(position).title);
                question.setText(_myList.get(position).question);
                num.setText(String.valueOf(_myList.get(position).numquestion));
            } else {
                num.setVisibility(View.GONE);
                question.setVisibility(View.GONE);
                title.setText(_myList.get(position).title);
                title.setGravity(Gravity.CENTER);
            }
            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Main_Question.this, Second_Activity.class);
                    i.putExtra("title", _myList.get(position).title);
                    i.putExtra("position", position);
                    i.putExtra("lang", lang[lang_id]);
                    startActivity(i);
                }
            });
            return view;
        }
    }
}
