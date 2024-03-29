package com.example.share.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.share.R;

import java.util.List;

public class RemainAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private List<String> data;

    public RemainAdapter(Context context, List<String> data) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListViewItem listViewItem;
        if (convertView == null) {
            listViewItem = new ListViewItem();
            convertView = layoutInflater.inflate(R.layout.list_item, null);
            listViewItem.tvName = convertView.findViewById(R.id.tv1);
            convertView.setTag(listViewItem);
        } else {
            listViewItem = (ListViewItem) convertView.getTag();
        }

        listViewItem.tvName.setText(data.get(position));
        return convertView;
    }

    public final class ListViewItem {
        TextView tvName;
    }
}
