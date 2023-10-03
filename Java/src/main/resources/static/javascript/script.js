document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector("form");
    const resultElement = document.getElementById("result");

    form.addEventListener("submit", function (event) {
        event.preventDefault();
        submitUserInfo();
    });

    function submitUserInfo() {
        const formData = new FormData(form);

        fetch("/api/calculate", {
            method: "POST",
            body: formData,
        })
            .then((response) => response.json())
            .then((data) => {
                resultElement.textContent = `Calories burned: ${data.caloriesBurned} calories`;
            })
            .catch((error) => {
                console.error("Error submitting user info:", error);
                resultElement.textContent = "Error submitting user info.";
            });
    }

    function calculateCalories(foodOrExercise) {
        fetch(`/api/calculate/${foodOrExercise}`)
            .then((response) => response.json())
            .then((data) => {
                resultElement.textContent = `Calories for ${foodOrExercise}: ${data.calories}`;
            })
            .catch((error) => {
                console.error(`Error calculating calories for ${foodOrExercise}:`, error);
                resultElement.textContent = `Error calculating calories for ${foodOrExercise}.`;
            });
    }
});
