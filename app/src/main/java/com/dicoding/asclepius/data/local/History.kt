package com.dicoding.asclepius.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "History")
 class History(
  @PrimaryKey(autoGenerate = true)
  var id: Int,

  @ColumnInfo(name = "image")
  var imageData: String,

  @ColumnInfo("hasil")
  var hasil: String = ""

 )