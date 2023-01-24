package com.example.convidados.repository

import android.content.ContentValues
import android.content.Context
import com.example.convidados.constants.DataBaseConstants
import com.example.convidados.model.GuestModel

class GuestRepository(context: Context) {

    private val guestDataBase = GuestDataBase.getDataBase(context).guestDAO()

//    companion object {
//        private lateinit var repository: GuestRepository
//
//        fun getInstance(context: Context): GuestRepository {
//            if (!::repository.isInitialized) {
//                repository = GuestRepository(context)
//            }
//            return repository
//        }
//    }

    fun insert(guest: GuestModel): Boolean {
        return guestDataBase.insert(guest) > 0

//        return try {
//            val db = guestDataBase.writableDatabase
//
//            val presence = if (guest.presenca) 1 else 0
//
//            val values = ContentValues()
//            values.put(DataBaseConstants.GUEST.COLUMNS.NAME, guest.name)
//            values.put(DataBaseConstants.GUEST.COLUMNS.PRESENCE, presence)
//
//            db.insert(DataBaseConstants.GUEST.TABLE_NAME, null, values)
//            true
//        } catch (e: Exception) {
//            false
//        }
    }

    fun update(guest: GuestModel): Boolean {
        return guestDataBase.update(guest) > 0
    }

    fun delete(id: Int) {
        val guest = get(id)
        guestDataBase.delete(guest)
    }

    fun get(id: Int): GuestModel {
        return guestDataBase.get(id)
    }

    fun getAll(): List<GuestModel> {
        return guestDataBase.getAll()
    }

    fun getPresent(): List<GuestModel>{
        return guestDataBase.getPresent()
    }

