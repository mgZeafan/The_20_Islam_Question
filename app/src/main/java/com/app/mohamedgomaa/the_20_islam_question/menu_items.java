package com.app.mohamedgomaa.the_20_islam_question;

import android.content.res.Resources;
import android.graphics.Color;

import com.yalantis.contextmenu.lib.MenuObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohamed Gooma on 6/5/2017.
 */

public class menu_items {
    private Resources _resources;

    public menu_items(Resources _resources) {
        this._resources = _resources;
    }

    List<MenuObject> getMenuObj()
    {
        List<MenuObject> menuObjects=new ArrayList<>();
        MenuObject language=new MenuObject(_resources.getString(R.string.lang));
        language.setResource(R.drawable.lang);
        MenuObject author=new MenuObject(_resources.getString(R.string.Author));
        author.setResource(R.drawable.author);
        MenuObject facebook=new MenuObject(_resources.getString(R.string.facebook));
        facebook.setResource(R.drawable.facebook);
        MenuObject youtube=new MenuObject(_resources.getString(R.string.youtube));
        youtube.setResource(R.drawable.youtube);
        MenuObject send = new MenuObject(_resources.getString(R.string.send));
        send.setResource(R.drawable.msg);
        MenuObject share = new MenuObject(_resources.getString(R.string.share));
        share.setResource(R.drawable.ic_share_white_36dp);
        MenuObject rate = new MenuObject(_resources.getString(R.string.like));
        rate.setResource(R.drawable.rate);


        send.setBgColor(Color.argb(150,20,20,20));
        youtube.setBgColor(Color.argb(150,20,20,20));
        facebook.setBgColor(Color.argb(150,20,20,20));
        language.setBgColor(Color.argb(150,20,20,20));
        author.setBgColor(Color.argb(150,20,20,20));
        rate.setBgColor(Color.argb(150,20,20,20));
        share.setBgColor(Color.argb(150,20,20,20));
        menuObjects.add(language);
        menuObjects.add(author);
        menuObjects.add(facebook);
        menuObjects.add(youtube);
        menuObjects.add(send);
        menuObjects.add(rate);
        menuObjects.add(share);
        return menuObjects;
    }
}
