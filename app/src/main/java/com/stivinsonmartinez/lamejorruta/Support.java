package com.stivinsonmartinez.lamejorruta;

import android.app.Activity;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Stivinson on 18/01/2016.
 */
public class Support {
    private final Activity context;
    private final String Text;
    private final Integer Imid1;

    public Support(Activity context, String text, Integer imid1) {
        this.context = context;
        Text = text;
        Imid1 = imid1;
    }
    public View getView(){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.support, null, true);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.suppicon);
        TextView textView = (TextView) rowView.findViewById(R.id.supptext);

        imageView.setImageResource(Imid1);
        textView.setText(Text);

        return rowView;
    }
}
