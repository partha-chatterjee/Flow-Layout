package partha.flowlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class FlowFormattedActivity extends AppCompatActivity {

    ArrayList<String> localcountries;
    private FlowLayout flow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow_formatted);

        initFields();
    }

    private void initFields() {
        flow = (FlowLayout) findViewById(R.id.flow);
        fetchLocale();
    }

    private void fetchLocale() {
        Locale[] locales = Locale.getAvailableLocales();
        localcountries = new ArrayList<String>();
        for(Locale l:locales)
        {
            localcountries.add(l.getDisplayLanguage().toString());
            addView(l.getDisplayLanguage().toString(), localcountries.size()-1);
        }
    }

    private void addView(String name, final int position) {
        final View itemView =  LayoutInflater.from(this).inflate(R.layout.item_flow_layout, flow, false);
        TextView txtName = itemView.findViewById(R.id.txt_name);
        ImageView imgCross = itemView.findViewById(R.id.img_cross);
        txtName.setText(name);
        flow.addView(itemView);
        imgCross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                flow.removeViewAt(position);
                flow.removeView(itemView);
                localcountries.remove(position);
//                localcountries.notify();
//                flow.notify();
            }
        });
    }
}
