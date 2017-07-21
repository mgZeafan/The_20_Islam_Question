package com.app.mohamedgomaa.the_20_islam_question;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Second_Activity extends AppCompatActivity implements OnPageChangeListener {
    TextView textView;
    Toolbar toolbar;
    String filename;
    private AdView mAdView;

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_);

        MobileAds.initialize(getApplicationContext(),
                "ca-app-pub-2377269014702707~1992291077");
        mAdView = (AdView) findViewById(R.id.adView2);
        if(new CheckConnnection(this).IsConnection()) {
            mAdView.setVisibility(View.VISIBLE);
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);
        }



        textView = (TextView) findViewById(R.id.textbar);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String title = getIntent().getExtras().getString("title");
        int pos = getIntent().getExtras().getInt("position");
        String lang = getIntent().getExtras().getString("lang");

        int num_page = getPages_num(pos, lang);
        if (num_page == 1000) {
            filename = "English1.pdf";
            num_page = 0;
        }

        textView.setText(title);
        PDFView pdfView = (PDFView) findViewById(R.id.pdfView);
        pdfView.fromAsset(filename).defaultPage(num_page).enableSwipe(true).swipeHorizontal(false).enableAntialiasing(true).onPageChange(this).load();

    }

    int getPages_num(int pos, String lang) {
        if (lang.equals("en")) {
            filename = "English2.pdf";
            switch (pos) {
                case 0:
                    return 1;

                case 1:
                    return 3;
                case 2:
                    return 6;
                case 3:
                    return 8;
                case 4:
                    return 12;
                case 5:
                    return 14;
                case 6:
                    return 17;
                case 7:
                    return 21;
                case 8:
                    return 22;
                case 9:
                    return 23;
                case 10:
                    return 24;
                case 11:
                    return 25;
                case 12:
                    return 26;
                case 13:
                    return 31;
                case 14:
                    return 33;
                case 16:
                    return 36;
                case 15:
                    return 1000;
                case 17:
                    return 40;
                case 18:
                    return 42;
                case 19:
                    return 46;
                case 20:
                    return 48;
            }
        }

        ////////////////////////hinda
        else if (lang.equals("hi")) {
            filename = "india.pdf";
            switch (pos) {
                case 0:
                    return 0;
                case 1:
                    return 0;
                case 2:
                    return 4;
                case 3:
                    return 6;
                case 4:
                    return 11;
                case 5:
                    return 14;
                case 6:
                    return 16;
                case 7:
                    return 20;
                case 8:
                    return 21;
                case 9:
                    return 23;
                case 10:
                    return 25;
                case 11:
                    return 27;
                case 12:
                    return 30;
                case 13:
                    return 36;
                case 14:
                    return 39;
                case 16:
                    return 42;
                case 15:
                    return 1000;
                case 17:
                    return 47;
                case 18:
                    return 50;
                case 19:
                    return 53;
                case 20:
                    return 55;
            }
        }

        //////////////////////////////////////////////
        else if (lang.equals("ru")) {
            filename = "russian.pdf";
            switch (pos) {
                case 0:
                    return 3;

                case 1:
                    return 6;
                case 2:
                    return 10;
                case 3:
                    return 11;
                case 4:
                    return 15;
                case 5:
                    return 18;
                case 6:
                    return 21;
                case 7:
                    return 25;
                case 8:
                    return 26;
                case 9:
                    return 27;
                case 10:
                    return 28;
                case 11:
                    return 29;
                case 12:
                    return 31;
                case 13:
                    return 36;
                case 14:
                    return 39;
                case 16:
                    return 42;
                case 15:
                    return 1000;
                case 17:
                    return 46;
                case 18:
                    return 49;
                case 19:
                    return 53;
                case 20:
                    return 55;
            }
        } else if (lang.equals("de")) {
            filename = "german.pdf";
            switch (pos) {
                case 0:
                    return 2;

                case 1:
                    return 4;
                case 2:
                    return 7;
                case 3:
                    return 8;
                case 4:
                    return 12;
                case 5:
                    return 14;
                case 6:
                    return 17;
                case 7:
                    return 20;
                case 8:
                    return 21;
                case 9:
                    return 22;
                case 10:
                    return 24;
                case 11:
                    return 25;
                case 12:
                    return 26;
                case 13:
                    return 30;
                case 14:
                    return 32;
                case 16:
                    return 34;
                case 15:
                    return 1000;
                case 17:
                    return 38;
                case 18:
                    return 40;
                case 19:
                    return 44;
                case 20:
                    return 46;
            }
        } else if (lang.equals("fr")) {
            filename = "franch.pdf";
            switch (pos) {
                case 0:
                    return 0;

                case 1:
                    return 2;
                case 2:
                    return 5;
                case 3:
                    return 6;
                case 4:
                    return 9;
                case 5:
                    return 11;
                case 6:
                    return 14;
                case 7:
                    return 17;
                case 8:
                    return 18;
                case 9:
                    return 19;
                case 10:
                    return 20;
                case 11:
                    return 21;
                case 12:
                    return 23;
                case 13:
                    return 26;
                case 14:
                    return 28;
                case 16:
                    return 30;
                case 15:
                    return 1000;
                case 17:
                    return 33;
                case 18:
                    return 35;
                case 19:
                    return 39;
                case 20:
                    return 41;
            }
        } else if (lang.equals("nl")) {
            filename = "alWolandy.pdf";
            switch (pos) {
                case 0:
                    return 2;

                case 1:
                    return 6;
                case 2:
                    return 11;
                case 3:
                    return 13;
                case 4:
                    return 19;
                case 5:
                    return 23;
                case 6:
                    return 27;
                case 7:
                    return 33;
                case 8:
                    return 35;
                case 9:
                    return 37;
                case 10:
                    return 39;
                case 11:
                    return 41;
                case 12:
                    return 44;
                case 13:
                    return 50;
                case 14:
                    return 54;
                case 16:
                    return 59;
                case 15:
                    return 1000;
                case 17:
                    return 64;
                case 18:
                    return 68;
                case 19:
                    return 74;
                case 20:
                    return 76;
            }

        } else if (lang.equals("hy")) {
            filename = "Armenian.pdf";
            switch (pos) {
                case 0:
                    return 3;
                case 1:
                    return 9;
                case 2:
                    return 17;
                case 3:
                    return 20;
                case 4:
                    return 29;
                case 5:
                    return 34;
                case 6:
                    return 40;
                case 7:
                    return 48;
                case 8:
                    return 50;
                case 9:
                    return 53;
                case 10:
                    return 55;
                case 11:
                    return 57;
                case 12:
                    return 61;
                case 13:
                    return 70;
                case 14:
                    return 77;
                case 16:
                    return 82;
                case 15:
                    return 1000;
                case 17:
                    return 91;
                case 18:
                    return 96;
                case 19:
                    return 106;
                case 20:
                    return 109;
            }
        } else if (lang.equals("uk")) {
            filename = "Ukrainian.pdf";
            switch (pos) {
                case 0:
                    return 3;
                case 1:
                    return 7;
                case 2:
                    return 13;
                case 3:
                    return 15;
                case 4:
                    return 23;
                case 5:
                    return 27;
                case 6:
                    return 32;
                case 7:
                    return 38;
                case 8:
                    return 40;
                case 9:
                    return 42;
                case 10:
                    return 44;
                case 11:
                    return 46;
                case 12:
                    return 49;
                case 13:
                    return 56;
                case 14:
                    return 61;
                case 16:
                    return 66;
                case 15:
                    return 1000;
                case 17:
                    return 73;
                case 18:
                    return 78;
                case 19:
                    return 86;
                case 20:
                    return 89;
            }
        } else if (lang.equals("ro")) {
            filename = "romani.pdf";
            switch (pos) {
                case 0:
                    return 4;
                case 1:
                    return 9;
                case 2:
                    return 16;
                case 3:
                    return 18;
                case 4:
                    return 25;
                case 5:
                    return 31;
                case 6:
                    return 35;
                case 7:
                    return 43;
                case 8:
                    return 45;
                case 9:
                    return 47;
                case 10:
                    return 50;
                case 11:
                    return 51;
                case 12:
                    return 55;
                case 13:
                    return 63;
                case 14:
                    return 67;
                case 16:
                    return 71;
                case 15:
                    return 1000;
                case 17:
                    return 78;
                case 18:
                    return 82;
                case 19:
                    return 89;
                case 20:
                    return 92;
            }
        } else if (lang.equals("sq")) {
            filename = "albany.pdf";
            switch (pos) {
                case 0:
                    return 8;
                case 1:
                    return 14;
                case 2:
                    return 22;
                case 3:
                    return 26;
                case 4:
                    return 36;
                case 5:
                    return 42;
                case 6:
                    return 48;
                case 7:
                    return 56;
                case 8:
                    return 60;
                case 9:
                    return 64;
                case 10:
                    return 68;
                case 11:
                    return 72;
                case 12:
                    return 78;
                case 13:
                    return 86;
                case 14:
                    return 92;
                case 16:
                    return 98;
                case 15:
                    return 1000;
                case 17:
                    return 108;
                case 18:
                    return 114;
                case 19:
                    return 124;
                case 20:
                    return 128;
            }
        }

        //////////////////////////////////
        else if (lang.equals("no")) {
            filename = "narwege.pdf";

            switch (pos) {
                case 0:
                    return 2;
                case 1:
                    return 3;
                case 2:
                    return 6;
                case 3:
                    return 7;
                case 4:
                    return 10;
                case 5:
                    return 13;
                case 6:
                    return 15;
                case 7:
                    return 20;
                case 8:
                    return 22;
                case 9:
                    return 24;
                case 10:
                    return 25;
                case 11:
                    return 27;
                case 12:
                    return 31;
                case 13:
                    return 33;
                case 14:
                    return 35;
                case 16:
                    return 39;
                case 15:
                    return 1000;
                case 17:
                    return 42;
                case 18:
                    return 44;
                case 19:
                    return 46;
                case 20:
                    return 47;
            }
        }
        else if (lang.equals("hu")) {
            filename = "magyar – Hungarian.pdf";

            switch (pos) {
                case 0:
                    return 4;
                case 1:
                    return 8;
                case 2:
                    return 14;
                case 3:
                    return 16;
                case 4:
                    return 23;
                case 5:
                    return 27;
                case 6:
                    return 31;
                case 7:
                    return 38;
                case 8:
                    return 40;
                case 9:
                    return 42;
                case 10:
                    return 44;
                case 11:
                    return 46;
                case 12:
                    return 49;
                case 13:
                    return 56;
                case 14:
                    return 61;
                case 16:
                    return 65;
                case 15:
                    return 1000;
                case 17:
                    return 72;
                case 18:
                    return 77;
                case 19:
                    return 83;
                case 20:
                    return 87;
            }
        }
        else if (lang.equals("el")) {
            filename = "unane.pdf";
            switch (pos) {
                case 0:
                    return 3;
                case 1:
                    return 8;
                case 2:
                    return 16;
                case 3:
                    return 19;
                case 4:
                    return 28;
                case 5:
                    return 35;
                case 6:
                    return 40;
                case 7:
                    return 50;
                case 8:
                    return 53;
                case 9:
                    return 55;
                case 10:
                    return 58;
                case 11:
                    return 61;
                case 12:
                    return 65;
                case 13:
                    return 75;
                case 14:
                    return 81;
                case 16:
                    return 86;
                case 15:
                    return 1000;
                case 17:
                    return 96;
                case 18:
                    return 102;
                case 19:
                    return 112;
                case 20:
                    return 116;
            }
        }


        return 0;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            startActivity(new Intent(this, Main_Question.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPageChanged(int page, int pageCount) {
        Toast.makeText(this, String.valueOf(page + 1) + "-" + String.valueOf(pageCount), Toast.LENGTH_SHORT).show();

    }
}
