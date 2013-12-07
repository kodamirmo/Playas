package com.karen.tourist_guide.webservices;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

public class DownloadImage {
	
	public static Bitmap getBitmapFromURL(String src) throws IOException {
		Log.e("src", src);
		URL url = new URL(src);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setDoInput(true);
		connection.connect();
		InputStream input = connection.getInputStream();
		Bitmap myBitmap = BitmapFactory.decodeStream(input);
		Log.e("TAG", "Imagen descargada");
		return myBitmap;
	}
}
