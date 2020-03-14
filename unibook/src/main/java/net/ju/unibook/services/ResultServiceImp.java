package main.java.net.ju.unibook.services;

import main.java.net.ju.unibook.dao.ResultDaoImp;
import main.java.net.ju.unibook.entities.Result;

public class ResultServiceImp implements ResultService {

    private ResultDaoImp resultDaoImp;

    public ResultServiceImp() {
        resultDaoImp = new ResultDaoImp();
    }

    public Result getResultInfo(int userId) {
        return resultDaoImp.getResultInfo(userId);
    }
}
