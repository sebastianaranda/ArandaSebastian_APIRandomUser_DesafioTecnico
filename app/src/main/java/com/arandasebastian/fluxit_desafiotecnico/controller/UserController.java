package com.arandasebastian.fluxit_desafiotecnico.controller;

import com.arandasebastian.fluxit_desafiotecnico.model.User;
import com.arandasebastian.fluxit_desafiotecnico.model.UserDAO;
import com.arandasebastian.fluxit_desafiotecnico.utils.ResultListener;
import java.util.List;

public class UserController {

    public void getUsersFromDAO(final ResultListener<List<User>> viewListener){
        UserDAO userDAO = new UserDAO();

        userDAO.getUsers(new ResultListener<List<User>>() {
            @Override
            public void finish(List<User> result) {
                viewListener.finish(result);
            }
        });
    }

}
