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
import com.example.order.app.domain.usecase.*
import com.example.order.viewModel.LoadingViewModel
import com.example.order.databinding.LoadingFragmentBinding
import kotlinx.coroutines.*

class LoadingFragment:Fragment() {
    private var _binding:LoadingFragmentBinding?=null
    private val binding get()=_binding!!
    private val viewModel:LoadingViewModel by lazy { ViewModelProvider(this).get(LoadingViewModel::class.java)

    }
    val cloud: FirebaseCaseImpl = FirebaseCaseImpl()
    private val fireBase: FireBaseCase =FirebaseCaseImpl()
    private val load: LoadDataFrom1CCase = LoadDataFrom1CCaseImpl()





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


        /*viewModel.clearDB()*/
        appCoroutineScope.launch{

            load.executeDownloadingDataFromFireBaseToLocalDB(fireBase.executeGettingDataFromFirebase("Novorossiysk"))

            viewModel.getGlobalLIst()
            goToMainList(activity?.supportFragmentManager)
        }




      /*  viewModel.putDataFromServer1CToLocalDatabase(listTest)*/
       /* viewModel.getDataFromServer()*/


    }



    private fun renderData(data: AppState) {
        when (data) {
            is AppState.Success -> {
               /* viewModel.clearDB()*/



               /* viewModel.loadDataFromFirebase("ПДД:ТемаДорожныеЗнаки:Билет1")*/
            /*    viewModel.putDataFromFireBaseLocalDatabase(data.listItem)*/



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
                Toast.makeText(context,data.error.message,Toast.LENGTH_SHORT).apply {
                    setGravity(Gravity.BOTTOM,0,250)
                    show()
                }

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

    private val appCoroutineScope = CoroutineScope(
        Dispatchers.Main + SupervisorJob() + CoroutineExceptionHandler { _, _ ->
            handleError()
        })

    private fun handleError() {}
    companion object {
        fun newInstance() = LoadingFragment()

        }
    }






