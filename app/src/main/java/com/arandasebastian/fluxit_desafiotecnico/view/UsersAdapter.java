package com.arandasebastian.fluxit_desafiotecnico.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.arandasebastian.fluxit_desafiotecnico.R;
import com.arandasebastian.fluxit_desafiotecnico.model.User;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersViewHolder> {

    private List<User> userList;
    private UserAdapterListener userAdapterListener;

    public UsersAdapter(UserAdapterListener userAdapterListener) {
        userList = new ArrayList<>();
        this.userAdapterListener = userAdapterListener;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
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
        User userShown = userList.get(position);
        holder.setUser(userShown);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class UsersViewHolder extends RecyclerView.ViewHolder{

        private TextView txtFirstName;
        private ImageView imgUser;

        public UsersViewHolder(@NonNull final View itemView) {
            super(itemView);
            txtFirstName = itemView.findViewById(R.id.user_row_fistname);
            imgUser = itemView.findViewById(R.id.user_image_profile);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TODO: cambiar comportamiento al hacer click
                    Toast.makeText(itemView.getContext(), "HICISTE CLICK", Toast.LENGTH_SHORT).show();
                    User selectedUser = userList.get(getAdapterPosition());
                    userAdapterListener.sendSelectedUser(selectedUser);
                }
            });
        }

        public void setUser(User user){
            txtFirstName.setText(user.getName().getFirstName());
            //TODO: agregar codigo para cargar imagen del usuario
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
