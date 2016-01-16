package com.stivinsonmartinez.lamejorruta;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Stivinson on 15/01/2016.
 */
public class Custom extends ArrayAdapter<String>{
    private final Activity context;
    private final String Text;
    private final Integer Imid1,Imid2,Imid3,Imid4,Imid5,Imid6,Imid7;

    public Custom(Activity context,String Text,Integer Imid1,Integer Imid2,Integer Imid3,Integer Imid4,Integer Imid5,Integer Imid6,Integer Imid7){
        super(context,R.layout.custom);

        this.context=context;
        this.Text=Text;
        this.Imid1=Imid1;
        this.Imid2=Imid2;
        this.Imid3=Imid3;
        this.Imid4=Imid4;
        this.Imid5=Imid5;
        this.Imid6=Imid6;
        this.Imid7=Imid7;
    }

    public View getView(){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.custom, null, true);

        TextView textView = (TextView) rowView.findViewById(R.id.tvText);
        ImageView imageView1 = (ImageView) rowView.findViewById(R.id.ivIcon1);
        ImageView imageView2 = (ImageView) rowView.findViewById(R.id.ivIcon2);
        ImageView imageView3 = (ImageView) rowView.findViewById(R.id.ivIcon3);
        ImageView imageView4 = (ImageView) rowView.findViewById(R.id.ivIcon4);
        ImageView imageView5 = (ImageView) rowView.findViewById(R.id.ivIcon5);
        ImageView imageView6 = (ImageView) rowView.findViewById(R.id.ivIcon6);
        ImageView imageView7 = (ImageView) rowView.findViewById(R.id.ivIcon7);

        imageView1.setImageResource(Imid1);
        imageView2.setImageResource(Imid2);
        imageView3.setImageResource(Imid3);
        imageView4.setImageResource(Imid4);
        imageView5.setImageResource(Imid5);
        imageView6.setImageResource(Imid6);
        imageView7.setImageResource(Imid7);
        textView.setText(Text);

        return rowView;
    }
}
