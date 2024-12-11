package za.hp.cwengandudula;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    //Reference to contacts to be displayed
    private final List<Contact> contacts;
    public ContactAdapter(List<Contact> contacts){
        this.contacts = contacts;
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {
        //region Properties & View References
        public ImageView imgAvatar;
        public TextView txtName, txtNumber, txtEmail;
        public ImageButton btnDial, btnMsg, btnDelete;
        public Contact contact;
        //endregion
        public ContactViewHolder(@NonNull View view) {
            super(view);

            txtName = view.findViewById(R.id.txtName);
            txtNumber = view.findViewById(R.id.txtNumber);
            txtEmail = view.findViewById(R.id.txtEmail);
            imgAvatar = view.findViewById(R.id.imgAvatar);
            btnDial = view.findViewById(R.id.btnDial);
            btnMsg = view.findViewById(R.id.btnMsg);
            btnDelete = view.findViewById(R.id.btnDelete);

            btnDial.setOnClickListener(v-> onDialClicked());
            btnMsg.setOnClickListener(v-> onMsgClicked());
            btnDelete.setOnClickListener(v-> onDeleteClicked());
        }

        public void setContact(Contact contact) {
            this.contact = contact;

            txtName.setText(contact.getName());
            txtNumber.setText(contact.getPhoneNo());
            txtEmail.setText(contact.getEmail());
            imgAvatar.setImageResource(R.drawable.avatar_08);
        }
        private void onDialClicked() {
            // Logic for dialing (e.g., opening a phone dialer with the number)
            if (contact != null && contact.getPhoneNo() != null) {
                Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                dialIntent.setData(Uri.parse("tel:" + contact.getPhoneNo()));
                itemView.getContext().startActivity(dialIntent);
            }
        }
        private void onMsgClicked() {
            // Logic for composing an email
            if (contact != null && contact.getEmail() != null) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:" + contact.getEmail()));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Hello " + contact.getName());
                itemView.getContext().startActivity(Intent.createChooser(emailIntent, "Send Email"));
            }
        }        
        private void onDeleteClicked(){

        }
    }

    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        //Here We inflate/create the Object associated with the layout (Contact Card);
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.contact,
                        parent, false);

        ContactViewHolder cvh = new ContactViewHolder(view);
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int pos){
        Contact contact = contacts.get(pos);
        holder.setContact(contact);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
    //Tells RecyclerVIew how much data is to be displayed

    public void addNewContact(Contact contact){
        contacts.add(contact);

        //Notify RecyclerView of data changes
        notifyItemChanged(contacts.size()-1); //Built-in method
    }

    //public void remove (Not required in this assignment)

    public Contact getContactIndex(int pos){
        return contacts.get(pos);
    }


}