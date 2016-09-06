package com.api.idao;

import java.sql.ResultSet;

import com.api.model.group;


public interface IGroupDAO {
	public ResultSet Query(String sql);
	public int insert(group stu);
	public int delete(int id);
	public int update(group stu);
}
