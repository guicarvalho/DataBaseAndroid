package br.com.bancodedados.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import br.com.bancodedados.database.FeedReaderContract.FeedEntry;
import br.com.bancodedados.model.Feed;

public class FeedDao {
	private FeedReaderDbHelper mDbHelper;

	public FeedDao(Context context) {
		mDbHelper = new FeedReaderDbHelper(context);
	}

	public long insert(Feed f) {
		SQLiteDatabase db = null;
		try {
			db = mDbHelper.getWritableDatabase();
		} catch (SQLiteException e) {
			e.printStackTrace();
		}
		ContentValues values = new ContentValues();
		values.put(FeedEntry.COLUMN_NAME_ENTRY_ID, f.getId());
		values.put(FeedEntry.COLUMN_NAME_ENTRY_TITLE, f.getTitle());
		values.put(FeedEntry.COLUMN_NAME_ENTRY_SUBTITLE, f.getSubtitle());
		values.put(FeedEntry.COLUMN_NAME_ENTRY_CONTENT, f.getContent());

		long newRowId = db.insert(FeedEntry.TABLE_NAME, null, values);

		return newRowId;
	}

	public List<Feed> selectAll() {
		List<Feed> list = new ArrayList<Feed>();

		// colunas que vc quer exibir no select
		String[] projection = { FeedEntry.COLUMN_NAME_ENTRY_ID,
				FeedEntry.COLUMN_NAME_ENTRY_TITLE,
				FeedEntry.COLUMN_NAME_ENTRY_SUBTITLE,
				FeedEntry.COLUMN_NAME_ENTRY_CONTENT };

		String sortOrder = FeedEntry.COLUMN_NAME_ENTRY_TITLE + " DESC";

		SQLiteDatabase db = mDbHelper.getWritableDatabase();
		Cursor cursor = db.query(FeedEntry.TABLE_NAME, projection, null, null,
				null, null, sortOrder);

		while (cursor.moveToNext()) {
			list.add(new Feed(
					cursor.getLong(cursor
							.getColumnIndexOrThrow(FeedEntry.COLUMN_NAME_ENTRY_ID)),
					cursor.getString(cursor
							.getColumnIndexOrThrow(FeedEntry.COLUMN_NAME_ENTRY_TITLE)),
					cursor.getString(cursor
							.getColumnIndexOrThrow(FeedEntry.COLUMN_NAME_ENTRY_SUBTITLE)),
					cursor.getString(cursor
							.getColumnIndexOrThrow(FeedEntry.COLUMN_NAME_ENTRY_CONTENT))));
		}

		return list;
	}

}
