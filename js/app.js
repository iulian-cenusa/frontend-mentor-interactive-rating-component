const ratingBoard = document.getElementById("ratingboard");
const validateBoard = document.getElementById("validateboard");
const selectedRating = document.getElementById("selected-rating");
const btn = document.getElementById("btn");

const rateOne = document.getElementById("one");
const rateTwo = document.getElementById("two");
const rateThree = document.getElementById("three");
const rateFour = document.getElementById("four");
const rateFive = document.getElementById("five");

btn.addEventListener("click", () => {
  validateBoard.classList.toggle("hidden");
  ratingBoard.classList.toggle("hidden");
});

function selectRating(element) {
  element.addEventListener("click", () => {
    selectedRating.innerText = element.innerText;
    element.classList.add("selected");
  });
}

function deselectRating(element) {
  element.classList.remove("selected");
}

rateOne.addEventListener("click", () => {
  deselectRating(rateTwo);
  deselectRating(rateThree);
  deselectRating(rateFour);
  deselectRating(rateFive);
  selectRating(rateOne);
});

rateTwo.addEventListener("click", () => {
  deselectRating(rateOne);
  deselectRating(rateThree);
  deselectRating(rateFour);
  deselectRating(rateFive);
  selectRating(rateTwo);
});

rateThree.addEventListener("click", () => {
  deselectRating(rateOne);
  deselectRating(rateTwo);
  deselectRating(rateFour);
  deselectRating(rateFive);
  selectRating(rateThree);
});

rateFour.addEventListener("click", () => {
  deselectRating(rateOne);
  deselectRating(rateTwo);
  deselectRating(rateThree);
  deselectRating(rateFive);
  selectRating(rateFour);
});

rateFive.addEventListener("click", () => {
  deselectRating(rateOne);
  deselectRating(rateTwo);
  deselectRating(rateThree);
  deselectRating(rateFour);
  selectRating(rateFive);
});
