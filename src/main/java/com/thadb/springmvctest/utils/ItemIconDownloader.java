package com.thadb.springmvctest.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;

import com.thadb.springmvctest.enums.ChampionType;
import com.thadb.springmvctest.enums.ItemType;

public class ItemIconDownloader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		for (ItemType c : Arrays.asList(ItemType.values())) {
			String itemName = c.name().replace("_", "-");
			itemName = itemName.replace(".", "").toLowerCase();
			itemName = itemName.replace("'", "");
			String itemOutName = itemName.replace("-", "_").toUpperCase();

			URL url = null;
			try {
				url = new URL("http://edge1.mobafire.com/images/item/"
						+ itemName + ".gif");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			URLConnection urlConnection;
			try {
				urlConnection = url.openConnection();
				BufferedInputStream in = new BufferedInputStream(
						urlConnection.getInputStream());
				File outFile = new File(System.getProperty("user.home")
						+ "/itemIcons/" + itemOutName + ".gif");
				System.out.println("Path: " + outFile.getAbsolutePath());
				if (!outFile.exists()) {
					new File(outFile.getParent()).mkdirs();
					outFile.createNewFile();
				}
				BufferedOutputStream out = new BufferedOutputStream(
						new FileOutputStream(outFile));
				int i;
				while ((i = in.read()) != -1) {
					out.write(i);
				}
				out.flush();

				out.close();
				in.close();

			} catch (IOException e) {
				System.out
						.println("Error saving champion: " + itemName + " : ");
				e.printStackTrace();
			}
		}

	}

}
