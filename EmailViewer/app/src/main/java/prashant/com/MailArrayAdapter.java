package prashant.com;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;




public class MailArrayAdapter extends ArrayAdapter<EmailItem> {

    private List<EmailItem> emailItems;

    public MailArrayAdapter(@NonNull Context context, List<EmailItem> emailItems) {
        super(context,R.layout.recyclerview_mail_item,emailItems);
        this.emailItems = emailItems;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.recyclerview_mail_item,parent,false);
        }

        EmailItem currentItem = emailItems.get(position);

        TextView initialView = convertView.findViewById(R.id.inital);
        TextView titleView = convertView.findViewById(R.id.title);
        TextView contentView = convertView.findViewById(R.id.content);

        initialView.setText(currentItem.getTitleInitial());
        titleView.setText(currentItem.getTitle());
        contentView.setText(currentItem.getContent());


        return convertView;
    }
}
