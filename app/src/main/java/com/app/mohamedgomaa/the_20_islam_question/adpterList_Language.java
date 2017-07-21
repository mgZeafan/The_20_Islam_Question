package com.app.mohamedgomaa.the_20_islam_question;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

class adpterList_Language extends BaseAdapter {
    List<list_item_language> m_list_lang=new ArrayList<>();
    LayoutInflater _myInflater;
    private Resources _resourse;
    private Context con;
    public adpterList_Language(Context con,LayoutInflater myInflater,Resources resources) {
        this._resourse=resources;
        this.con=con;
        this._myInflater=myInflater;
        m_list_lang.add(new list_item_language(R.drawable.united_states,_resourse.getString(R.string.lang_1)));
        m_list_lang.add(new list_item_language(R.drawable.russia_640,_resourse.getString(R.string.lang_2)));
        m_list_lang.add(new list_item_language(R.drawable.india_640,_resourse.getString(R.string.lang_3)));
        m_list_lang.add(new list_item_language(R.drawable.german,_resourse.getString(R.string.lang_4)));
        m_list_lang.add(new list_item_language(R.drawable.france,_resourse.getString(R.string.lang_5)));
        m_list_lang.add(new list_item_language(R.drawable.dutch,_resourse.getString(R.string.lang_6)));
        m_list_lang.add(new list_item_language(R.drawable.armenia,_resourse.getString(R.string.lang_7)));
        m_list_lang.add(new list_item_language(R.drawable.ukraine,_resourse.getString(R.string.lang_8)));
        m_list_lang.add(new list_item_language(R.drawable.romania_640,_resourse.getString(R.string.lang_9)));
        m_list_lang.add(new list_item_language(R.drawable.albania_640,_resourse.getString(R.string.lang_10)));
        m_list_lang.add(new list_item_language(R.drawable.norway_640,_resourse.getString(R.string.lang_11)));
        m_list_lang.add(new list_item_language(R.drawable.hungary_640,_resourse.getString(R.string.lang_12)));
        m_list_lang.add(new list_item_language(R.drawable.greec,_resourse.getString(R.string.lang_13)));
    }

    @Override
    public int getCount() {
        return m_list_lang.size();
    }

    @Override
    public Object getItem(int position) {
        return m_list_lang.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        View view = _myInflater.inflate(R.layout.language_raw, null);
        LinearLayout layout=(LinearLayout)view.findViewById(R.id.linear_id);
        ImageView img=(ImageView)view.findViewById(R.id.image_language);
        TextView textLang=(TextView)view.findViewById(R.id.text_lang);
        img.setImageResource(m_list_lang.get(position).id_image);
        textLang.setText(m_list_lang.get(position).name_language);
        return view;
    }
}