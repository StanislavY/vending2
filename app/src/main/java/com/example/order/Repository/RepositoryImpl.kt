package com.example.order.Repository

import com.example.order.Data.MainList

class RepositoryImpl:Repository {
    /*var listDetails: List<MainList>? = listOf(MainList(0," "))*/
    override fun getMainList(key:Int): List<MainList> {
        val mainRepisitory:MainRepisitory=MainRepositoryImpl()
      val listFrom1C=mainRepisitory.getListFrom1C()
        var tempList:MutableList<MainList> = mutableListOf()
        for (mainList in listFrom1C) {
            if (mainList.id1 == key) {
                tempList.add(mainList)

            }

        }

        return tempList

        }

    }

   /* override fun getDetails(): List<MainList> {
        return listOf(
            MainList(1,1,"Обрезка"),
            MainList(1,2,"Чизелевание"),
            MainList(1,3,"Посадка"),
            MainList(1,4,"Культивация"),
            MainList(2,5,"МТЗ 921"),
            MainList(2,6,"Джон дир"),
            MainList(2,7,"Фентд"),
            MainList(2,8,"Валтра"),

            ).also {
            this.listDetails = it
        }

    }*/

/*    override fun getNumbers(): List<Int> {
        return listOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20)

    }

    override fun getDate(): List<Int> {
        return listOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31)
    }*/

  /*  override fun chooseListDetails(): List<MainList> {
       var createListDetails:List<MainList>
        listDetails?.forEach{if listDetails[]

        }*/



