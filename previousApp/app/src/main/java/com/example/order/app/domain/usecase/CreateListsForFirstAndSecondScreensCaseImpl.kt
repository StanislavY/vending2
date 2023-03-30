package com.example.order.app.domain.usecase

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.order.core.GlobalConstAndVars
import com.example.order.app.domain.model.ListItem
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class CreateListsForFirstAndSecondScreensCaseImpl: CreateListsForFirstAndSecondScreensCase {
    @RequiresApi(Build.VERSION_CODES.N)
    override suspend fun  getCellsToOpen(orderNumber: String): List<ListItem> {
          return suspendCoroutine { res ->
              val cellsList=GlobalConstAndVars.GLOBAL_LIST.filter { it.documentFB==orderNumber }


              /*GlobalConstAndVars.SWITCH=1*/
              GlobalConstAndVars.CELLS_LIST=cellsList
              res.resume(cellsList)



          }





    }

    override suspend fun openCellForLoading(goodsArticle: String) {
        val freeCells=GlobalConstAndVars.GLOBAL_LIST

        val cellsQuantity =12 //заглушка. сделать метод для опроса ардуины о том сколько у нее ячеек
        val startCell = 2 //заглушка. сделать запрос на ардуину с какой цифры начинать отсчет






    }

    override suspend fun getFreeCellsList(freeCellsList: List<ListItem>) {

    }

    override suspend fun getQuestionsAndAnswers(fieldsName: String, ticketNumber:String): List<ListItem> {
        return suspendCoroutine { res ->
            var listForFilter=GlobalConstAndVars.GLOBAL_LIST
            var filteredList= listForFilter.filter { it.documentFB==ticketNumber }.filter { it.field.contains(fieldsName)  }
            GlobalConstAndVars.SWITCH=2
            if (fieldsName == GlobalConstAndVars.NAME_VARIANT_FIELD) {
                GlobalConstAndVars.QUESTIONS_LIST=filteredList
            }
            if (fieldsName == GlobalConstAndVars.NAME_QUESTION_FIELD) {
                GlobalConstAndVars.QUESTION_TEXT_LIST=filteredList
                filteredList.forEach {
                    if (it.field == fieldsName) {
                        GlobalConstAndVars.QUESTION_TEXT=it.value

                    } }

            }
            if (fieldsName == GlobalConstAndVars.IMAGE_URL_NAME) {
                GlobalConstAndVars.URL_LIST=filteredList
                filteredList.forEach {
                    if (it.field == fieldsName) {
                        GlobalConstAndVars.PICTURES_URL=it.value

                    } }

            }
            if (fieldsName == GlobalConstAndVars.NAME_ANSWER_FIELD) {
                GlobalConstAndVars.ANSWER_LIST=filteredList
                filteredList.forEach {
                    if (it.field == fieldsName) {
                        GlobalConstAndVars.ANSWER_NUMBER=it.value

                    } }

            }

           

            res.resume(filteredList)
        }








    }

    override suspend fun isAnswerRight(rightAnswer: String, answerForCheck: String):Boolean {

        return answerForCheck.contains(rightAnswer)



    }
    override suspend fun detectRightAnswerFromList (list:List<ListItem>,rigtAnswerNumber:String){

        list.forEach {
            if (it.field.contains(rigtAnswerNumber)) {
                GlobalConstAndVars.RIGHT_ANSWER=it
            }



            }


    }






}








