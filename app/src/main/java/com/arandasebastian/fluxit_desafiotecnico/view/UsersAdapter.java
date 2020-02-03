package com.arandasebastian.fluxit_desafiotecnico.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.arandasebastian.fluxit_desafiotecnico.R;
import com.arandasebastian.fluxit_desafiotecnico.model.User;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersViewHolder> {

    private List<User> userList;
    private List<User> userListFiltered;
    private UserAdapterListener userAdapterListener;

    public UsersAdapter(UserAdapterListener userAdapterListener) {
        userList = new ArrayList<>();
        userListFiltered = new ArrayList<>();
        this.userAdapterListener = userAdapterListener;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
        this.userListFiltered = userList;
        notifyDataSetChanged();
    }

    public void addNewUsers(List<User> newUsers){
        this.userList.addAll(newUsers);
        this.userListFiltered = userList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View rowView = inflater.inflate(R.layout.user_row,parent,false);
        return new UsersViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, int position) {
        User userShown = userListFiltered.get(position);
        holder.setUser(userShown);
    }

    @Override
    public int getItemCount() {
        return userListFiltered.size();
    }

    public void filter(String inputText) {
        ArrayList<User> newUserListFiltered = new ArrayList<>();
        for (User user : userList) {
            String userToSearch = user.getName().getLastName().toLowerCase()+ " " + user.getName().getFirstName().toLowerCase();
            if(userToSearch.contains(inputText.toLowerCase())){
                newUserListFiltered.add(user);
            }
        }
        userListFiltered = newUserListFiltered;
        notifyDataSetChanged();
    }

    public class UsersViewHolder extends RecyclerView.ViewHolder{

        private TextView txtFirstName;
        private TextView txtLastName;
        private ImageView imgUser;

        public UsersViewHolder(@NonNull final View itemView) {
            super(itemView);
            txtFirstName = itemView.findViewById(R.id.user_row_fistname);
            txtLastName = itemView.findViewById(R.id.user_row_lastname);
            imgUser = itemView.findViewById(R.id.user_image_profile);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    User selectedUser = userListFiltered.get(getAdapterPosition());
                    userAdapterListener.sendSelectedUser(selectedUser);
                }
            });
        }

        public void setUser(User user){
            txtFirstName.setText(user.getName().getFirstName());
            txtLastName.setText(user.getName().getLastName());
            Glide.with(itemView)
                    .load(user.getPictures().getPictureLarge())
                    .placeholder(R.drawable.img_profile_placeholder)
                    .into(imgUser);
        }
    }

    public interface UserAdapterListener {
        public void sendSelectedUser(User user);
    }

}
