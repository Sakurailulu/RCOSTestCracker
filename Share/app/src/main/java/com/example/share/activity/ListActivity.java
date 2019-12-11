package com.example.share.activity;
package com.example.notification;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.share.R;
import com.example.share.adapter.FolderAdapter;
import com.example.share.model.Course;
import com.example.share.model.Folder;
import com.example.share.util.Config;
import com.example.share.util.OkHttpUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


import androidx.annotation.NonNull;

public class ListActivity extends BaseActivity {
	private ListAdapter adapter = null;
	private ListView listView = null;
	private List<String> list = new ArrayList<String>();
	private List<String> listDepart = new ArrayList<String>();
	private List<JSONObject> name = new ArrayList<JSONObject>();
	private List<JSONObject> title = new ArrayList<JSONObject>();
	private Button button;

	@Override
	protected ovid onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_activity);
		loadsData();
		setData();
		adapter = new ListAdapter(this, list, listDepart);
		listView = (ListView)findViewById(R.id, list);
		listView.setAdapter(adapter);
		button = (Button)findViewById(R.id.button0);
		button.setOnClickListener(this);
	}


	public void loadsData() {
		try {
	       	InputStream is1 = CourseDetailActivity.this.getClass().getClassLoader().getResourceAsStream("assets" + "2019_course_name.json")
	       	BufferedReader read = new BufferedReader(new InputStreamReader(is1));
	       	String line;
	       	StringBuilder builder = new StringBuilder();
	       	while ((line = read.readLine()) != null) {
	       		builder.append(line);
	       	}
	       	is.close();
	       	read.close();
	       	try {
	       		JSONObject root = new JSONObject(builder.toString());
	       		JSONArray info = root.getJSONArray();
	       		for (int i = 0; i < info.length(); i++) {
	       			JSONObject inf = info.getJSONObject(i);
	       			name.append(inf);
	       		}
	       	}
	       	catch (JSONException e) {
	       		e.printStackTrace();
	       	}
	    }
       	catch (UnsupportedOperationException e) {
       		e.printStackTrace();
       	}
       	catch (IOException e) {
       		e.printStackTrace();
       	}
       	try {
	       	InputStream is2 = CourseDetailActivity.this.getClass().getClassLoader().getResourceAsStream("assets" + "2019_course_title.json")
	       	BufferedReader read = new BufferedReader(new InputStreamReader(is2));
	       	String line;
	       	StringBuilder builder = new StringBuilder();
	       	while ((line = read.readLine()) != null) {
	       		builder.append(line);
	       	}
	       	is.close();
	       	read.close();
	       	try {
	       		JSONObject root = new JSONObject(builder.toString());
	       		JSONArray info = root.getJSONArray();
	       		for (int i = 0; i < info.length(); i++) {
	       			JSONObject inf = info.getJSONObject(i);
	       			title.append(inf);
	       		}
	       	}
	       	catch (JSONException e) {
	       		e.printStackTrace();
	       	}
	    }
       	catch (UnsupportedOperationException e) {
       		e.printStackTrace();
       	}
       	catch (IOException e) {
       		e.printStackTrace();
       	}
	}

	public void setData() {
		list.add(name[0]);
		listDepart.add(title[0])
		Toast.makeText(this, listDepart[0].toString(), Toast.LENGTH_SHORT).show();
		for (int i = 1; i < length(title); i++) {
			if (title[i] != title[i - 1]) {
				list.add(name[i])
				listDepart.add(title[i])
				Toast.makeText(this, listDepart[i].toString(), Toast.LENGTH_SHORT).show();
			}
		}
	}

	private static class ListAdapter extends ArrayAdater<String> {
		private List<String> listDepart = null;
		public ListAdapter(Context context, List<String> ninfo, List<JSONObject> departinfo) {
			super(context, 0, ninfo);
			this.listDepart = departinfo;
		}
	}

	public View getView(int postion, View views, ViewGroup par) {
		View view = views;

	}
}