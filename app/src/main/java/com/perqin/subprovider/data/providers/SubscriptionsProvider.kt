package com.perqin.subprovider.data.providers

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import android.os.ParcelFileDescriptor
import android.util.Base64
import org.json.JSONArray
import org.json.JSONObject
import java.net.URL

class SubscriptionsProvider : ContentProvider() {
    override fun openFile(uri: Uri, mode: String): ParcelFileDescriptor? {
        val file = context!!.filesDir.resolve("sub-cache").resolve("${uri.pathSegments.first()}.json")
        if (!file.parentFile!!.isDirectory && !file.parentFile!!.mkdirs()) {
            throw RuntimeException("Failed to mkdirs")
        }
        if (!file.exists()) {
            // Fetch
            val ssdResponse = URL("https://cn.bing.com"/*Replace with subscription URL*/).readText()
            if (!ssdResponse.startsWith("ssd://")) {
                throw RuntimeException("Malformed response")
            }
            val json = Base64.decode(ssdResponse.substring(6), 0).toString(Charsets.UTF_8)
            val jo = JSONObject(json)
            val s = jo.getJSONArray("servers")
            val result = JSONArray()
            for (i in 0 until s.length()) {
                val o = s.getJSONObject(i)
                result.put(JSONObject().apply {
                    put("server", o.getString("server"))
                    put("server_port", jo.getInt("port"))
                    put("password", jo.getString("password"))
                    put("method", jo.getString("encryption"))
                    put("remarks", o.getString("remarks"))
                })
            }
            file.writeText(result.toString())
        }
        return ParcelFileDescriptor.open(file, ParcelFileDescriptor.MODE_READ_ONLY)
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        throw UnsupportedOperationException()
    }

    override fun getType(uri: Uri): String? {
        throw UnsupportedOperationException()
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        throw UnsupportedOperationException()
    }

    override fun onCreate(): Boolean {
        return true
    }

    override fun query(
        uri: Uri, projection: Array<String>?, selection: String?,
        selectionArgs: Array<String>?, sortOrder: String?
    ): Cursor? {
        throw UnsupportedOperationException()
    }

    override fun update(
        uri: Uri, values: ContentValues?, selection: String?,
        selectionArgs: Array<String>?
    ): Int {
        throw UnsupportedOperationException()
    }
}