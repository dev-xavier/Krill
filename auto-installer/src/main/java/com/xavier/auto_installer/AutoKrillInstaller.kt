package com.xavier.auto_installer

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import com.xavier.installer.KrillInstaller

class AutoKrillInstaller : ContentProvider() {

    override fun onCreate(): Boolean {
        KrillInstaller.init(context!!.applicationContext)
        return true
    }

    override fun query(
        uri: Uri,
        projectionArg: Array<String>?,
        selection: String?,
        selectionArgs: Array<String>?,
        sortOrder: String?
    ): Cursor? = null

    override fun getType(uri: Uri): String? = null

    override fun insert(uri: Uri, contentValues: ContentValues?): Uri? = null

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int = 0

    override fun update(
        uri: Uri, values: ContentValues?, selection: String?, selectionArgs: Array<out String>?
    ): Int = 0
}