package com.arandasebastian.fluxit_desafiotecnico.view;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.arandasebastian.fluxit_desafiotecnico.R;
import com.arandasebastian.fluxit_desafiotecnico.controller.UserController;
import com.arandasebastian.fluxit_desafiotecnico.model.User;
import com.arandasebastian.fluxit_desafiotecnico.utils.ResultListener;
import java.util.List;

public class UsersListFragment extends Fragment implements UsersAdapter.UserAdapterListener {

    ProgressBar progressBar;
    private FragmentUserListener fragmentUserListener;

    public UsersListFragment() {
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        fragmentUserListener = (FragmentUserListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_users_list, container, false);
        final SwipeRefreshLayout pullToRefresh = view.findViewById(R.id.swipe_refresh_layout);
        progressBar = view.findViewById(R.id.fragment_user_list_progressbar);
        progressBar.setVisibility(View.VISIBLE);
        RecyclerView recyclerView = view.findViewById(R.id.fragment_users_recycler);
        final UsersAdapter usersAdapter = new UsersAdapter(this);
        final UserController userController = new UserController();
        userController.getUsersFromDAO(new ResultListener<List<User>>() {
            @Override
            public void finish(List<User> result) {
                progressBar.setVisibility(View.GONE);
                usersAdapter.setUserList(result);
                usersAdapter.notifyDataSetChanged();
                Toast.makeText(getContext(), "El pedido se completo correctamente", Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        recyclerView.setAdapter(usersAdapter);
        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                userController.getUsersFromDAO(new ResultListener<List<User>>() {
                    @Override
                    public void finish(List<User> result) {
                        usersAdapter.setUserList(result);
                        usersAdapter.notifyDataSetChanged();
                        Toast.makeText(getContext(), "El pedido se completo correctamente", Toast.LENGTH_SHORT).show();
                        pullToRefresh.setRefreshing(false);
                    }
                });
            }
        });
        return view;
    }

    @Override
    public void sendSelectedUser(User user) {
        fragmentUserListener.receiveUser(user);
    }

    public interface FragmentUserListener{
        void receiveUser(User user);
    }

}
