import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import prashant.com.R;

public class MailAdapter extends RecyclerView.Adapter<MailViewHolder> {

    private List<EmailItem> emailItems;

    public MailAdapter(List<EmailItem> emailItems){
        this.emailItems = emailItems;

    }


    @NonNull
    @Override
    public MailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_mail_item,parent,false);
        return new MailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MailViewHolder holder, int position) {
        EmailItem currentItem = emailItems.get(position);
        holder.initalTextView.setText(currentItem.getTitleInitial());
        holder.titleView.setText(currentItem.getTitle());
        holder.contentView.setText(currentItem.getContent());


    }


    @Override
    public int getItemCount() {
        return emailItems.size();
    }
}

class MailViewHolder extends RecyclerView.ViewHolder{
    public TextView initalTextView;
    public TextView titleView;
    public TextView contentView;

    public MailViewHolder(@NonNull View itemView) {
        super(itemView);

        initalTextView = itemView.findViewById(R.id.inital);
        titleView= itemView.findViewById(R.id.title);
        contentView = initalTextView.findViewById(R.id.content);
    }
}


