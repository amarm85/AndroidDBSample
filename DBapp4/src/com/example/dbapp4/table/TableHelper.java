package com.example.dbapp4.table;

public abstract class TableHelper implements Table {

	 public  String tableName;
	 //public static String CREATE_TABLE_SQL = null;
	 //public static String DELETE_TABLE_SQL = null; 
	 
	 public TableHelper(String tableName){
		 this.tableName = tableName;
	 }
	 
	 //protected abstract String createTableSql();
	 
	 //protected abstract String deleteTableSql();
	 	 
}
