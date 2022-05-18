package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_seconde.*
import java.lang.Exception
import java.util.*

class SecondeActivity : AppCompatActivity(),TextToSpeech.OnInitListener {

    var val_ques:Array<String> ?=null
    var val_answer:Array<String> ?=null
    var index :Int ?= null
    var TtoS : TextToSpeech ?= null
    var res : Int ?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seconde)
//        TtoS = TextToSpeech(this,object :TextToSpeech.OnInitListener{
//            override fun onInit(status: Int) {
//                TODO("Not yet implemented")
//            }
//        })
        //R.array.answer
        //R.array.ques
        val_answer = resources.getStringArray(R.array.answer)
        val_ques = resources.getStringArray(R.array.ques)

//        TtoS = TextToSpeech(this,object : TextToSpeech.OnInitListener{
//            override fun onInit(p0: Int) {
//                TODO("Not yet implemented")
//                res = TtoS!!.setLanguage(Locale.ENGLISH)
//            }
//        })


        index = 0
        tv_question.text = val_ques!![index!!]
        tv_xx.text = "${index!! + 1}"
        tv_yy.text = "/${val_ques!!.size}"

    }

    fun showAction (v: View?){
        when(v?.id){
            R.id.back -> {
                try {


                    index = index!! - 1
                    tv_question.text = "${val_ques!![index!!]}"
                    tv_xx.text = (index!! + 1).toString()
                    tv_answers.text = "press a Button for answer"
                }
                catch (ex:Exception){
                    //index = index!! + 1
                    index = val_ques!!.size - 1
                    tv_question.text = "${val_ques!![index!!]}"
                    tv_xx.text = (index!! + 1).toString()
                }
            }
            R.id.answers -> {
                tv_answers.text = "${val_answer!![index!!]}"
            }
            R.id.next -> {
                try {


                    index = index!! + 1
                    tv_question.text = "${val_ques!![index!!]}"
                    tv_xx.text = (index!! + 1).toString()
                    tv_answers.text = "press a Button for answer"
                }
                catch (ex:Exception){
                    //index = index!! - 1
                    index = 5 - val_ques!!.size
                    tv_question.text = "${val_ques!![index!!]}"
                    tv_xx.text = (index!! + 1).toString()
                }

            }

            R.id.btn_voice -> {

//                if(res == TextToSpeech.LANG_NOT_SUPPORTED|| res==TextToSpeech.LANG_MISSING_DATA){
//                    Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show()
//
//                }
//                else{
//                    TtoS!!.speak(tv_question.text,TextToSpeech.QUEUE_FLUSH, null,"")
//                }
            }
        }
    }

    override fun onInit(status: Int) {
        TODO("Not yet implemented")
        res = TtoS!!.setLanguage(Locale.ENGLISH)
    }
}
