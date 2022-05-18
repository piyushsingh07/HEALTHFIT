package com.example.a7minworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.view.SupportActionModeWrapper
import com.example.a7minworkout.databinding.ActivityBmiBinding
import java.math.BigDecimal
import java.math.RoundingMode

class BMIActivity : AppCompatActivity() {

    companion object{
        private const val METRIC_UNITS_VIEW="METRIC_UNITS_VIEW"
        private const val US_UNITS_VIEW="US_UNITS_VIEW"
    }
    private var currentVisibleView:String=METRIC_UNITS_VIEW

    private var binding : ActivityBmiBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityBmiBinding.inflate(layoutInflater)

        setContentView(binding?.root)

        setSupportActionBar(binding?.toolbarBmiActivity)
        if (supportActionBar!=null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.title="CALCULATE BMI"
        }
        binding?.toolbarBmiActivity?.setNavigationOnClickListener{
            onBackPressed()
        }

        makeVisibleMetricUnitsView()

        binding?.rgUnits?.setOnCheckedChangeListener{_,checkedId:Int->
            if(checkedId==R.id.rbMetricUnits){
                makeVisibleMetricUnitsView()
            }
            else{
                makeVisibleUsUnitsView()
            }
        }
        binding?.btnCalculateUnits?.setOnClickListener{
           calculateUnits()
        }
    }

    private fun makeVisibleMetricUnitsView(){
        currentVisibleView= METRIC_UNITS_VIEW
        binding?.tilMetricUnitHeight?.visibility=View.VISIBLE
        binding?.tilMetricUnitWeight?.visibility=View.VISIBLE

        binding?.tilMetricUsUnitHeightFeet?.visibility=View.GONE
        binding?.tilMetricUsUnitHeightInch?.visibility=View.GONE
        binding?.tilUsMetricUnitWeight?.visibility=View.GONE

        binding?.etMetricUnitHeight?.text!!.clear()
        binding?.etMetricUnitWeight?.text!!.clear()

        binding?.llDisplayBMIResult?.visibility=View.INVISIBLE

    }

    private fun makeVisibleUsUnitsView(){
        currentVisibleView= US_UNITS_VIEW
        binding?.tilMetricUnitHeight?.visibility=View.INVISIBLE
        binding?.tilMetricUnitWeight?.visibility=View.INVISIBLE

        binding?.tilMetricUsUnitHeightFeet?.visibility=View.VISIBLE
        binding?.tilMetricUsUnitHeightInch?.visibility=View.VISIBLE
        binding?.tilUsMetricUnitWeight?.visibility=View.VISIBLE

        binding?.etMetricUnitWeight?.text!!.clear()
        binding?.etMetricUnitHeight?.text!!.clear()
        binding?.etMetricUnitWeight?.text!!.clear()

        binding?.llDisplayBMIResult?.visibility=View.INVISIBLE

    }

    private fun displayBMIResults(bmi:Float){
        val bmiLabel:String
        val bmiDescription:String

        if(bmi.compareTo(15f)<=0){
            bmiLabel="Very Severely Underweight"
            bmiDescription="Oops! You really need to take good care of yourself! Eat more!"
        }else if(bmi.compareTo(15f)>0 && bmi.compareTo(16f)<=0){
            bmiLabel="Severely Underweight"
            bmiDescription="Oops! You really need to take good care of yourself! Eat more!"
        }else if(bmi.compareTo(16f)>0 && bmi.compareTo(18.5f)<=0){
            bmiLabel="Underweight"
            bmiDescription="Oops! You really need to take good care of yourself! Eat more!"
        }
        else if(bmi.compareTo(18.5f)>0 && bmi.compareTo(25f)<=0){
            bmiLabel="Normal"
            bmiDescription="Congratulations! You are in good shape!"
        }else if(bmi.compareTo(25f)>0 && bmi.compareTo(30f)<=0){
            bmiLabel="Overweight"
            bmiDescription="Oops! You really need to take good care of yourself! Workout!"
        }
        else if(bmi.compareTo(30f)>0 && bmi.compareTo(35f)<=0){
            bmiLabel="Obese class! | (Moderately obese)"
            bmiDescription="Oops! You really need to take good care of yourself! Workout!"
        }
        else if(bmi.compareTo(35f)>0 && bmi.compareTo(40f)<=0){
            bmiLabel="Obese class! | (Severely obese)"
            bmiDescription="Oops! You really need to take good care of yourself! Workout!"
        }
        else{
            bmiLabel="Obese class! | (Very Severely obese)"
            bmiDescription="Oops! You really need to take good care of yourself! Act now!"
        }

        val bmiValue=
            BigDecimal(bmi.toDouble()).setScale(2,RoundingMode.HALF_EVEN).toString()
        binding?.llDisplayBMIResult?.visibility=View.VISIBLE
        binding?.tvBMIValue?.text=bmiValue

        binding?.tvBMIType?.text=bmiLabel
        binding?.tvBMIDescription?.text=bmiDescription
    }

    private fun validateMetricUnits():Boolean{
        var isValid=true;
        if(binding?.etMetricUnitWeight?.text.toString().isEmpty()){
            isValid=false
        }
        else if(binding?.etMetricUnitHeight?.text.toString().isEmpty()){
            isValid=false
        }
        return isValid
    }

    private fun calculateUnits(){
        if (currentVisibleView== METRIC_UNITS_VIEW){
            if(validateMetricUnits()){
                val heightValue:Float= binding?.etMetricUnitHeight?.text?.toString()!!.toFloat()/100
                val weightValue:Float= binding?.etMetricUnitWeight?.text?.toString()!!.toFloat()
                val bmi=weightValue/(heightValue*heightValue)
                displayBMIResults(bmi)
            }else{
                Toast.makeText(this@BMIActivity,"Please Enter Valid Values.",Toast.LENGTH_SHORT).show()
            }
        }else{
            if (validateUsUnits()){
                val usUnitHeightValueInch:String=
                    binding?.etUsMetricUnitHeightInch?.text.toString()
                val usUnitHeightValueFeet:String=
                    binding?.etUsMetricUnitHeightFeet?.text.toString()
                val usUnitWeightValue:
                        Float=binding?.etUsMetricUnitWeight?.text.toString().toFloat()
                val heightValue=usUnitHeightValueInch.toFloat()+usUnitHeightValueFeet.toFloat()*12

                val bmi=703*(usUnitWeightValue/(heightValue*heightValue))

                displayBMIResults(bmi)

            }else{
                Toast.makeText(this@BMIActivity,"Please Enter Valid Values.",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateUsUnits():Boolean{
        var isValid=true;
        if(binding?.etUsMetricUnitWeight?.text.toString().isEmpty()){
            isValid=false
        }
        else if(binding?.etUsMetricUnitHeightFeet?.text.toString().isEmpty()){
            isValid=false
        }
        else if(binding?.etUsMetricUnitHeightInch?.text.toString().isEmpty()){
            isValid=false
        }
        return isValid
    }
}
