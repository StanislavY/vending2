package com.example.order.core

import com.example.order.app.domain.model.ListItem
import com.example.order.datasource.Server.ServerResponseData
import com.example.order.app.domain.model.ServerResponseDataFireBase
import com.google.firebase.firestore.DocumentSnapshot

object GlobalConstAndVars {
    const val UID="123456"
    var CELLS_TO_OPEN_BYTE_ARRAY=ByteArray(1)
    var CELLS_STRING=""
    var CURRENT_QUESTION=ListItem("","","","","","")
    var DATA_FROM_USB=""
    var ANSWER_CLICKED:ListItem=ListItem("","","","","","")
    var CHOSEN_LIST_ITEM=ListItem("","","","","","")
    val NAME_VARIANT_FIELD="variant"
    val NAME_ANSWER_FIELD="answer"
    val NAME_QUESTION_FIELD="question"
    val START_TICKET="1"
    var SWITCH=1
    var CELLS_LIST:List<ListItem> = mutableListOf(
        ListItem(UID,"5","123456","","",""),
            ListItem(UID,"12","123456","","",""))
    var QUESTIONS_LIST:List<ListItem> = mutableListOf()
    var QUESTION_TEXT_LIST:List<ListItem> = mutableListOf()
    var RIGHT_ANSWER:ListItem=ListItem("","","","","","")


    var QUESTION_TEXT=""
    var IMAGE_URL_NAME="picture"
    var PICTURES_URL=""
    var URL_LIST:List<ListItem> = mutableListOf()

    var ANSWER_NUMBER=""
    var ANSWER_LIST:List<ListItem> = mutableListOf()

    var taskList:List<DocumentSnapshot> = listOf()
    var listFromCloud:MutableList<ServerResponseDataFireBase> = mutableListOf()
    const val DEFAULT_VALUE: String = "0"
    var listItemFromDb:List<ListItem> = mutableListOf()
    var LIST_KEY: String = DEFAULT_VALUE
    var count: Int = 0
    var KEY_FOR_INFLATE_MAIN_LIST = 0
    var LIST_OF_CHOSEN_ITEMS: MutableList<ListItem> = mutableListOf()
    var DATABASE1C_NAME: String = "Database1C.db"
    /*const val STEP_FOR_WORK_LIST=0.01*///не удалять - может понадобиться
    /*const val NUMBERS_OF_VALUES_FOR_WORK_LIST=3000*///не удалять - может понадобиться
    const val STEP_FOR_WORKED_HOURS=1.0
    const val NUMBERS_OF_VALUES_FOR_WORKED_HOURS=50
    val DEFAULT_lIST= listOf(ListItem("","","","","",""))
    var DATE_OF_ORDER=""
    var GLOBAL_LIST= DEFAULT_lIST
    var LIST_OF_ITEMS_FOR_FIRST_AND_SECOND_SCREENS:List<ListItem> = mutableListOf()
    const val DEFAULT_VALUE_FOR_GENERATED_LIST=""
    var LIST_OF_FINISHED_ORDERS = listOf<ServerResponseData>()
    const val MARKER_OF_FINISHED_ORDER="1"
    var ORDERS_NUMBER:String=""
    var GOOD_TO_LOAD:String=""
    var SWITCH_FOR_ORDERS_LIST=0

}