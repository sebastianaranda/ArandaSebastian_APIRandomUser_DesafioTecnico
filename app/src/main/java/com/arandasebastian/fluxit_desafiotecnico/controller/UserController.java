package com.arandasebastian.fluxit_desafiotecnico.controller;

import com.arandasebastian.fluxit_desafiotecnico.model.User;
import com.arandasebastian.fluxit_desafiotecnico.model.UserDAO;
import com.arandasebastian.fluxit_desafiotecnico.utils.ResultListener;
import java.util.List;
import java.util.Random;

public class UserController {

    private Integer PAGE_NUMBER = 1;
    private Random rand = new Random();
    private Integer SEED_KEY = rand.nextInt(100);

    public void getNewUsersFromDAO(final ResultListener<List<User>> viewListener){
        SEED_KEY = rand.nextInt(100);
        UserDAO userDAO = new UserDAO();
        userDAO.getUsersPaginated(new ResultListener<List<User>>() {
            @Override
            public void finish(List<User> result) {
                PAGE_NUMBER = PAGE_NUMBER + 1;
                viewListener.finish(result);
            }
        },SEED_KEY,PAGE_NUMBER);
    }

    public void getUsersPaginatedFromDAO(final ResultListener<List<User>> viewListener){
        UserDAO userDAO = new UserDAO();
        userDAO.getUsersPaginated(new ResultListener<List<User>>() {
            @Override
            public void finish(List<User> result) {
                PAGE_NUMBER = PAGE_NUMBER + 1;
                viewListener.finish(result);
            }
        },SEED_KEY,PAGE_NUMBER);
    }

    public Integer getSEED_KEY() {
        return SEED_KEY;
    }
}
