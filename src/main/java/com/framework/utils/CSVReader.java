package com.framework.utils;



import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;

import org.testng.Assert;

import com.google.common.io.Resources;
public class CSVReader {

	
	private String filename;
	public CSVReader(String filename) {
		this.filename = filename;
	}
	public Object[][] getData() {
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		InputStreamReader reader = null;
		BufferedReader br = null;

		try {
			System.out.println("Input File name: " + this.filename);
			URL fileUrl = Resources.getResource(this.filename);
			if(fileUrl == null) {
				Assert.fail("Input test data file: " + this.filename + " not found");
			}
			String file = URLDecoder.decode(fileUrl.getPath(), "UTF-8");
			reader = new InputStreamReader(new FileInputStream(file), "UTF-8");
			br = new BufferedReader(reader);
			int count = 0;

			String s;
			while ((s = br.readLine()) != null) {
				if(count != 0) {
					String[] strings = s.split(",", -1);
					ArrayList<String> str = new ArrayList<String>();
					String helper = "";
					for(int i = 0; i < strings.length; i++) {
						if(strings[i].contains("\"") && helper.equals("")) {
							helper = strings[i].replace("\"", "");
						} else if(helper.equals("")) {
							str.add(strings[i]);
						} else if(!helper.equals("") && !strings[i].contains("\"")) {
							helper = helper + "," + strings[i];
						} else if(!helper.equals("") && strings[i].contains("\"")) {
							helper = helper + "," + strings[i].replace("\"", "");
							str.add(helper);
							helper = "";
						}
					}
					list.add(str);
				}
				count++;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		} finally {
			try {
				if(reader != null) {
					reader.close();
				}
				if(br != null) {
					br.close();
				}
			} catch (Exception e) {
				System.out.println(e.toString());
				e.printStackTrace();
				Assert.fail("Exception while reading Input CSV files, Please check the input path.");
			}
		}

		Object[][] data = new Object[list.size()][list.get(0).size()];
		for(int i = 0; i < list.size(); i++) {
			ArrayList<String> subList = list.get(i);
			Object[] inner = new Object[subList.size()];
			for(int j = 0; j < subList.size(); j++) {
				inner[j] = subList.get(j);
			}
			data[i] = inner;
		}
		return data;
	}
}