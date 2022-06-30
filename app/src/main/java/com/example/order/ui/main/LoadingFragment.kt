package com.example.order.ui.main

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.example.order.R
import com.example.order.app.domain.model.ListItem
import com.example.order.viewModel.LoadingViewModel
import com.example.order.app.domain.usecase.AppState
import com.example.order.app.domain.usecase.CreateListOfAllItemsFrom1CDBCase
import com.example.order.core.GlobalConstAndVars
import com.example.order.databinding.LoadingFragmentBinding
import com.example.order.datasource.fireBase.CloudFireStore
import io.reactivex.Single

class LoadingFragment:Fragment() {
    private var _binding:LoadingFragmentBinding?=null
    private val binding get()=_binding!!
    private val viewModel:LoadingViewModel by lazy { ViewModelProvider(this).get(LoadingViewModel::class.java)

    }
    val cloud:CloudFireStore=CloudFireStore()





    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {



        _binding= LoadingFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onDestroyView() {
        _binding=null
        super.onDestroyView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loadinglayout.show()
        viewModel.getDataFromServerForDB().observe(viewLifecycleOwner, { renderData(it) })
        val listTest = listOf(
            ListItem("1","Вариант","1","До моста производство работ не менее 150 метров"),
            ListItem("2","Вариант","1","До железнодорожного переезда без шлагбаума не менее 50 метров"),
            ListItem("3","Вариант","1","До железнодорожного переезда со шлагбаумом не менее 150 метров"),
            ListItem("4","ТекстВопроса","1","О чем предупреждают Вас данные знаки?"),
            ListItem("5","Ответ","1","3"),

            ListItem("1","Вариант","2","какой-то вариант1"),
            ListItem("2","Вариант","2","какой-то вариант2"),
            ListItem("3","Вариант","2","какой-то варинат3"),
            ListItem("3","Вариант","2","какой-то варинат4"),
            ListItem("4","ТекстВопроса","2","Какой-то вопрос"),
            ListItem("5","Ответ","2","3")




        )
        var x: Single<List<com.example.order.datasource.fireBase.Task>>
       cloud.getAllDataFromCollectionCloudFireStore()
        GlobalConstAndVars.taskList.isEmpty()

        viewModel.clearDB()

      /*  viewModel.putDataFromServer1CToLocalDatabase(listTest)*/
        viewModel.getDataFromServer()
        viewModel.getGlobalLIst()

    }



    private fun renderData(data: AppState) {
        when (data) {
            is AppState.Success -> {
                viewModel.clearDB()
               /* viewModel.putDataFromServer1CToLocalDatabase(data.listItem)*/



                Toast.makeText(context,"Справочники загружены успешно",Toast.LENGTH_SHORT).apply {
                    setGravity(Gravity.BOTTOM,0,250)
                    show()
                }
                binding.loadinglayout.hide()
                goToMainList(activity?.supportFragmentManager)

            }
            is AppState.Loading -> {
                binding.loadinglayout.show()
            }
            is AppState.Error -> {
                binding.loadinglayout.show()
              /*  Toast.makeText(context,data.error.message,Toast.LENGTH_SHORT).apply {
                    setGravity(Gravity.BOTTOM,0,250)
                    show()
                }*/
                goToMainList(activity?.supportFragmentManager)


            }
        }
    }

    private fun goToMainList(
        manager: FragmentManager?,

    ) {
        manager?.beginTransaction()?.replace(R.id.container, MainFragment.newInstance())
            ?.addToBackStack("")?.commitAllowingStateLoss()
    }
    companion object {
        fun newInstance() = LoadingFragment()

        }
    }






