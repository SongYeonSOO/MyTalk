package ys.grad.mytalk;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class TalkAdapter extends RecyclerView.Adapter<TalkAdapter.ViewHolder> {
    ArrayList<Talk> talks = new ArrayList<>();

    public TalkAdapter(ArrayList<Talk> talks) {
        this.talks = talks;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        View sView = mInflater.inflate(R.layout.layout_my_talk, parent, false);
        return new ViewHolder(sView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Talk curTalk = talks.get(position);
        Log.d("TAG", "onClick adapter: "+curTalk.getTime() + " / " + curTalk.getTalk() + " / " + curTalk.isMe() );
        if (curTalk.isMe()) {
            holder.otherLayout.setVisibility(View.GONE);
            holder.myLayout.setVisibility(View.VISIBLE);
            holder.myTimeView.setText(curTalk.getTime());
            holder.myTextView.setText(curTalk.getTalk());
            holder.otherTimeView.setText("");
            holder.otherTextView.setText("");

        } else {
            holder.myLayout.setVisibility(View.GONE);
            holder.otherLayout.setVisibility(View.VISIBLE);
            holder.otherTimeView.setText(curTalk.getTime());
            holder.otherTextView.setText(curTalk.getTalk());
            holder.myTimeView.setText("");
            holder.myTextView.setText("");
        }
    }

    @Override
    public int getItemCount() {
        return talks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout myLayout;
        RelativeLayout otherLayout;
        TextView myTextView, otherTextView, myTimeView, otherTimeView;

        public ViewHolder(View itemView) {
            super(itemView);
            myLayout = (LinearLayout) itemView.findViewById(R.id.layout_my);
            myTextView = (TextView) itemView.findViewById(R.id.text_my);
            myTimeView = (TextView) itemView.findViewById(R.id.time_my);
            otherLayout = (RelativeLayout) itemView.findViewById(R.id.layout_other);
            otherTextView = (TextView) itemView.findViewById(R.id.text_other);
            otherTimeView = (TextView) itemView.findViewById(R.id.time_other);
        }
    }
}