    fun getAbsent(): List<GuestModel>{
        return guestDataBase.getAbsent()
    }

//    fun update(guest: GuestModel): Boolean {
//
//        return try {
//            val db = guestDataBase.writableDatabase
//
//            val presence = if (guest.presenca) 1 else 0
//
//            val values = ContentValues()
//            values.put(DataBaseConstants.GUEST.COLUMNS.NAME, guest.name)
//            values.put(DataBaseConstants.GUEST.COLUMNS.PRESENCE, presence)
//
//            //Esse é o WHERE da Query Update. É o Critério de Seleção.
//            val selection = DataBaseConstants.GUEST.COLUMNS.ID + " = ?"
//            val args = arrayOf(guest.id.toString())
//
//            db.update(DataBaseConstants.GUEST.TABLE_NAME, values, selection, args)
//            true
//        } catch (e: Exception) {
//            false
//        }
//    }
//
//    fun delete(id: Int): Boolean {
//
//        return try {
//            val db = guestDataBase.writableDatabase
//
//            //É o Critério de Seleção.
//            val selection = DataBaseConstants.GUEST.COLUMNS.ID + " = ?"
//            val args = arrayOf(id.toString())
//
//            db.delete(DataBaseConstants.GUEST.TABLE_NAME, selection, args)
//            true
//        } catch (e: Exception) {
//            false
//        }
//    }
//
//    fun getAll(): List<GuestModel> {
//
//        val list = mutableListOf<GuestModel>()
//
//        try {
//            val db = guestDataBase.readableDatabase
//
//            val selection = arrayOf(
//                DataBaseConstants.GUEST.COLUMNS.ID,
//                DataBaseConstants.GUEST.COLUMNS.NAME,
//                DataBaseConstants.GUEST.COLUMNS.PRESENCE
//            )
//
//            val cursor = db.query(
//                DataBaseConstants.GUEST.TABLE_NAME, selection,
//                null, null,
//                null, null, null
//            )
//
//            //0,    1,      2
//            //id, name, presence
//
//            //Verifica se tem alguma coisa
//            if (cursor != null && cursor.count > 0){
//                while(cursor.moveToNext()) {
//
//                    val id =
//                        cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.ID))
//                    val name =
//                        cursor.getString(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.NAME))
//                    val presence =
//                        cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.PRESENCE))
//
//                    val guest = GuestModel(id, name, presence == 1)
//                    list.add(GuestModel(id,name,presence == 1))
//                }
//            }
//
//            cursor.close()
//        } catch (e: Exception) {
//            return list
//        }
//        return list
//    }
//
//    fun getPresent(): List<GuestModel> {
//
//        val list = mutableListOf<GuestModel>()
//
//        try {
//            val db = guestDataBase.readableDatabase
//
////            val projection = arrayOf(
////                DataBaseConstants.GUEST.COLUMNS.ID,
////                DataBaseConstants.GUEST.COLUMNS.NAME,
////                DataBaseConstants.GUEST.COLUMNS.PRESENCE
////            )
////
////            val selection = DataBaseConstants.GUEST.COLUMNS.PRESENCE + " = ?"
////            val args = arrayOf("1")
//
//            val cursor = db.rawQuery("SELECT id, name, presence FROM Guest WHERE presence = 1", null)
////            val cursor = db.query(
////                DataBaseConstants.GUEST.TABLE_NAME, projection,
////                selection, args,
////                null, null, null
////            )
//
//            //0,    1,      2
//            //id, name, presence
//
//            //Verifica se tem alguma coisa
//            if (cursor != null && cursor.count > 0){
//                while(cursor.moveToNext()) {
//
//                    val id =
//                        cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.ID))
//                    val name =
//                        cursor.getString(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.NAME))
//                    val presence =
//                        cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.PRESENCE))
//
//                    val guest = GuestModel(id, name, presence == 1)
//                    list.add(GuestModel(id,name,presence == 1))
//                }
//            }
//
//            cursor.close()
//        } catch (e: Exception) {
//            return list
//        }
//        return list
//    }
//
//    fun getAbsent(): List<GuestModel> {
//
//        val list = mutableListOf<GuestModel>()
//
//        try {
//            val db = guestDataBase.readableDatabase
//
////            val projection = arrayOf(
////                DataBaseConstants.GUEST.COLUMNS.ID,
////                DataBaseConstants.GUEST.COLUMNS.NAME,
////                DataBaseConstants.GUEST.COLUMNS.PRESENCE
////            )
////
////            val selection = DataBaseConstants.GUEST.COLUMNS.PRESENCE + " = ?"
////            val args = arrayOf("1")
//
//            val cursor = db.rawQuery("SELECT id, name, presence FROM Guest WHERE presence = 0", null)
////            val cursor = db.query(
////                DataBaseConstants.GUEST.TABLE_NAME, projection,
////                selection, args,
////                null, null, null
////            )
//
//            //0,    1,      2
//            //id, name, presence
//
//            //Verifica se tem alguma coisa
//            if (cursor != null && cursor.count > 0){
//                while(cursor.moveToNext()) {
//
//                    val id =
//                        cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.ID))
//                    val name =
//                        cursor.getString(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.NAME))
//                    val presence =
//                        cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.PRESENCE))
//
//                    val guest = GuestModel(id, name, presence == 1)
//                    list.add(GuestModel(id,name,presence == 1))
//                }
//            }
//
//            cursor.close()
//        } catch (e: Exception) {
//            return list
//        }
//        return list
//    }
//
//    fun get(id: Int): GuestModel? {
//
//        var guest : GuestModel? = null
//
//        try {
//            val db = guestDataBase.readableDatabase
//
//            val selection = DataBaseConstants.GUEST.COLUMNS.ID + " = ?"
//            val args = arrayOf(id.toString())
//
//            val projection = arrayOf(
//                DataBaseConstants.GUEST.COLUMNS.ID,
//                DataBaseConstants.GUEST.COLUMNS.NAME,
//                DataBaseConstants.GUEST.COLUMNS.PRESENCE
//            )
//
//            val cursor = db.query(
//                DataBaseConstants.GUEST.TABLE_NAME, projection,
//                selection, args,
//                null, null, null
//            )
//
//            //0,    1,      2
//            //id, name, presence
//
//            //Verifica se tem alguma coisa
//            if (cursor != null && cursor.count > 0){
//                while(cursor.moveToNext()) {
//
//                    val name =
//                        cursor.getString(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.NAME))
//                    val presence =
//                        cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.PRESENCE))
//
//                    guest = GuestModel(id, name, presence == 1)
//                }
//            }
//
//            cursor.close()
//        } catch (e: Exception) {
//            return guest
//        }
//        return guest
//    }

}