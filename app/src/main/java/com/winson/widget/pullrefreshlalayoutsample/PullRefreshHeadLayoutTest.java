package com.winson.widget.pullrefreshlalayoutsample;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.winson.widget.pullrefreshlayout.PullRefreshHeadLayout;
import com.winson.widget.pullrefreshlayout.PullRefreshHeadWatcher;

/**
 * <a href="https://github.com/WinsonZhou/PullRefreshLayout">the url of this project on the github</a>
 */
public class PullRefreshHeadLayoutTest extends PullRefreshHeadLayout {

    public static final String TAG = PullRefreshHeadWatcher.class.getSimpleName();

    private TextView progressFlagTV;
    private TextView refreshFlagTV;

    public PullRefreshHeadLayoutTest(Context context) {
        super(context);
        init(context, null, 0, 0);
    }

    public PullRefreshHeadLayoutTest(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0, 0);
    }

    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    public PullRefreshHeadLayoutTest(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr, 0);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PullRefreshHeadLayoutTest(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        View co = new View(context);
        LayoutParams lp1 = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        lp1.gravity = Gravity.BOTTOM | Gravity.LEFT;
        lp1.weight = 1;
        co.setLayoutParams(lp1);
        addView(co);

        progressFlagTV = new TextView(context);
        progressFlagTV.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        progressFlagTV.setTextColor(Color.RED);
        LayoutParams lp2 = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        lp2.gravity = Gravity.BOTTOM | Gravity.LEFT;
        progressFlagTV.setLayoutParams(lp2);
        addView(progressFlagTV);

        refreshFlagTV = new TextView(context);
        refreshFlagTV.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        refreshFlagTV.setTextColor(Color.RED);
        LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.BOTTOM | Gravity.LEFT;
        lp.topMargin = 10;
        refreshFlagTV.setLayoutParams(lp);
        addView(refreshFlagTV);
        refreshFlagTV.setText("Not on Refresh");

        setBackgroundColor(Color.parseColor("#42A5F5"));
    }

    @Override
    public void onPullProgressUpdate(int progress) {
        progressFlagTV.setText("onPullProgressUpdate : " + progress);
    }

    @Override
    public void onRefresh() {
        refreshFlagTV.setText("On Refresh!");

    }

    @Override
    public void onRefreshComplete() {
        refreshFlagTV.setText("Not on Refresh!");
    }


}
