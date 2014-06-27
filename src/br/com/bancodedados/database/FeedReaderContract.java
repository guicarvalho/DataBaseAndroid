package br.com.bancodedados.database;

import android.provider.BaseColumns;

public final class FeedReaderContract {

	public FeedReaderContract() {
	}

	public static abstract class FeedEntry implements BaseColumns {
		public static final String TABLE_NAME = "entry";
		public static final String COLUMN_NAME_ENTRY_ID = "entryid";
		public static final String COLUMN_NAME_ENTRY_TITLE = "title";
		public static final String COLUMN_NAME_ENTRY_SUBTITLE = "subtitle";
		public static final String COLUMN_NAME_ENTRY_CONTENT = "content";

		private static final String TEXT_TYPE = " TEXT";
		private static final String COMMA_SEP = ",";
		
		public static final String SQL_CREATE_ENTRIES = "CREATE TABLE "
				+ TABLE_NAME + " (" + _ID + " INTEGER PRIMARY KEY,"
				+ COLUMN_NAME_ENTRY_ID + TEXT_TYPE + COMMA_SEP
				+ COLUMN_NAME_ENTRY_TITLE + TEXT_TYPE + COMMA_SEP
				+ COLUMN_NAME_ENTRY_SUBTITLE + TEXT_TYPE + COMMA_SEP
				+ COLUMN_NAME_ENTRY_CONTENT + TEXT_TYPE + ")";
		
		public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS "
				+ FeedEntry.TABLE_NAME;
	}
}
