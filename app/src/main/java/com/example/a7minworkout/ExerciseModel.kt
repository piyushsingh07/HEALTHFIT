package com.example.a7minworkout

class ExerciseModel (
    private var id: Int,
    private var name: String,
    private var image: Int,
    private var isCompleted: Boolean,
    private var isSelected: Boolean,
){

    fun getId():Int{
        return id
    }

    fun setId(Id:Int){
        this.id=id
    }

    fun getName():String{
        return name
    }

    fun setName(name:String){
        this.name=name
    }

    fun getImage():Int{
        return image
    }

    fun setImage(name:Int){
        this.image=image
    }

    fun getIsCompleted(): Any {
        return isCompleted
    }
    fun setIsCompleted(isCompleted:Boolean){
        this.isCompleted = isCompleted
    }

    fun getIsSelected(): Any {
        return isSelected
    }
    fun setIsSelected(isSelected:Boolean){
        this.isSelected = isSelected
    }
}