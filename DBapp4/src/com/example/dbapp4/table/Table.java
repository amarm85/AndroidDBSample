package com.example.dbapp4.table;

import java.util.List;

import com.example.dbapp4.model.Model;

public interface Table {

	 static final String TEXT_TYPE = " TEXT";
	 static final String COMMA_SEP = ",";
	 static final String INTEGER_TYPE = " INTEGER";
	 static final String REAL_TYPE = " REAL";
	 static final String DATE_TYPE = " DATETIME DEFAULT CURRENT_TIMESTAMP";
	 static final String PRIMARY_TYPE = "  PRIMARY KEY";
	 static final String _ID = "_id";
	 static final String _COUNT = "_count";
	 
	 int getCount();
	 
	 int update(Model model);
	 
	 Model find(int id);
	 
	 List<Model> findAll();
	 
	 int delete(Model model);
	 void add(Model model);
	 //String createTableSql();
	 //String deleteTableSql();
	 
	 //String setTableName();
	 
	 

	
}
