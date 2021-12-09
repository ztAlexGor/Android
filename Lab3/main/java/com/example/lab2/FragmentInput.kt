package com.example.lab2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.content.Intent




// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentInput.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentInput : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var checkBox1: CheckBox
    private lateinit var checkBox2: CheckBox
    private lateinit var radioGroup: RadioGroup
    private lateinit var button: Button
    private lateinit var button_open: Button







    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_input, container, false)
        checkBox1 = view.findViewById(R.id.checkBox)
        checkBox2 = view.findViewById(R.id.checkBox2)
        radioGroup = view.findViewById(R.id.radioGroup)
        button = view.findViewById(R.id.button)
        button_open = view.findViewById(R.id.button_open)

        button.setOnClickListener {
            if ((!checkBox1.isChecked() && !checkBox2.isChecked()) || radioGroup.checkedRadioButtonId == -1){
                Toast.makeText(activity?.applicationContext,"Select both the option and the figure", Toast.LENGTH_LONG).show();
            }else{
                var res : String = ""
                if (checkBox1.isChecked()){
                    res += checkBox1.text
                }
                if (checkBox2.isChecked()){
                    if (res != ""){
                        res += " "
                    }
                    res += checkBox2.text
                }

                res += " " + view.findViewById<RadioButton>(radioGroup.checkedRadioButtonId).text + "\n"


                (activity as MainActivity).setResult(res)
                FileManager().saveData(res, (activity as MainActivity))

//                val fragmentOutput = (activity as MainActivity).fragmentOutput
//                fragmentOutput.resText.text = res
            }
        }



        button_open.setOnClickListener {
            this@FragmentInput.startActivity(Intent(getActivity(), DataActivity::class.java))
        }
        // Inflate the layout for this fragment
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentInput.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentInput().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}