package com.example.a7minworkout

object Constants {

    fun defaultExerciseList():ArrayList<ExerciseModel>{
        val exerciseList=ArrayList<ExerciseModel>()
        val jumpingJacks=ExerciseModel(
            1,
            "Jumping Jacks",
            R.drawable.jumping_jack,
            false,
            false

        )
        exerciseList.add(jumpingJacks)

        val wallSit=ExerciseModel(
            2,
            "wall Sit",
            R.drawable.wallsit,
            false,
            false

        )
        exerciseList.add(wallSit)

        val pushUps=ExerciseModel(
            3,
            "Push Ups",
            R.drawable.pushups,
            false,
            false

        )
        exerciseList.add(pushUps)

        val abdominalCrunch=ExerciseModel(
            4,
            "Abdominal Crunch",
            R.drawable.abdominal_crunch,
            false,
            false

        )
        exerciseList.add(abdominalCrunch)

        val stepUpOnChair=ExerciseModel(
            5,
            "Step Up On Chair",
            R.drawable.step_up_on_chair,
            false,
            false

        )
        exerciseList.add(stepUpOnChair)

        val squats=ExerciseModel(
            6,
            "Squats Dip On Chair",
            R.drawable.squats,
            false,
            false

        )
        exerciseList.add(squats)

        val tricepDipOnChair=ExerciseModel(
            7,
            "Tricep Dip On Chair",
            R.drawable.tricep_dip,
            false,
            false

        )
        exerciseList.add(tricepDipOnChair)

        val planks=ExerciseModel(
            8,
            "Planks",
            R.drawable.plank,
            false,
            false

        )
        exerciseList.add(planks)

        val highKneesRunningInPlaces=ExerciseModel(
            9,
            "High Knees Running In Places",
            R.drawable.high_knees,
            false,
            false

        )
        exerciseList.add(highKneesRunningInPlaces)

        val lunges=ExerciseModel(
            10,
            "lunges",
            R.drawable.lunges,
            false,
            false

        )
        exerciseList.add(lunges)

        val pushUpsAndRotation=ExerciseModel(
            11,
            "Push Ups And Rotation",
            R.drawable.push_up_rotation,
            false,
            false

        )
        exerciseList.add(pushUpsAndRotation)

        val sidePlanks=ExerciseModel(
            12,
            "Side Planks",
            R.drawable.sideplank,
            false,
            false

        )
        exerciseList.add(sidePlanks)

        return exerciseList
    }
}