// File: iosApp/iosApp.swift

import SwiftUI
import shared

struct ContentView: View {
    @State private var weight = ""
    @State private var height = ""
    @State private var result = ""
    @State private var advice = ""

    let bmiCalculator = BmiCalculator()

    var body: some View {
        VStack {
            TextField("Weight (kg)", text: $weight)
                .padding()
                .keyboardType(.decimalPad)
            TextField("Height (m)", text: $height)
                .padding()
                .keyboardType(.decimalPad)

            Button("Calculate BMI") {
                if let weight = Double(weight), let height = Double(height) {
                    let bmi = bmiCalculator.calculateBMI(weight: weight, height: height)
                    result = String(format: "Your BMI: %.2f", bmi)
                    advice = bmiCalculator.getHealthAdvice(bmi: bmi, gender: .male)  // You can change gender as needed
                }
            }
            .padding()

            Text(result)
            Text(advice)
        }
        .padding()
    }
}

@main
struct iosApp: App {
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
