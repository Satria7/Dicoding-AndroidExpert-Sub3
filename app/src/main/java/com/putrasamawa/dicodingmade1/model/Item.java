package com.putrasamawa.dicodingmade1.model;

import android.os.Parcel;
import android.os.Parcelable;

//* Satria Junanda *//

public class Item implements Parcelable {
    private String mImageResource;
    private String mText1;
    private String mText2;

    public Item(String imageResource, String text1, String text2) {
        mImageResource = imageResource;
        mText1 = text1;
        mText2 = text2;
    }

    protected Item(Parcel in) {
        mImageResource = in.readString();
        mText1 = in.readString();
        mText2 = in.readString();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public String getImageResource() {
        return mImageResource;
    }

    public String getText1() {
        return mText1;
    }

    public String getText2() {
        return mText2;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mImageResource);
        dest.writeString(mText1);
        dest.writeString(mText2);
    }
}

//* Satria Junanda *//