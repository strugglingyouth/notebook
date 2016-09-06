package com.api.idao;

import java.sql.ResultSet;

import com.api.model.notearticle;
import com.api.model.noteclass;


public interface INotearticleDAO {
	public int insert(notearticle stu);//添加notearticle
	public ResultSet Query(String sql);//查找artiicle
	public int update(notearticle stu);//修改article
	public int delete(int ID);//删除article

}
