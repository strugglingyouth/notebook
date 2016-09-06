package com.api.idao;

import java.sql.ResultSet;

import com.api.model.noteclass;
import com.api.model.user;

public interface INoteclassDAO {

		public int insert(noteclass stu);
		public ResultSet Query(String sql);
		public int update(noteclass stu);
		public int delete(int ID);
		//public List<user> select(String condt); 
	}


