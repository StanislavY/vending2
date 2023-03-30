package com.example.order.app.domain.usecase

import com.example.order.app.domain.model.ListItem

interface LoadDataFrom1CCase {
   fun  executeDeletingDataFromDb()
   fun executeDownloadingDataFrom1CToDB(listItemFromServer:List<ListItem>)
   suspend fun executeDownloadingDataFromFireBaseToLocalDB(listItemFromFB:List<ListItem>)
}