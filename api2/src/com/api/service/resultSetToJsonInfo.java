package com.api.service;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class resultSetToJsonInfo{
	public resultSetToJsonInfo(){
		
	}
	
public static String resultSetToJson2(ResultSet rs) throws SQLException,JSONException  
{  
   // json数组  
   JSONArray array = new JSONArray(); 
   
    
   // 获取列数  
   ResultSetMetaData metaData = rs.getMetaData();  
 
  int columnCount= metaData.getColumnCount();  
  
   JSONObject jsonObj=null;
   String coder=null;
   String msgr=null;
   // 遍历ResultSet中的每条数据  
   int count=0;
    while (rs.next()) {  
         jsonObj = new JSONObject();  
         if(columnCount==0)
        	 break;
        // 遍历每一列  
        for (int i = 1; i <= columnCount; i++) {  
            String columnName =metaData.getColumnLabel(i);  
            String value = rs.getString(columnName);  
            jsonObj.put(columnName, value);  
          
        } 
        count++;
       
        
        array.put(jsonObj);   
    }  
    
    if(count!=0){
    	coder="\"1\"";
    	msgr="\"操作成功\"";
    	
    }
    else{
    	coder="\"-1\"";
    	msgr="\"操作失败\"";
    }
    
    
      return "{"+"\"code\""+":"+coder+"<br>"+"\"msg\""+":"+msgr+"<br>"+"\"data\""+":"+array.toString()+"\n"+"}";  
 
	   
} 

} 