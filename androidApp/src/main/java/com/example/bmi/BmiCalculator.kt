package com.example.bmi

class BmiCalculator {

    fun calculateBMI(weight: Double, height: Double, gender: Gender): Double {
        val bmi = when (gender) {
            Gender.MALE -> weight / ((height / 100) * (height / 100))
            Gender.FEMALE -> weight / ((height / 100) * (height / 100)) * 0.9
            else -> 0.0
        }

        return bmi
    }

    fun getBMICategory(bmi: Double): String {
        return when {
            bmi < 18.5 -> "Underweight"
            bmi in 18.5..24.9 -> "Normal weight"
            bmi in 25.0..29.9 -> "Overweight"
            bmi >= 30.0 -> "Obesity"
            else -> "Invalid BMI"
        }
    }

    fun getHealthAdvice(bmi: Double): String {
        return when (getBMICategory(bmi)) {
            "Underweight" -> "It's recommended to gain more weight by eating a balanced, calorie-rich diet."
            "Normal weight" -> "Your BMI is in a healthy range. Maintain your lifestyle and stay active."
            "Overweight" -> "Consider incorporating more physical activity and a balanced diet into your routine."
            "Obesity" -> "Consult with a healthcare provider for advice on weight loss and management."
            else -> "Invalid BMI"
        }
    }
}

enum class Gender {
    MALE,FEMALE
}